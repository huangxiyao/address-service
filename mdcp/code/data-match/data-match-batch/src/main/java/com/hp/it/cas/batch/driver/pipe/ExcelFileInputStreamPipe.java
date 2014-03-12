package com.hp.it.cas.batch.driver.pipe;

import com.hp.it.cas.foundation.pipe.AbstractPipe;
import com.hp.it.cas.foundation.pipe.Pipe;
import com.hp.it.cas.foundation.pipe.SingleIterator;
import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.foundation.validation.Validations;
import com.hp.it.cas.io.adapter.IoFiles;
import com.hp.it.cas.io.adapter.IoPath;
import com.hp.it.cas.io.adapter.IoPaths;

import org.apache.http.annotation.Immutable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import java.net.URI;

import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;


/**
 * Starts with file URIs and emits an input stream for that file.
 *
 * @author  quintin.may@hp.com
 * @author  hugh.mckee@hp.com
 */
public class ExcelFileInputStreamPipe<E> extends AbstractPipe<URI, E> {
    private final Logger logger = LoggerFactory.getLogger(ExcelFileInputStreamPipe.class);
    private final Pipe<OPCPackage, E> pipe;

    private URI previousUri;
    private InputStream previousStream;
    private OPCPackage opcPackage;
    private final Auditor<InputStream> auditor;

    /**
     * Creates a new FileInputStreamPipe object.
     *
     * @param  pipe  the pipe that processed the input stream and emits type E
     */
    public ExcelFileInputStreamPipe(Auditor<InputStream> auditor, Pipe<OPCPackage, E> pipe) {
    	this.auditor = auditor;
        this.pipe = pipe;
    }

    @Override
    protected E processNextStart() throws NoSuchElementException {
        try {
            while (true) {
                if (previousStream == null) {
                    previousUri = getStarts().next();
                    previousStream = open(previousUri);
                    openOPCPackage(previousStream);
					pipe.setStarts(new SingleIterator<OPCPackage>(opcPackage));
                }

                try {
                    return pipe.next();
                } catch (NoSuchElementException e) {
                	closeOPCPackage();
                    close();
                }
            }
        } catch (RuntimeException e) {
        	closeOPCPackage();
            close();
            throw e;
        } catch (Exception e) {
        	closeOPCPackage();
            close();
            throw new RuntimeException(e);
        }
    }

    /**
     * Opens a file input stream.
     *
     * @param   fileUri  the file URI
     *
     * @return  the file input stream
     *
     * @throws  IllegalArgumentException  if not a file
     * @throws  TunnelledException        IOException if there is a problem opening the file
     */
    private InputStream open(URI fileUri) {
        IoPath file = IoPaths.get(fileUri);

        if (! IoFiles.isRegularFile(file)) {
            String message = String.format("Not a file: '%s'.", fileUri);
            throw new IllegalArgumentException(message);
        }

        logger.debug("Opening file '{}'", fileUri);

        try {
            return IoFiles.newInputStream(file);
        } catch (IOException e) {
            String message = String.format("Unable to open file '%s'", fileUri);
            throw new TunnelledException(message, e);
        }
    }

    /**
     * Close the previously open file input stream.
     *
     * @throws  TunnelledException  IOException if there is a problem closing the file
     */
    private void close() {
        try {
            if (previousStream != null) {
                logger.debug("Closing file '{}'", previousUri);

                previousStream.close();
            }
        } catch (IOException e) {
            String message = String.format("Unable to close file '%s'.", previousUri);
            throw new TunnelledException(message, e);
        } finally {
            previousUri = null;
            previousStream = null;
        }
    }
    
	/**
	 * Open a package with the inputStream.
	 * 
	 * @param inputStream
	 *            the InputStream to read the package from
	 */
	private void openOPCPackage(InputStream inputStream) {
		Set<ConstraintViolation<InputStream>> constraintViolations = new OpenOPCPackageValidator().validate(inputStream);
		if (constraintViolations == null || constraintViolations.isEmpty()) {
			return;
		}
		opcPackage = null;
		logger.error("Cannot open excel file {}.", previousUri);
		auditor.log(auditor.getMessageContext(), constraintViolations);
	}

	/**
	 * Close the package.
	 */
	private void closeOPCPackage() {
		try {
			if (opcPackage != null) {
				opcPackage.close();
			}
		} catch (IOException e) {
			throw new TunnelledException(e);
		} 
	}
    
	
	@Immutable
	final class OpenOPCPackageValidator {
		
		Set<ConstraintViolation<InputStream>> validate(InputStream inputStream){
			ConstraintViolationContext<InputStream> context = new ConstraintViolationContext<InputStream>(inputStream);
            Set<ConstraintViolation<InputStream>> annotationViolations = Validations.getValidator().validate(inputStream);
            context.addAll(annotationViolations);

            if(annotationViolations.isEmpty()){
            	validateOpenOPCPackage(inputStream, context);
            }
            return context.getConstraintViolations();
		}
		
		private void validateOpenOPCPackage(InputStream inputStream, ConstraintViolationContext<InputStream> context) {
            
			try {
				opcPackage = OPCPackage.open(inputStream);
			} catch (InvalidFormatException e) {
				context.buildConstraintViolationWithTemplate("Unable to create OPCPackage: " + previousUri)
						.putAttribute("Exception", e)
						.addConstraintViolationForValue(inputStream);
			} catch (IOException e) {
				context.buildConstraintViolationWithTemplate("Cannot open the excel file: " +  previousUri)
						.putAttribute("Exception", e)
						.addConstraintViolationForValue(inputStream);
			}
        }
	}
}
