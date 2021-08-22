package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InteractionsPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(InteractionsPage.class);

    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(4) > .text")
    protected WebElement droppablePage;

    public InteractionsPage(WebDriver driver) {
        log.info("Currently on the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on Droppable Page")
    public DroppablePage clickOnDroppablePage() {
        log.info("Clicking on Droppable Page");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", droppablePage);
        droppablePage.click();
        return new DroppablePage(driver);
    }


}
