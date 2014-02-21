package com.hp.it.cas.batch.driver.pipe;

import com.hp.it.cas.foundation.pipe.Pipe;
import com.hp.it.cas.foundation.pipe.Pipeline;
import com.hp.it.cas.foundation.pipe.StartPipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.beans.PropertyEditor;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * Implementations provide transaction file header row count, {@link RowMapper row mapper}, boundary row pattern,
 * {@link FileDisposition file disposition} and controllers.
 * 
 * @author quintin.may@hp.com
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public abstract class ExcelFileDriver<T, R> extends DataSourceDriver<R> {
	private final Logger logger = LoggerFactory.getLogger(ExcelFileDriver.class);
	private static final PropertyEditor URI_PROPERTY_EDITOR = new UriPropertyEditor();
	private static final PropertyEditor ROW_NUMBER_PROPERTY_EDITOR = new RowNumberPropertyEditor();

	private static enum Restart {
		DATA_SOURCE_URI, AFTER_ROW_NUMBER
	}

	private Pipe<Void, R> flow;

	/**
	 * Creates a new TransactionDriver object.
	 * 
	 * @param configuration
	 *            the configuration
	 */
	public ExcelFileDriver(Configuration configuration) {
		super(configuration);
	}

	@Override
	protected R processNextStart() throws NoSuchElementException {
		return flow().next();
	}

	/**
	 * The driver flow.
	 * 
	 * @return the driver flow
	 */
	private Pipe<Void, R> flow() {
		if (flow == null) {
			Configuration configuration = getConfiguration();
			logger.debug("{}", configuration.getJobIdentifier());
			DataSource dataSource = getDataSource();

			Checkpointer checkpointer = new Checkpointer(configuration, dataSource);
			Auditor auditor = getAuditor();

			flow = new CheckpointRestartPipe<Void, R>(checkpointer, new Pipeline<Void, R>(new StartPipe<URI>(
					directoryPath(configuration)), new DirectoryListPipe(), new AntFileFilterPipe(
					filePattern(configuration)), new RestartFilterPipe<URI>(configuration,
					Restart.DATA_SOURCE_URI.name(), URI_PROPERTY_EDITOR), new LockFileFilterPipe(configuration,
					dataSource), getFileDispositionPipe(), new StatisticsPipe<File>(configuration, "file"),
					new CheckpointTriggerPipe<File>(configuration, checkpointer, 1),
					new FileInputStreamPipe<R>(new Pipeline<InputStream, R>(new RowReaderPipe(getFileHeaderRowCount()),
							new RestartAfterFilterPipe<Row>(configuration, Restart.AFTER_ROW_NUMBER.name(),
									ROW_NUMBER_PROPERTY_EDITOR), new ConstraintViolationBoundaryPipe<Row, R>(
									configuration, auditor, new Pipeline<Row, R>(getRowMapperPipe(),
											new CheckpointTriggerPipe<T>(configuration, checkpointer,
													checkpointInterval(configuration)), new StatisticsPipe<T>(
													configuration, "transaction"), new SavepointPipe<T, R>(
													configuration, dataSource, new TransactionControllerPipe<T, R>(
															configuration, dataSource, auditor,
															getTransactionControllers()))))))));
		}

		return flow;
	}

	/**
	 * Gets the file header row count.
	 * 
	 * @return the file header row count
	 */
	protected abstract int getFileHeaderRowCount();

	/**
	 * Gets the file disposition.
	 * 
	 * @return the file disposition
	 */
	protected abstract FileDisposition getFileDisposition();

	/**
	 * Gets the row mapper.
	 * 
	 * @return the row mapper
	 */
	protected abstract RowMapper<T> getRowMapper();

	/**
	 * Gets the boundary row pattern.
	 * 
	 * @return the boundary line pattern
	 */
	protected abstract Pattern getBoundaryRowPattern();

	/**
	 * Gets the transaction controllers.
	 * 
	 * @return the business process managers
	 */
	protected abstract Collection<TransactionController<T, R>> getTransactionControllers();

	/**
	 * Override this method to provide a custom auditor implementation.
	 * 
	 * @return the auditor
	 */
	protected Auditor getAuditor() {
		return new Auditor(getDataSource(), Auditor.Level.OFF);
	}

	/**
	 * Takes the transaction data source URI job configuration setting and returns it as a URI.
	 * 
	 * @param configuration
	 *            the configuration
	 * 
	 * @return the data source URI
	 * 
	 * @throws IllegalArgumentException
	 *             if the transaction data source URI job configuration setting is not defined
	 * @throws RuntimeException
	 *             if the transaction data source URI job configuration setting is not valid
	 */
	private URI directoryPath(Configuration configuration) {
		String uriPath = configuration.getTransactionDataSourceUriPath();

		if ((uriPath == null) || (uriPath.trim().length() == 0)) {
			throw new IllegalArgumentException("Transaction data source URI path not defined.");
		}

		try {
			return new URI(uriPath);
		} catch (URISyntaxException e) {
			String message = String.format("Transaction data source URI is invalid, '%s'.", uriPath);
			throw new RuntimeException(message, e);
		}
	}

	/**
	 * Gets the data source file pattern text from the configuration.
	 * 
	 * @param configuration
	 *            the configuration
	 * 
	 * @return the data source file pattern text
	 * 
	 * @throws IllegalArgumentException
	 *             if the data source file pattern text is not defined
	 */
	private String filePattern(Configuration configuration) {
		String patternText = configuration.getTransactionDataSourcePatternText();

		if ((patternText == null) || (patternText.length() == 0)) {
			throw new IllegalArgumentException("Transaction data source pattern text not defined.");
		}

		return patternText;
	}

	/**
	 * Gets the commit frequency logical unit of work count from the configuration.
	 * 
	 * @param configuration
	 *            the configuration
	 * 
	 * @return the commit frequency logical unit of work count
	 * 
	 * @throws IllegalArgumentException
	 *             if the commit frequency logical unit of work count is not set
	 */
	private int checkpointInterval(Configuration configuration) {
		int checkpointInterval = configuration.getCommitFrequencyLogicalUnitOfWorkCount();

		if (checkpointInterval < 1) {
			throw new IllegalArgumentException("CommitFrequencyLogicalUnitOfWorkCount must be greater than zero.");
		}

		return checkpointInterval;
	}

	/**
	 * Gets the file disposition pipe.
	 * 
	 * @return the file disposition pipe
	 */
	private FileDispositionPipe getFileDispositionPipe() {
		return new FileDispositionPipe(getFileDisposition());
	}

	/**
	 * Gets the row mapper pipe.
	 * 
	 * @return the row mapper pipe
	 */
	private RowMapperPipe<T> getRowMapperPipe() {
		return new RowMapperPipe<T>(getRowMapper(), getBoundaryRowPattern());
	}
}
