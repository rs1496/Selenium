package com.salesforce.automation.pageModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.salesforce.automation.config.ExtentConfigurer;
import com.salesforce.automation.datamodel.LeadDataModel;
import com.salesforce.automation.utility.XlsOperationsUtility;



public class LeadPage {
	
	public LeadPage(WebDriver driver)
	{
		this.driver = driver;
		builder = new Actions(driver);
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	}
	
	private WebDriver driver;	
	private WebDriverWait wait;
	Actions builder;
	
	
	
	@FindBy(xpath = "//div[text()='New']")
	private WebElement newButton;
	
	@FindBy(xpath = "//a[@data-itemid='Lead']/span[2]/span[text()='Leads']")
	private WebElement leadsDropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Log out as')]")
	private WebElement logOutLink;
	
	
	@FindBy(xpath = "//input[starts-with(@placeholder,'Search')]/ancestor::div[1][@class='uiInput uiAutocomplete uiInput--default']/input")
	private WebElement globalSearchField;
	
	@FindBy(xpath = "//ul[@class='lookup__list  visible']/li[2]")
	private WebElement globalSearchValueSelection;
	
	
	@FindBy(xpath = "//ul[@class='lookup__list  visible']/li[1]")
	private WebElement globalSearchValueFirstOption;
	
	@FindBy(xpath = "//div[@title='User Detail']")
	private WebElement userDetailButton;
	
	@FindBy(xpath = "//h2[text()='User Detail']/following::input[@title='Login'][1]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//button[@title='Show Navigation Menu']")
	private WebElement navigationMenuDropdown;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//span[text()='Product']/following::a[1][@class='select']")
	private WebElement productDropdown;
	
	@FindBy(xpath = "//span[text()='Last Name']/following::input[1]")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//span[text()='Mobile No.']/ancestor::label[1]/following::input[1]")
	private WebElement mobilenoField;
	
	@FindBy(xpath = "//span[text()='Lead Source']/following::a[1]")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//a[@title='Home']")
	private WebElement homeDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Account']/span[2]/span[text()='Accounts']")
	private WebElement accountDropdown;
	
	@FindBy(xpath = "//button[@title='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='modal-footer slds-modal__footer']/button[2]/span[text()='Save']")
	private WebElement saveButtonOfNTBLeadPage;
	
	@FindBy(xpath = "//span[text()='Lead Lifecycle']")
	private WebElement leadlifecycle;
	
	@FindBy(xpath = "//p[text()='Lead ID']/following::slot[1]/lightning-formatted-text")
	private WebElement leadNumber;
	
	@FindBy(xpath = "//p[text()='Lead Owner']/following::a[1]")
	private WebElement leadOwner;
	
	@FindBy(xpath = "//p[text()='Lead Status']/following::slot[1]/lightning-formatted-text")
	private WebElement leadStatus;
	
	@FindBy(xpath = "//p[text()='Lead Sub Status']/following::slot[1]/lightning-formatted-text")
	private WebElement leadSubStatus;
	
	@FindBy(xpath = "//span[text()='Channel Partner']/following::a[1]")
	private WebElement channelPartnerDropdown;
	
	@FindBy(xpath = "//span[text()='First Name']/following::input[1]")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//button[text()='Add'][@type='button']")
	private WebElement addbuttonOfAction;
	
	@FindBy(xpath ="//div[text()='Quick Actions']/following::div[text()='New Lead']")
	private WebElement newLeadButtonOfQuickActions;
	
	@FindBy(xpath = "//span[text()='Segment Type']/following::a[1]")
	private WebElement segmentTypeDropdown;
	
	@FindBy(xpath = "//input[@placeholder='Search this list...']")
	private WebElement searchThisListField;
	
	@FindBy(xpath = "//table[@data-aura-class='uiVirtualDataTable']/tbody[1]/tr[1]/th[1]/span/a[1]")
	private WebElement topAccountName;
	
	@FindBy(xpath = "//img[@class='icon noicon']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement logout;
	
	@FindBy(xpath = "//label[text()='Username']")
	private WebElement usernamelabel;
	
	public void sampleLoginTest(LeadDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			this.performClickWithAction(userIcon);
			//userIcon.click();
			Thread.sleep(3000);
			logout.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(usernamelabel));
			usernamelabel.isDisplayed();
			System.out.println("Successfully tested sample login");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}

	
	
	
	public void clearTab() {
		try {
			Thread.sleep(2000);			
			driver.findElements(By.xpath("//button[contains(@title,'Close')][@type='button']")).stream()
			.forEach(item -> item.click());
						
			Thread.sleep(1000);

		} catch (Exception e) {
			// do nothing
		}
	}
	
	private void performClickWithAction(WebElement element)
    {
		 try
		 {			 			
			 builder.moveToElement(element).click(element);			 		
			 Thread.sleep(1000);
			 builder.perform();
			 Thread.sleep(1000);
		 }		 
		 catch (InterruptedException e)
		 {			 
			 e.printStackTrace();
		 }
    }

	
	 private String trimQuote(String str)
	 {
		 	return str.replaceAll("'", "");
	 }
	 
