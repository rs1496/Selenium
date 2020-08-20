package com.salesforce.automation.config;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {
	
	public static ChromeOptions getDriverConfigOptions() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		//options.addArguments("user-data-dir=" + System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		return options;
	}
}
