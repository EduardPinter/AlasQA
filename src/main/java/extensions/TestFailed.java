package extensions;

import driverInit.TestBase;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFailed implements TestWatcher {

    private final Logger log = LoggerFactory.getLogger(TestFailed.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) { // implementation of methods in overriden Junit5 method testFailed
        log.info("Assertion Failed : \n {} ", cause.getMessage());      // so it can screenshot on failure and logging the assertion failure
        log.info("==========================================");
        final TestBase testBase = (TestBase) context.getRequiredTestInstance();
        try {
            makingAFile(testBase.getDriver(), context.getDisplayName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        log.info("***** Error " + context.getDisplayName() + " test has failed ******");
        log.info("==========================================");
        log.info("Driver on which case test case failed : " + testBase.getDriver());
        log.info("==========================================");
    }

    public File createScreenshotOfWindow(WebDriver driver, String testName) throws FileNotFoundException { // screenshot on failure
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment(testName + "-Screenshot", new FileInputStream(screenshot)); // bypass adding one more attachment with one line code
        return screenshot;
    }

    public void makingAFile(WebDriver driver, String name) throws FileNotFoundException {

        final File screenshot = createScreenshotOfWindow(driver, name);
        File destFile = new File("FailedScreenshots" + "/" + name);
        try {
            FileUtils.copyFileToDirectory(screenshot, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
            // making a file for screenshot
    }

}
