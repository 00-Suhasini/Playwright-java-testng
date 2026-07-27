package com.qa.telco.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.telco.constants.Appconstants;
import com.qa.telco.pages.HomePage;

public class HomePageTest extends BaseTest {
  
	protected HomePage homePage;   
	
	
	
	@Test(priority = 1)
	public void HomePageTitleTest() {
		homePage = new HomePage(page);
		String actualTitle=homePage.getHomePgTitle();
		Assert.assertEquals(actualTitle,Appconstants.LOGIN_APP_TITLE);
	}
	
	@Test(priority = 2)
	public void HomePageurlTest() {
		homePage = new HomePage(page);
		String acutalURL=homePage.getHomePgurl();
		Assert.assertEquals(acutalURL,prop.getProperty("url"));
	}
	

	
	@Test(priority = 4)
	public void HomePageSearchheaderTest() {
		homePage = new HomePage(page);
		String actualHeader=homePage.doSearch();
		Assert.assertEquals(actualHeader, Appconstants.HOMEPAGE_APPHEADER);
	}
	
	@Test(priority =5)
	public void SimplictyPlanPageTest() {
		homePage = new HomePage(page);
		
		
		
		homePage.clickSimplictyPlan();
		
	}
	
	
}
