import demoQApom.DroppablePage;
import demoQApom.InteractionsPage;
import demoQApom.MainPage;
import demoQApom.ToolTipPage;
import driverInit.TestBase;
import googlePom.BasePage;
import googlePom.SearchedResults;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Test_DemoQA extends TestBase {

    private final Logger log = LoggerFactory.getLogger(Test_DemoQA.class);
    private String demoQAUrl = "https://demoqa.com/";

    @Story("DemoQA drag and drop, hover functions")
    @Description("Drag and drop elements, hovering button and getting the hover message")
    @Test
    public void testDemoQA() throws IOException {
        BasePage basePage = new BasePage(driver);
        basePage.visitUrl();
        basePage.searchDemoQA();
        SearchedResults searchedResults = basePage.clickSearchButton();
        MainPage mainPage = searchedResults.clickFirstSearchResult();
        Assertions.assertEquals(demoQAUrl, driver.getCurrentUrl(), "It's not the right page url");
        InteractionsPage intPage = mainPage.clickOnInteractions();
        DroppablePage dropPage = intPage.clickOnDroppablePage();
        dropPage.dragAndDropElement(); // Drag and Drop function works using Firefox for testing
        dropPage.printDrophereBoxText();
        dropPage.screenshotElement();
        dropPage.clickOnWidgetsDropdown();
        ToolTipPage toolTipPage = dropPage.clickOnToolTipPage();
        toolTipPage.hoverButton(); // Hovering function works using Chrome for testing
        log.info(toolTipPage.getButtonText());


    }
}
