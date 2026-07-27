package com.qa.telco.pages;

import com.microsoft.playwright.Page;

public class SimplictyPlanPage {

	private Page page;

	public SimplictyPlanPage(Page page) {
		this.page=page;
	}
	
	
	
	public String getSPPagetitle() {
		String SPtitle= page.title();
		System.out.println("SPPage title: " + SPtitle);
		return SPtitle;
	}
	
}
