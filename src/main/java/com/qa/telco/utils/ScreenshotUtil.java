package com.qa.telco.utils;


	import java.nio.file.Paths;

	import com.microsoft.playwright.Page;

	public class ScreenshotUtil {

	    public static String captureScreenshot(Page page, String testName) {

	        String path = "./test-output/screenshots/" + testName + ".png";

	        page.screenshot(new Page.ScreenshotOptions()
	                .setPath(Paths.get(path))
	                .setFullPage(true));

	        return path;
	    }
	}

