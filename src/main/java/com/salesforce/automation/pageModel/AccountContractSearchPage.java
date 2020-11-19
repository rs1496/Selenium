package com.salesforce.automation.pageModel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.salesforce.automation.config.ExtentConfigurer;
import com.salesforce.automation.datamodel.AccountContractDataModel;

public class AccountContractSearchPage {

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[3]/th[1]/input ")
	private WebElement customerNumberCheckBox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:SecItemCustNo:SecItemCustNoIP']")
	private WebElement customerNumberValue;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:accCtrlpgBlock:j_') and contains(@id, ':searchBtn')]")
	private WebElement searchButton;
	
	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/span")
	private WebElement searchError;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:j_')]/div[2]/table/tbody/tr[1]/th/input")
	private WebElement supplyLocationIDCheckbox;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:j_')]/div[2]/table/tbody/tr[2]/td/input")
	private WebElement supplyLocationValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:secItmCTINo:CTINoIP']")
	private WebElement phoneCTICheckBox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:secItmCTINoIPbx:CTINoIPbx']")
	private WebElement phoneCTIValue;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:j_') and contains(@id, ':isBillNoIP')]")
	private WebElement billNumberCACheckbox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[4]/td[2]/input")
	private WebElement billNumberCAValue;

	@FindBy(xpath = ".//*[starts-with(@id, 'brandBand_')]/div/div/force-aloha-page/div/iframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:searchResultBlock:j_id')]/b")
	private WebElement searchResult;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:j_') and contains(@id, ':isContractOwnerIP')]")
	private WebElement contractOwnerCheckBox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[4]/td[3]/input")
	private WebElement contactOwnerValue;

	@FindBy(xpath = "//*[@id='page:frm:searchResultBlock:NoRecordFound']/b")
	private WebElement noRecordsElement;

	@FindBy(xpath = "//*[@id='page:frm:searchResultBlock:NoRecordFound1']/b")
	private WebElement searchExceeded;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:j_')]/div[2]/table/tbody/tr[5]/th/input")
	private WebElement payerNameCheckbox;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:j_')]/div[2]/table/tbody/tr[6]/td/input")
	private WebElement payerNameValue;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:j_')]/div[2]/table/tbody/tr[3]/th/input")
	private WebElement summaryBillRepCheckbox;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:j_')]/div[2]/table/tbody/tr[4]/td/input")
	private WebElement summaryBillRepValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[5]/th/input")
	private WebElement mainAddress;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:j_id39:test']")
	private WebElement zipCodeCheckBox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:addZipPBI:RequestorTextBox']")
	private WebElement zipCodeValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:j_id41:test']")
	private WebElement addressCheckbox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:addPBI:kanjiAddress']")
	private WebElement addressValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:j_id43:test']")
	private WebElement issueCheckbox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:noPBI:contNum']")
	private WebElement issueValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[8]/th[1]/input")
	private WebElement buildingNameCheckbox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:bldKanaPBI:buildKana']")
	private WebElement buildingNameValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[8]/th[2]/input")
	private WebElement buildingNumCheckbox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:bldRidgePBI:ridgeNum']")
	private WebElement buildingNumValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[8]/th[3]/input")
	private WebElement roomNumCheckbox;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc:bldNumPBI:buildNum']")
	private WebElement roomNumberValue;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[12]/td[1]/table/tbody/tr/td[1]/input")
	private WebElement requestorKana;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[12]/td[2]/input")
	private WebElement contactNumber;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[14]/td[1]/select")
	private WebElement payment;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[14]/td[2]/input")
	private WebElement financeInst;

	@FindBy(xpath = "//*[@id='page:frm:pgBlockHrItmAcc:pgBlockSecHrItmAcc']/div[2]/table/tbody/tr[14]/td[3]/input")
	private WebElement accNum;

	@FindBy(xpath = "//*[@id='page:frm:accCtrlpgBlock']/div[2]/div[2]/input")
	private WebElement checkAllCheckBox;

