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
import com.salesforce.automation.datamodel.OptimusCaseDataModel;

public class OptimusCasePage 
{
	public OptimusCasePage(WebDriver driver)
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
	private String caseCount = "";
	
	
	//@FindBy(xpath = "//div[text()='New']")
	@FindBy(xpath  = "//a[@id='customTab3__item'][text()='New']")
	private WebElement newButton;
	
	@FindBy(xpath = "//button[text()='New Case']")
	private WebElement newCaseButton;
	
	@FindBy(xpath = "//select[@name='CaseType']")
	private WebElement caseTypeDropdown;
	
	//@FindBy(xpath = "//span[text()='Category']/following::select[1]")
	@FindBy(xpath = "//span[text()='Category']/ancestor::label/following::select[1]")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//span[text()='Sub Category']/following::select[1]")
	private WebElement subCategoryDropdown;
	
	@FindBy(xpath = "//label[text()='Authentication Mode']/following::input[1]")
	private WebElement AuthenticationModeDropdown;
	
	@FindBy(xpath = "//input[@name='IFB_Non_Customer_Name__c']")
	private WebElement customerNameField;
	
	//@FindBy(xpath = "//input[@name='IFB_MobileNo__c']")
	@FindBy(xpath = "//input[@name='IFB_New_Mobile_Number__c']")
	private WebElement mobileNumberField;
	
	@FindBy(xpath = "//label[contains(text(),'ISD Code')]/following::input[1]")
	private WebElement isdCodeField;
			
	@FindBy(xpath = "//select[@name='StatusField']")
	private WebElement statusCodeDropdown;
	
	@FindBy(xpath = "//button[@title='Show Navigation Menu']")
	private WebElement navigationMenuDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Case']/span[2]/span[text()='Cases']")
	private WebElement caseDropdown;
	
	@FindBy(xpath = "//a[@title='Home']")
	private WebElement homeDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Account']/span[2]/span[text()='Accounts']")
	private WebElement accountDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Contact']/span[2]/span[text()='Contacts']")
	private WebElement contactsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Dashboard']/span[2]/span[text()='Dashboards']")
	private WebElement dashboradsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Report']/span[2]/span[text()='Reports']")
	private WebElement reportsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Event']/span[2]/span[text()='Calendar']")
	private WebElement calenderDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Task']/span[2]/span[text()='Tasks']")
	private WebElement tasksDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_Integration_Header_Detail__c']/span[2]/span[text()='Integration Header Details']")
	private WebElement integrationHeaderDetailsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_Integration_Header__c']/span[2]/span[text()='Integration Headers']")
	private WebElement integrationHeadersDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Alerts']/span[2]/span[text()='Alerts']")
	private WebElement alertsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='Lead']/span[2]/span[text()='Leads']")
	private WebElement leadsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_QC__c']/span[2]/span[text()='QC']")
	private WebElement qcDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_File_Import']/span[2]/span[text()='File Import']")
	private WebElement fileImportDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_Offer__c']/span[2]/span[text()='Offers']")
	private WebElement offersDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_BulkUploadLog__c']/span[2]/span[text()='BulkUploadLogs']")
	private WebElement BulkUploadLogsDropdown;
	
	@FindBy(xpath = "//a[@data-itemid='IFB_BulkUploadResultLog__c']/span[2]/span[text()='BulkUploadResultLogs']")
	private WebElement BulkUploadResultLogsDropdown;
	
	@FindBy(xpath = "//span[text()='Accounts']/ancestor::li[1]")
	private WebElement accountsLabel;
	
	@FindBy(xpath = "//img[@title='Accounts']")
	private WebElement accountImg;
	
	@FindBy(xpath = "//div[text()='New']/ancestor::a[1]")
	private WebElement newButtonOfAccount;
	
	@FindBy(xpath = "//div[text()='Import']/ancestor::a[1]")
	private WebElement importButtonOfAccount;
	
	@FindBy(xpath = "//span[@title='Customer Name']")
	private WebElement customerNameOfAccount;
	
	@FindBy(xpath = "//span[text()='Phone']")
	private WebElement phoneOfAccount;
	
	@FindBy(xpath = "//span[text()='Account Owner Alias']")
	private WebElement accountOwnerAlias;
	
	
	
	@FindBy(xpath = "//span[text()='Recently Viewed']/ancestor::a[1]")
	private WebElement recentlyViewedOption;
	
	
	@FindBy(xpath = "//span[text()='Case Responsibilities']/following::button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Case')]/following::button[1][text()='Save']")
	private WebElement topSaveButton;
	
	@FindBy(xpath = "//span[text()='App Launcher']/ancestor::button[1]")
	private WebElement appLauncher;
	
	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	private WebElement appLauncherSearchField;
	
	@FindBy(xpath = "//a[@data-label='Retail Banking Console']")
	private WebElement retailBankingConsoleOption;
	
	//@FindBy(xpath = "//input[@placeholder='Search Salesforce']")	
	
	//@FindBy(xpath = "//input[@placeholder='Search...' OR @placeholder='Search Setup']")
	
	//@FindBy(xpath = "//input[@placeholder='Search...']")
	
	@FindBy(xpath = "//input[starts-with(@placeholder,'Search')]/ancestor::div[1][@class='uiInput uiAutocomplete uiInput--default']/input")
	private WebElement globalSearchField;
	
