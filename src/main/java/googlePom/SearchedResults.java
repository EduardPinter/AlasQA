package googlePom;

import demoQApom.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class SearchedResults {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(SearchedResults.class);

    @FindBy(id = "result-stats")
    protected WebElement resultStats;
    @FindBy(xpath = "/html//div[@id='rso']/div//div/div/div//a/h3")
    protected List<WebElement> firstPageResult;

    public SearchedResults(WebDriver driver) {
        log.info("Currently on the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting result stats text")
    public String getResultStatsText() {
        log.info("Getting result stats text");
        log.info("==========================================");
        return resultStats.getText();
    }

    @Step("Clicking first search result")
    public MainPage clickFirstSearchResult() {
        log.info("Clicking first search result");
        log.info("==========================================");
        firstPageResult.get(0).click();
        return new MainPage(driver);
    }


}