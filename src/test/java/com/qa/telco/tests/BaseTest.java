package com.qa.telco.tests;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.telco.factry.playmightfactry;
import com.qa.telco.pages.HomePage;
import com.qa.telco.pages.SimplictyPlanPage;

public class BaseTest {
    playmightfactry pf;
	Page page;
	
	
	protected Properties prop;
	HomePage homePage;   
	SimplictyPlanPage SPPage;
	@BeforeTest
	public void setup() {
		
	    pf=new playmightfactry();
		prop = pf.init_prop();
		page =pf.initBrowser(prop);
		homePage = new HomePage(page);
		SPPage= new SimplictyPlanPage(page);
	}
	
	

	@AfterTest
	public void tearDown() {
		//page.context().browser().close();
	}
}
