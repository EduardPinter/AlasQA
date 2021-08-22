package orangeHRMpom;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CandidatesPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected String filePath = "/home/edi/IdeaProjects/AlasQA/resume.txt";

    @FindBy(css = "tr.dataDefaultRaw")
    protected List<WebElement> numberOfCandidates;
    @FindBy(css = "#fromToOf > div")
    protected WebElement bottomNumberOfCandidates;
    @FindBy(css = "body.material-icons-visible:nth-child(2) div.menu-visible:nth-child(2) div.recruitment div.row.content:nth-child(9) div.col.l12.pageholder div.fixed-action-btn:nth-child(1) a.btn-floating.btn-large.tooltipped > i.large.mdi-content-add.material-icons")
    protected WebElement addCandidateButton;
    @FindBy(tagName = "iframe")
    protected WebElement iFrame;
    @FindBy(css = "#addCandidate_firstName")
    protected WebElement firstname;
    @FindBy(css = "#addCandidate_lastName")
    protected WebElement lastName;
    @FindBy(css = "#addCandidate_email")
    protected WebElement email;
    @FindBy(css = "#textarea_addCandidate_vacancy")
    protected WebElement vacancy;
    @FindBy(css = "body.material-icons-visible:nth-child(2) div.menu-visible:nth-child(2) div.recruitment div.modal.modal-fixed-footer.custom-height-modal.open:nth-child(4) div.customized-modal-content.modal-content.row div.col.l12:nth-child(6) div.input-field.col.l8:nth-child(1) div.materializeWidgetObjectMultySelect-container:nth-child(1) ul.dropdown-content.dropdownObjectSearch.active:nth-child(2) li:nth-child(1) a.searchObjectA.employeeSearchBox > input.employee-search.validate")
    protected WebElement vacancyType;
    @FindBy(css = "body.material-icons-visible:nth-child(2) div.menu-visible:nth-child(2) div.recruitment div.modal.modal-fixed-footer.custom-height-modal.open:nth-child(4) div.customized-modal-content.modal-content.row div.col.l12:nth-child(6) div.input-field.col.l8:nth-child(1) div.materializeWidgetObjectMultySelect-container:nth-child(1) ul.dropdown-content.dropdownObjectSearch.active:nth-child(2) div:nth-child(2) li.searchSingleObjectLi.not-selected:nth-child(10) a.searchObjectA > p.search-row.searchListObjectName")
    protected WebElement vacancyQAEngineer;
    @FindBy(id = "addCandidate_resume")
    protected WebElement resumeUpload;
    @FindBy(css = "#saveCandidateButton")
    protected WebElement saveNewCandidate;
    @FindBy(css = "tr:nth-of-type(1) > .material-checkbox > label")
    protected WebElement newAddedCandidateCheckbox;
    @FindBy(id = "ohrmList_Menu")
    protected WebElement optionsForCandidates;
    @FindBy(linkText = "Delete")
    protected WebElement deleteCandidatesButton;
    @FindBy(id = "candidate-delete-button")
    protected WebElement deleteConfirmation;
    @FindBy(id = "user-dropdown")
    protected WebElement userDropdown;
    @FindBy(css = "#logoutLink")
    protected WebElement logoutLink;

    public CandidatesPage(WebDriver driver) {
        log.info("Url of the page : " + driver.getCurrentUrl());
        log.info("==========================================");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting Number of candidates")
    public Integer getNumberOfCandidates() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(addCandidateButton));
        Integer counter = numberOfCandidates.size();
        return counter;
    }

    @Step("Clicking Add Candidate button")
    public void clickAddCandidateButton() {
        log.info("Clicking + sign to add new candidate");
        log.info("==========================================");
        addCandidateButton.click();
    }

    @Step("Switching to iframe window on the page")
    public void switchToIframe() {
        log.info("Switching to iframe window on the page");
        log.info("==========================================");
        driver.switchTo().frame(iFrame);
    }

    @Step("Typing first name")
    public void enterFirstName() {
        log.info("Entering first name");
        log.info("==========================================");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(firstname));
        firstname.sendKeys("QA Automation - " + java.time.LocalDate.now());
    }

    @Step("Typing last name")
    public void enterLastName() {
        log.info("Entering last name");
        log.info("==========================================");
        lastName.sendKeys("Pinter");
    }

    @Step("Typing email")
    public void enterEmail() {
        log.info("Entering email");
        log.info("==========================================");
        email.sendKeys("ep.96@gmail.com");
    }

    @Step("Selecting Vacancy")
    public void selectVacancy() {
        log.info("Selecting vacancy");
        log.info("==========================================");
        vacancy.click();
        vacancyType.click();
        vacancyType.sendKeys("QA");
        vacancyQAEngineer.click();
    }

    @Step("Uploading resume")
    public void uploadResume() {
        log.info("Uploading resume");
        log.info("==========================================");
        resumeUpload.sendKeys(filePath);
    }

    @Step("Saving new Candidate")
    public void clickSaveNewCandidate() {
        log.info("Saving new created candidate");
        log.info("==========================================");
        saveNewCandidate.click();
    }

    @Step("Clicking checkbox on newly added candidate")
    public void checkBoxNewCandidate() {
        log.info("Checking the box on the left side for the newly created candidate");
        log.info("==========================================");
        newAddedCandidateCheckbox.click();
    }

    @Step("Clicking for more options for candidates")
    public void clickOnOptionsForCandidates() {
        log.info("Clicking on three dots for options on Candidates");
        log.info("==========================================");
        optionsForCandidates.click();
    }

    @Step("Deleting a candidate")
    public void deleteCandidates() {
        log.info("Deleting the new created candidate");
        log.info("==========================================");
        deleteCandidatesButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(deleteConfirmation));
        deleteConfirmation.click();
    }

    @Step("Clicking user dropdown")
    public void clickUserDropdown() {
        log.info("Clicking user dropdown on the left side panel");
        log.info("==========================================");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        userDropdown.click();
    }


    public void checkForBottomNumberOfCandidates() {         // A method which had to be implemented in order for the page to fully wait
        Integer counter = numberOfCandidates.size();        // for the candidate to be deleted, if not implemented the test would fail
        counter -= 1;                                         // because the page would assert the number before fully deleting the candidate
                                                                // and it would grab the number as if the candidate was not deleted.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(bottomNumberOfCandidates, String.valueOf(counter)));
    }

    @Step("Clicking logout button")
    public void clickLogout() {
        log.info("Logging out of the application");
        log.info("==========================================");
        logoutLink.click();
    }

}
