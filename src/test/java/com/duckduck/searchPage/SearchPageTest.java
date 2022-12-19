package com.duckduck.searchPage;

import BaseConfig.BaseTest;
import duckduck.searchPage.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    @Test
    @Parameters({"Keywords"})
    public void search(String Keywords){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goToSearchPage();
        searchPage.doSearch(Keywords);
        searchPage.goToVideos();
        int size =searchPage.getResult();
        Assert.assertTrue(size > 0);
    }

}
