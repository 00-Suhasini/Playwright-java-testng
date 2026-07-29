package com.qa.telco.tests;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.microsoft.playwright.Page;
import com.qa.telco.factry.playmightfactry;
import com.qa.telco.pages.HomePage;
import com.qa.telco.pages.SimplictyPlanPage;



public class BaseTest {
    playmightfactry pf;
	protected static Page page;
	 
	public static Page getPage() {
		return page;
	}
	
	protected Properties prop;
	protected HomePage homePage;   
	protected SimplictyPlanPage SPPage;
	@BeforeMethod
	public void setup() {
		
	    pf=new playmightfactry();
		prop = pf.init_prop();
		page =pf.initBrowser(prop);
		System.out.println("BaseTest page = " + page);
		homePage = new HomePage(page);
		
		//SPPage= new SimplictyPlanPage(page);
	}
	
	

	@AfterMethod
	public void tearDown() {
		//page.context().browser().close();
	}
}
