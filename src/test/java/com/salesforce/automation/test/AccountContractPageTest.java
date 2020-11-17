package com.salesforce.automation.test;

import static com.salesforce.automation.constants.SalesForceConstants.ACCOUNT_CONTRACT_RESULT_PAGE;
import static com.salesforce.automation.constants.SalesForceConstants.PASSWORD;
import static com.salesforce.automation.constants.SalesForceConstants.USERNAME;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.salesforce.automation.config.ExtentConfigurer;
import com.salesforce.automation.config.ExtentReportListener;
import com.salesforce.automation.config.WebDriverConfig;
import com.salesforce.automation.datamodel.AccountContractDataModel;
import com.salesforce.automation.helper.AccountContractDataHelper;
import com.salesforce.automation.pageModel.LoginPage;

@Listeners(ExtentReportListener.class)
public class AccountContractPageTest extends ExtentReportListener implements ITest{

	private static ThreadLocal<String> testName = new ThreadLocal<>();

	private WebDriver driver;

	private Object objClass;

	private Class<?> keyWordClass;

	static {
		testName.set("unknown");
	}

	@DataProvider(name = "AccountContractDataSet")
	public static Iterator<Object[]> getDataSet() throws Exception {
		List<AccountContractDataModel> dataSet = AccountContractDataHelper.retrievedataset();
		Collection<Object[]> data = new ArrayList<Object[]>();
		dataSet.forEach(item -> data.add(new Object[] { item }));
		return data.iterator();
	}

	@Test(dataProvider = "AccountContractDataSet")
	public void test_AccountSearchPage(AccountContractDataModel handlerData) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				By.xpath(".//*[starts-with(@id, 'brandBand_')]/div/div/force-aloha-page/div/iframe")));
		List<String> validationOperation = Arrays.asList(handlerData.getOperations().split(","));
		try {
			Thread.sleep(2000);
			for (String singleOperation : validationOperation) {
				Method m = keyWordClass.getDeclaredMethod(singleOperation, AccountContractDataModel.class);
				m.invoke(objClass, handlerData);
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("Test Failed due to : " + e.getLocalizedMessage());
			ExtentConfigurer.getTest().log(Status.ERROR, "Error : " + e.getLocalizedMessage());
		}
		driver.navigate().refresh();
	}

	@BeforeMethod
	public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
		AccountContractDataModel handlerObj = (AccountContractDataModel) testData[0];
		if (testData.length > 0) {
			testName.set(method.getName() + "_" + handlerObj.getScenarioName());
			ctx.setAttribute("testName", testName.get());
		} else
			ctx.setAttribute("testName", method.getName());
	}
	
	@BeforeClass
	public void before() {
		ExtentConfigurer.getInstance(ACCOUNT_CONTRACT_RESULT_PAGE);
		driver = new ChromeDriver(WebDriverConfig.getDriverConfigOptions());
		driver.manage().window().maximize();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(USERNAME, PASSWORD);
		try {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			keyWordClass = Class.forName("com.salesforce.automation.pageModel.AccountContractSearchPage");
			objClass = keyWordClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (Exception e) {
			Assert.fail("Test Failed due to : " + e.getLocalizedMessage());
		}
	}
	
	@AfterClass
	public void afterAll() {
		driver.close();
	}
	
	@Override
	public String getTestName() {
		return testName.get();
	}
}