	@FindBy(xpath = "//*[starts-with(@id, 'page:frm:accCtrlpgBlock:j_')]/input[1]")
	private WebElement clearBtn;

	private WebDriver driver;

	private WebDriverWait wait;

	public AccountContractSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@id='oneHeader']/div[3]/div/div[1]/div[3]/div/button/lightning-primitive-icon"))).click();
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[contains(text(), '顧客契約検索')]"))).click();
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Unable to load the page");
		}
		
	}

	public void setCustomerNumber(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(customerNumberCheckBox));
			customerNumberCheckBox.click();
			wait.until(ExpectedConditions.visibilityOf(customerNumberValue));
			customerNumberValue.sendKeys(this.removeDecimal(handler.getCustomer_number_BP()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Customer Number BP is set to : " + this.removeDecimal(handler.getCustomer_number_BP()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}

	}

	public void setPayerName(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(payerNameCheckbox));
			payerNameCheckbox.click();
			payerNameValue.sendKeys(handler.getPayersName());
			ExtentConfigurer.getTest().log(Status.INFO, "Payer Name is set to : " + handler.getPayersName());
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setSummaryRep(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(summaryBillRepCheckbox));
			summaryBillRepCheckbox.click();
			summaryBillRepValue.sendKeys(this.removeDecimal(handler.getSummaryBillRep()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Summary Bill Rep Num is set to : " + this.removeDecimal(handler.getSummaryBillRep()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}
	
	public void search(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchButton));
			searchButton.click();
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOf(searchError));
			ExtentConfigurer.getTest().log(Status.INFO, "Message on alert :" + searchError.getText());
			Assert.assertNotNull(searchError.getText());
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}
	
	public void searchForNoResult(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchButton));
			searchButton.click();
			wait.until(ExpectedConditions.visibilityOf(noRecordsElement));
			ExtentConfigurer.getTest().log(Status.INFO, "Message on alert :" + noRecordsElement.getText());
			Assert.assertNotNull(noRecordsElement.getText());
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}
	
	public void searchForExceededResult(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchButton));
			searchButton.click();
			wait.until(ExpectedConditions.visibilityOf(searchExceeded));
			ExtentConfigurer.getTest().log(Status.INFO, "Message on alert :" + searchExceeded.getText());
			Assert.assertNotNull(searchExceeded.getText());
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setSupplyLocation(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(supplyLocationIDCheckbox));
			supplyLocationIDCheckbox.click();
			wait.until(ExpectedConditions.visibilityOf(supplyLocationValue));
			Thread.sleep(1000);
			supplyLocationValue.sendKeys(this.removeDecimal(handler.getSupply_location_ID()));
			Thread.sleep(1000);
			ExtentConfigurer.getTest().log(Status.INFO,
					"Supply Location ID is set to : " + this.removeDecimal(handler.getSupply_location_ID()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setPhoneCTINumber(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(phoneCTICheckBox));
			phoneCTICheckBox.click();
			wait.until(ExpectedConditions.visibilityOf(phoneCTIValue));
			phoneCTIValue.sendKeys(this.removeDecimal(handler.getPhoneCTINumber()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Phone\\CTI Number is set to : " + this.removeDecimal(handler.getPhoneCTINumber()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setContractOwner(AccountContractDataModel handler) {
		try {
			if (!StringUtils.containsIgnoreCase(handler.getScenarioName(), "# 17")) {
				wait.until(ExpectedConditions.visibilityOf(contractOwnerCheckBox));
				contractOwnerCheckBox.click();
			}
			wait.until(ExpectedConditions.visibilityOf(contactOwnerValue));
			contactOwnerValue.sendKeys(handler.getContract_owner());
			Thread.sleep(1000);
			ExtentConfigurer.getTest().log(Status.INFO,
					"Contract Owner (Kana-Kanji) is set to : " + handler.getContract_owner());
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setBillNumberCA(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(billNumberCACheckbox));
			billNumberCACheckbox.click();
			billNumberCAValue.sendKeys(this.removeDecimal(handler.getBill_number_CA()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Bill Number CA is set to : " + this.removeDecimal(handler.getBill_number_CA()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void searchForResult(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchButton));
			searchButton.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOf(searchResult));
			js.executeScript("arguments[0].scrollIntoView();", searchResult);
			ExtentConfigurer.getTest().log(Status.INFO, "Contract Details : " + searchResult.getText());
			this.captureScreenShot(handler);
		} catch (Exception e) {
			this.handleNoSearchRecords(handler, e);
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}

	}

	public void setZipCode(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(zipCodeCheckBox));
			zipCodeCheckBox.click();
			String zipValue = handler.getZipCode();
			String zipCode = zipValue.substring(0, zipValue.indexOf("/"));
			zipCodeValue.sendKeys(zipCode);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//*[contains(text(), '"+ zipValue.substring(zipValue.indexOf("/") + 1, zipValue.length() - 1) +"')]")))
					.click();
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setAddress(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(addressCheckbox));
			addressCheckbox.click();
			addressValue.sendKeys(this.removeDecimal(handler.getAddress()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Address is set to : " + this.removeDecimal(handler.getAddress()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setIssueNum(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(issueCheckbox));
			issueCheckbox.click();
			issueValue.sendKeys(this.removeDecimal(handler.getIssueNum()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Issue Num is set to : " + this.removeDecimal(handler.getIssueNum()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setBuildingName(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(buildingNameCheckbox));
			buildingNameCheckbox.click();
			buildingNameValue.sendKeys(handler.getBuildingName());
			ExtentConfigurer.getTest().log(Status.INFO, "building Name is set to : " + handler.getBuildingName());
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setBuildingNum(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(buildingNumCheckbox));
			buildingNumCheckbox.click();
			buildingNumValue.sendKeys(this.removeDecimal(handler.getBuildingNumber()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"building Num is set to : " + this.removeDecimal(handler.getBuildingNumber()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setRoomNum(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(roomNumCheckbox));
			roomNumCheckbox.click();
			roomNumberValue.sendKeys(this.removeDecimal(handler.getRoomNumber()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Room Num is set to : " + this.removeDecimal(handler.getRoomNumber()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setRequestorKana(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(requestorKana));
			requestorKana.sendKeys(handler.getRequestorKana());
			ExtentConfigurer.getTest().log(Status.INFO, "Requestor Kana is set to : " + handler.getRequestorKana());
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setContactNum(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(contactNumber));
			contactNumber.sendKeys(this.removeDecimal(handler.getContactNumber()));
			ExtentConfigurer.getTest().log(Status.INFO,
					"Contact Number is set to : " + this.removeDecimal(handler.getContactNumber()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setPaymentMethod(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(payment));
			Select paymentOptions = new Select(payment);
			paymentOptions.selectByVisibleText(handler.getPaymentMethod());
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setfinanceInst(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(financeInst));
			financeInst.sendKeys(handler.getFinanceInst());
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void setAccNum(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(accNum));
			accNum.sendKeys(this.removeDecimal(handler.getAccNumber()));
			Thread.sleep(2000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void checkForDisabledFields(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(addressValue));
			Assert.assertFalse(addressValue.isEnabled());
			Assert.assertFalse(issueValue.isEnabled());
			Assert.assertFalse(buildingNameValue.isEnabled());
			Assert.assertFalse(buildingNumValue.isEnabled());
			Assert.assertFalse(roomNumberValue.isEnabled());
			ExtentConfigurer.getTest().log(Status.INFO, "Required fields are disabled on page launch");
			Thread.sleep(2000);
		} catch (AssertionError ex) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + ex.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed ");
		} catch (Exception e) {
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}
	}

	public void checkAllCheckbox(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(checkAllCheckBox));
			checkAllCheckBox.click();
			Assert.assertTrue(customerNumberCheckBox.isSelected());
			Assert.assertTrue(phoneCTICheckBox.isSelected());
			Assert.assertTrue(billNumberCACheckbox.isSelected());
			Assert.assertTrue(contractOwnerCheckBox.isSelected());
			Assert.assertTrue(zipCodeCheckBox.isSelected());
			Assert.assertTrue(addressCheckbox.isSelected());
			Assert.assertTrue(issueCheckbox.isSelected());
			Assert.assertTrue(buildingNameCheckbox.isSelected());
			Assert.assertTrue(buildingNumCheckbox.isSelected());
			Assert.assertTrue(roomNumCheckbox.isSelected());
			Assert.assertTrue(supplyLocationIDCheckbox.isSelected());
			Assert.assertTrue(payerNameCheckbox.isSelected());
			Assert.assertTrue(summaryBillRepCheckbox.isSelected());
			ExtentConfigurer.getTest().log(Status.INFO,
					"Validated : On selecting 'Check all ON/OFF' field all check box are selected");
			checkAllCheckBox.click();
			this.validateEmptyCheckboxFields(handler);
			ExtentConfigurer.getTest().log(Status.INFO,
					"Validated : On deselecting 'Check all ON/OFF' field all check box are deselected");
		} catch (AssertionError ex) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + ex.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed ");
		} catch (Exception e) {
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}

	}

	public void checkAllCheckboxForAddress(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(mainAddress));
			mainAddress.click();
			Assert.assertTrue(zipCodeCheckBox.isSelected());
			Assert.assertTrue(addressCheckbox.isSelected());
			Assert.assertTrue(issueCheckbox.isSelected());
			Assert.assertTrue(buildingNameCheckbox.isSelected());
			Assert.assertTrue(buildingNumCheckbox.isSelected());
			ExtentConfigurer.getTest().log(Status.INFO,
					"Validated : On selecting 'Address' field all address check boxes are selected");
			mainAddress.click();
			Assert.assertFalse(zipCodeCheckBox.isSelected());
			Assert.assertFalse(addressCheckbox.isSelected());
			Assert.assertFalse(issueCheckbox.isSelected());
			Assert.assertFalse(buildingNameCheckbox.isSelected());
			Assert.assertFalse(buildingNumCheckbox.isSelected());
			ExtentConfigurer.getTest().log(Status.INFO,
					"Validated : On deselecting 'Address' field all address check boxes are deselected");
		} catch (AssertionError ex) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + ex.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed ");
		} catch (Exception e) {
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}

	}

	public void completeData(AccountContractDataModel handler) {
		this.setCustomerNumber(handler);
		this.setBillNumberCA(handler);
		this.setPhoneCTINumber(handler);
		this.setContractOwner(handler);
		this.setZipCode(handler); this.setAddress(handler);
		this.setIssueNum(handler); this.setBuildingName(handler);
		this.setBuildingNum(handler); this.setRoomNum(handler);
		this.setRequestorKana(handler);
		this.setContactNum(handler);
		this.setPaymentMethod(handler);
		this.setfinanceInst(handler);
		this.setAccNum(handler);
		this.setPayerName(handler);
		this.setSummaryRep(handler);
	}

	public void clear(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(clearBtn));
			clearBtn.click();
		} catch (Exception e) {
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}

	}

	public void validateEmptyCheckboxFields(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(checkAllCheckBox));
			Assert.assertFalse(checkAllCheckBox.isSelected());
			Assert.assertFalse(phoneCTICheckBox.isSelected());
			Assert.assertFalse(customerNumberCheckBox.isSelected());
			Assert.assertFalse(billNumberCACheckbox.isSelected());
			Assert.assertFalse(mainAddress.isSelected());
			Assert.assertFalse(zipCodeCheckBox.isSelected());
			Assert.assertFalse(contractOwnerCheckBox.isSelected());
			Assert.assertFalse(addressCheckbox.isSelected());
			Assert.assertFalse(issueCheckbox.isSelected());
			Assert.assertFalse(buildingNameCheckbox.isSelected());
			Assert.assertFalse(buildingNumCheckbox.isSelected());
			Assert.assertFalse(roomNumCheckbox.isSelected());
			Assert.assertFalse(payerNameCheckbox.isSelected());
			Assert.assertFalse(supplyLocationIDCheckbox.isSelected());
			Assert.assertFalse(summaryBillRepCheckbox.isSelected());
			ExtentConfigurer.getTest().log(Status.INFO, "All checkboxes are de-selected");
		} catch (AssertionError ex) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + ex.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail("Test Failed ");
		} catch (Exception e) {
			driver.navigate().refresh();
			Assert.fail("Test Failed :" + e.getLocalizedMessage());
		}

	}

	public void validateEmptyTextField(AccountContractDataModel handler) {
		try {
			wait.until(ExpectedConditions.visibilityOf(phoneCTIValue));
			Assert.assertEquals("", phoneCTIValue.getText());
			Assert.assertEquals("", customerNumberValue.getText());
			Assert.assertEquals("", billNumberCAValue.getText());
			Assert.assertEquals("", contactOwnerValue.getText());
			Assert.assertEquals("", zipCodeValue.getText());
			Assert.assertEquals("", addressValue.getText());
			Assert.assertEquals("", issueValue.getText());
			Assert.assertEquals("", buildingNameValue.getText());
			Assert.assertEquals("", buildingNumValue.getText());
			Assert.assertEquals("", roomNumberValue.getText());
			Assert.assertEquals("", requestorKana.getText());
			Assert.assertEquals("", contactNumber.getText());
			Assert.assertEquals("", supplyLocationValue.getText());
			Assert.assertEquals("", summaryBillRepValue.getText());
			Assert.assertEquals("", financeInst.getText());
			Assert.assertEquals("", accNum.getText());
			ExtentConfigurer.getTest().log(Status.INFO, "All text boxes are empty");
		} catch (AssertionError e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Assertion failed : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail();
		}

	}

	public void checkWhenZipIsCleared(AccountContractDataModel handler) {
		try{
			this.setZipCode(handler);
			zipCodeValue.clear();
			this.checkForDisabledFields(handler);
		}catch (Exception e){
			ExtentConfigurer.getTest().log(Status.ERROR, "Assertion failed : " + e.getLocalizedMessage());
			driver.navigate().refresh();
			Assert.fail();
		}
		
	}

	private void handleNoSearchRecords(AccountContractDataModel handler, Exception e) {
		try {
			if (this.isElementPresent("//*[@id='page:frm:searchResultBlock:NoRecordFound']/b")) {
				ExtentConfigurer.getTest().log(Status.ERROR,
						"Expected Result but found : " + noRecordsElement.getText());
			} else if (this.isElementPresent("//*[@id='page:frm:searchResultBlock:NoRecordFound1']/b")) {
				ExtentConfigurer.getTest().log(Status.ERROR, "Expected Result but found : " + searchExceeded.getText());
			} else {
				ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
			}
		} catch (Exception ex) {
			driver.navigate().refresh();
		}
	}

	public void captureScreenShot(AccountContractDataModel handler) {

		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String reportsPath = System.getProperty("user.dir") + "\\ScreenShots\\"
					+ handler.getScenarioName().replaceAll("\\s", "").replaceAll("#", "_") + ".png";
			File targetFile = new File(reportsPath);
			FileHandler.copy(screenshotFile, targetFile);
			ExtentConfigurer.getTest().addScreenCaptureFromPath(reportsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isElementPresent(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private String removeDecimal(String s) {
		int index = s.length() - 1;
		if (s.contains(".")) {
			index = s.indexOf(".");
		} else if (s.contains("'")) {
			index = s.indexOf("'");
		}
		return s.substring(0, index);
	}
}
