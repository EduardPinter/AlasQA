package driverInit;

import extensions.DriverQuit;
import extensions.GetTestName;
import extensions.TestFailed;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ExtendWith(GetTestName.class)
@ExtendWith(DriverQuit.class) // if the position of extendWith was reversed the screenshot would fail because
@ExtendWith(TestFailed.class) // the driver would be null

public class TestBase {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void initializeWebDriver() throws IOException {
        log.info("Initializing the driver....");
        log.info("==========================================");
        String property = System.getProperty("browser", "chrome"); // default value for running tests through Intellij

        switch (property.toLowerCase()) {
            case "chrome":
                log.info("Chrome was chosen!");
                getChromeDriver();
                break;
            case "firefox":
                log.info("Firefox was chosen!");
                getFirefoxDriver();
                break;
            case "edge":
                log.info("Microsoft Edge was chosen!");
                getMicrosoftEdge();
                break;
            case "ie":
                log.info("Internet Explorer was chosen!");
                getInternetExplorer();
                break;
            default:
                throw new RuntimeException("Unsupported browser! Will not start any browser! Examples to write : microsoftEdge, internetExplorer, chrome, firefox");
        }

    }


    public void getChromeDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void getFirefoxDriver() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void getInternetExplorer() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void getMicrosoftEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public WebDriver getDriver() {
        return driver;
    }
}