	 private void selectElement(WebElement element, String option)
		{
			Select selectElement = new Select(element);
			selectElement.selectByVisibleText(option);
		}

	
	public void logoutUser(LeadDataModel handler)
	{
		try
		{					
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");					
		}
		
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void continueExecution()
	{
		try
		{
						
			if(logOutLink.isDisplayed())
			{
				logOutLink.click();
				System.out.println("Logged out NOW");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void searchUserAndLoginByBranchOrBOCUser(LeadDataModel handler)
	{
		try
		{
			Thread.sleep(3000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);		
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			homeDropdown.click();
			Thread.sleep(3000);
			
			
			Actions action = new Actions(driver);
			action.doubleClick(globalSearchField).perform();
			
			
			globalSearchField.sendKeys(this.trimQuote(handler.getGlobalSearch()));			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.visibilityOf(userDetailButton)).click();
			System.out.println("Clicked on UserDetails button");
			Thread.sleep(2000);
			driver.navigate().refresh();
			
			Thread.sleep(15000);
			driver.switchTo().frame(0);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(loginButton));
			this.performClickWithAction(loginButton);
			
			System.out.println("Logged in Successfully");
			Thread.sleep(10000);
			driver.navigate().refresh();
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void searchUserLoginOnSetUpPage(LeadDataModel handler)
	{
		try
		{
			Thread.sleep(3000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(2000);
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(3000);
			
			Thread.sleep(8000);
			
			this.continueExecution();		
			
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.doubleClick(globalSearchField).perform();
			
			
			globalSearchField.sendKeys(this.trimQuote(handler.getGlobalSearch()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);			
						
			Thread.sleep(15000);
			driver.switchTo().frame(0);
			Thread.sleep(10000);
			this.performClickWithAction(loginButton);
			
			System.out.println("Logged in Successfully");
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void selectAccount(LeadDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			this.clearTab();			
			Thread.sleep(5000);	
			this.clearTab();
			Thread.sleep(2000);
			this.clearTab();
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(5000);
			homeDropdown.click();
			System.out.println("Home dropdown is selected");
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			accountDropdown.click();	
			System.out.println("Account dropdown is selected");
			
			//driver.navigate().refresh();
			
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(searchThisListField));
			
			//Thread.sleep(6000);	
			searchThisListField.clear();
			searchThisListField.sendKeys(handler.getAccountName());
			searchThisListField.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='1 item • ']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topAccountName);
			System.out.println("Selected Account");
			Thread.sleep(5000);
			
			
						
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createNTBLead(LeadDataModel handler)
	{
		try
		{
			this.clearTab();
			System.out.println("Closing All Tabs");
			driver.navigate().refresh();
			this.clearTab();
			this.clearTab();
			this.clearTab();
			this.clearTab();
			Thread.sleep(7000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			leadsDropdown.click();
			Thread.sleep(1000);
			this.clearTab();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(newButton)).click();
			
			
			String recordtypevalue = handler.getRecordType();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='changeRecordTypeTopDownOneColumn']/fieldset/div/label/span[2][text()='"+recordtypevalue+"']"))).click();
			
			nextButton.click();
			System.out.println("Clicked on next button");
			
			wait.until(ExpectedConditions.visibilityOf(productDropdown));
			
			productDropdown.click();						
			String productval = handler.getProduct();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+productval+"']"))).click();
			
			mobilenoField.click();
			mobilenoField.sendKeys("7738544453");
			
			firstNameField.sendKeys(handler.getFirstname());
			lastNameField.sendKeys(handler.getLastname());
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",leadlifecycle);
			Thread.sleep(2000);
			
			leadSourceDropdown.click();
			String leadsourceval = handler.getLeadSource();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+leadsourceval+"']"))).click();
			
			
			
			
			saveButton.click();
			System.out.println("Clicked on save button");
			
			
			
			
			wait.until(ExpectedConditions.visibilityOf(leadNumber));
			XlsOperationsUtility.captureScreenshot(driver, "LeadCreated");
			
			String leadno = leadNumber.getText();
			System.out.println("Lead ID" +" "+ leadno);
								
			String leadownerval = leadOwner.getText();
			System.out.println("Lead Owner" +" "+ leadownerval);	
			
			String leadstatusval = leadStatus.getText();
			System.out.println("Lead Status" +" "+ leadstatusval);
			
			String leadsubstatusval = leadSubStatus.getText();
			System.out.println("Lead Sub Status" +" "+ leadsubstatusval);
			
			
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	

	

	public void createNTBLeadForAssetsChannelPartner(LeadDataModel handler)
	{
		try
		{
			this.clearTab();
			System.out.println("Closing All Tabs");
			Thread.sleep(3000);
			
			this.clearTab();
			this.clearTab();
			this.clearTab();
			this.clearTab();
			Thread.sleep(7000);
			navigationMenuDropdown.click();
			Thread.sleep(1000);
			leadsDropdown.click();
			wait.until(ExpectedConditions.visibilityOf(newButton)).click();
			
			
			String recordtypevalue = handler.getRecordType();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='changeRecordTypeTopDownOneColumn']/fieldset/div/label/span[2][text()='"+recordtypevalue+"']"))).click();
			
			nextButton.click();
			System.out.println("Clicked on next button");
			
			wait.until(ExpectedConditions.visibilityOf(productDropdown));
			
			productDropdown.click();						
			String productval = handler.getProduct();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+productval+"']"))).click();
			
			mobilenoField.click();
			mobilenoField.sendKeys("7738544453");
			
			lastNameField.sendKeys(handler.getLastname());
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",leadlifecycle);
			Thread.sleep(2000);
			
			leadSourceDropdown.click();
			String leadsourceval = handler.getLeadSource();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+leadsourceval+"']"))).click();
			
			wait.until(ExpectedConditions.visibilityOf(channelPartnerDropdown));
			
			channelPartnerDropdown.click();
			String channelpartnerval = handler.getChannelPartner();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+channelpartnerval+"']"))).click();
			
			saveButton.click();
			System.out.println("Clicked on save button");
			
			
			
			
			wait.until(ExpectedConditions.visibilityOf(leadNumber));
			XlsOperationsUtility.captureScreenshot(driver, "LeadCreatedForAsset");
			
			String leadno = leadNumber.getText();
			System.out.println("Lead ID" +" "+ leadno);
						
			String leadownerval = leadOwner.getText();
			System.out.println("Lead Owner" +" "+ leadownerval);	
			
			String leadstatusval = leadStatus.getText();
			System.out.println("Lead Status" +" "+ leadstatusval);
			
			String leadsubstatusval = leadSubStatus.getText();
			System.out.println("Lead Sub Status" +" "+ leadsubstatusval);
			
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}

	public void createNTBLeadFailed(LeadDataModel handler)
	{
		try
		{
			this.clearTab();
			System.out.println("Closing All Tabs");
			driver.navigate().refresh();
			this.clearTab();
			this.clearTab();
			this.clearTab();
			this.clearTab();
			Thread.sleep(7000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			leadsDropdown.click();
			Thread.sleep(1000);
			this.clearTab();
			Thread.sleep(5000);
			
			nextButton.click();
			System.out.println("Clicked on next button");
			
			wait.until(ExpectedConditions.visibilityOf(productDropdown));
			
			productDropdown.click();						
			String productval = handler.getProduct();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+productval+"']"))).click();
			
			mobilenoField.click();
			mobilenoField.sendKeys("7738544453");
			
			firstNameField.sendKeys(handler.getFirstname());
			lastNameField.sendKeys(handler.getLastname());
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",leadlifecycle);
			Thread.sleep(2000);
			
			leadSourceDropdown.click();
			String leadsourceval = handler.getLeadSource();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+leadsourceval+"']"))).click();
			
			
			
			
			saveButton.click();
			System.out.println("Clicked on save button");
			
			
			
			
			wait.until(ExpectedConditions.visibilityOf(leadNumber));
			XlsOperationsUtility.captureScreenshot(driver, "LeadCreated");
			
			String leadno = leadNumber.getText();
			System.out.println("Lead ID" +" "+ leadno);
								
			String leadownerval = leadOwner.getText();
			System.out.println("Lead Owner" +" "+ leadownerval);	
			
			String leadstatusval = leadStatus.getText();
			System.out.println("Lead Status" +" "+ leadstatusval);
			
			String leadsubstatusval = leadSubStatus.getText();
			System.out.println("Lead Sub Status" +" "+ leadsubstatusval);
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createETBLead(LeadDataModel handler)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("arguments[0].scrollIntoView();",addbuttonOfAction );	
			
			wait.until(ExpectedConditions.visibilityOf(addbuttonOfAction));
			this.performClickWithAction(addbuttonOfAction);
			System.out.println("Clicked on Add button to create lead");
			wait.until(ExpectedConditions.visibilityOf(newLeadButtonOfQuickActions));
			newLeadButtonOfQuickActions.click();
			wait.until(ExpectedConditions.visibilityOf(segmentTypeDropdown));
			this.performClickWithAction(segmentTypeDropdown);
			//segmentTypeDropdown.click();
			String segmentval = handler.getRecordType();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+segmentval+"']"))).click();
			
			productDropdown.click();						
			String productval = handler.getProduct();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+productval+"']"))).click();
			
			leadSourceDropdown.click();
			String leadsourceval = handler.getLeadSource();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-options']/ul/li/a[@title='"+leadsourceval+"']"))).click();
			System.out.println("Entered all values");
			
			this.performClickWithAction(saveButtonOfNTBLeadPage);
			
			System.out.println("Clicked on save button");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
}
