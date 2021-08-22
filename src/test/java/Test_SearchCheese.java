import driverInit.TestBase;
import googlePom.BasePage;
import googlePom.SearchedResults;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test_SearchCheese extends TestBase {

    private final Logger log = LoggerFactory.getLogger(Test_SearchCheese.class);
    private String resultStat = String.format("Око %s резултата ", "777");

    @Story("Searching for word 'cheese', google")
    @Description("Searching for word 'cheese' on google and asserting the results")
    @Test
    public void testGoogleSearchCheese() {
        BasePage basePage = new BasePage(driver);
        basePage.visitUrl();
        basePage.searchCheese();
        SearchedResults srcResult = basePage.clickSearchButton();
        Assertions.assertTrue(srcResult.getResultStatsText().contains("777"), "There is too much cheese on the internet");
        //Assertions.assertEquals(resultStat, srcResult.getResultStatsText(), "There is too much cheese on the internet");

    }
}
