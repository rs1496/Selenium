package com.salesforce.automation.pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.salesforce.automation.constants.SalesForceConstants.IDFC_BASE_URL;

public class LoginPage {

	@FindBy(xpath = "//*[@id=\"username\"]")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"Login\"]")
	private WebElement loginButton;
	
	private  WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		 this.driver = driver; 
		 PageFactory.initElements(driver, this);
	}
	public void performLogin(String userName, String pwd) {
		driver.get(IDFC_BASE_URL);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
	
}
