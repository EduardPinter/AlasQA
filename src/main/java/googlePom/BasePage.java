package googlePom;

import demoQApom.MainPage;
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

    @FindBy(css = ".a4bIc > input[role='combobox']")
    protected WebElement searchBoxInput;
    @FindBy(xpath = "/html/body//form[@role='search']//div[@class='A8SBwf']/div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")
    protected WebElement googleSearchButton;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Visiting Google search")
    public void visitUrl() {
        log.info("Visiting google.com");
        log.info("==========================================");
        driver.get("https://www.google.com/");
    }

    @Step("Typing word 'cheese' into input field")
    public void searchCheese() {
        log.info("Searching for results for word 'cheese'");
        log.info("==========================================");
        searchBoxInput.sendKeys("cheese");
    }

    @Step("Typing word 'demoqa.com' into input field")
    public void searchDemoQA() {
        log.info("Searching for results for word 'demoqa.com'");
        log.info("==========================================");
        searchBoxInput.sendKeys("demoqa.com");
    }

    @Step("Clicking 'Google Search' button")
    public SearchedResults clickSearchButton() {
        log.info("Clicking 'Google Search' button");
        log.info("==========================================");
        googleSearchButton.click();
        return new SearchedResults(driver);
    }


}
