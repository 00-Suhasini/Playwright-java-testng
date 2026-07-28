package com.qa.telco.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://www.verizon.com"
	 Page page;
//String locators
    
	private String mobilesearch = "button#gnav20-Mobile-L1";
    private String smartphoneClick="a:has-text('Smartphones')";
    
    
    
    private String header="h1 span:has-text('Smartphones')";
    private String simplctyPlanTab = "a[class='vui:cmp-quicklinks__anchor vui:button vui:cmp-quicklinks__anchor__dark_brand']:has-text('Simplicity Plan')";

	
    private String HomePagename="a[title='Verizon Home Page']";

	//constructor
	public HomePage(Page page) {
		this.page=page;
	    System.out.println("HomePage page = " + this.page);
	}
	
	//page actions/methods
	public String getHomePgTitle() {
		String title = page.title();
		System.out.println("page title: " + title);
		
		return title;
	}
	
    
	
	public String getHomePgurl() {
	String url = page.url();
	
	System.out.println("page url : " + url);
	return url;
}
  
    public String doSearch() {
    	
    	
    	page.locator(mobilesearch).click();
    	page.click(smartphoneClick);
    	return page.textContent(header);
    	
    }
    
     public SimplictyPlanPage clickSimplictyPlan() {
    	page.click(HomePagename);
    	page.click(simplctyPlanTab);
    	//String SPtitle = page.title();
    	//System.out.println("SP page title: " + SPtitle);
    	return new SimplictyPlanPage(page);
    }
	
}

