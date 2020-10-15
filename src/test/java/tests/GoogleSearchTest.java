package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ResultsPage;
import utilites.Log;

public class GoogleSearchTest extends BaseTest {

    //1. Go to main page
    //2. Type the search query
    //3. Submit the query
    //4. Verify that results page is displayed
    @Test (priority = 2)
    public void test0001() {
        String queryForSearch = "Selenium and Maven";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Log.info("Main page was opened");
        mainPage.typeQuery(queryForSearch);
        Log.info("Query was typed");
        mainPage.submitQuery();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.waitForStats();
        boolean statsVisible = resultsPage.isStatsVisible();
        Log.info("Waiting to result!");
        Assert.assertTrue(statsVisible);
        Log.info("Stats is visible!");
    }

    @Test (priority = 3)
    public void test0002() {
        String queryForSearch = "TestNg and prioritize";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.typeQuery(queryForSearch);
        mainPage.submitQuery();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.waitForStats();
        boolean statsVisible = resultsPage.isStatsVisible();

        Assert.assertTrue(statsVisible);
    }


    @Test (priority = 1)
    public void test_SearchWithParameter() {
        String queryForSearch = "In JAVA we trust!";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.typeQuery(queryForSearch);
        mainPage.submitQuery();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.waitForStats();
        boolean statsVisible = resultsPage.isStatsVisible();

        Assert.assertTrue(statsVisible);
    }
}
