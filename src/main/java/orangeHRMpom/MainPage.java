package orangeHRMpom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);

    @FindBy(css = "#menu_recruitment_viewRecruitmentModule > a:nth-of-type(1) .left-menu-title")
    protected WebElement recruitmentSidePanel;
    @FindBy(css = "#menu_recruitment_viewCandidates > span.left-menu-title")
    protected WebElement candidatesPage;

    public MainPage(WebDriver driver) {
        log.info("Url of the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on 'Recruitment' section in left side panel")
    public void clickRecruitmentSidePanel() {
        log.info("Clicking on 'Recruitment' section in left side panel");
        log.info("==========================================");
        recruitmentSidePanel.click();
    }

    @Step("Clicking on 'Candidates' section in left side panel")
    public CandidatesPage clickOnCandidatesSidePanel() {
        log.info("Clicking on 'Candidates' section in left side panel");
        log.info("==========================================");
        candidatesPage.click();
        return new CandidatesPage(driver);
    }
}
