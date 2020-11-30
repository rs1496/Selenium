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
import com.salesforce.automation.datamodel.CaseDataModel;



public class CasePage {
	
	public CasePage(WebDriver driver) 
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
	
	
	public void logoutUser(CaseDataModel handler)
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
	
	public void logoutThroughApplication(CaseDataModel handler)
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
	
	
	public void clickAppLauncherSearchRetailBanking(CaseDataModel handler)
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
	
	public void searchUserAndLogin(CaseDataModel handler)
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
	
	public void searchUserLoginOnSetUpPage(CaseDataModel handler)
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
	
	

	
	public void createNewCase(CaseDataModel handler)
	{
		try
		{			
			Thread.sleep(10000);
			this.clearTab();
			
			Thread.sleep(5000);
	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);
			
			//select My open cases
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			Thread.sleep(2000);
			//searchThisListField.sendKeys("1035504748");
			
			existingTopCustomerName.click();
			
			Thread.sleep(3000);
			//casesWithIcon.click();
			
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
			
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			barCodeField.clear();
			barCodeField.sendKeys(handler.getBarcode());
			/*customerNameField.clear();
			customerNameField.sendKeys(handler.getCustomerName());
			mobileNumberField.clear();
			mobileNumberField.sendKeys(handler.getMobileNumber());*/
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			Thread.sleep(10000);
			
			//this.storingCaseNumber();
			
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
	
	public void loginDVUMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(1000);
			this.clearTab();
			Thread.sleep(1000);
			this.clearTab();
			Thread.sleep(1000);
			this.clearTab();
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			homeDropdown.click();
			Thread.sleep(3000);
			
			
			Actions action = new Actions(driver);
			action.doubleClick(globalSearchField).perform();
			
			globalSearchField.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			
			
			this.performClickWithAction(userDetailButton);
			
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("DVU maker user logged in Successfully");
			Thread.sleep(3000);
		}
		
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	
	
	
	//DVU checker process
	
