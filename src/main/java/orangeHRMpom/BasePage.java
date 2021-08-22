package orangeHRMpom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);

    @FindBy(id = "btnLogin")
    protected WebElement loginButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Visiting the url of the page")
    public void visitUrl() {
        log.info("Visiting orangeHrm page url");
        log.info("==========================================");
        driver.get("https://orangehrm-demo-7x.orangehrmlive.com/");
    }

    @Step("Clicking on Login button")
    public MainPage clickLoginButton() {
        log.info("Clicking on Login button");
        log.info("==========================================");
        loginButton.click();
        return new MainPage(driver);
    }
}
