package com.hp.it.cas.match.address;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.match.address.engine.CharacterScript.Analysis;
import com.hp.it.cas.match.address.engine.CharacterScript;
import com.ibm.icu.lang.UScript;

/**
 * Test cases for character detector
 * 
 * @author <link href="yin-hao.liang@hp.com">Leon Liang</link>
 * @version 1.0
 */
public class CharacterScriptDetectorTest {

    protected static final Logger logger;
    private static SimpleDateFormat sdf = null;

    static {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        org.apache.log4j.Logger root = LogManager.getRootLogger();
        Appender appender = new ConsoleAppender(new PatternLayout("%d %p [CAS] [%c] - %m%n"),
                                                ConsoleAppender.SYSTEM_OUT);
        appender.setName("stdout");
        root.addAppender(appender);
        root.setLevel(Level.DEBUG);

        logger = LoggerFactory.getLogger("ROOT");
    }

    private List<MockData> source;
    private boolean testResult;

    @Before
    public void setUp() throws Exception {
        source = new ArrayList<MockData>();
        testResult = false;
    }

    @Test
    public void testHANString() {
        testScriptDetector(UScript.HAN);
    }

    @Test
    public void testARABICString() {
        testScriptDetector(UScript.ARABIC);
    }

    @Test
    public void testCYRILLICString() {
        testScriptDetector(UScript.CYRILLIC);
    }

    @Test
    public void testHEBREWString() {
        testScriptDetector(UScript.HEBREW);
    }

    @Test
    public void testKATAKANAString() {
        testScriptDetector(UScript.KATAKANA);
    }

    @Test
    public void testJAPANESEString() {
        testScriptDetector(UScript.JAPANESE);
    }

    @Test
    public void testKOREANString() {
        testScriptDetector(UScript.KOREAN);
    }

    @Test
    public void testLATINString() {
        testScriptDetector(UScript.LATIN);
    }

    @Test
    public void testGREEKString() {
        testScriptDetector(UScript.GREEK);
    }
    
    @Test
    public void testCommonString() {
        testScriptDetector(UScript.COMMON);
    }

    @Test
    public void testUNKNOWNString() {
        // Given
        source.clear();
        source.addAll(StringPool.getSpecifiedStringsByScript(UScript.UNKNOWN));

        // When
        boolean isSuccess = true;
        for (MockData data : source) {
            if (CharacterScript.analyze(data.getSource()) != null) {
                isSuccess = false;
            }
            if (!isSuccess) {
                logger.warn("Detect this string is failed");
                logger.warn("Unicode text is: {}", data.getSource());
                logger.warn("Script is: {}", data.getAnalysis().getScript());
                logger.warn("Length is: {}", data.getAnalysis().getLength());
                break;
            }
        }

        // Then
        Assert.assertTrue(isSuccess);
    }

	private boolean compareResult(Analysis a1, Analysis a2) {
		if (a1.getLength() == a2.getLength() && a1.getScript().equals(a2.getScript())
				&& a1.isNonLatin() == a2.isNonLatin()) {
			return true;
		} else {
			return false;
		}
	}
    
    /**
     * Detect strings and check results
     * 
     * @param source
     *            list of string object to be detected
     * @return check result, if one piece of string is failed, the checking will be blocked
     */
    private boolean checkDetectedResults(List<MockData> sources) {
        boolean isSuccess = true;
        for (MockData data : sources) {
            isSuccess = compareResult(data.getAnalysis(), CharacterScript.analyze(data.getSource()));
            if (!isSuccess) {
                logger.warn("Detect this string is failed");
                logger.warn("Unicode text is: {}", data.getSource());
                logger.warn("Script is: {}", data.getAnalysis().getScript());
                logger.warn("Length is: {}", data.getAnalysis().getLength());
                break;
            }
        }
        return isSuccess;
    }

    /**
     * According to specified script, fetching string data accordingly and testing
     * 
     * @param script
     *            Specify script for testing, e.g. UScript.LATIN
     * @see com.ibm.icu.lang.UScript
     */
    private void testScriptDetector(int script) {
        // Given
        source.clear();
        source.addAll(StringPool.getSpecifiedStringsByScript(script));

        // When
        testResult = checkDetectedResults(source);

        // Then
        Assert.assertTrue(testResult);
    }
}
