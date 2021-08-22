package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ToolTipPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(ToolTipPage.class);

    @FindBy(xpath = "/html//button[@id='toolTipButton']")
    protected WebElement toolTipBtn;
    @FindBy(id = "buttonToolTip")
    protected WebElement btnMessage;


    public ToolTipPage(WebDriver driver) {
        log.info("Currently on the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Hovering over a button")
    public void hoverButton() {
        log.info("Hovering over a button");
        log.info("==========================================");
        Actions action = new Actions(driver);
        action.moveToElement(toolTipBtn).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(btnMessage));
    }

    @Step("Getting button hover text message")
    public String getButtonText() {
        log.info("Getting button hover text message");
        log.info("==========================================");
        return btnMessage.getText();
    }


}