	public void LoginAcceptAndChangeStatusCodeByDVUCheckerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuCheckerUser()));
			
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
			System.out.println("DVU Checker user logged in Successfully");
			Thread.sleep(3000);
			
			
			
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(9000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Checker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Checker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		//	caseNumberCheckbox.click();
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			
			statusCodeDropdown.click();			
			this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatusCode());
			System.out.println("Status code is changed");
			
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(4000);

			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
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
			
			System.out.println("Completed RL Ops DVU Checker process");
			
		
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	public void LoginAcceptAndChangeStatusCodeByDVUCheckerUserNonIndividualRequest(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuCheckerUser()));
			
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
			System.out.println("DVU Checker user logged in Successfully");
			Thread.sleep(3000);
			
			
			
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Checker – Non Individual Reqs");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Checker – Non Individual Reqs is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
	
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();	
			this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(5000);	
			
			
			driver.navigate().refresh();
			
			Thread.sleep(10000);
			statusCodeDropdown.click();	
			this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Completed RL Ops DVU Checker non individual process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	//DVU Maker
	
	public void acceptDVUMaker(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		//	caseNumberCheckbox.click();
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(2000);
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
		
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Completed RL Ops DVU Maker process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	//login DE Maker
	public void loginAcceptAndChangeStatusCodeByDEMakerUser(CaseDataModel handler)
	{
		try
		{
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeMakerUser()));
			
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
			System.out.println("DE maker user logged in Successfully");
			Thread.sleep(3000);
			
						
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();	
			this.clearTab();
			Thread.sleep(3000);	
			this.clearTab();
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DE Maker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DE Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);	
			wait.until(ExpectedConditions.visibilityOf(caseSearchField));
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		//	caseNumberCheckbox.click();
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);			
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			System.out.println("Clicked on Edit button");
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(4000);
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Completed RL Ops DE Maker process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	public void createCasewithFirstStep(CaseDataModel handler)
	{
		try
		{
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//select My open cases
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			Thread.sleep(2000);					
			existingTopCustomerName.click();			
			Thread.sleep(3000);
			
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
			
			Thread.sleep(20000);					
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Succesfully clicked on verify Transaction Checkbox");
		
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
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
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			//click on Search Setuup input fiel(Global Search)
			
			searchGlodalFieldOfUserPage.click();			
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getRlOpsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();		
			
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("RL Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//RL ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops Request");
			Thread.sleep(3000);
			
			//Selecting 2nd option of RL Ops Request
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("RL Ops Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getRlOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			//String caseownername = caseOwnerValue.getText();
			System.out.println("Case owner name is " + caseownername);
			
			//String customername = customerNameValue.getText();
			System.out.println("Customer name is " + customername);
			
			//String statuscode = statusCodeValue.getText();
			System.out.println("Status code is " + statuscode);
			
			//String createdBydate = createdByDateValue.getText();
			System.out.println("Created By date " + createdBydate);
			
			//String createdByName = createdByNameValue.getText();
			System.out.println("Created by name " + createdByName);
			
			
			System.out.println("Completed RL Ops DE Maker process");
			
			Thread.sleep(3000);
			
			

		}
		
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	
	//Select Account
	
	public void selectAccount(CaseDataModel handler)
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
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			this.clearTab();
			this.clearTab();
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(searchThisListField));
			
			//Thread.sleep(6000);	
			searchThisListField.clear();
			searchThisListField.sendKeys(handler.getAccountName());
			searchThisListField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='1 item • ']")).click();
			Thread.sleep(5000);
			this.performClickWithAction(topAccountName);
			System.out.println("Selected Account");
			Thread.sleep(10000);
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	//Email modification SR creation 
	public void emailModificationSRCreation(CaseDataModel handler)
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
			
			//entring email id
			newEmailIdField.sendKeys(handler.getNewEmailId());
			Thread.sleep(2000);
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();			
			
			Thread.sleep(20000);
			
			System.out.println("Succesfully clicked on verify transaction Checkbox");
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code as Draft");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
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
		
			Thread.sleep(5000);
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
	
	
	public void createCaseWithFirstStepNegative(CaseDataModel handler)
	{
		try
		{
			
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
								
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);

			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(errorMessages));
			String errormsg = errorMessages.getText();
			System.out.println("Error is " + errormsg);
			
			Assert.assertTrue(errormsg.contains(handler.getErrorMessage()));
			
			System.out.println("Error is " + errormsg);
			
		}
		catch(Exception e) 
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseWithCallBack(CaseDataModel handler)
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
			
			this.performClickWithAction(mothersMaidenNameCheckbox);
			
			//mothersMaidenNameCheckbox.click();
			this.performClickWithAction(verifyTransactionCheckbox);
			
			//verifyTransactionCheckbox.click();			
			
			Thread.sleep(2000);
								
			//statusCodeDropdown.click();
			this.performClickWithAction(statusCodeDropdown);
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			
			Thread.sleep(2000);
			callBackDropdown.click();
			Thread.sleep(1000);
			
			callBackYes.click();
			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());
			System.out.println("Selected call back date time");
			Thread.sleep(1000);
			/*timeField.clear();
			timeField.sendKeys(handler.getCallBackTime());*/
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
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
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			
			//click on Search Setup input field(Global Search)
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getRlOpsUser()));
			
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
			System.out.println("RL Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//RL ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops Request");
			Thread.sleep(5000);
			
			//Selecting 2nd option of RL Ops Request
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("RL Ops Request is selected");
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getRlOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);

			//saveButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Case owner name is " + caseownername);	
			System.out.println("Customer name is " + customername);
			System.out.println("Status code is " + statuscode);
			System.out.println("Created By date " + createdBydate);
			System.out.println("Created by name " + createdByName);
			System.out.println("Completed RL Ops DE Maker process");
			
			Thread.sleep(3000);
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			
			//BOC user login
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBocUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			//driver.switchTo().frame(0);
			/*wait.until(ExpectedConditions.visibilityOf(userDetailButton));
						
			this.performClickWithAction(userDetailButton);*/
			Thread.sleep(8000);
			driver.switchTo().frame(0);
			Thread.sleep(8000);
			this.performClickWithAction(loginButton);
			
			System.out.println("BOC user logged in Successfully");
			Thread.sleep(5000);
			
			//BOC user logged in & accept case
			
			this.clearTab();			
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(10000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);	
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("BOC Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BOC Request is selected");
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
						
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBocStatusCode());
			System.out.println("Status code is changed to Communicated & Closed.");
			Thread.sleep(2000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
			String statuscode1 = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode1);
			
			if(statuscode1.equals("Communicated & Closed"))
			{
				System.out.println("Status code is Comunicated & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
				
			System.out.println("Completed Call back scenarios with Communicated & Closed status");
			
		
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	//non contactable
	
	public void createCaseWithCallBack_nonContactable(CaseDataModel handler)
	{
		try
		{
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
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();			
			
			Thread.sleep(2000);
								
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			
			Thread.sleep(2000);
			callBackDropdown.click();
			Thread.sleep(1000);
			
			callBackYes.click();
			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());
			System.out.println("Selected call back date and time");
			Thread.sleep(1000);
			/*timeField.clear();
			timeField.sendKeys(handler.getCallBackTime());*/
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
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
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			
			//click on Search Setup input field(Global Search)
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getRlOpsUser()));
			
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
			System.out.println("RL Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//RL ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops Request");
			Thread.sleep(5000);
			
			//Selecting 2nd option of RL Ops Request
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("RL Ops Request is selected");
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			//Actions actions = new Actions(driver);
			//actions.doubleClick(topCaseNumberLink).perform();
			
			//topCaseNumberLink.click();
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getRlOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			//saveButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Case owner name is " + caseownername);	
			System.out.println("Customer name is " + customername);
			System.out.println("Status code is " + statuscode);
			System.out.println("Created By date " + createdBydate);
			System.out.println("Created by name " + createdByName);
			System.out.println("Completed RL Ops DE Maker process");
			
			Thread.sleep(3000);
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			
			//BOC user login
			
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBocUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			//driver.switchTo().frame(0);
			/*wait.until(ExpectedConditions.visibilityOf(userDetailButton));
						
			this.performClickWithAction(userDetailButton);*/
			Thread.sleep(8000);
			driver.switchTo().frame(0);
			Thread.sleep(8000);
			this.performClickWithAction(loginButton);
			
			System.out.println("BOC user logged in Successfully");
			Thread.sleep(5000);
			
			//BOC user logged in & accept case
			
			this.clearTab();			
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(10000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);	
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("BOC Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BOC Request is selected");
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
						
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBocStatusCode());
			System.out.println("Status code is changed to Not Contactable & Closed");
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
			String statuscode1 = statusCodeValue.getText();
			
			System.out.println("Status code is " + statuscode1);
			
			if(statuscode1.equals("Not Contactable & Closed"))
			{
				System.out.println("Status code is Not Contactable & Closed");
			}
			else
			{
				System.out.println("Status code is not matched");
				Assert.fail();
			}
			
			
				
			System.out.println("Completed Call back scenarios with Not Contactable & Closed status");
			
		
			
		
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void homePageValidation(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			homeDropdown.click();
			Thread.sleep(3000);
			
			
			globalSearchField.isDisplayed();
			System.out.println("Validated global search field");
			
			userIcon.isDisplayed();
			System.out.println("Validated user Icon");
			
			appLauncher.isDisplayed();
			System.out.println("Validated App Launcher icon");
			
			retailBankingConsoleLabel.isDisplayed();
			System.out.println("Validated Retail Baking Console Label");
			
			idfcBankLogo.isDisplayed();
			System.out.println("Validated IDFC BANK logo");
			
			Thread.sleep(2000);
			
			/*tasksLabel.isDisplayed();
			System.out.println("Validated Tasks label");
			
			myPendingTasksLabel.isDisplayed();
			System.out.println("Validated My pending tasks label");
			
			tasksIcon.isDisplayed();
			System.out.println("Validated Tasks icon");
			
			newTaskButton.isDisplayed();
			System.out.println("Validated New task button label");*/
			
			quickLeadLabel.isDisplayed();
			System.out.println("Validated Quick lead label");
			
			segmentTypeLabel.isDisplayed();
			System.out.println("Validated Segment Type label");
			
			productLabel.isDisplayed();
			System.out.println("Validated Product label");
			
			firstNameLabel.isDisplayed();
			System.out.println("Validated First name label");
			
			lastNameLable.isDisplayed();
			System.out.println("Validated Last name label");
			
			countryISDCodeLabel.isDisplayed();
			System.out.println("Validated Country ISD code label");
			
			mobilenoLabel.isDisplayed();
			System.out.println("Validated Mobile no. label");
			
			leadSourceLabel.isDisplayed();
			System.out.println("Validated Lead source label");
			
			viewCalendarLabel.isDisplayed();
			System.out.println("Validated View calender label");
			//Thread.sleep(20000);
			
			/*myBookOfBusinessLabel.isDisplayed();
			System.out.println("Validated My book of business label");
			*/
			/*totalHouseholdsBookBusinessLabel.isDisplayed();
			System.out.println("Validated Total household book of business label");
			*/
			/*leastValuableClientsAUMLabel.isDisplayed();
			System.out.println("Validated Least valuable client AMU label");
			
			totalFinancialAccountsLabel.isDisplayed();
			System.out.println("Validated Total financial accounts label");
			
			totalFinancialAccountsByClientLabel.isDisplayed();
			System.out.println("Validated Total financial accounts by client label");
			
			mostValuableClientByAUMLabel.isDisplayed();
			System.out.println("Validated Most valuable client by AMU label");
			
			totalAssetsUnderManagementLabel.isDisplayed();
			System.out.println("Validated Total asset under management label");
			
			totalHeldAwayAssetsLabel.isDisplayed();
			System.out.println("Validated Total held away assets label");
			
			clientBirthdayThisMonthLabel.isDisplayed();
			System.out.println("Validated Client birthday this month label");
			*/
			/*dashboardLabel.isDisplayed();
			System.out.println("Validated Dashboard label");
			*/
			/*myBookBusinessOverviewLabel.isDisplayed();
			System.out.println("Validated My book business overview label");
			*/
			/*openButton.isDisplayed();
			System.out.println("Validated Open button");
			
			refreshButton.isDisplayed();
			System.out.println("Validated refresh button");*/
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void accountPageValidation(CaseDataModel handler)
	{
		try
		{
			/*Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			homeDropdown.click();
			Thread.sleep(20000);*/
			
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			accountDropdown.click();
			Thread.sleep(3000);
			accountsLabel.isDisplayed();
			accountImg.isDisplayed();
			/*newButtonOfAccount.isDisplayed();
			importButtonOfAccount.isDisplayed();*/
			customerNameOfAccount.isDisplayed();
			phoneOfAccount.isDisplayed();
			accountOwnerAlias.isDisplayed();
			searchThisListField.isDisplayed();
			System.out.println("Validated Account Page.");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validateObjects(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(3000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
		//	homeDropdown.click();
			//Thread.sleep(20000);
			
			
			//validations of dropdown
			homeDropdown.isDisplayed();
			accountDropdown.isDisplayed();
			contactsDropdown.isDisplayed();
			dashboradsDropdown.isDisplayed();
			reportsDropdown.isDisplayed();
			calenderDropdown.isDisplayed();
			tasksDropdown.isDisplayed();
			/*JavascriptExecutor jse = (JavascriptExecutor)driver;

			jse.executeScript("scroll(0, 250)");*/
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", tasksDropdown );
			Thread.sleep(250);
			
			integrationHeaderDetailsDropdown.isDisplayed();
			integrationHeadersDropdown.isDisplayed();
			alertsDropdown.isDisplayed();
			leadsDropdown.isDisplayed();
			qcDropdown.isDisplayed();
			fileImportDropdown.isDisplayed();
			offersDropdown.isDisplayed();
			BulkUploadLogsDropdown.isDisplayed();
			BulkUploadResultLogsDropdown.isDisplayed();
			
			System.out.println("Validated all dropdowns");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	
	public void createCaseStep4ClarificationRequired(CaseDataModel handler)
	{
		try 
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(5000);
			
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
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(5000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			//saveButton.click();
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
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			Thread.sleep(10000);
			
			//click on Search Setup input field(Global Search) of User Page
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(5000);
			globalSearchValueSelection.click();
			
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(5000);
			this.performClickWithAction(loginButton);
			
			System.out.println("RL Ops DVU Maker user logged in Successfully");
			Thread.sleep(5000);
			//RL OPS DVU Maker accept Invite & Edit
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker – Individual Request");					
			
			//RL OPS DVU Maker accept Invite & Edit
						
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			System.out.println("Successfully clicked on Accept Button");
			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(listViewDropdown));
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));	
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed to Sent to DVU Checker - Rejected");
			Thread.sleep(5000);
			reasonForRejectionTopVallue.click();
			Thread.sleep(3000);
			moveSelectionToChosenArrowButton.click();
			Thread.sleep(3000);
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			
			System.out.println("Completed RL Ops DVU Maker process");
			
		
		//logout process
		
		Thread.sleep(1000);
		logOutLink.click();
		System.out.println("Successfuly logged out");
		Thread.sleep(10000);
		
		//click on Search Setup input field(Global Search)
		
		searchGlodalFieldOfUserPage.click();
		
		searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuCheckerUser()));
		
		Thread.sleep(3000);
		globalSearchValueSelection.click();
		Thread.sleep(5000);
		Thread.sleep(9000);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
		Thread.sleep(2000);
		this.performClickWithAction(loginButton);
		
		System.out.println("RL Ops DVU Checker user logged in Successfully");
		Thread.sleep(3000);
		
		//RL OPS DVU Maker accept Invite & Edit
		
		Thread.sleep(10000);
		this.clearTab();			
		Thread.sleep(5000);	
		this.clearTab();			
		Thread.sleep(5000);	
		navigationMenuDropdown.click();
		Thread.sleep(3000);
		caseDropdown.click();
		Thread.sleep(3000);			
		//Accept case process
		listViewDropdown.click();
		Thread.sleep(5000);
		listViewSearchField.sendKeys("RL Ops DVU Checker – Individual Request");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("RL Ops DVU Checker – Individual Request is selected");
		
		
		Thread.sleep(6000);				
		caseSearchField.sendKeys(caseno);
		caseSearchField.sendKeys(Keys.ENTER);
		Thread.sleep(9000);
		this.performClickWithAction(caseNumberCheckbox);
	
		acceptButton.click();
		Thread.sleep(10000);
		System.out.println("Successfully clicked on Accept Button");
		
		
		//CHange status code process
		listViewDropdown.click();
		Thread.sleep(3000);
		listViewSearchField.sendKeys("My Open Cases");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("My open cases is selected");
		Thread.sleep(6000);			
		caseSearchField.sendKeys(caseno);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
		Thread.sleep(2000);
		this.performClickWithAction(topCaseNumberLink);

		
		System.out.println("Clicked on Case number");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		editButton.click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
		statusCodeDropdown.click();
		this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatusCode());
		System.out.println("Status code is changed to Clarification Required");
		Thread.sleep(2000);
		
		//scrolling page on top
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(5000);
				
		
		this.performClickWithAction(topSaveButton);
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(caseNumber));
		
		System.out.println("Completed RL Ops DVU Checker process");
	
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			//click on Search Setup input field(Global Search)
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBocUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("BOC user logged in Successfully");
			Thread.sleep(3000);
			
			//BOC user accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(3000);
			
			//selecting Clarification Required - BOC value in dropdown of BOC
			clarificationRequiredBOCOption.click();		
			
			Thread.sleep(3000);
			//listViewFirstOption.click();
			System.out.println("Clarification Required - BOC is selected");			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			
			Thread.sleep(3000);
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
						
			//selecting My open cases option of BOC in dropdown
			myOpenCasesBOCOption.click();
			
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			//editButton.click();
			this.performClickWithAction(editButton);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBocStatusCode());
			System.out.println("Status code is changed to Clarification Provided");
			Thread.sleep(5000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			System.out.println("Completed BOC user process");
		
			
					//logout process
					
					Thread.sleep(5000);
					logOutLink.click();
					System.out.println("Successfuly logged out");
					
					//click on Search Setup input field(Global Search)
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
					searchGlodalFieldOfUserPage.click();
					
					searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuCheckerUser()));
					
					Thread.sleep(3000);
					globalSearchValueSelection.click();
					Thread.sleep(5000);
					Thread.sleep(9000);
					
					driver.switchTo().frame(0);
					Thread.sleep(5000);
										
					this.performClickWithAction(loginButton);
					
					System.out.println("DVU checker user logged in Successfully");
					Thread.sleep(3000);
					
					//RL Ops Dvu Checker accept Invite & Edit
					
					Thread.sleep(10000);
					this.clearTab();			
					Thread.sleep(5000);	
					navigationMenuDropdown.click();
					Thread.sleep(3000);
					caseDropdown.click();
					Thread.sleep(3000);			
					//Accept case process
					listViewDropdown.click();
					Thread.sleep(5000);
					listViewSearchField.sendKeys("Clarification Provided-RLOpsDVUChecker-I");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("Clarification Provided-RLOpsDVUChecker-I is selected");
					
					
					Thread.sleep(6000);				
					caseSearchField.sendKeys(caseno);
					caseSearchField.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					this.performClickWithAction(caseNumberCheckbox);
				
					acceptButton.click();
					Thread.sleep(10000);
					System.out.println("Successfully clicked on Accept Button");
					
					
					//CHange status code process
					listViewDropdown.click();
					Thread.sleep(3000);
					listViewSearchField.sendKeys("My Open Cases");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("My open cases is selected");
					Thread.sleep(3000);			
					caseSearchField.sendKeys(caseno);
					Thread.sleep(6000);
					driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
					Thread.sleep(2000);
					this.performClickWithAction(topCaseNumberLink);

					
					System.out.println("Clickd on Case number");
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(editButton));
					editButton.click();
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
					statusCodeDropdown.click();
					this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatus1());
					System.out.println("Status code is changed as Sent to DE Maker");
					Thread.sleep(5000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
					this.performClickWithAction(topSaveButton);
					System.out.println("Completed DVU Checker user process");
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(caseNumber));
				
				
				//logout process
				
				Thread.sleep(1000);
				logOutLink.click();
				System.out.println("Successfuly logged out");
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
				//click on Search Setup input field(Global Search)
				
				searchGlodalFieldOfUserPage.click();
				
				searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeMakerUser()));
				
				Thread.sleep(3000);
				globalSearchValueSelection.click();
				Thread.sleep(5000);
				Thread.sleep(9000);
				
				driver.switchTo().frame(0);
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				this.performClickWithAction(loginButton);
				
				System.out.println("DE maker user logged in Successfully");
				Thread.sleep(3000);
				
				//DE Maker accept Invite & Edit
				
				Thread.sleep(10000);
				this.clearTab();			
				Thread.sleep(5000);	
				navigationMenuDropdown.click();
				Thread.sleep(3000);
				caseDropdown.click();
				Thread.sleep(3000);			
				//Accept case process
				listViewDropdown.click();
				Thread.sleep(5000);
				listViewSearchField.sendKeys("RL Ops DE Maker – Individual Request");
				Thread.sleep(3000);
				listViewFirstOption.click();
				System.out.println("RL Ops DE Maker – Individual Request is selected");
				
				
				Thread.sleep(10000);				
				caseSearchField.sendKeys(caseno);
				caseSearchField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				this.performClickWithAction(caseNumberCheckbox);
				Thread.sleep(3000);
				acceptButton.click();
				Thread.sleep(10000);
				System.out.println("Successfully clicked on Accept Button");
				
				
				//CHange status code process
				listViewDropdown.click();
				Thread.sleep(3000);
				listViewSearchField.sendKeys("My Open Cases");
				Thread.sleep(3000);
				listViewFirstOption.click();
				System.out.println("My open cases is selected");
				Thread.sleep(3000);			
				caseSearchField.sendKeys(caseno);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
				Thread.sleep(2000);
				this.performClickWithAction(topCaseNumberLink);

				
				System.out.println("Clickd on Case number");
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(editButton));
				editButton.click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
				statusCodeDropdown.click();
				this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
				System.out.println("Status code is changed as Sent to DE Checker");
				Thread.sleep(5000);
				
				journalNumber.sendKeys(handler.getJournalNumber());
				((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				
				this.performClickWithAction(topSaveButton);
				System.out.println("Completed DE Maker user process");
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(caseNumber));
				
		
		//logout process
		
		Thread.sleep(1000);
		logOutLink.click();
		System.out.println("Successfuly logged out");
		
		Thread.sleep(10000);
		//click on Search Setup input field(Global Search)
		wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
		
		searchGlodalFieldOfUserPage.click();
		
		searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeCheckerUser()));
		
		Thread.sleep(3000);
		globalSearchValueSelection.click();
		Thread.sleep(5000);
		Thread.sleep(9000);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		this.performClickWithAction(loginButton);
		
		System.out.println("DE checker user logged in Successfully");
		Thread.sleep(3000);
		
		//DE checker accept Invite & Edit
		
		Thread.sleep(10000);
		this.clearTab();			
		Thread.sleep(5000);	
		navigationMenuDropdown.click();
		Thread.sleep(3000);
		caseDropdown.click();
		Thread.sleep(3000);			
		//Accept case process
		listViewDropdown.click();
		Thread.sleep(5000);
		listViewSearchField.sendKeys("RL Ops DE Checker – Individual Request");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("RL Ops DE Checker – Individual Request is selected");
		
		
		Thread.sleep(6000);				
		caseSearchField.sendKeys(caseno);
		caseSearchField.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		this.performClickWithAction(caseNumberCheckbox);
	
		acceptButton.click();
		Thread.sleep(10000);
		System.out.println("Successfully clicked on Accept Button");
		
		
		//CHange status code process
		listViewDropdown.click();
		Thread.sleep(3000);
		listViewSearchField.sendKeys("My Open Cases");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("My open cases is selected");
		Thread.sleep(3000);			
		caseSearchField.sendKeys(caseno);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
		Thread.sleep(2000);
		this.performClickWithAction(topCaseNumberLink);

		
		System.out.println("Clickd on Case number");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		editButton.click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
		statusCodeDropdown.click();
		this.selectElement(statusCodeDropdown, handler.getDeCheckerStatus());
		System.out.println("Status code is Resolved");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		this.performClickWithAction(topSaveButton);
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
		String statuscode1 = statusCodeValue.getText();
		
		System.out.println("Status code is " + statuscode1);
		
		if(statuscode1.equals("Resolved And Closed"))
		{
			System.out.println("Status code is Resolved & Closed");
		}
		else
		{
			System.out.println("Status code is not matched");
			Assert.fail();
		}
		
		
			
		System.out.println("Completed RL OPS 4 step");
	
		
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	
	
	public void createCaseStep4ClarificationRequiredByBranch(CaseDataModel handler)
	{
		try 
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(5000);
			
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
			
			barCodeField.sendKeys(handler.getBarcode());
			
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(5000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			//saveButton.click();
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
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			Thread.sleep(10000);
			
			//click on Search Setup input field(Global Search) of User Page
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(5000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(5000);
			this.performClickWithAction(loginButton);
			
			System.out.println("RL Ops DVU Maker user logged in Successfully");
			Thread.sleep(5000);
			//RL OPS DVU Maker accept Invite & Edit
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker – Individual Request");					
			
			//RL OPS DVU Maker accept Invite & Edit
						
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			System.out.println("Successfully clicked on Accept Button");
			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(listViewDropdown));
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));	
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed to Sent to DVU Checker - Rejected");
			Thread.sleep(5000);
			reasonForRejectionTopVallue.click();
			Thread.sleep(3000);
			moveSelectionToChosenArrowButton.click();
			Thread.sleep(3000);
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			
			System.out.println("Completed RL Ops DVU Maker process");
			
		
		//logout process
		
		Thread.sleep(1000);
		logOutLink.click();
		System.out.println("Successfuly logged out");
		Thread.sleep(10000);
		
		//click on Search Setup input field(Global Search)
		
		searchGlodalFieldOfUserPage.click();
		
		searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuCheckerUser()));
		
		Thread.sleep(3000);
		globalSearchValueSelection.click();
		Thread.sleep(5000);
		Thread.sleep(9000);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
		Thread.sleep(2000);
		this.performClickWithAction(loginButton);
		
		System.out.println("RL Ops DVU Checker user logged in Successfully");
		Thread.sleep(3000);
		
		//RL OPS DVU Maker accept Invite & Edit
		
		Thread.sleep(10000);
		this.clearTab();			
		Thread.sleep(5000);	
		this.clearTab();			
		Thread.sleep(5000);	
		navigationMenuDropdown.click();
		Thread.sleep(3000);
		caseDropdown.click();
		Thread.sleep(3000);			
		//Accept case process
		listViewDropdown.click();
		Thread.sleep(5000);
		listViewSearchField.sendKeys("RL Ops DVU Checker – Individual Request");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("RL Ops DVU Checker – Individual Request is selected");
		
		
		Thread.sleep(6000);				
		caseSearchField.sendKeys(caseno);
		caseSearchField.sendKeys(Keys.ENTER);
		Thread.sleep(9000);
		this.performClickWithAction(caseNumberCheckbox);
	
		acceptButton.click();
		Thread.sleep(10000);
		System.out.println("Successfully clicked on Accept Button");
		
		
		//CHange status code process
		listViewDropdown.click();
		Thread.sleep(3000);
		listViewSearchField.sendKeys("My Open Cases");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("My open cases is selected");
		Thread.sleep(6000);			
		caseSearchField.sendKeys(caseno);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
		Thread.sleep(2000);
		this.performClickWithAction(topCaseNumberLink);

		
		System.out.println("Clicked on Case number");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		editButton.click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
		statusCodeDropdown.click();
		this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatusCode());
		System.out.println("Status code is changed to Clarification Required");
		Thread.sleep(2000);
		
		//scrolling page on top
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(5000);
				
		
		this.performClickWithAction(topSaveButton);
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(caseNumber));
		
		System.out.println("Completed RL Ops DVU Checker process");
	
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			//click on Search Setup input field(Global Search)
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBranchUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("Branch user logged in Successfully");
			Thread.sleep(3000);
			
			//BOC user accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(3000);
			
			listViewSearchField.sendKeys("Clarification Required - Branch");
			
			Thread.sleep(3000);
			listViewFirstOption.click();
			Thread.sleep(3000);
			
			System.out.println("Clarification Required - Branch is selected");			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);		
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			//editButton.click();
			this.performClickWithAction(editButton);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBranchStatusCode());
			System.out.println("Status code is changed to Clarification Provided");
			Thread.sleep(5000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			System.out.println("Completed BOC user process");
		
			
					//logout process
					
					Thread.sleep(5000);
					logOutLink.click();
					System.out.println("Successfuly logged out");
					
					//click on Search Setup input field(Global Search)
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
					searchGlodalFieldOfUserPage.click();
					
					searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuCheckerUser()));
					
					Thread.sleep(3000);
					globalSearchValueSelection.click();
					Thread.sleep(5000);
					Thread.sleep(9000);
					
					driver.switchTo().frame(0);
					Thread.sleep(5000);
										
					this.performClickWithAction(loginButton);
					
					System.out.println("DVU checker user logged in Successfully");
					Thread.sleep(3000);
					
					//RL Ops Dvu Checker accept Invite & Edit
					
					Thread.sleep(10000);
					this.clearTab();			
					Thread.sleep(5000);	
					navigationMenuDropdown.click();
					Thread.sleep(3000);
					caseDropdown.click();
					Thread.sleep(3000);			
					//Accept case process
					listViewDropdown.click();
					Thread.sleep(5000);
					listViewSearchField.sendKeys("Clarification Provided-RLOpsDVUChecker-I");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("Clarification Provided-RLOpsDVUChecker-I is selected");
					
					
					Thread.sleep(6000);				
					caseSearchField.sendKeys(caseno);
					caseSearchField.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					this.performClickWithAction(caseNumberCheckbox);
				
					acceptButton.click();
					Thread.sleep(10000);
					System.out.println("Successfully clicked on Accept Button");
					
					
					//CHange status code process
					listViewDropdown.click();
					Thread.sleep(3000);
					listViewSearchField.sendKeys("My Open Cases");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("My open cases is selected");
					Thread.sleep(3000);			
					caseSearchField.sendKeys(caseno);
					Thread.sleep(6000);
					driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
					Thread.sleep(2000);
					this.performClickWithAction(topCaseNumberLink);

					
					System.out.println("Clickd on Case number");
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(editButton));
					editButton.click();
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
					statusCodeDropdown.click();
					this.selectElement(statusCodeDropdown, handler.getDvuCheckerStatus1());
					System.out.println("Status code is changed as Sent to DE Maker");
					Thread.sleep(5000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
					this.performClickWithAction(topSaveButton);
					System.out.println("Completed DVU Checker user process");
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(caseNumber));
				
				
				//logout process
				
				Thread.sleep(1000);
				logOutLink.click();
				System.out.println("Successfuly logged out");
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
				//click on Search Setup input field(Global Search)
				
				searchGlodalFieldOfUserPage.click();
				
				searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeMakerUser()));
				
				Thread.sleep(3000);
				globalSearchValueSelection.click();
				Thread.sleep(5000);
				Thread.sleep(9000);
				
				driver.switchTo().frame(0);
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				this.performClickWithAction(loginButton);
				
				System.out.println("DE maker user logged in Successfully");
				Thread.sleep(3000);
				
				//DE Maker accept Invite & Edit
				
				Thread.sleep(10000);
				this.clearTab();			
				Thread.sleep(5000);	
				navigationMenuDropdown.click();
				Thread.sleep(3000);
				caseDropdown.click();
				Thread.sleep(3000);			
				//Accept case process
				listViewDropdown.click();
				Thread.sleep(5000);
				listViewSearchField.sendKeys("RL Ops DE Maker – Individual Request");
				Thread.sleep(3000);
				listViewFirstOption.click();
				System.out.println("RL Ops DE Maker – Individual Request is selected");
				
				
				Thread.sleep(10000);				
				caseSearchField.sendKeys(caseno);
				caseSearchField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				this.performClickWithAction(caseNumberCheckbox);
				Thread.sleep(3000);
				acceptButton.click();
				Thread.sleep(10000);
				System.out.println("Successfully clicked on Accept Button");
				
				
				//CHange status code process
				listViewDropdown.click();
				Thread.sleep(3000);
				listViewSearchField.sendKeys("My Open Cases");
				Thread.sleep(3000);
				listViewFirstOption.click();
				System.out.println("My open cases is selected");
				Thread.sleep(3000);			
				caseSearchField.sendKeys(caseno);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
				Thread.sleep(2000);
				this.performClickWithAction(topCaseNumberLink);

				
				System.out.println("Clickd on Case number");
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(editButton));
				editButton.click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
				statusCodeDropdown.click();
				this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
				System.out.println("Status code is changed as Sent to DE Checker");
				Thread.sleep(5000);
				
				journalNumber.sendKeys(handler.getJournalNumber());
				((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				
				this.performClickWithAction(topSaveButton);
				System.out.println("Completed DE Maker user process");
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(caseNumber));
				
		
		//logout process
		
		Thread.sleep(1000);
		logOutLink.click();
		System.out.println("Successfuly logged out");
		
		Thread.sleep(10000);
		//click on Search Setup input field(Global Search)
		wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
		
		searchGlodalFieldOfUserPage.click();
		
		searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeCheckerUser()));
		
		Thread.sleep(3000);
		globalSearchValueSelection.click();
		Thread.sleep(5000);
		Thread.sleep(9000);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		this.performClickWithAction(loginButton);
		
		System.out.println("DE checker user logged in Successfully");
		Thread.sleep(3000);
		
		//DE checker accept Invite & Edit
		
		Thread.sleep(10000);
		this.clearTab();			
		Thread.sleep(5000);	
		navigationMenuDropdown.click();
		Thread.sleep(3000);
		caseDropdown.click();
		Thread.sleep(3000);			
		//Accept case process
		listViewDropdown.click();
		Thread.sleep(5000);
		listViewSearchField.sendKeys("RL Ops DE Checker – Individual Request");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("RL Ops DE Checker – Individual Request is selected");
		
		
		Thread.sleep(6000);				
		caseSearchField.sendKeys(caseno);
		caseSearchField.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		this.performClickWithAction(caseNumberCheckbox);
	
		acceptButton.click();
		Thread.sleep(10000);
		System.out.println("Successfully clicked on Accept Button");
		
		
		//CHange status code process
		listViewDropdown.click();
		Thread.sleep(3000);
		listViewSearchField.sendKeys("My Open Cases");
		Thread.sleep(3000);
		listViewFirstOption.click();
		System.out.println("My open cases is selected");
		Thread.sleep(3000);			
		caseSearchField.sendKeys(caseno);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
		Thread.sleep(2000);
		this.performClickWithAction(topCaseNumberLink);

		
		System.out.println("Clickd on Case number");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		editButton.click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
		statusCodeDropdown.click();
		this.selectElement(statusCodeDropdown, handler.getDeCheckerStatus());
		System.out.println("Status code is Resolved");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		this.performClickWithAction(topSaveButton);
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
		String statuscode1 = statusCodeValue.getText();
		
		System.out.println("Status code is " + statuscode1);
		
		if(statuscode1.equals("Resolved And Closed"))
		{
			System.out.println("Status code is Resolved & Closed");
		}
		else
		{
			System.out.println("Status code is not matched");
			Assert.fail();
		}
		
		
			
		System.out.println("Completed RL OPS 4 step");
	
		
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	public void createCaseWith3Step(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(3000);
			
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
			
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
						
			
			String caseno =  caseNumber.getText();	
			this.caseCount = caseno;
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
			
			//logout process
			
			Thread.sleep(1000);
			logOutLink.click();
			System.out.println("Successfuly logged out");
			
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			//click on Search Setup input field(Global Search) of User Page
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("RL Ops DVU Maker user logged in Successfully");
			Thread.sleep(3000);
			driver.navigate().refresh();
			
			//RL OPS DVU Maker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(caseno);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(caseno);
			Thread.sleep(6000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed to Sent to DE maker");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Completed RL Ops DVU Maker process");
			
				
					//logout process
					
					Thread.sleep(1000);
					logOutLink.click();
					System.out.println("Successfuly logged out");
					
					//click on Search Setup input field(Global Search) of User Page
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
					searchGlodalFieldOfUserPage.click();
					
					searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeMakerUser()));
					
					Thread.sleep(3000);
					globalSearchValueSelection.click();
					Thread.sleep(5000);
					Thread.sleep(9000);
					
					driver.switchTo().frame(0);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
					Thread.sleep(2000);
					this.performClickWithAction(loginButton);
					
					System.out.println("DE maker user logged in Successfully");
					Thread.sleep(3000);
					
					//DE Maker accept Invite & Edit
					
					Thread.sleep(10000);
					this.clearTab();			
					Thread.sleep(5000);	
					navigationMenuDropdown.click();
					Thread.sleep(3000);
					caseDropdown.click();
					Thread.sleep(3000);			
					//Accept case process
					listViewDropdown.click();
					Thread.sleep(5000);
					listViewSearchField.sendKeys("RL Ops DE Maker – Individual Request");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("RL Ops DE Maker – Individual Request is selected");
					
					
					Thread.sleep(6000);				
					caseSearchField.sendKeys(caseno);
					caseSearchField.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					this.performClickWithAction(caseNumberCheckbox);
				
					acceptButton.click();
					Thread.sleep(10000);
					System.out.println("Successfully clicked on Accept Button");
					
					
					//CHange status code process
					listViewDropdown.click();
					Thread.sleep(3000);
					listViewSearchField.sendKeys("My Open Cases");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("My open cases is selected");
					Thread.sleep(3000);			
					caseSearchField.sendKeys(caseno);
					Thread.sleep(6000);
					driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
					Thread.sleep(4000);
					this.performClickWithAction(topCaseNumberLink);
					System.out.println("Clickd on Case number");
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(editButton));
					editButton.click();
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(journalNumber));
					journalNumber.sendKeys(handler.getJournalNumber());
					statusCodeDropdown.click();
					this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
					System.out.println("Status code is changed as Sent to DE Checker");
					Thread.sleep(2000);
					
					
					((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
					Thread.sleep(5000);
					
					this.performClickWithAction(topSaveButton);
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
					
					System.out.println("Completed DE Maker user process");
					
					//logout process
					
					Thread.sleep(1000);
					logOutLink.click();
					System.out.println("Successfuly logged out");
					
					//click on Search Setup input field(Global Search)
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
					
					searchGlodalFieldOfUserPage.click();
					
					searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeCheckerUser()));
					
					Thread.sleep(3000);
					globalSearchValueSelection.click();
					Thread.sleep(5000);
					Thread.sleep(9000);
					
					driver.switchTo().frame(0);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
					Thread.sleep(2000);
					this.performClickWithAction(loginButton);
					
					System.out.println("DE checker user logged in Successfully");
					Thread.sleep(3000);
					
					//DE checker accept Invite & Edit
					
					Thread.sleep(10000);
					this.clearTab();			
					Thread.sleep(5000);	
					navigationMenuDropdown.click();
					Thread.sleep(3000);
					caseDropdown.click();
					Thread.sleep(3000);			
					//Accept case process
					listViewDropdown.click();
					Thread.sleep(5000);
					listViewSearchField.sendKeys("RL Ops DE Checker – Individual Request");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("RL Ops DE Checker – Individual Request is selected");
					
					
					Thread.sleep(6000);				
					caseSearchField.sendKeys(caseno);
					caseSearchField.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					this.performClickWithAction(caseNumberCheckbox);
				
					acceptButton.click();
					Thread.sleep(10000);
					System.out.println("Successfully clicked on Accept Button");
					
					
					//CHange status code process
					listViewDropdown.click();
					Thread.sleep(3000);
					listViewSearchField.sendKeys("My Open Cases");
					Thread.sleep(3000);
					listViewFirstOption.click();
					System.out.println("My open cases is selected");
					Thread.sleep(3000);			
					caseSearchField.sendKeys(caseno);
					Thread.sleep(6000);
					driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
					Thread.sleep(4000);
					this.performClickWithAction(topCaseNumberLink);
					
					System.out.println("Clickd on Case number");
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(editButton));

					editButton.click();
					Thread.sleep(10000);
					statusCodeDropdown.click();
					wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
					this.selectElement(statusCodeDropdown, handler.getDeCheckerStatus());
					System.out.println("Status code Changed to Resolved");
					Thread.sleep(2000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
					Thread.sleep(5000);

					this.performClickWithAction(topSaveButton);
					
					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOf(statusCodeValue));
					String statuscode1 = statusCodeValue.getText();
					
					System.out.println("Status code is " + statuscode1);
					
					if(statuscode1.equals("Resolved And Closed"))
					{
						System.out.println("Status code is Resolved & Closed");
					}
					else
					{
						System.out.println("Status code is not matched");
						Assert.fail();
					}
					
					
						
					System.out.println("Completed RL OPS 3 step");
				
				
					
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void validationOfGlobalSearchFieldProd(CaseDataModel handler)
	{
		try
		{
			navigationMenuDropdown.click();
			Thread.sleep(1000);
			homeDropdown.click();
			Thread.sleep(2000);
			//Search by Customer name
			globalSearchField.clear();
			globalSearchField.sendKeys(handler.getAccountName());
			Thread.sleep(2000);
			globalSearchValueFirstOption.click();
			Thread.sleep(2000);
			accountsLabelOfCustomerPage.isDisplayed();
			
			cutsomerNameLabelOfCustomerPage.isDisplayed();
			customerNameValueOfCustomerPage.isDisplayed();
			System.out.println("Customer Name: " + customerNameValueOfCustomerPage.getText());
			
			
			phoneLabelOfCustomerPage.isDisplayed();
			phoneValueOfCustomerPage.isDisplayed();
			System.out.println("Phone:" + phoneValueOfCustomerPage.getText());
			
			accountOwnerAliasOfCustomerPage.isDisplayed();
			accountOwnerValueOfCustomerPage.isDisplayed();
			System.out.println("Account owner Alias: "+ accountOwnerValueOfCustomerPage.getText() );
			
			//click on Customer name
			customerNameValueOfCustomerPage.click();
			Thread.sleep(2000);
			
			customerIdLabel.isDisplayed();
			customerIdValue.isDisplayed();
			System.out.println("Customer ID:" + customerIdValue.getText());
			
			segmentTypeLabelOfCustomerInfo.isDisplayed();
			segmentTypeValue.isDisplayed();
			System.out.println("Segment Type:" + segmentTypeValue.getText());
			
			casesWithIcon.isDisplayed();
			System.out.println("Cases with dropdown is displayed");
			
			offersLabel.isDisplayed();
			System.out.println("Offers label is displayed");
			
			financialAccountsLabel.isDisplayed();
			System.out.println("Financial Accounyts label is displayed");
			
			activitiesLabel.isDisplayed();
			System.out.println("Activities label is displayed");
			
			
			actionPlansLabel.isDisplayed();
			System.out.println("Action Plans label is displayed");
			
			kycLabel.isDisplayed();
			System.out.println("KYC label is displayed");
			
			System.out.println("Validated by customer name");
			
		}
		catch(Exception e)
		{

			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void searchByCustomerAccount(CaseDataModel handler) 
	{
		try
		{
			Thread.sleep(2000);
			this.clearTab();
			Thread.sleep(2000);
			navigationMenuDropdown.click();
			Thread.sleep(2000);
			homeDropdown.click();
			Thread.sleep(2000);
			globalSearchField.clear();
			globalSearchField.sendKeys(handler.getAccountName());
			Thread.sleep(2000);
			globalSearchValueSelection.click();
			System.out.println("Account is selected");
			
			customerIdLabel.isDisplayed();
			customerIdValue.isDisplayed();
			System.out.println("Customer ID:" + customerIdValue.getText());
			
			segmentTypeLabelOfCustomerInfo.isDisplayed();
			segmentTypeValue.isDisplayed();
			System.out.println("Segment Type:" + segmentTypeValue.getText());
			
			casesWithIcon.isDisplayed();
			System.out.println("Cases with dropdown is displayed");
			
			offersLabel.isDisplayed();
			System.out.println("Offers label is displayed");
			
			financialAccountsLabel.isDisplayed();
			System.out.println("Financial Accounyts label is displayed");
			
			activitiesLabel.isDisplayed();
			System.out.println("Activities label is displayed");
			
			
			actionPlansLabel.isDisplayed();
			System.out.println("Action Plans label is displayed");
			
			kycLabel.isDisplayed();
			System.out.println("KYC label is displayed");
			
			System.out.println("Validated by Customer account");
			
			
		}
		catch(Exception e)
		{

			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void searchByPhoneNumber(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(2000);
			this.clearTab();
			Thread.sleep(2000);
			navigationMenuDropdown.click();
			Thread.sleep(2000);
			homeDropdown.click();
			Thread.sleep(2000);
			//search by phone no
			globalSearchField.clear();
			globalSearchField.sendKeys(handler.getMobileNumber());
			
			Thread.sleep(2000);
			globalSearchValueFirstOption.click();
			Thread.sleep(2000);
			accountsLabelOfCustomerPage.isDisplayed();
			
			cutsomerNameLabelOfCustomerPage.isDisplayed();
			customerNameValueOfCustomerPage.isDisplayed();
			System.out.println("Customer Name: " + customerNameValueOfCustomerPage.getText());
			
			
			phoneLabelOfCustomerPage.isDisplayed();
			phoneValueOfCustomerPage.isDisplayed();
			System.out.println("Phone:" + phoneValueOfCustomerPage.getText());
			
			accountOwnerAliasOfCustomerPage.isDisplayed();
			accountOwnerValueOfCustomerPage.isDisplayed();
			System.out.println("Account owner Alias: "+ accountOwnerValueOfCustomerPage.getText() );
			
			//click on Customer name
			customerNameValueOfCustomerPage.click();
			Thread.sleep(2000);
			
			customerIdLabel.isDisplayed();
			customerIdValue.isDisplayed();
			System.out.println("Customer ID:" + customerIdValue.getText());
			
			segmentTypeLabelOfCustomerInfo.isDisplayed();
			segmentTypeValue.isDisplayed();
			System.out.println("Segment Type:" + segmentTypeValue.getText());
			
			casesWithIcon.isDisplayed();
			System.out.println("Cases with dropdown is displayed");
			
			offersLabel.isDisplayed();
			System.out.println("Offers label is displayed");
			
			financialAccountsLabel.isDisplayed();
			System.out.println("Financial Accounyts label is displayed");
			
			activitiesLabel.isDisplayed();
			System.out.println("Activities label is displayed");
			
			
			actionPlansLabel.isDisplayed();
			System.out.println("Action Plans label is displayed");
			
			kycLabel.isDisplayed();
			System.out.println("KYC label is displayed");
			
			System.out.println("Validated by phone no");
			
			
		}
		catch(Exception e)
		{

			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void searchByCustomerId(CaseDataModel handler)
	{
		try
		{
			
			Thread.sleep(2000);
			this.clearTab();
			Thread.sleep(2000);
			navigationMenuDropdown.click();
			Thread.sleep(2000);
			homeDropdown.click();
			Thread.sleep(2000);
			//search by customer id
			globalSearchField.clear();
			globalSearchField.sendKeys(handler.getCustomerId());
			
			Thread.sleep(2000);
			globalSearchValueFirstOption.click();
			Thread.sleep(2000);
			
			accountsLabelOfCustomerPage.isDisplayed();
			
			cutsomerNameLabelOfCustomerPage.isDisplayed();
			customerNameValueOfCustomerPage.isDisplayed();
			System.out.println("Customer Name: " + customerNameValueOfCustomerPage.getText());
			
			
			phoneLabelOfCustomerPage.isDisplayed();
			phoneValueOfCustomerPage.isDisplayed();
			System.out.println("Phone:" + phoneValueOfCustomerPage.getText());
			
			accountOwnerAliasOfCustomerPage.isDisplayed();
			accountOwnerValueOfCustomerPage.isDisplayed();
			System.out.println("Account owner Alias: "+ accountOwnerValueOfCustomerPage.getText() );
			
			//click on Customer name
			customerNameValueOfCustomerPage.click();
			Thread.sleep(2000);
			
			customerIdLabel.isDisplayed();
			customerIdValue.isDisplayed();
			System.out.println("Customer ID:" + customerIdValue.getText());
			
			segmentTypeLabelOfCustomerInfo.isDisplayed();
			segmentTypeValue.isDisplayed();
			System.out.println("Segment Type:" + segmentTypeValue.getText());
			
			casesWithIcon.isDisplayed();
			System.out.println("Cases with dropdown is displayed");
			
			offersLabel.isDisplayed();
			System.out.println("Offers label is displayed");
			
			financialAccountsLabel.isDisplayed();
			System.out.println("Financial Accounyts label is displayed");
			
			activitiesLabel.isDisplayed();
			System.out.println("Activities label is displayed");
			
			
			actionPlansLabel.isDisplayed();
			System.out.println("Action Plans label is displayed");
			
			kycLabel.isDisplayed();
			System.out.println("KYC label is displayed");
			
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void validateCasePageWithCaseId(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(2000);
			this.clearTab();
			Thread.sleep(2000);
			this.clearTab();
			Thread.sleep(5000);
			navigationMenuDropdown.click();
			Thread.sleep(2000);
			homeDropdown.click();
			Thread.sleep(2000);
			navigationMenuDropdown.click();
			Thread.sleep(2000);
			caseDropdown.click();
			System.out.println("Cases dropdown selected");
			Thread.sleep(5000);
			newButton.isDisplayed();
			casesImg.isDisplayed();
			
			caseSearchField.isDisplayed();
			/*
			listViewDropdown.click();
			
			//to print all values[try1]
			
			listBoxRecentListView.isDisplayed();
			String listAllValues = listBoxRecentListView.getText();
			System.out.println(listAllValues);*/
			
			caseSearchField.sendKeys(handler.getCaseId());
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			Thread.sleep(2000);
			//
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
			
			changeUserRoleButton.isDisplayed();
			editButton.isDisplayed();
			
			detailsTab.isDisplayed();
			historyTab.isDisplayed();
			System.out.println("Detail & history tab validated");
			
			/*convertToComplaintButton.isDisplayed();
			viewDocumentOmniScanButton.isDisplayed();
			uploadDocumentButton.isDisplayed();
			System.out.println("Convert to complaint, View Documentation Omni Scan, Upload document buttons are validated");
			*/
			Thread.sleep(2000);
			caseTypeValue.isDisplayed();
			categoryValue.isDisplayed();
			subCategoryValue.isDisplayed();
			
			System.out.println("Case Type , category & sub category values are validated");
			
			historyTab.click();
			
			Thread.sleep(2000);
			caseHistoryLabel.isDisplayed();
			startTimeStampLabel.isDisplayed();
			newValueLabel.isDisplayed();
			typeLabel.isDisplayed();
			createdByLabel.isDisplayed();
			logIdLabel.isDisplayed();
			
			System.out.println("Validated History tab");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseOnly(CaseDataModel handler)
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
			Thread.sleep(4000);
			
			this.performClickWithAction(statusCodeDropdown);
			
			
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
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
	
	
	public void createCaseForEmbossedNameChangebyBoc(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			this.performClickWithAction(newButton);
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
			
			//validation checks
						
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
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
	
	
	public void createCaseOnlybyBranch(CaseDataModel handler)
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
			Thread.sleep(4000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());			
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			barCodeField.sendKeys(handler.getBarCode());
			
			Thread.sleep(2000);
			this.performClickWithAction(statusCodeDropdown);
			
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
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
	
	
	public void createCaseonlyForRuralAccountByBranch(CaseDataModel handler)
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
			Thread.sleep(4000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());			
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			sourceBranchField.click();
			sourceBranchField.sendKeys("Chembur");
			Thread.sleep(3000);
			
			showAllResultsForOption.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(selectBranchName1stOption));
			selectBranchName1stOption.click();
			
			/*
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[text()='Source Branch']/following::input[1]/following::lightning-icon[1]/lightning-primitive-icon[1]")).click();
			Thread.sleep(2000);
			sourceBranchField.sendKeys(Keys.UP);
			sourceBranchField.sendKeys(Keys.ENTER);*/
			
			/*List<WebElement> list = driver.findElements(By.cssSelector("#ui-id-1 li:nth-child(n)")).stream().limit(5).collect(Collectors.toList());
			list.get(0).click();
			System.out.println("selected source");*/
			
			Thread.sleep(2000);
			barCodeField.sendKeys(handler.getBarCode());
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(5000);

			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
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
	
	
	
	
	public void createCaseCallBackForRuralAccountByBranch(CaseDataModel handler)
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
			Thread.sleep(4000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());			
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			sourceBranchField.click();
			sourceBranchField.sendKeys("Chembur");
			Thread.sleep(3000);
			
			showAllResultsForOption.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(selectBranchName1stOption));
			selectBranchName1stOption.click();			
						
			Thread.sleep(2000);
			barCodeField.sendKeys(handler.getBarCode());
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(5000);
			
			Thread.sleep(2000);
			callBackDropdown.click();
			Thread.sleep(1000);			
			callBackYes.click();			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());		
			System.out.println("Selected call back date & time");
			
			Thread.sleep(3000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(5000);

			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
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
	
	public void createCaseWithCallBackbyBranch(CaseDataModel handler)
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
			
			barCodeField.sendKeys(handler.getBarCode());
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(5000);
			
			callBackDropdown.click();
			Thread.sleep(1000);
			
			callBackYes.click();
			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());
			Thread.sleep(3000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
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
	
	public void grdScenario_convertToComplaint(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(4000);
			this.performClickWithAction(convertToComplaintButton);
			
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			System.out.println("Convert to complaint done");
			//wait.until(ExpectedConditions.visibilityOf(isComplaintCheckbox)).click();
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusByRLOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getRlOpsUser()));
			
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
			System.out.println("RL Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//RL ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops Request");
			Thread.sleep(3000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("RL Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			WebElement d1 = driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span"));
			this.performClickWithAction(d1);
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
		
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(13000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getRlOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			//saveButton.click();
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed RL Ops User process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusByGRDUser(CaseDataModel handler)
	{
		try
		{
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getGrdUser()));
			
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
			System.out.println("GRD user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By GRD
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("GRD Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			//driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("GRD Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getGrdStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			//saveButton.click();
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed GRD User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseAssignToDepartment(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			newButton.click();
			newCaseButton.click();
			Thread.sleep(5000);
			this.performClickWithAction(caseTypeDropdown);
			//caseTypeDropdown.click();
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
			System.out.println("Status Code : Assigned to department");
			
			Thread.sleep(5000);
			
			departmentDropdown.click();
			String departmentvalue = handler.getDepartment();
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			Thread.sleep(2000);	
			this.performClickWithAction(d1);
			System.out.println("Department value selected");
			Thread.sleep(2000);			
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
	
	public void createCaseAssignToDepartmentBranchByBOC(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			newButton.click();
			newCaseButton.click();
			Thread.sleep(5000);
			this.performClickWithAction(caseTypeDropdown);
			//caseTypeDropdown.click();
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
			System.out.println("Status Code : Assigned to department");
			
			Thread.sleep(5000);
			
			
			
			departmentDropdown.click();
			String departmentvalue = handler.getDepartment();				
			WebElement branchOption = driver.findElement(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']"));
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", branchOption );
			
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']"))).click();
			System.out.println("Department value selected");
			Thread.sleep(5000);		
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			
			branchDropdownOFNewCasePage.click();
			this.selectElement(branchDropdownOFNewCasePage, "10");
			System.out.println("Branch dropdown selected value");
			
			Thread.sleep(2000);	
			
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
	
	
	public void loginAcceptAndChangeStatusCodeWithDepartmentByWealthOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWealthOpsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(10000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Wealth Ops user logged in Successfully");
			Thread.sleep(10000);
			
			//Accept By Wealth Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Wealth Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Wealth Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(6000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			Thread.sleep(5000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWealthOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			departmentDropdown.click();
			String departmentvalue = handler.getWealthOpsDepartment();
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			this.performClickWithAction(d1);
			System.out.println("Department value is changed");
			Thread.sleep(5000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed Wealth ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeByWealthOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWealthOpsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(10000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("Wealth Ops user logged in Successfully");
			Thread.sleep(10000);
			
			//Accept By Wealth Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Wealth Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Wealth Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(6000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			//editButton.click();
			Thread.sleep(10000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWealthOpsStatusCode());
			System.out.println("Status code is changed");
			
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed Wealth ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeWithDepartmentByWCOpsUser(CaseDataModel handler)
	{
		try
		{	
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWcOpsUser()));
			
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
			System.out.println("Wc Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wc Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("WC Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("WC Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(9000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWcOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			departmentDropdown.click();
			String departmentvalue = handler.getWcOpsDepartment();		
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			this.performClickWithAction(d1);
			System.out.println("Department value is changed");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed WC ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeByWCOpsUser1Again(CaseDataModel handler)
	{
		try
		{	
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWcOpsUser()));
			
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
			System.out.println("Wc Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wc Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("WC Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("WC Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(7000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(13000);
			statusCodeDropdown.click();			
			this.selectElement(statusCodeDropdown, handler.getWcOpsStatusCode1());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(5000);
			
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
			
			
			System.out.println("Completed WC ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeByWCOpsUser(CaseDataModel handler)
	{
		try
		{	
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWcOpsUser()));
			
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
			System.out.println("Wc Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wc Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("WC Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("WC Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(7000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(13000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWcOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(5000);
			
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
			
			
			System.out.println("Completed WC ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusCodeDepartmentByCMSOpsUser(CaseDataModel handler )
	{
		try
		{
			Thread.sleep(5000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCmsOpsUser()));
			
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
			System.out.println("CMS Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By CMS Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("CMS Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("CMS Ops Request is selected");
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseSearchField));
			
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();
			*/
			//topCaseNumberLink.click();
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			this.selectElement(statusCodeDropdown, handler.getCmsOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			departmentDropdown.click();
			String departmentvalue = handler.getCmsOpsDepartment();		
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			this.performClickWithAction(d1);
			System.out.println("Department value is changed");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed CMS ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeWithDepartmentByReconOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getReconsOpsUser()));
			
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
			System.out.println("Recon Ops user logged in Successfully");
			Thread.sleep(5000);
			
			//Accept By Recons Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);			
			reconOpsRequestOption.click();			
			Thread.sleep(3000);
						
			System.out.println("Recon Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(5000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();
			*/
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			//editButton.click();
			Thread.sleep(15000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getReconOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(8000);
			
			departmentDropdown.click();
			Thread.sleep(3000);
			String departmentvalue = handler.getReconOpsDepartment();		
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			this.performClickWithAction(d1);
			System.out.println("Department value is changed");
			Thread.sleep(5000);
										
			
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(5000);
			
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
			
			
			System.out.println("Completed Recon ops User process");
			
						
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeWithDepartmentByWealthProductTeam(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWealthProductTeamUser()));
			
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
			System.out.println("Wealth Product team user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wealth Product team
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Wealth Product Team Request");
			Thread.sleep(5000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Wealth Product Team Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			//editButton.click();
			Thread.sleep(6000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWealthProductTeamStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			
			departmentDropdown.click();
			String departmentvalue = handler.getWealthProductTeamDepartment();		
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			this.performClickWithAction(d1);
			System.out.println("Department value is changed");
			Thread.sleep(5000);
			//Adding Branch dropdown code
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed Wealth Product Team User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeWithResolutionCommentByWealthProductTeam(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWealthProductTeamUser()));
			
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
			System.out.println("Wealth Product team user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wealth Product team
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Wealth Product Team Request");
			Thread.sleep(5000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Wealth Product Team Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			Thread.sleep(6000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWealthProductTeamStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(3000);
			
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(3000);
			
			
			System.out.println("Resolution comment entered");
			Thread.sleep(4000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			
			//this.performClickWithAction(saveButton);
			
			Thread.sleep(7000);
			
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
			
			
			System.out.println("Completed Wealth Product Team User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
				
	
	public void loginAcceptAndChangeStatusCodeForChemburBranchRequestByBranchUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBranchUser()));
			
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
			System.out.println("Branch user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By GRD
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Chembur Branch Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Chembur Branch Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBranchStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			departmentDropdown.click();			
			String departmentvalue = handler.getBranchDepartment();		
			WebElement d1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']")));
			this.performClickWithAction(d1);
			System.out.println("Department value is changed");
			Thread.sleep(5000);
						
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);

			this.performClickWithAction(topSaveButton);
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed Branch User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAndChangeStatusCodeInClarificationRequiredBranchOptionByBranchUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBranchUser()));
			
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
			System.out.println("Branch user logged in Successfully");
			Thread.sleep(3000);
			
			//Change Status
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);	
			
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("Clarification Required - Branch");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("Clarification Required - Branch is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
		//	editButton.click();
			Thread.sleep(9000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBranchStatusCode());
			System.out.println("Status code is changed");
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed Branch User process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusDepartmentByGRDUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getGrdUser()));
			
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
			System.out.println("GRD user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By GRD
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("GRD Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			Thread.sleep(6000);
		//	driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("GRD Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getGrdStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			
			departmentDropdown.click();			
			Thread.sleep(2000);		
			String grddepartmentvalue = handler.getGrdDepartment();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+grddepartmentvalue+"']"))).click();
			System.out.println("Department value selected");
			Thread.sleep(3000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed GRD User process with Department");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndStatusChangeByIOUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getIoUser()));
			
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
			System.out.println("IO user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By GRD
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);
			this.clearTab();
			Thread.sleep(5000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("IO Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("Io Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(15000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getIoStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);		
			
			
			departmentDropdown.click();			
			Thread.sleep(4000);		
			String iodepartmentvalue = handler.getIoDepartment();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+iodepartmentvalue+"']"))).click();
			System.out.println("Department value selected");
			Thread.sleep(3000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			//saveButton.click();
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed IO User process with Department");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusByGRDUser1again(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getGrdUser()));
			
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
			System.out.println("GRD user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By GRD
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("GRD Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("GRD Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);			
			System.out.println("Clickd on Case number");
			
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(15000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getGrdStatusCode1());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			
			
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(2000);
			
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(9000);
			
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
			
			
			System.out.println("Completed GRD User process twice");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseAssignedtoUserForEmbossedNameChange(CaseDataModel handler)
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
			
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Succesfully clicked on verify Transaction Checkbox");
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
			
			
			userField.sendKeys(handler.getUserFieldForAssigned());
			Thread.sleep(2000);
			//selecting the 1st option of user search- code working
			userField.sendKeys(Keys.DOWN);
			userField.sendKeys(Keys.ENTER);
			
			/*
			 *if above code not work below code can try
			 *driver.findElement(By.xpath("//span[contains(text(),'Show All Results for')]/following::span[@class='slds-media__body']/span[2]/lightning-base-combobox-formatted-text[1]")).click();
			*/
			
			Thread.sleep(5000);
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
	
	//branch
	
	public void createCaseAssignedtoUserByBranch(CaseDataModel handler)
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
			
			barCodeField.sendKeys(handler.getBarCode());
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
			
			
			userField.sendKeys(handler.getUserFieldForAssigned());
			Thread.sleep(2000);
			//selecting the 1st option of user search- code working
			userField.sendKeys(Keys.DOWN);
			userField.sendKeys(Keys.ENTER);
			
			/*
			 *if above code not work below code can try
			 *driver.findElement(By.xpath("//span[contains(text(),'Show All Results for')]/following::span[@class='slds-media__body']/span[2]/lightning-base-combobox-formatted-text[1]")).click();
			*/
			
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
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
	
	public void onlyEditcaseByGRDuser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getGrdUser()));
			
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
			System.out.println("GRD user logged in Successfully");
			Thread.sleep(3000);
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(2000);
			this.clearTab();			
			Thread.sleep(5000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			
			
			//Change status code
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
					
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getGrdStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(4000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			this.performClickWithAction(topSaveButton);
			//saveButton.click();
			Thread.sleep(10000);
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
			
			System.out.println("Completed the process by GRD");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseWithCSOTOCMSAuthenticationMode(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(3000);
			
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
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
						
			authenticationModeDropdown.click();			
			Thread.sleep(2000);
			String authenticationModevalue = handler.getAuthenticationMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+authenticationModevalue+"']"))).click();
			Thread.sleep(2000);
			barCodeField.clear();
			barCodeField.sendKeys(handler.getBarcode());
			
			
			saveButton.click();
			Thread.sleep(2000);
			
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
	
	public void loginAcceptAndStatusChangeByCSOUser(CaseDataModel handler)
	{
		try
		{
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCsoUser()));
			
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
			System.out.println("CSO user logged in Successfully");
			Thread.sleep(3000);
			
			//CSO user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops Request");
			Thread.sleep(3000);
			//Selecting 2nd option of RL Ops Request
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Select List View']/following::input[@role='combobox']/following::ul[1]/li[2]")).click();
			Thread.sleep(2000);
			System.out.println("CSO Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getRlOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(2000);
			
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
			
			
			System.out.println("Completed RL Ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	//
	
	public void loginAcceptAndChangeStatusCodeOnlyByCMSOpsUser(CaseDataModel handler)
	{
		try
		{
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCmsOpsUser()));
			
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
			System.out.println("CMS Ops user logged in Successfully");
			Thread.sleep(3000);
			
			
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("CMS Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();			
			Thread.sleep(2000);
			System.out.println("CMS Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();	*/	
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCmsOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(2000);
			
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
			
			
			System.out.println("Completed CMS ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeWithRejectionReasonByDVUMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
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
			System.out.println("DVU maker user logged in Successfully");
			Thread.sleep(3000);
			
			//DVU maker user logged in 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			Thread.sleep(3000);	
			this.clearTab();
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker – Individual Request");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("RL Ops DVU Maker - Individual Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			System.out.println("Clickd on Case number");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
						
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed to Sent to DVU Checker - Rejected");
			Thread.sleep(8000);
			reasonForRejectionTopVallue.click();
			Thread.sleep(3000);
			moveSelectionToChosenArrowButton.click();
			Thread.sleep(3000);
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			
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
			
			
			System.out.println("Completed DVU Maker User rejected process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeJournalNOByDEMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeMakerUser()));
			
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
			System.out.println("DE maker user logged in Successfully");
			Thread.sleep(3000);
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DE Maker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DE Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			System.out.println("Successfully clicked on Accept Button");
			Thread.sleep(10000);
			
			
			wait.until(ExpectedConditions.visibilityOf(listViewDropdown));
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(journalNumber));
			journalNumber.sendKeys(handler.getJournalNumber());
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
			System.out.println("Status code is changed as Sent to DE Checker");
			Thread.sleep(2000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			this.performClickWithAction(topSaveButton);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			Thread.sleep(10000);
			
			System.out.println("Completed DE Maker user process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusCodeJournalNOByDEMakerUserNonIndividualRequest(CaseDataModel handler)
	{
		try
		{
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeMakerUser()));
			
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
			System.out.println("DE maker user logged in Successfully");
			Thread.sleep(3000);
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DE Maker – Non Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DE Maker – Non Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			journalNumber.sendKeys(handler.getJournalNumber());
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
			System.out.println("Status code is changed as Sent to DE Checker");
			Thread.sleep(2000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(2000);
			
			System.out.println("Completed DE Maker user process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeByDECheckerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeCheckerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("DE checker user logged in Successfully");
			Thread.sleep(3000);
			
			//DE checker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(10000);
			driver.navigate().refresh();
			Thread.sleep(5000);	
			this.clearTab();
			Thread.sleep(5000);	
			//Accept case process
			wait.until(ExpectedConditions.visibilityOf(listViewDropdown));
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DE Checker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DE Checker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDeCheckerStatus());
			System.out.println("Status code is Resolved");
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(4000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Completed DE Checker user process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusCodeByDECheckerUserNonIndividualRequest(CaseDataModel handler)
	{
		try
		{
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDeCheckerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("DE checker user logged in Successfully");
			Thread.sleep(3000);
			
			//DE checker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DE Checker – Non Individual Reqs");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DE Checker – Non Individual Reqs is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDeCheckerStatus());
			System.out.println("Status code is Resolved");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(5000);
			System.out.println("Completed DE Checker user non individual request process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeWithResolutionCommentByCMSOpsUser(CaseDataModel handler)
	{
		try
		{
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getCmsOpsUser()));
			
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
			System.out.println("CMS Ops user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By GRD
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("CMS Ops Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("CMS Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getCmsOpsStatusCode());
			System.out.println("Status code is changed");
			
			Thread.sleep(2000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			
			Thread.sleep(2000);
			
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(2000);
			
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
			
			
			System.out.println("Completed CMS ops User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	public void createCaseFraudulentMissusebyBranch(CaseDataModel handler)
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
			
			transactionRefernceNoField.sendKeys(handler.getTransactionReferenceNo());
			disputeAmtField.sendKeys(handler.getDisputeAmt());
			barCodeField.sendKeys(handler.getBarcode());
			Thread.sleep(3000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			Thread.sleep(3000);	
			
			
			disputeStageField.click();
			String disputestagevalue = handler.getDisputeStage();						
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispute Stage']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+disputestagevalue+"']"))).click();
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
		   			
			Thread.sleep(5000);
			System.out.println("Clicked on save button");
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
	
	public void createCaseFraudulentMissusebyBOC(CaseDataModel handler)
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
			
			transactionRefernceNoField.sendKeys(handler.getTransactionReferenceNo());
			disputeAmtField.sendKeys(handler.getDisputeAmt());
			disputeStageField.click();
			String disputestagevalue = handler.getDisputeStage();						
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispute Stage']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+disputestagevalue+"']"))).click();
			
			
			Thread.sleep(3000);	
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code changed");
			Thread.sleep(3000);	
			
			
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
		   			
			Thread.sleep(5000);
			System.out.println("Clicked on save button");
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
	
	
	public void loginAcceptAndChangeStatusCodeByReconOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getReconsOpsUser()));
			
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
			System.out.println("Recon Ops user logged in Successfully");
			Thread.sleep(6000);
			
			//Accept By Recons Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);			
			reconOpsRequestOption.click();			
			Thread.sleep(3000);
						
			System.out.println("Recon Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(5000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			//editButton.click();
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getReconOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(8000);										
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed Recon ops User process");
			
						
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusCodeForClarificationProvidedOpsReqByReconOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getReconsOpsUser()));
			
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
			System.out.println("Recon Ops user logged in Successfully");
			Thread.sleep(6000);
			
			//Accept By Recons Ops
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);	
			listViewSearchField.sendKeys("Clarification Provided - Recon Ops");
			Thread.sleep(2000);
			listViewFirstOption.click();
			Thread.sleep(3000);
						
			System.out.println("Clarification Provided - Recon Ops is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(5000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			/*Actions actions = new Actions(driver);
			actions.doubleClick(topCaseNumberLink).perform();*/
			
			//topCaseNumberLink.click();
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			//editButton.click();
			Thread.sleep(15000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getReconOpsStatusCode1());
			System.out.println("Status code is changed");
			Thread.sleep(5000);
			
			
			transactionDisputeStatusDropdown.click();
			String transactiondisputestatusvalue = handler .getTransactionDisputeStatus();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Transaction Dispute Status']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+transactiondisputestatusvalue+"']"))).click();
			System.out.println("Department value selected");
			Thread.sleep(2000);			
			

			
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(8000);
			
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
			
			
			System.out.println("Completed Recon ops User process");
			
						
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void loginAcceptAndChangeStatusCodeByDVUMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("RL Ops DVU Maker user logged in Successfully");
			Thread.sleep(3000);
			driver.navigate().refresh();
			
			//RL OPS DVU Maker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker – Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker – Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			System.out.println("Completed RL Ops DVU Maker process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAndChangeStatusCodeWithResolutionCommentByBranchUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBranchUser()));
			
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
			System.out.println("Branch user logged in Successfully");
			Thread.sleep(15000);
			
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);	
			
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(10000);
			
			
			WebElement d1 = driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span"));
			d1.click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBranchStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(8000);
			
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(4000);
			
			
			this.performClickWithAction(saveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(6000);
			
			
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
			
			System.out.println("Completed the branch user process with resolution comment");

		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void createCaseWelcomeKitRedirectionByBOC(CaseDataModel handler)
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
			Thread.sleep(4000);
			
			dispatchDestinationDropdown.click();			
			String dispatchdestinationvalue = handler.getDispatchDestination();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispatch Destination']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+dispatchdestinationvalue+"']"))).click();
			System.out.println("Dispatch Destination value selected");
			Thread.sleep(2000);
			
			landmarkField.sendKeys(handler.getLandmark());
			
			dispatchModeDropdown.click();
			String dispatchmodvalue = handler.getDispatchMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispatch Mode']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+dispatchmodvalue+"']"))).click();
			System.out.println("Dispatch Destination value selected");
			Thread.sleep(2000);
			
			validatePANCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Validation checkbox clicked");
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
			this.performClickWithAction(saveButton);
			
			
			Thread.sleep(7000);
			
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
	
	public void createCaseWelcomeKitRedirectionByBranch(CaseDataModel handler)
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
			Thread.sleep(4000);
			
			barCodeField.sendKeys(handler.getBarCode());
			Thread.sleep(1000);
			
			dispatchDestinationDropdown.click();			
			String dispatchdestinationvalue = handler.getDispatchDestination();			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispatch Destination']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+dispatchdestinationvalue+"']"))).click();
			System.out.println("Dispatch Destination value selected");
			Thread.sleep(2000);
			
			landmarkField.sendKeys(handler.getLandmark());
			
			dispatchModeDropdown.click();
			String dispatchmodvalue = handler.getDispatchMode();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispatch Mode']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+dispatchmodvalue+"']"))).click();
			System.out.println("Dispatch Destination value selected");
			Thread.sleep(2000);		
						
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
			this.performClickWithAction(saveButton);
			
			
			Thread.sleep(7000);
			
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
	
	public void loginAcceptAndChangeStatusWithResolutionCommentByBOCUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBocUser()));
			
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
			System.out.println("BOC user logged in Successfully");
			Thread.sleep(3000);
			
			//BOC user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BOC Request");
			Thread.sleep(3000);			
			listViewFirstOption.click();
			Thread.sleep(2000);
			System.out.println("BOC Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBocStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(2000);
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed BOC User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeByBBOpsUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbopsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(8000);
			this.performClickWithAction(loginButton);			
			System.out.println("BB OPS user logged in Successfully");
			Thread.sleep(6000);
			
			
			//BB Ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops Request");
			Thread.sleep(3000);			
			listViewFirstOption.click();
			Thread.sleep(2000);
			System.out.println("BB Ops Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			this.selectElement(statusCodeDropdown, handler.getBbOpsStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed BB Ops User process");
			
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptCaseFromClarificationProvidedBBOPsOptionAndChangeStatusByBBOpsUser1again(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbopsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(8000);
			this.performClickWithAction(loginButton);			
			System.out.println("BB OPS user logged in Successfully");
			Thread.sleep(6000);
			
			
			//BB Ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Clarification Provided - BB Ops");
			Thread.sleep(3000);			
			listViewFirstOption.click();
			Thread.sleep(2000);
			System.out.println("Clarification Provided - BB Ops is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);			
			this.selectElement(statusCodeDropdown, handler.getBbOpsStatusCode1());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed BB Ops Clarification Provided BB OPs Option User process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	
	public void loginAcceptAndChangeStatusCodeByDVUMakerNonIndividualUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("RL Ops DVU Maker user logged in Successfully");
			Thread.sleep(3000);
			driver.navigate().refresh();
			
			//RL OPS DVU Maker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker –Non Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker –Non Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(9000);
			
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed ");
			Thread.sleep(2000);
			
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			
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
			
			System.out.println("Completed RL Ops DVU Maker Non Individual process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeWithDepartmentByDVUMakerNonIndividualUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getDvuMakerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("RL Ops DVU Maker user logged in Successfully");
			Thread.sleep(3000);
			driver.navigate().refresh();
			
			//RL OPS DVU Maker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("RL Ops DVU Maker –Non Individual Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("RL Ops DVU Maker –Non Individual Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			this.selectElement(statusCodeDropdown, handler.getDvuMakerStatusCode());
			System.out.println("Status code is changed ");
			Thread.sleep(2000);
			
			departmentDropdown.click();
			String departmentvalue = handler.getDepartment();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Department']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+departmentvalue+"']"))).click();
			System.out.println("Department value selected");
			Thread.sleep(2000);			
			
			
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			
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
			
			System.out.println("Completed RL Ops DVU Maker Non Individual process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeByHomeSaverOpsUser(CaseDataModel handler)
	{
		try 
		{
			Thread.sleep(10000);			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getHomeSaverOpsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("Home Saver Ops user logged in Successfully");
			Thread.sleep(3000);
			driver.navigate().refresh();
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Home Saver Ops");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("Home Saver Ops is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			// Change status
			
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			this.selectElement(statusCodeDropdown, handler.getHomeSaverOpsStatusCode());
			System.out.println("Status code is changed ");
			Thread.sleep(2000);
			
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			
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
			
			System.out.println("Completed Home Saver Ops process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeByHomeSaverOpsUser1Again(CaseDataModel handler)
	{
		try 
		{
			Thread.sleep(10000);			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getHomeSaverOpsUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("Home Saver Ops user logged in Successfully");
			Thread.sleep(3000);
			driver.navigate().refresh();
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Home Saver Ops");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("Home Saver Ops is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			// Change status
			
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			this.selectElement(statusCodeDropdown, handler.getHomeSaverOpsStatusCode1());
			System.out.println("Status code is changed ");
			Thread.sleep(2000);
			
			
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			
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
			
			System.out.println("Completed Home Saver Ops process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseWithCallBackByBOCUser(CaseDataModel handler)
	{
		try
		{
			
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
			
								
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code is changed");
			
			Thread.sleep(2000);
			callBackDropdown.click();
			Thread.sleep(1000);
			
			callBackYes.click();
			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());
			Thread.sleep(1000);
			/*timeField.clear();
			timeField.sendKeys(handler.getCallBackTime());*/
			Thread.sleep(2000);
			
			saveButton.click();
			Thread.sleep(10000);
			
			
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
	
	public void loginAcceptAndChangeStatusCodeByBBOpsDVUMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbOpsDVUMakerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(8000);
			this.performClickWithAction(loginButton);			
			System.out.println("BB OPS DVU Maker user logged in Successfully");
			Thread.sleep(6000);
			
			
			//BB Ops user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DVU Maker Request");
			Thread.sleep(3000);			
			listViewFirstOption.click();
			Thread.sleep(2000);
			System.out.println("BB Ops DVU Maker Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			System.out.println("Successfully clicked on Accept Button");
			Thread.sleep(10000);
			
			Thread.sleep(3000);
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clicked on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on Edit button");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();			
			this.selectElement(statusCodeDropdown, handler.getBbOpsDVUMakerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
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
			
			
			System.out.println("Completed BB Ops User process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	
	public void createCaseForRuralAccountWithCallBackByBranch(CaseDataModel handler)
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
			Thread.sleep(4000);
			categoryDropdown.click();
			this.selectElement(categoryDropdown, handler.getCategory());
			System.out.println("Category selected");
			Thread.sleep(2000);
			subCategoryDropdown.click();
			this.selectElement(subCategoryDropdown, handler.getSubCategory());			
			System.out.println("Sub category selected");
			Thread.sleep(2000);
			
			sourceBranchField.clear();
			sourceBranchField.sendKeys("Chembur");
			Thread.sleep(1000);
			sourceBranchField.sendKeys(Keys.ARROW_DOWN);
			sourceBranchField.sendKeys(Keys.ENTER);
			
			
			/*
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[text()='Source Branch']/following::input[1]/following::lightning-icon[1]/lightning-primitive-icon[1]")).click();
			Thread.sleep(2000);
			sourceBranchField.sendKeys(Keys.UP);
			sourceBranchField.sendKeys(Keys.ENTER);*/
			
			/*List<WebElement> list = driver.findElements(By.cssSelector("#ui-id-1 li:nth-child(n)")).stream().limit(5).collect(Collectors.toList());
			list.get(0).click();
			System.out.println("selected source");*/
			
			
			barCodeField.sendKeys(handler.getBarCode());
			
			Thread.sleep(2000);
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			
			
			Thread.sleep(2000);
			callBackDropdown.click();
			Thread.sleep(1000);
			
			callBackYes.click();
			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());
			
			
			Thread.sleep(3000);
			this.performClickWithAction(saveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			
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
	
	public void LoginAcceptAndChangeStatusCodeByBBOpsDVUCheckerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbOpsDVUCheckerUser()));
			
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
			System.out.println("BB Ops DVU Checker user logged in Successfully");
			Thread.sleep(5000);
			
			
			
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();
			this.clearTab();
			Thread.sleep(3000);
			this.clearTab();
			Thread.sleep(5000);
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);	
			wait.until(ExpectedConditions.visibilityOf(listViewDropdown));
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DVU Checker Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BB Ops DVU Checker Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		//	caseNumberCheckbox.click();
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(10000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();			
			this.selectElement(statusCodeDropdown, handler.getBbOpsDVUCheckerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(3000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(3000);
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			
			
			System.out.println("Completed BB Ops DVU Checker process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	
	
	
	public void LoginAcceptAndChangeStatusCodeByBBOpsDVUCheckerUserTRY(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(60000);
			/*Thread.sleep(3000);
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
			
			
			globalSearchField.sendKeys(this.trimQuote(handler.getBbOpsDVUCheckerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(userDetailButton)).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			//loginButton.click();
			System.out.println("BB Ops DVU Checker user logged in Successfully");
			Thread.sleep(5000);
			
			*/
			
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			/*listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DVU Checker Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BB Ops DVU Checker Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys("1000050370");
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		//	caseNumberCheckbox.click();
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			*/
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys("1000050370");
			Thread.sleep(10000);
			
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(30000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			System.out.println("Clicked on edit button");
			Thread.sleep(15000);
			
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();			
			this.selectElement(statusCodeDropdown, handler.getBbOpsDVUCheckerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(6000);
			
			driver.navigate().refresh();
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();	
			this.selectElement(statusCodeDropdown, handler.getBbOpsDVUCheckerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			
			
			System.out.println("Completed BB Ops DVU Checker process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	public void loginAcceptAndChangeStatusCodeByBBOpsDEMakerUser(CaseDataModel handler)
	{
		try
		{
			
			Thread.sleep(10000);
			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbOpsDEMakerUser()));
			
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
			System.out.println("BB OPs DE maker user logged in Successfully");
			Thread.sleep(3000);
			
						
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DE Maker Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BB Ops DE Maker Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			this.selectElement(statusCodeDropdown, handler.getDeMakerStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			this.performClickWithAction(saveButton);
			//saveButton.click();
			Thread.sleep(2000);
			
			System.out.println("Completed BB Ops DE Maker process");
			
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
			
		}
	}
	
	public void loginAcceptAndChangeStatusCodeJournalNOByBBOpsDEMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbOpsDEMakerUser()));
			
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
			System.out.println("BB OPs DE maker user logged in Successfully");
			Thread.sleep(3000);
			
						
			// After login 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DE Maker Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BB Ops DE Maker Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(journalNumber));
			journalNumber.sendKeys(handler.getJournalNumber());
			Thread.sleep(2000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBbOpsDEMakerStatusCode());
			System.out.println("Status code is changed ");
			Thread.sleep(2000);
			
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			
			System.out.println("Completed BB Ops DE Maker user process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeByBBOpsDECheckerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(searchGlodalFieldOfUserPage));
			
			searchGlodalFieldOfUserPage.click();
			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbOpsDECheckerUser()));
			
			Thread.sleep(3000);
			globalSearchValueSelection.click();
			Thread.sleep(5000);
			Thread.sleep(9000);
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='User Detail']")).click();
			Thread.sleep(2000);
			this.performClickWithAction(loginButton);
			
			System.out.println("BB Ops DE checker user logged in Successfully");
			Thread.sleep(3000);
			
			//DE checker accept Invite & Edit
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DE Checker Request");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("BB Ops DE Checker Request is selected");
			
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
		
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
			
			
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);

			
			System.out.println("Clickd on Case number");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(statusCodeDropdown));
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBbOpsDECheckerStatuscode());
			System.out.println("Status code is Changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(caseNumber));
			System.out.println("Completed BB Ops DE Checker user process");
			
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAndChangeStatusCodeByBranchUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBranchUser()));
			
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
			System.out.println("Branch user logged in Successfully");
			Thread.sleep(15000);
			
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(5000);	
			
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(10000);
			
			
			WebElement d1 = driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span"));
			d1.click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			this.selectElement(statusCodeDropdown, handler.getBranchStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(8000);
			
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			Thread.sleep(4000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");
			
			Thread.sleep(10000);
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
			
			System.out.println("Completed the branch user process with resolution comment");

		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void loginAcceptAndChangeStatusCodeByWealthProductTeam(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWealthProductTeamUser()));
			
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
			System.out.println("Wealth Product team user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wealth Product team
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Wealth Product Team Request");
			Thread.sleep(5000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Wealth Product Team Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clicked on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			this.performClickWithAction(editButton);
			Thread.sleep(13000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWealthProductTeamStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			
			Thread.sleep(2000);
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed Wealth Product Team User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeForClarificationRequiredBOCByBOCUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBocUser()));
			
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
			System.out.println("BOC user logged in Successfully");
			Thread.sleep(3000);
			
			//BOC user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Clarification Required - BOC");
			Thread.sleep(3000);			
			listViewFirstOption.click();
			Thread.sleep(2000);
			System.out.println("Clarification Required - BOC is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(5000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(9000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(4000);
			this.performClickWithAction(topCaseNumberLink);
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(10000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBocStatusCode());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			
			this.performClickWithAction(topSaveButton);
			
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed BOC User clarification  process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	
	public void loginAcceptAndChangeStatusCodeForClarificationProvidedProductTeamWithResolutionCommentsByWealthProductTeamUser1Again(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(5000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getWealthProductTeamUser()));
			
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
			System.out.println("Wealth Product team user logged in Successfully");
			Thread.sleep(3000);
			
			//Accept By Wealth Product team
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(3000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("Clarification Provided - Product Team");
			Thread.sleep(5000);
			listViewFirstOption.click();
			
			Thread.sleep(2000);
			
			System.out.println("Clarification Provided - Product Team is selected");
			
			Thread.sleep(10000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
			//CHange status code process
			listViewDropdown.click();
			Thread.sleep(3000);
			listViewSearchField.sendKeys("My Open Cases");
			Thread.sleep(3000);
			listViewFirstOption.click();
			System.out.println("My open cases is selected");
			Thread.sleep(3000);			
			caseSearchField.sendKeys(this.caseCount);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[1]/span")).click();
			Thread.sleep(2000);
			this.performClickWithAction(topCaseNumberLink);
			
			System.out.println("Clickd on Case number");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(editButton));
			editButton.click();
			Thread.sleep(6000);
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getWealthProductTeamStatusCode1());
			System.out.println("Status code is changed");
			Thread.sleep(2000);
			resolutionCommentField.sendKeys(handler.getResolutionComment());
			System.out.println("Resolution comment entered");
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
			this.performClickWithAction(saveButton);
			
			Thread.sleep(10000);
			
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
			
			
			System.out.println("Completed Wealth Product Team User process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCaseWithCallBackEmobossedNameChangeForRuralAccountByBOCUser(CaseDataModel handler)
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
			
			validatePANCheckbox.click();
			validatePassportNoCheckbox.click();
			validateDrivingLicenseNoCheckbox.click();
			validateVoterIdCheckbox.click();
			validateDobCheckbox.click();
			mothersMaidenNameCheckbox.click();
			verifyTransactionCheckbox.click();
			System.out.println("Sucessfully selected all checkbox");
			
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			
			Thread.sleep(2000);
			callBackDropdown.click();
			Thread.sleep(1000);			
			callBackYes.click();			
			//select date & Time
			dateField.sendKeys(handler.getCallBackDate());			
			Thread.sleep(2000);
			
			
			this.performClickWithAction(saveButton);
			
			
			Thread.sleep(10000);
			
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
	
	
	
	
	public void createCaseBBPSTransactionDisputeByBOC(CaseDataModel handler)
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
			
			disputeStageField.click();
			String disputestagevalue = handler.getDisputeStage();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Dispute Stage']/following::div[2]/div[2]/lightning-base-combobox-item/span[2]/span[text()='"+disputestagevalue+"']"))).click();
			System.out.println("Dispute Stage value selected");
			Thread.sleep(2000);			
						
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getStatusCode());
			System.out.println("Status Code Sent To Ops");
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			transactionDateField.sendKeys("08/04/2020");
			transactionRefernceNoField.sendKeys(handler.getTransactionReferenceNo());
			disputeAmtField.sendKeys(handler.getDisputeAmt());
			
			this.performClickWithAction(topSaveButton);
			
			
			Thread.sleep(15000);
			
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
	
	
	public void loginAcceptAndChangeStatusCodeWithRejectionReasonByBBOpsDVUMakerUser(CaseDataModel handler)
	{
		try
		{
			Thread.sleep(10000);
			searchGlodalFieldOfUserPage.click();			
			searchGlodalFieldOfUserPage.sendKeys(this.trimQuote(handler.getBbOpsDVUMakerUser()));
			
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
			System.out.println("DVU maker user logged in Successfully");
			Thread.sleep(3000);
			
			//DVU maker user logged in 
			
			Thread.sleep(10000);
			this.clearTab();			
			Thread.sleep(5000);	
			navigationMenuDropdown.click();
			Thread.sleep(3000);
			caseDropdown.click();
			Thread.sleep(6000);			
			//Accept case process
			listViewDropdown.click();
			Thread.sleep(5000);
			listViewSearchField.sendKeys("BB Ops DVU Maker Request");
						
			Thread.sleep(3000);
			listViewFirstOption.click();
						
			Thread.sleep(3000);			
			System.out.println("BB Ops DVU Maker Request is selected");
			
			Thread.sleep(6000);				
			caseSearchField.sendKeys(this.caseCount);
			caseSearchField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			this.performClickWithAction(caseNumberCheckbox);
			acceptButton.click();
			Thread.sleep(10000);
			System.out.println("Successfully clicked on Accept Button");
						
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
			Thread.sleep(10000);
						
			statusCodeDropdown.click();
			this.selectElement(statusCodeDropdown, handler.getBbOpsDVUMakerStatusCode());
			System.out.println("Status code is changed to Sent to DVU Checker - Rejected");
			Thread.sleep(8000);
			reasonForRejectionTopVallue.click();
			Thread.sleep(3000);
			moveSelectionToChosenArrowButton.click();
			Thread.sleep(3000);
					
			//scrolling page on top
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			Thread.sleep(5000);
					
			
			this.performClickWithAction(topSaveButton);
			System.out.println("Clicked on save button");	
			
			Thread.sleep(8000);
			
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
			
			
			System.out.println("Completed DVU Maker User rejected process");
		}
		catch(Exception e)
		{
			ExtentConfigurer.getTest().log(Status.ERROR, "Selenium Error Occurred : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void createCasesWithAccount(CaseDataModel handler)
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
	
	
	public void loginAcceptAndChangeStatusByCibilQueue(CaseDataModel handler)
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
	
	
	
	public void loginAcceptAndChangeStatusByCollectionQueue(CaseDataModel handler)
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
	
	
	public void loginAcceptAndChangeStatusByOpsPDEGroup(CaseDataModel handler)
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
	
	
	
	public void loginAcceptAndChangeStatusByOpsDocManagement(CaseDataModel handler)
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
	
	
	
	public void loginAcceptAndChangeStatusByOpsPropertyPapersManagemnt(CaseDataModel handler)
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
	
	
	public void loginAcceptAndChangeStatusByOpsVehiclePDDMgmt(CaseDataModel handler)
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
	
	
	public void loginAcceptAndChangeStatusByOpsPDCEntrySwap(CaseDataModel handler)
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
