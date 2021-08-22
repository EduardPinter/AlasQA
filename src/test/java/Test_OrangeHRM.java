import driverInit.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import orangeHRMpom.BasePage;
import orangeHRMpom.CandidatesPage;
import orangeHRMpom.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test_OrangeHRM extends TestBase {

    private final Logger log = LoggerFactory.getLogger(Test_OrangeHRM.class);
    private Integer numberOfCandidatesBefore;
    private Integer numberOfCandidatesAfter;

    @Story("Candidates table, adding and removing")
    @Description("Adding new candidates, removing them, asserting the table update")
    @Test
    public void testOrangeHrm() {
        BasePage basePage = new BasePage(driver);
        basePage.visitUrl();
        MainPage mainPage = basePage.clickLoginButton();
        mainPage.clickRecruitmentSidePanel();
        CandidatesPage candidatesPage = mainPage.clickOnCandidatesSidePanel();
        candidatesPage.switchToIframe();
        numberOfCandidatesBefore = candidatesPage.getNumberOfCandidates();
        log.info("Number of Candidates right now : " + numberOfCandidatesBefore);
        numberOfCandidatesAfter = numberOfCandidatesBefore + 1;
        candidatesPage.clickAddCandidateButton();
        candidatesPage.enterFirstName();
        candidatesPage.enterLastName();
        candidatesPage.enterEmail();
        candidatesPage.selectVacancy();
        candidatesPage.uploadResume();
        candidatesPage.clickSaveNewCandidate();
        log.info("Number of Candidates right now : " + candidatesPage.getNumberOfCandidates());
        Assertions.assertEquals(numberOfCandidatesAfter, candidatesPage.getNumberOfCandidates(), "Number of candidates has not increased by 1");
        candidatesPage.checkBoxNewCandidate();
        candidatesPage.clickOnOptionsForCandidates();
        candidatesPage.deleteCandidates();
        candidatesPage.checkForBottomNumberOfCandidates();
        log.info("Number of Candidates right now : " + candidatesPage.getNumberOfCandidates());
        Assertions.assertEquals(numberOfCandidatesBefore, candidatesPage.getNumberOfCandidates(), "Number of candidates has not decreased by 1");
        candidatesPage.clickUserDropdown();
        candidatesPage.clickLogout();
    }

}
