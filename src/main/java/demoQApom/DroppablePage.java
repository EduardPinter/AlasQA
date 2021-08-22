package demoQApom;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class DroppablePage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(DroppablePage.class);

    @FindBy(css = "div#draggable")
    protected WebElement draggable;
    @FindBy(css = "#simpleDropContainer #droppable")
    protected WebElement droppable;
    @FindBy(css = "div:nth-of-type(4) > .group-header > .header-wrapper > .header-text")
    protected WebElement widgetsDropdown;
    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(7) > .text")
    protected WebElement toolTipPage;
    @FindBy(css = "#droppable > p")
    protected WebElement dropHereBoxText;
    @FindBy(css = "#app > div > div > div.row")
    protected WebElement screenshotOfPage;


    public DroppablePage(WebDriver driver) {
        log.info("Currently on the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Drag and Drop element")
    public void dragAndDropElement() {
        log.info("Drag and Drop element");
        log.info("==========================================");
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(draggable)
                .moveToElement(droppable)
                .release(droppable)
                .build();
        dragAndDrop.perform();
    }

    @Step("Printing 'Drop here' box text")
    public void printDrophereBoxText() {
        log.info("Printing the text from big box");
        log.info("==========================================");
        log.info("Text that is inside the 'Drop here' box is now :" + dropHereBoxText.getText());
        log.info("++++++++++++++++++++++++++++++++++++++++++");
    }

    @Step("Screenshoting the Element")
    public void screenshotElement() throws IOException {
        log.info("Screenshoting the Element");
        log.info("==========================================");
        File file = screenshotOfPage.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenshot.png"));
    }

    @Step("Clicking on Widgets Dropdown on Droppable page")
    public void clickOnWidgetsDropdown() {
        log.info("Clicking on Widgets dropdown on left side panel");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsDropdown);
        widgetsDropdown.click();
    }

    @Step("Clicking on ToolTip Page")
    public ToolTipPage clickOnToolTipPage() {
        log.info("Clicking on ToolTip Page");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toolTipPage);
        toolTipPage.click();
        return new ToolTipPage(driver);
    }

}
