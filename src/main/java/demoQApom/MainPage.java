package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MainPage.class);

    @FindBy(css = "div:nth-of-type(1) > div > .card-up")
    protected WebElement elementsPage;
    @FindBy(css = "div:nth-of-type(4) > div > .card-up")
    protected WebElement widgetsPage;
    @FindBy(css = "div:nth-of-type(5) > div > .card-up")
    protected WebElement interactionsPage;


    public MainPage(WebDriver driver) {
        log.info("Currently on the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on Interactions section")
    public InteractionsPage clickOnInteractions() {
        log.info("Clicking on Interactions Page");
        log.info("==========================================");
        interactionsPage.click();
        return new InteractionsPage(driver);
    }

}
