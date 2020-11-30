package com.salesforce.automation.pageModel;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.poi.util.SystemOutLogger;
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
import com.salesforce.automation.datamodel.MvpDataModel;

public class MvpPage {
	
	public MvpPage(WebDriver driver)
	{
		this.driver = driver;
		builder = new Actions(driver);
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private String caseCount = "";
	
	Actions builder;

	
	//@FindBy(xpath = "//div[text()='New']")
	//@FindBy(xpath = "//h1[text()='Cases']/following::a[@title='New'][@class='forceActionLink']")
	@FindBy(xpath = "//a[@id='customTab3__item'][text()='New']")
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
	
	@FindBy(xpath = "//label[text()='Account Number']/following::textarea[1]")
	private WebElement accountNumberField;
		
	@FindBy(xpath = "//h2[contains(text(),'Account Details')]/following::button[text()='Select'][1]")
	private WebElement selectButtonOfAccountDetails;
	
	@FindBy(xpath = "//label[text()='Authentication Mode']/following::input[1]")
	private WebElement AuthenticationModeDropdown;
	
	@FindBy(xpath = "//input[@name='IFB_Non_Customer_Name__c']")
	private WebElement customerNameField;
	
	@FindBy(xpath = "//input[@name='IFB_MobileNo__c']")
	private WebElement mobileNumberField;
			
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
	
	//@FindBy(xpath = "//h2[text()='Edit Case']/following::button[1][text()='Save']")
	@FindBy(xpath = "//h2[contains(text(),'Case')]/following::button[1][text()='Save']")
	private WebElement topSaveButton;
	
	@FindBy(xpath = "//span[text()='App Launcher']/ancestor::button[1]")
	private WebElement appLauncher;
	
	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	private WebElement appLauncherSearchField;
	
	@FindBy(xpath = "//a[@data-label='Retail Banking Console']")
	private WebElement retailBankingConsoleOption;
	
	//@FindBy(xpath = "//input[@placeholder='Search Salesforce']")
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
	
	//uat edit button
	//@FindBy(xpath = "//div[text()='Change User Role']/following::a[@title='Edit'][1]")
	
	@FindBy(xpath = "//button[text()='Change User Role']/following::button[1][text()='Edit']")
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
	
	@FindBy(xpath = "//span[text()='Validate Passport No']/following::input[1]")
	private WebElement validatePassportNoCheckbox;
	
	@FindBy(xpath = "//span[text()='Validate Driving License No']/following::input[1]")
	private WebElement validateDrivingLicenseNoCheckbox;
	
	@FindBy(xpath = "//span[text()='Validate Voter ID']/following::input[1]")
	private WebElement validateVoterIdCheckbox;
	
	@FindBy(xpath = "//span[text()='Validate DOB']/following::input[1]")
	private WebElement validateDobCheckbox;
	
	@FindBy(xpath = "//input[@placeholder='Search Setup']")
	private WebElement searchGlodalFieldOfUserPage;
	
	@FindBy(xpath = "//label[text()='New Email ID*']/following::input[1]")
	private WebElement newEmailIdField;
	
	//@FindBy(xpath = "//span[contains(text(),'Validate Mother')]/following::input[1]")
	@FindBy(xpath = "//input[@name='IFB_Validate_Mother_s_Maiden_Name__c']")
	private WebElement mothersMaidenNameCheckbox;
	
	@FindBy(xpath = "//span[contains(text(),'Verify Transaction')]/following::input[1]")
	private WebElement verifyTransactionCheckbox;
	
	@FindBy(xpath = "//img[@class='icon noicon']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement logoutLinkOfUserBox;
	
	@FindBy(xpath = "//div[@data-key='error']/div/div/span[1]")
	private WebElement errorMessages;
	
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
	
	/*@FindBy(xpath = "//div[text()='My Book of Business']")
	private WebElement myBookOfBusinessLabel;
	
	@FindBy(xpath = "//div[text()='Total Households in My Book of Business']")
	private WebElement totalHouseholdsBookBusinessLabel;
	
	@FindBy(xpath = "//div[text()='Least Valuable Clients by AUM']")
	private WebElement leastValuableClientsAUMLabel;
	
	@FindBy(xpath = "//div[text()='Total Financial Accounts']")
	private WebElement totalFinancialAccountsLabel;
	
	@FindBy(xpath = "//div[text()='Total Financial Accounts by Client']")
	private WebElement totalFinancialAccountsByClientLabel;
	
	@FindBy(xpath = "//div[text()='Most Valuable Clients by AUM']")
	private WebElement mostValuableClientByAUMLabel;
	
	@FindBy(xpath = "//div[text()='Total Assets Under Management']")
	private WebElement totalAssetsUnderManagementLabel;
	
	@FindBy(xpath = "//div[text()='Total Held Away Assets']")
	private WebElement totalHeldAwayAssetsLabel;
	
	@FindBy(xpath = "//span[text()='Client Birthday This Month']")
	private WebElement clientBirthdayThisMonthLabel;*/
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardLabel;
	
	/*@FindBy(xpath = "//span[text()='My Book of Business - Overview']")
	private WebElement myBookBusinessOverviewLabel;*/
	
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
	
	@FindBy(xpath = "//span[text()='Case Processing']")
	private WebElement caseProcessingSection;
	
	@FindBy(xpath = "//label[text()='Transaction Reference no.']/following::input[1]")
	private WebElement transactionRefernceNoField;
	
	@FindBy(xpath = "//label[text()='Dispute Amt']/following::input[1]")
	private WebElement disputeAmtField;
	
	@FindBy(xpath = "//span[text()='Recon Ops Request']")
	private WebElement reconOpsRequestOption;
	
	@FindBy(xpath = "//label[text()='Dispute Stage']/following::input[1]")
	private WebElement disputeStageField;
	
	@FindBy(xpath = "//label[text()='Source Branch']/following::input[1]")
	private WebElement sourceBranchField;
	
	@FindBy(xpath = "//span[text()='Branch']/ancestor::label[1]/following::select[1]")
	private WebElement branchDropdownOFNewCasePage;
	
	@FindBy(xpath = "//label[text()='Transaction Date']/following::input[1]")
	private WebElement transactionDateField;
	
	@FindBy(xpath = "//label[text()='Transaction Dispute Status']/following::input[1]")
	private WebElement transactionDisputeStatusDropdown;
	
	@FindBy(xpath = "//span[contains(text(),'Show All Results for')]")
	private WebElement showAllResultsForOption;
	
	@FindBy(xpath = "//a[text()='Branch Name']/following::tbody[1]/tr/td[1]/a[1]")
	private WebElement selectBranchName1stOption;
	
	@FindBy(xpath = "//a[@data-label='Cases']")
	private WebElement casesTab;
	
	

	public void clearTab() {
		try {
			Thread.sleep(2000);

			/*driver.findElements(By.xpath("//button[@title='閉じる']")).stream().forEach(item -> item.click());

			driver.findElements(By.xpath("//button[contains(@title,'を閉じる')][@type='button']")).stream()
					.forEach(item -> item.click());
*/
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
	
	
	public void logoutUser(MvpDataModel handler)
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
	
	public void logoutThroughApplication(MvpDataModel handler)
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
	
	
	public void clickAppLauncherSearchRetailBanking(MvpDataModel handler)
	{
		try
		{
			//currently this retail banking console option not working
			 Thread.sleep(3000);
             this.performClickWithAction(appLauncher);
             Thread.sleep(2000);
             appLauncherSearchField.sendKeys(this.trimQuote(handler.getAppLauncherSearch()));
             Thread.sleep(3000);
             this.performClickWithAction(retailBankingConsoleOption);
             Thread.sleep(8000);
             
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void searchUserAndLogin(MvpDataModel handler)
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
			this.continueExecution();
			
			
			Actions action = new Actions(driver);
			action.doubleClick(globalSearchField).perform();
			
			
			globalSearchField.sendKeys(this.trimQuote(handler.getGlobalSearch()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.visibilityOf(userDetailButton)).click();
			System.out.println("Clicked on UserDetails button");
			Thread.sleep(5000);
			driver.navigate().refresh();
			
			Thread.sleep(15000);
			driver.switchTo().frame(0);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(loginButton));
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
	
	public void searchUserLoginOnSetUpPage(MvpDataModel handler)
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
			/*navigationMenuDropdown.click();
			Thread.sleep(3000);
			homeDropdown.click();
			Thread.sleep(8000);*/
			
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
			
			System.out.println("Logged in Successfully through setup page");
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	

	
	
	
	public void createCasesWithAccount(MvpDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].scrollIntoView();",casesTab);
			casesTab.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(newButton));
			this.performClickWithAction(newButton);
			System.out.println("Clicked on new button");
			Thread.sleep(2000);			
			wait.until(ExpectedConditions.visibilityOf(newCaseButton));
			this.performClickWithAction(newCaseButton);
			System.out.println("Clicked on new case button");			
			Thread.sleep(9000);	
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
			Thread.sleep(4000);			
			accountNumberField.click();
			Thread.sleep(4000);
			selectButtonOfAccountDetails.click();
			Thread.sleep(5000);
			System.out.println("Account number selected from Account Details");		
			
			this.performClickWithAction(statusCodeDropdown);
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
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
	
	
	public void loginAcceptAndChangeStatusByCibilQueue(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Cibil queue user logged in Successfully");
			Thread.sleep(3000);
			
			//DVU maker user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(5000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("CIBIL_Queue");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("CIBIL_Queue is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed CIBIL Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusByCollectionQueue(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Collection queue user logged in Successfully");
			Thread.sleep(3000);
			
			//Collection queue user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(8000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Collections_queue");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("Collections_queue is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed Collection Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusByOpsPDEGroup(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("OPS PDE Group logged in Successfully");
			Thread.sleep(3000);
			
			//Collection queue user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(8000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Ops_PDE Group");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("Ops_PDE Group is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed Collection Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusByOpsDocManagement(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Ops_Doc Management user logged in Successfully");
			Thread.sleep(3000);
			
			//Ops_Doc Management user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(8000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Ops_Doc Management");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("Ops_Doc Management is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed Collection Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusByOpsPropertyPapersManagemnt(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Ops _Property Papers Management user logged in Successfully");
			Thread.sleep(3000);
			
			//Ops_Doc Management user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(8000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Ops _Property Papers Management");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("Ops _Property Papers Management is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed Collection Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusByOpsVehiclePDDMgmt(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Ops Vehicle PDD Mgmt user logged in Successfully");
			Thread.sleep(3000);
			
			//Ops_Doc Management user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(8000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Ops Vehicle PDD Mgmt");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("Ops Vehicle PDD Mgmt is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed Collection Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusByOpsPDCEntrySwap(MvpDataModel handler)
	{
		try
		{
			
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCibilQueueUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("OPS PDC Entry swap user logged in Successfully");
			Thread.sleep(3000);
			
			//Ops_Doc Management user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			System.out.println("Clear tab");
			Thread.sleep(8000);	
			wait.until(ExpectedConditions.visibilityOf(navigationMenuDropdown));
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("OPS PDC Entry swap");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("OPS PDC Entry swap is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			Thread.sleep(3000);
			this.clearTab();			
			Thread.sleep(5000);	
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.performClickWithAction(statusCodeDropdown);
			//statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCibilQueueStatusCode());
			System.out.println("Status code is changed to Communicated & Closed");
			Thread.sleep(8000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(caseOwnerValue));
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
			
			if(statuscode.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Communicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
			System.out.println("Completed Collection Queue ");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	private void selectElement(WebElement element, String option)
	{
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(option);
	}
}
