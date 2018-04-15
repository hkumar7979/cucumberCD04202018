package com.cucumber.framework.stepdefinition.ProductCategory;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.HomePage;
import com.cucumber.framework.pageobject.WomenMainPage;
import com.cucumber.framework.pageobject.WomenTopsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class WomenTopsProductCategory {
	
private final Logger log= LoggerHelper.getLogger(WomenTopsProductCategory.class);
HomePage homepage;
WomenMainPage womenMainPg;
WomenTopsPage womenTopsPage;

@Given("^User click on women navigation menu$")
public void user_click_on_women_navigation_menu() throws Throwable {
  homepage = new HomePage(TestBase.driver);
  log.info("Clicking on Women menu");
  womenMainPg = homepage.clickOnMenu(homepage.womenMenu);
    
}

@And("^click on women's Tops link$")
public void User_clicks_on_Tops_link() throws Throwable {
	womenTopsPage= womenMainPg.clickOnWomenTopsLink(womenMainPg.topsLink);  
}

@Then("^Verify Tops page is displayed$")
public void Verify_Tops_page_is_displayed() throws Throwable {
	womenTopsPage.verifyWomenTopPageHeader();
}


@And("^click on orange color filter$")
public void click_on_orange_color_filter() throws Throwable {
	womenTopsPage.selectColor(womenTopsPage.Orange);
    log.info("We are selecting " +womenTopsPage.Orange);
    
}

@Then("^verify total number of women product displayed as \"([^\"]*)\"$")
public void verify_total_number_of_women_product_displayed_as(String arg1) throws Throwable {
   int total= womenTopsPage.getTotalProducts();
   if(total==Integer.parseInt(arg1))
	   Assert.assertTrue(true, "given product count is matching");
   else
	   Assert.assertFalse(false,"given product count is not matching");
   
}

}
