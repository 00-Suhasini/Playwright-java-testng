package com.qa.telco.factry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;


import com.microsoft.playwright.Playwright;

public class playmightfactry {
    Playwright play;
    Browser brow;
    Properties prop;
    
    BrowserContext context;
    Page page;
	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);
		play= Playwright.create();
		switch(browserName.toLowerCase()) {
		case "chromium":
			brow = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			brow = play.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			brow = play.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
		
			brow = play.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;	
		default:
			System.out.println("pass the browsername correctly");
			break;
			}
		context = brow.newContext();
		page = context.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
		}
	
	public Properties init_prop() {
		try {
			FileInputStream fis= new FileInputStream("./src/test/resourcess/config/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