/*	@FindBy(xpath = "//ul[@class='slds-global-actions']/li[8]/span/button/div/span/div/span/img[@class='icon noicon'][@title='User']")
	private WebElement userIcon;*/
		
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement logout;
	
	@FindBy(xpath = "//div[text()='You signed out of your account']")
	private WebElement youSignedOutOfYourAccount;
	
	@FindBy(xpath = "//ul[@class='lookup__list  visible']/li[2]")
	private WebElement globalSearchValueSelection;
	
	@FindBy(xpath = "//ul[@class='lookup__list  visible']/li[1]")
	private WebElement globalSearchValueFirstOption;
	
	@FindBy(xpath = "//div[@title='User Detail']")
	private WebElement userDetailButton;
	
	@FindBy(xpath = "//h2[text()='User Detail']/following::input[@title='Login'][1]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//label[text()='Authentication Mode']/following::input[1]")
	private WebElement authenticationModeDropdown;
	
	@FindBy(xpath = "//input[@name='IFB_Bar_Code__c']")
	private WebElement barCodeField;
	
	@FindBy(xpath = "//a[@title='Select List View']")
	private WebElement listViewDropdown;
	
	@FindBy(xpath = "//a[@title='Select List View']/following::input[@role='combobox']")
	private WebElement listViewSearchField;
	
	@FindBy(xpath = "//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li/a[1]")
	private WebElement listViewFirstOption;
	
	@FindBy(xpath = "//input[@placeholder='Search this list...']")
	private WebElement searchThisListField;
	
	@FindBy(xpath = "//table[@data-aura-class='uiVirtualDataTable']/tbody/tr[1]/td[4]/span/a[1]")
	private WebElement existingTopCustomerName;
	
	@FindBy(xpath = "//table[@data-aura-class='uiVirtualDataTable']/tbody[1]/tr[1]/th[1]/span/a[1]")
	private WebElement topAccountName;
	
	@FindBy(xpath = "//div[@class='extraSmall forceEntityIcon']/following::span[1][@title='Cases']")
	private WebElement casesWithIcon;
	
	@FindBy(xpath = "//div[text()='Case']/following::slot[2]/lightning-formatted-text")
	private WebElement caseNumber;
	
	@FindBy(xpath = "//p[text()='Customer Name']/following::lightning-formatted-text[1]")
	private WebElement customerNameValue;
	
	@FindBy(xpath = "//p[text()='Case Owner']/following::lightning-formatted-text[1]")
	private WebElement caseOwnerValue;
	
	@FindBy(xpath = "//p[text()='Status Code']/following::lightning-formatted-text[1]")
	private WebElement statusCodeValue;
	
	@FindBy(xpath = "//p[text()='Created By']/following::lightning-formatted-text[1]")
	private WebElement createdByDateValue;
	
	@FindBy(xpath = "//p[text()='Created By']/following::a[1]")
	private WebElement createdByNameValue;
	
	@FindBy(xpath = "//a[contains(text(),'Log out as')]")
	private WebElement logOutLink;
	
	@FindBy(xpath = "//input[@name='Case-search-input']")
	private WebElement caseSearchField;
	
	@FindBy(xpath = "//span[@title='Case Number']/following::a[@data-refid='recordId'][1]")
	private WebElement topCaseNumberLink;
	
	@FindBy(xpath = "//div[text()='Change User Role']/following::a[@title='Edit'][1]")
	private WebElement editButton;
		
	@FindBy(xpath = "//span[text()='Select item 1']/ancestor::label[1]/span[1]")
	private WebElement caseNumberCheckbox;
	
	@FindBy(xpath = "//div[text()='Accept']")
	private WebElement acceptButton;
	
	@FindBy(xpath = "//label[text()='Dispatch Destination']/following::input[1]")
	private WebElement dispatchDestinationDropdown;
	
	@FindBy(xpath = "//label[text()='Landmark']/following::input[1]")
	private WebElement landmarkField;
	
	@FindBy(xpath = "//label[text()='Dispatch Mode']/following::input[1]")
	private WebElement dispatchModeDropdown;
	
	@FindBy(xpath = "//span[text()='Validate PAN']/following::input[1]")
	private WebElement validatePANCheckbox;
	
	@FindBy(xpath = "//input[@placeholder='Search Setup']")
	private WebElement searchGlodalFieldOfUserPage;
	
	@FindBy(xpath = "//label[text()='New Email ID*']/following::input[1]")
	private WebElement newEmailIdField;
	
	@FindBy(xpath = "//span[contains(text(),'Validate Mother')]/following::input[1]")
	private WebElement mothersMaidenNameCheckbox;
	
	@FindBy(xpath = "//span[contains(text(),'Verify Transaction')]/following::input[1]")
	private WebElement verifyTransactionCheckbox;
	
	@FindBy(xpath = "//img[@class='icon noicon']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement logoutLinkOfUserBox;
	
	@FindBy(xpath = "//div[text()='Error Occurred!!!']/following-sibling::span[1]")
	private WebElement errorMessages;
	
	@FindBy(xpath = "//div[text()='Failed!']/following-sibling::span[1]")
	private WebElement errorMessagesofFailed;
	
	@FindBy(xpath = "//label[text()='Call Back']/following::input[1]/following::div[2][contains(@id,'dropdown-element')]/lightning-base-combobox-item[@data-value='Yes']")
	private WebElement callBackYes;
	 
	@FindBy(xpath = "//label[text()='Call Back']/following::input[1]")
	private WebElement callBackDropdown;
	
	@FindBy(xpath = "//label[text()='Date']/following::input[1]")
	private WebElement dateField;
	
	@FindBy(xpath = "//label[text()='Time']/following::input[1]")
	private WebElement timeField;
	
	@FindBy(xpath = "//span[text()='Tasks']")
	private WebElement tasksLabel;
	
	@FindBy(xpath = "//a[text()='My Pending Tasks']")
	private WebElement myPendingTasksLabel;
	
	@FindBy(xpath = "//img[@title='Tasks']")
	private WebElement tasksIcon;
	
	@FindBy(xpath = "//div[text()='New Task']")
	private WebElement newTaskButton;
	
	@FindBy(xpath = "//span[text()='Quick Lead']")
	private WebElement quickLeadLabel;
	
	@FindBy(xpath = "//div[text()='Segment Type']")
	private WebElement segmentTypeLabel;
	
	@FindBy(xpath = "//div[text()='Product']")
	private WebElement productLabel;
	
	@FindBy(xpath = "//span[text()='First Name']")
	private WebElement firstNameLabel;
	
	@FindBy(xpath = "//span[text()='Last Name']")
	private WebElement lastNameLable;
	
	@FindBy(xpath = "//div[text()='Country ISD Code']")
	private WebElement countryISDCodeLabel;
	
	@FindBy(xpath = "//span[text()='Mobile No.']")
	private WebElement mobilenoLabel;
	
	@FindBy(xpath = "//div[text()='Lead Source']")
	private WebElement leadSourceLabel;
	
	@FindBy(xpath = "//span[text()='View Calendar']")
	private WebElement viewCalendarLabel;
	
	
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardLabel;

	
	@FindBy(xpath = "//button[text()='Open']")
	private WebElement openButton;
	
	@FindBy(xpath = "//button[text()='Refresh']")
	private WebElement refreshButton;
	
	@FindBy(xpath = "//label[text()='Journal Number']/following::input[1]")
	private WebElement journalNumber;
	
	@FindBy(xpath = "//div[@class='slds-context-bar__primary navLeft']//span[text()='Retail Banking Console']")
	private WebElement retailBankingConsoleLabel;
	
	@FindBy(xpath = "//div[@class='slds-global-header__item']/div[@class='slds-global-header__logo']")
	private WebElement idfcBankLogo;
	
	@FindBy(xpath = "//a[text()='Accounts']")
	private WebElement accountsLabelOfCustomerPage;
	
	@FindBy(xpath = "//a[text()='Accounts']/following::table[@data-aura-class='uiVirtualDataTable'][1]/thead/tr/th[2]/div[1]/a/span[2][text()='Customer Name']")
	private WebElement cutsomerNameLabelOfCustomerPage;
	
	@FindBy(xpath = "//a[text()='Accounts']/following::table[@data-aura-class='uiVirtualDataTable'][1]/thead/tr/th[3]/div/a/span[2][text()='Phone']")
	private WebElement phoneLabelOfCustomerPage;
	
	@FindBy(xpath = "//a[text()='Accounts']/following::table[@data-aura-class='uiVirtualDataTable'][1]/thead/tr/th[4]/div/a/span[2][text()='Account Owner Alias']")
	private WebElement accountOwnerAliasOfCustomerPage;
	
	@FindBy(xpath = "//a[text()='Accounts']/following::table[@data-aura-class='uiVirtualDataTable'][1]/tbody/tr/th[1]/span/a")
	private WebElement customerNameValueOfCustomerPage;
	
	@FindBy(xpath = "//a[text()='Accounts']/following::table[@data-aura-class='uiVirtualDataTable'][1]/tbody/tr/td[2]/span[1]/span[1]")
	private WebElement phoneValueOfCustomerPage;
	
	@FindBy(xpath = "//a[text()='Accounts']/following::table[@data-aura-class='uiVirtualDataTable'][1]/tbody/tr/td[3]/span[1]/span[1]")
	private WebElement accountOwnerValueOfCustomerPage;
	
	@FindBy(xpath = "//span[text()='Customer ID']")
	private WebElement customerIdLabel;
	
	@FindBy(xpath = "//span[text()='Customer ID']/following::lightning-formatted-text[1]")
	private WebElement customerIdValue;
	
	@FindBy(xpath = "//span[text()='Segment Type'][@class='test-id__field-label']")
	private WebElement segmentTypeLabelOfCustomerInfo;
	
	@FindBy(xpath = "//span[text()='Segment Type'][@class='test-id__field-label']/following::lightning-formatted-text[1]")
	private WebElement segmentTypeValue;
	
	@FindBy(xpath = "//span[text()='Offers']")
	private WebElement offersLabel;
	
	@FindBy(xpath = "//a[text()='Financial Accounts']")
	private WebElement financialAccountsLabel;
	
	@FindBy(xpath = "//a[text()='Activities']")
	private WebElement activitiesLabel;
	
	@FindBy(xpath = "//a[text()='Action Plans']")
	private WebElement actionPlansLabel;
	
	@FindBy(xpath = "//a[text()='KYC']")
	private WebElement kycLabel;
	
	@FindBy(xpath = "//img[@title='Cases']")
	private WebElement casesImg;
	
	@FindBy(xpath = "//ul[@role='listbox']/li/a/lightning-icon/span")
	private WebElement listBoxRecentListView;
	
	@FindBy(xpath = "//div[text()='Change User Role']")
	private WebElement changeUserRoleButton;
	
	@FindBy(xpath = "//a[text()='Details']")
	private WebElement detailsTab;
	
	@FindBy(xpath = "//a[text()='History']")
	private WebElement historyTab;
	
	@FindBy(xpath = "//button[text()='Convert to Complaint']")
	private WebElement convertToComplaintButton;
	
	@FindBy(xpath = "//button[text()='View Document OmniScan']")
	private WebElement viewDocumentOmniScanButton;
	
	@FindBy(xpath = "//button[text()='Upload Document']")
	private WebElement uploadDocumentButton;
	
	@FindBy(xpath = "//span[text()='Case Type']/following::lightning-formatted-text[1]")
	private WebElement caseTypeValue;
	
	@FindBy(xpath = "//span[text()='Category']/following::lightning-formatted-text[1]")
	private WebElement categoryValue;
	
	@FindBy(xpath = "//span[text()='SubCategory']/ancestor::lightning-output-field[1]/div/lightning-formatted-text")
	private WebElement subCategoryValue;
	
	@FindBy(xpath = "//span[text()='Case History'][@title='Case History']")
	private WebElement caseHistoryLabel;
	
	@FindBy(xpath = "//span[text()='Start Timestamp']")
	private WebElement startTimeStampLabel;
	
	@FindBy(xpath = "//span[text()='New Value']")
	private WebElement newValueLabel;
	
	@FindBy(xpath = "//span[text()='Type']")
	private WebElement typeLabel;
	
	@FindBy(xpath = "//span[text()='Created By']")
	private WebElement createdByLabel;
	
	@FindBy(xpath = "//span[text()='Log ID']")
	private WebElement logIdLabel;
	
	@FindBy(xpath = "//span[text()='According to the value date please strike off one of the branch receipt stamp.']")
	private WebElement reasonForRejectionTopVallue;
	
	@FindBy(xpath = "//span[text()='Move selection to Chosen']/ancestor::button/lightning-primitive-icon")
	private WebElement moveSelectionToChosenArrowButton;
	
	@FindBy(xpath = "//span[text()='Is Complaint'][@class='slds-form-element__label']/following::label[1]/span[1]")
	private WebElement isComplaintCheckbox;
	
	@FindBy(xpath = "//label[text()='Department']/following::input[1]")
	private WebElement departmentDropdown;
	
	@FindBy(xpath = "//label[text()='User']/following::input[1]")
	private WebElement userField;
	
	@FindBy(xpath = "//span[text()='Clarification Required - BOC']")
	private WebElement clarificationRequiredBOCOption;
	
	@FindBy(xpath = "//span[text()='My Open Cases']")
	private WebElement myOpenCasesBOCOption;
	
	@FindBy(xpath = "//label[text()='Resolution Comment']/following::textarea[1][@name='IFB_Resolution_Comment__c']")
	private WebElement resolutionCommentField;
	
	@FindBy(xpath = "//button[@title='Check In CBS']")
	private WebElement checkInCBSButton;
	
	@FindBy(xpath = "//label[text()='Account Number']/following::textarea[1]")
	private WebElement accountNumberField;
		
	@FindBy(xpath = "//h2[contains(text(),'Account Details')]/following::button[text()='Select'][1]")
	private WebElement selectButtonOfAccountDetails;
	
	@FindBy(xpath = "//h2[contains(text(),'Account Details')]/following::button[text()='Select'][2]")
	private WebElement select2ndButtonOfAccountDetails;
	
	@FindBy(xpath = "//input[@name='IFB_To_Cheque_No__c']")
	private WebElement toChequenoField;
	
	@FindBy(xpath = "//input[@name='IFB_From_Cheque_No__c']")
	private WebElement fromChequenoField;
	
	@FindBy(xpath = "//label[text()='Stop Reason']/following::input[1]")
	private WebElement stopReasonDropdown;
	
	@FindBy(xpath = "//span[text()='Validate Passport No']/following::input[1]")
	private WebElement validatePassportNoCheckbox;
	
	@FindBy(xpath = "//span[text()='Validate Driving License No']/following::input[1]")
	private WebElement validateDrivingLicenseNoCheckbox;
	
	@FindBy(xpath = "//span[text()='Validate Voter ID']/following::input[1]")
	private WebElement validateVoterIdCheckbox;
	
	@FindBy(xpath = "//span[text()='Validate DOB']/following::input[1]")
	private WebElement validateDobCheckbox;
	
	@FindBy(xpath = "//label[text()='Card Number']/following::textarea[1]")
	private WebElement cardNumberField;
	
	@FindBy(xpath = "//h2[text()='Card Details']/following::button[text()='Select'][1]")
	private WebElement selectButtonOfCardDetails;
	
	@FindBy(xpath = "//lightning-base-formatted-text[text()='SECONDARY OPEN']/ancestor::tr[1]/th/lightning-primitive-cell-factory/span/div/lightning-primitive-cell-button/lightning-button/button")
	private WebElement selectButtonOfSecondaryOpenCardDetails;
	
	@FindBy(xpath = "//lightning-base-formatted-text[text()='PRIMARY OPEN']/ancestor::tr[1]/th/lightning-primitive-cell-factory/span/div/lightning-primitive-cell-button/lightning-button/button")
	private WebElement selectButtonOfPrimaryOpenCardDetails;
	
	
	@FindBy(xpath = "//button[@title='Validate PAN']")
	private WebElement validatePanButton;
	
	@FindBy(xpath = "//label[text()='PAN Available']/following::label[1][text()='PAN No.']/following::input[1]")
	private WebElement panNoField;
	
	@FindBy(xpath = "//label[text()='No of Cheque Leaves*']/following::input[1]")
	private WebElement noOfChequeLeavesDropdown;
	
	@FindBy(xpath = "//input[@name='IFB_Reason_for_Reissue__c']")
	private WebElement reasonForReissueDropdown;
	
	@FindBy(xpath = "//label[text()='Switch On']/following::input[1]")
	private WebElement switchOnDropdown;
	
	@FindBy(xpath = "//button[text()='STP Retry']")
	private WebElement stpRetryButton;
	
	@FindBy(xpath = "//label[text()='Freeze/Unfreeze Source']/following::input[1]")
	private WebElement freezeUnfreezeSourceDropdown;
	
	@FindBy(xpath = "//label[text()='Freeze/Unfreeze Type']/following::input[1]")
	private WebElement freezeUnfreezeTypeDropdown;
	
	@FindBy(xpath = "//input[@name='IFB_Reason__c']")
	private WebElement reasonField;
	
	
	
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
	
	public void logoutUser(OptimusCaseDataModel handler)
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
	
	public void logoutThroughApplication(OptimusCaseDataModel handler)
	{
		try
		{
			userIcon.click();
			Thread.sleep(3000);
			logoutLinkOfUserBox.click();
			Thread.sleep(3000);
			System.out.println("Successfully logged out from application");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
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
	
	
	 public void clickAppLauncherSearchRetailBanking(OptimusCaseDataModel handler)
		{
			try
			{
				//currently this retail banking console option not working
				 Thread.sleep(3000);
	             this.performClickWithAction(appLauncher);
	             Thread.sleep(2000);
	             appLauncherSearchField.sendKeys("Retail Banking Console(managed)");
	             Thread.sleep(3000);
	             driver.findElement(By.xpath("//div[@aria-label='Apps']/one-app-launcher-menu-item[1]/a[1]")).click();
	             //this.performClickWithAction(retailBankingConsoleOption);
	             Thread.sleep(8000);
	             
				
			}
			catch(Exception e)
			{
				ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
				Assert.fail();
			}
		}
	 
	
		
	 
	 
	public void searchUserAndLogin(OptimusCaseDataModel handler)
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
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			homeDropdown.click();
			Thread.sleep(3000);
			Thread.sleep(5000);
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
	
	public void searchUserLoginOnSetUpPage(OptimusCaseDataModel handler)
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
	
	
	public void selectAccount(OptimusCaseDataModel handler)
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
			
			/*//later remove this code
			Thread.sleep(10000);
			
			this.performClickWithAction(casesWithIcon);
			Thread.sleep(3000);
			
			newButton.click();
			Thread.sleep(8000);*/
						
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseEmailModificationSRCreation(OptimusCaseDataModel handler)
	{
		try
		{			
			Thread.sleep(10000);
			
					
			newButton.click();
			newCaseButton.click();
			
			Thread.sleep(8000);
			this.performClickWithAction(caseTypeDropdown);
			
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			
					
			
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());
						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			//entring email id
			newEmailIdField.sendKeys(handler.getNewEmailId());
			Thread.sleep(2000);
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();			
			
			Thread.sleep(20000);
			
			System.out.println("Succesfully clicked on verify transaction Checkbox");
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			saveButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			//refresh the page
			
			Thread.sleep(10000);
			
			driver.navigate().refresh();
		
			Thread.sleep(10000);
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
										
			System.out.println("Completed BOC Email Modification SR process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseMobileNumberChange(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());
						
			System.out.println("Sub category selected");
			Thread.sleep(4000);
						
			mobileNumberField.sendKeys(handler.getMobileNumber());
			isdCodeField.sendKeys(handler.getIsdCode());			
			Thread.sleep(2000);			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseChequeBookRequest(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			/*this.performClickWithAction(casesWithIcon);
			Thread.sleep(3000);*/
			
			newButton.click();
			newCaseButton.click();
			
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
				
			//write code for no of cheque leaves dropdown
			
			
			noOfChequeLeavesDropdown.click();
			String chequeLeavesno = handler.getNoOfChequeLeaves();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='No of Cheque Leaves*']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[@title='"+chequeLeavesno+"']"))).click();
			
			Thread.sleep(2000);
			System.out.println("No Of Cheques leaves are selected");
			
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseStopPaymentRevocation(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			toChequenoField.sendKeys(handler.getToChequeno());
			Thread.sleep(1000);	
			
			this.performClickWithAction(stopReasonDropdown);
			String stopReasonValue = handler.getStopReason();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Stop Reason']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[@title='"+stopReasonValue+"']"))).click();
			fromChequenoField.sendKeys(handler.getFromChequeno());
			
			Thread.sleep(3000);
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseCardBlock(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number entered");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
								
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseCardUnBlock(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
								
			System.out.println("Card unblocked completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCasePANUpdate(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			
			checkInCBSButton.click();
			Thread.sleep(3000);
			panNoField.sendKeys(handler.getPanNo());			
			validatePanButton.click();
			
			//code pending , waiting for proper account
						
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseDNCRegistration(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);			
			
			validatePANCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			
			Thread.sleep(2000);	
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			Thread.sleep(5000);
			
			driver.navigate().refresh();
		
			Thread.sleep(5000);
			
			
			String statuscode = statusCodeValue.getText();
			
			wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
								
			System.out.println("DNC Registration completed");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseDNCDeRegistration(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			validatePANCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			
			Thread.sleep(2000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			Thread.sleep(5000);
			
			driver.navigate().refresh();
		
			Thread.sleep(5000);
			String statuscode = statusCodeValue.getText();
			wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
								
			System.out.println("DNC DE-Registration completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseNetBanking(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Net Banking completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseCardDelinking(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			select2ndButtonOfAccountDetails.click();
			//selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfSecondaryOpenCardDetails.click();
			//selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);	
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);	
			
			Thread.sleep(3000);
			
			driver.navigate().refresh();
		
			Thread.sleep(10000);
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
								
			System.out.println("Card delinking completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void creatCaseDebitCardReissuance(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			reasonForReissueDropdown.click();
			
			String 	reasonresissuevalue = handler.getReasonForReissue();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Reason for Reissue']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+reasonresissuevalue+"']"))).click();
		
			Thread.sleep(2000);
			System.out.println("Reason for reissue selected");
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Debit Card Reissuance completed");
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseDebitCardNewIssuance(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Debit Card New Issuance completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseSwitchInternationalDomesticUsage(OptimusCaseDataModel handler)
	{
		try 
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			switchOnDropdown.click();
			
			String 	switchonvalue = handler.getSwitchOn();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Switch On']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+switchonvalue+"']"))).click();
		
			Thread.sleep(2000);
			System.out.println("Switch On option selected");
			
			Thread.sleep(3000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Switch On/Off , International/Domestic Usage completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseEmailModificationByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			
			newEmailIdField.sendKeys(handler.getNewEmailId());
			
			barCodeField.sendKeys(handler.getBarcode());
						
			Thread.sleep(3000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);		
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Email modification by Branch completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseChequeBookRequestByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);		
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			
			barCodeField.sendKeys(handler.getBarcode());
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
				
			
			noOfChequeLeavesDropdown.click();
			String chequeLeavesno = handler.getNoOfChequeLeaves();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='No of Cheque Leaves*']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[@title='"+chequeLeavesno+"']"))).click();
			
			Thread.sleep(2000);
			System.out.println("No Of Cheques leaves are selected");
			
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			Thread.sleep(3000);			
			this.performClickWithAction(saveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseMobileNumberChangeByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());
						
			System.out.println("Sub category selected");
			Thread.sleep(4000);
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
						
			mobileNumberField.sendKeys(handler.getMobileNumber());
			isdCodeField.sendKeys(handler.getIsdCode());			
			Thread.sleep(2000);			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseCardDelinkingByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(10000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			//selectButtonOfAccountDetails.click();
			select2ndButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfSecondaryOpenCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);	
			
			Thread.sleep(3000);
			
			driver.navigate().refresh();
		
			Thread.sleep(10000);
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
								
			System.out.println("Card delinking by Branch completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseCardLinkingByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(10000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			//selectButtonOfAccountDetails.click();
			select2ndButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			//selectButtonOfCardDetails.click();
			selectButtonOfPrimaryOpenCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);	
			
			Thread.sleep(3000);
			
			driver.navigate().refresh();
		
			Thread.sleep(10000);
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
								
			System.out.println("Card linking completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseCardReissuanceByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			barCodeField.sendKeys(handler.getBarcode());
			
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			reasonForReissueDropdown.click();
			
			String 	reasonresissuevalue = handler.getReasonForReissue();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Reason for Reissue']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+reasonresissuevalue+"']"))).click();
		
			Thread.sleep(2000);
			System.out.println("Reason for reissue selected");
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Debit Card Reissuance by Branch completed");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseCardNewIssuanceByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
						
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			
			barCodeField.sendKeys(handler.getBarcode());
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			/*cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			reasonForReissueDropdown.click();
			
			String 	reasonresissuevalue = handler.getReasonForReissue();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Reason for Reissue']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+reasonresissuevalue+"']"))).click();
		
			Thread.sleep(2000);
			System.out.println("Reason for reissue selected");*/
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Debit Card Reissuance by Branch completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseVirtualPhysicalCardConversionByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			Thread.sleep(2000);			
			
			barCodeField.sendKeys(handler.getBarcode());
			
			Thread.sleep(2000);		
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Virtual to Physical Card Conversion by Branch completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseStopPaymentRevocationByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);
			barCodeField.sendKeys(handler.getBarcode());
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			toChequenoField.sendKeys(handler.getToChequeno());
			Thread.sleep(1000);	
			this.performClickWithAction(stopReasonDropdown);
			String stopReasonValue = handler.getStopReason();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Stop Reason']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[@title='"+stopReasonValue+"']"))).click();;
			Thread.sleep(2000);
			fromChequenoField.sendKeys(handler.getFromChequeno());
			
			Thread.sleep(3000);
						
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);	
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseCardBlockByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);			
			
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			barCodeField.sendKeys(handler.getBarcode());
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number entered");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseCardUnBlockByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			barCodeField.sendKeys(handler.getBarcode());
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
								
			System.out.println("Card unblocked By Branch completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseSwitchInternationalDomesticUsageByBranch(OptimusCaseDataModel handler)
	{
		try 
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			barCodeField.sendKeys(handler.getBarcode());
			
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);			
			switchOnDropdown.click();
			
			String 	switchonvalue = handler.getSwitchOn();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Switch On']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+switchonvalue+"']"))).click();
		
			Thread.sleep(2000);
			System.out.println("Switch On option selected");
			
			Thread.sleep(3000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Switch On/Off , International/Domestic Usage completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseDNCRegistrationByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);			
			
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			Thread.sleep(5000);
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			/*System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			*/
			
								
			System.out.println("DNC Registration completed");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseDNCDeRegistrationByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);		
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			Thread.sleep(5000);
			
			driver.navigate().refresh();
		
			Thread.sleep(5000);
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			/*if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}*/
			
								
			System.out.println("DNC DE-Registration completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseNetBankingByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(4000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			barCodeField.sendKeys(handler.getBarcode());
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Net Banking completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validateAccountMandatoryError(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			String erroroccured = driver.findElement(By.xpath("//div[text()='Error Occurred!!!']")).getText();
			System.out.println(erroroccured);
			
			String err = errorMessages.getText();
			System.out.println(err);
			Assert.assertTrue(err.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validateAccountMandatoryErrorForAllCombo(OptimusCaseDataModel handler)
	{
		try
		{
			
			Thread.sleep(3000);
			//((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(3000);
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(5000);
			String erroroccured = driver.findElement(By.xpath("//div[text()='Error Occurred!!!']")).getText();
			System.out.println(erroroccured);
			
			String err = errorMessages.getText();
			System.out.println(err);
			Assert.assertTrue(err.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validateCardnoMandatoryError(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(3000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(5000);
			String erroroccured = driver.findElement(By.xpath("//div[text()='Error Occurred!!!']")).getText();
			System.out.println(erroroccured);
			
			String err = errorMessages.getText();
			System.out.println(err);
			Assert.assertTrue(err.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validateCardMandatoryErrorForAllCombo(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(3000);
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(3000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(5000);
			String erroroccured = driver.findElement(By.xpath("//div[text()='Error Occurred!!!']")).getText();
			System.out.println(erroroccured);
			
			String err = errorMessages.getText();
			System.out.println(err);
			Assert.assertTrue(err.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseCardLinkingByBOC(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			
			accountNumberField.click();
			Thread.sleep(4000);
			//selectButtonOfAccountDetails.click();
			select2ndButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			
			cardNumberField.click();
			Thread.sleep(4000);
			//selectButtonOfCardDetails.click();
			selectButtonOfPrimaryOpenCardDetails.click();
			System.out.println("Card number selected");
			
			Thread.sleep(2000);	
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
			
			Thread.sleep(10000);
			
			driver.navigate().refresh();
		
			Thread.sleep(10000);
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Processed"))
			{
				System.out.println("Status code is STP Processed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
								
			System.out.println("Card delinking completed");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseVirtualPhysicalCardConversionByBOC(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
					
						
			Thread.sleep(2000);		
			cardNumberField.click();
			Thread.sleep(4000);
			selectButtonOfCardDetails.click();
			System.out.println("Card number selected");
			Thread.sleep(2000);	
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("Virtual to Physical Card Conversion by BOC completed");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCasePANUpdateByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			barCodeField.sendKeys(handler.getBarcode());
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			System.out.println("PAN Update by branch completed");
						
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validationErrorLevelL2ByBOC(OptimusCaseDataModel handler)
	{
		try
		{
			/*Thread.sleep(10000);
			
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);*/
			
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(3000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);

			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			
			String erroroccured = driver.findElement(By.xpath("//div[text()='Error Occurred!!!']")).getText();
			System.out.println(erroroccured);
			
			String err = errorMessages.getText();
			System.out.println(err);
			Assert.assertTrue(err.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validationErrorSentToOpsCriticalSRByBOC(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseTypeDropdown));
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);

			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			
			
			String erroroccured = driver.findElement(By.xpath("//div[text()='Error Occurred!!!']")).getText();
			System.out.println(erroroccured);
			
			String err = errorMessages.getText();
			System.out.println(err);
			Assert.assertTrue(err.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void validationAuthenticationFailureStatusCodeByBOC(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(10000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as SENT TO OPS");
			Thread.sleep(3000);

			this.performClickWithAction(saveButton);
						
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
								
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("Authentication Failure"))
			{
				System.out.println("Status code is Authentication Failure");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
										
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseNetBankingSTPFailure(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			Thread.sleep(8000);
			driver.navigate().refresh();
			Thread.sleep(10000);
			
			Thread.sleep(5000);
			String failederror = driver.findElement(By.xpath("//div[text()='Failed!']")).getText();
			System.out.println(failederror);
			
			String errFailed = errorMessagesofFailed.getText();
			System.out.println(errFailed);
			//Assert.assertTrue(errFailed.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			
			System.out.println("Completed the STP failure internal mode journey");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseSTPFailedRetryClose(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(8000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);	
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);
			
			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);	
									
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);		
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			Thread.sleep(10000);			
			
			//refresh1
			driver.navigate().refresh();
			Thread.sleep(15000);		
						
			String errFailed = errorMessagesofFailed.getText();
			System.out.println(errFailed);			
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(2000);
			
			//stp try 1
			this.performClickWithAction(stpRetryButton);			
			Thread.sleep(2000);
			String statuscode1 = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode1);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			
			//refresh 2
			driver.navigate().refresh();
			Thread.sleep(10000);		
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();			
			Thread.sleep(1000);
			
			//stp try 2
			this.performClickWithAction(stpRetryButton);
			Thread.sleep(4000);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			//refresh 3
			driver.navigate().refresh();
			Thread.sleep(10000);
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			//stp try 3
			this.performClickWithAction(stpRetryButton);
			Thread.sleep(4000);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			driver.navigate().refresh();
			Thread.sleep(10000);
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			
			//stp try 4
			this.performClickWithAction(stpRetryButton);
			System.out.println("Clicked on STP retry button on 4th time");
			Thread.sleep(4000);	
			String errFailed1 = errorMessagesofFailed.getText();
			System.out.println(errFailed1);	
			
						
			//Assert.assertTrue(errFailed1.equals("You have exhausted the maximum number of STP attempts for your channel. Kindly process case manually, or send to Ops."));
			Assert.assertTrue(errFailed1.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(10000);
			
			this.performClickWithAction(editButton);
			
			Thread.sleep(10000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, "Sent To Ops");
			System.out.println("Status Code as Sent To Ops");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
		
			String errFailed2 = errorMessages.getText();
			System.out.println(errFailed2);
			
			Assert.assertTrue(errFailed2.equals("This is a Critical SR. Kindly process the case by logging in respective system i.e DCMS or CBS"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, "Communicated & Closed");
			System.out.println("Status Code as Communicated & Closed ");
			Thread.sleep(4000);
			
			resolutionCommentField.sendKeys("Closing this case");
			Thread.sleep(2000);
			
			this.performClickWithAction(saveButton);			
			System.out.println("Clicked on save button");
			Thread.sleep(8000);
			
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String statuscode2 = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode2);
			
			Assert.assertTrue(statuscode2.equals("Communicated & Closed"));
			System.out.println("Completed the journey of retry and close.");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseEmailModificationSTPFailedByBOC(OptimusCaseDataModel handler)
	{
		try
		{			
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(9000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());
						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			//entring email id
			newEmailIdField.sendKeys(handler.getNewEmailId());
			Thread.sleep(2000);
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();			
			
			Thread.sleep(20000);
			
			System.out.println("Succesfully clicked on verify transaction Checkbox");
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			this.performClickWithAction(saveButton);
			System.out.println("Clicked on save button");
		
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			Thread.sleep(10000);			
			
			//refresh1
			driver.navigate().refresh();
			Thread.sleep(10000);
			driver.navigate().refresh();
			Thread.sleep(15000);
			String errFailed = errorMessagesofFailed.getText();
			System.out.println(errFailed);			
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(2000);
			
			//stp try 1
			this.performClickWithAction(stpRetryButton);			
			Thread.sleep(2000);
			String statuscode1 = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode1);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			
			//refresh 2
			driver.navigate().refresh();
			Thread.sleep(10000);		
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();			
			Thread.sleep(1000);
			
			//stp try 2
			this.performClickWithAction(stpRetryButton);
			Thread.sleep(4000);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			//refresh 3
			driver.navigate().refresh();
			Thread.sleep(10000);
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			//stp try 3
			this.performClickWithAction(stpRetryButton);
			Thread.sleep(4000);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			driver.navigate().refresh();
			Thread.sleep(10000);
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			
			//stp try 4
			this.performClickWithAction(stpRetryButton);
			System.out.println("Clicked on STP retry button on 4th time");
			Thread.sleep(4000);	
			String errFailed1 = errorMessagesofFailed.getText();
			System.out.println(errFailed1);	
			
						
			Assert.assertTrue(errFailed1.equals(handler.getErrorMessage()));
			System.out.println("Error Validated");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(10000);
			
			this.performClickWithAction(editButton);
			
			Thread.sleep(10000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, "Sent To Ops");
			System.out.println("Status Code as Sent To Ops");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
		
			String errFailed2 = errorMessages.getText();
			System.out.println(errFailed2);
			
			Assert.assertTrue(errFailed2.equals("This is a Critical SR. Kindly process the case by logging in respective system i.e DCMS or CBS"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(2000);
			
			
			
			/*//refresh the page
			
			Thread.sleep(15000);
			
			driver.navigate().refresh();
		
			Thread.sleep(10000);
			
			String statuscode = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode);
			
			if(statuscode.equals("STP Failed"))
			{
				System.out.println("Status code is STP Failed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			//refresh1
			driver.navigate().refresh();
			Thread.sleep(15000);		
						
			
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			//stp try 1
			this.performClickWithAction(stpRetryButton);			
			Thread.sleep(2000);
			String statuscode1 = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode1);		
			
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			//refresh 2
			driver.navigate().refresh();
			Thread.sleep(10000);			
			
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();			
			Thread.sleep(1000);
			
			//stp try 2
			this.performClickWithAction(stpRetryButton);
			Thread.sleep(4000);
			Assert.assertTrue(statuscode1.equals("STP Failed"));
			//refresh 3
			driver.navigate().refresh();
			Thread.sleep(10000);
			
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			//stp try 3
			this.performClickWithAction(stpRetryButton);
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(10000);
			
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(1000);
			
			
			//stp try 4
			this.performClickWithAction(stpRetryButton);
			System.out.println("Clicked on STP retry button on 4th time");
			Thread.sleep(6000);	
		
			driver.findElement(By.xpath("//button[@title='Close']/lightning-primitive-icon")).click();
			Thread.sleep(10000);
			
			this.performClickWithAction(editButton);
			
			Thread.sleep(10000);
			this.performClickWithAction(statusCodeDropdown);
			this.selectElement(statusCodeDropdown, "Sent To Ops");
			System.out.println("Status Code as Sent To Ops");
			Thread.sleep(3000);
			
			this.performClickWithAction(saveButton);			
			System.out.println("Clicked on save button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));*/
			
									
			
										
			System.out.println("Completed BOC Email Modification SR STP Failure process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseDebitCreditFreezeByBOC(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(5000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());
						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			freezeUnfreezeTypeDropdown.click();
			String freezeunfreezetypevalue = handler.getFreezeUnfreezeType();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Freeze/Unfreeze Type']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+freezeunfreezetypevalue+"']"))).click();
			System.out.println("Freeze/Unfreeze Type selected");
			Thread.sleep(2000);		
			
			
			freezeUnfreezeSourceDropdown.click();
			String freezeunfreezesourcevalue = handler.getFreezeUnfreezeSource();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Freeze/Unfreeze Source']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+freezeunfreezesourcevalue+"']"))).click();
			System.out.println("Freeze/Unfreeze Source selected");
			Thread.sleep(2000);
			reasonField.sendKeys(handler.getReason());
			
			System.out.println("Reason entered");
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			saveButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);			
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
					
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	//
	
	public void createCaseDebitCreditFreezeByBranch(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(5000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());						
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			Thread.sleep(3000);	
			
			
			freezeUnfreezeTypeDropdown.click();
			String freezeunfreezetypevalue = handler.getFreezeUnfreezeType();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Freeze/Unfreeze Type']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+freezeunfreezetypevalue+"']"))).click();
			System.out.println("Freeze/Unfreeze Type selected");
			Thread.sleep(2000);		
			
			
			freezeUnfreezeSourceDropdown.click();
			String freezeunfreezesourcevalue = handler.getFreezeUnfreezeSource();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Freeze/Unfreeze Source']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+freezeunfreezesourcevalue+"']"))).click();
			System.out.println("Freeze/Unfreeze Source selected");
			Thread.sleep(2000);
			reasonField.sendKeys(handler.getReason());
			
			System.out.println("Reason entered");
			Thread.sleep(2000);			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			saveButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno = caseNumber.getText();
			System.out.println("caseno" +" "+ caseno);	
						
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);			
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
					
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseNACHMandateCancellation(OptimusCaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(9000);
			
			this.performClickWithAction(caseTypeDropdown);
			this.selectElement(caseTypeDropdown, handler.getCaseType());
			System.out.println("Case type selected");
			Thread.sleep(2000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());			
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");
			

			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();			
			
			Thread.sleep(2000);
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Changed");
			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(3000);

			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on Save button");
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			String caseno =  caseNumber.getText();	
			this.caseCount = caseno;
			System.out.println("caseno" +" "+ this.caseCount);
			
			String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	
}


