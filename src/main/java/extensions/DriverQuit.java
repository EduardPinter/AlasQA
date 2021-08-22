package extensions;

import driverInit.TestBase;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class DriverQuit implements TestWatcher {

    private final Logger log = LoggerFactory.getLogger(DriverQuit.class);

    @Override
    public void testSuccessful(ExtensionContext context) {
        final TestBase testBase = (TestBase) context.getRequiredTestInstance();
        testBase.getDriver().quit();
        log.info("Test was successful, test name : " + testBase);
        log.info("\n ###############################################################################################################################");
        File file = new File("LoggingFolder/" + MDC.get("folderName") + "/" + MDC.get("folderName") + ".log");
        try {
            Allure.addAttachment("LoggingFile", new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MDC.remove("methodName");
        MDC.remove("folderName");
        MDC.clear();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        final TestBase testBase = (TestBase) context.getRequiredTestInstance();
        testBase.getDriver().quit();
        log.info("Test failed, test name : " + testBase);
        log.info("\n ###############################################################################################################################");
        File file = new File("LoggingFolder/" + MDC.get("folderName") + "/" + MDC.get("folderName") + ".log");
        try {
            Allure.addAttachment("LoggingFile", new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MDC.remove("methodName");
        MDC.remove("folderName");
        MDC.clear();
    }

    // Overriding Junit5 methods, creating a custom log file in LoggingFolder, attaching the file to allure report
    // clearing variables so they can be used with different tests
}
