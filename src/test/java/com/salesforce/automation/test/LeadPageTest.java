package com.salesforce.automation.test;

import static com.salesforce.automation.constants.SalesForceConstants.PASSWORD;
import static com.salesforce.automation.constants.SalesForceConstants.LEAD_PAGE;
import static com.salesforce.automation.constants.SalesForceConstants.USERNAME;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.salesforce.automation.config.ExtentConfigurer;
import com.salesforce.automation.config.ExtentReportListener;
import com.salesforce.automation.config.WebDriverConfig;
import com.salesforce.automation.datamodel.LeadDataModel;
import com.salesforce.automation.helper.LeadDataHelper;
import com.salesforce.automation.pageModel.LoginPage;
import com.salesforce.automation.utility.XlsOperationsUtility;


@Listeners(ExtentReportListener.class)
public class LeadPageTest extends ExtentReportListener implements ITest
{
	
	private static ThreadLocal<String> testName = new ThreadLocal<>();
	
	private WebDriver driver;
	
	private Object objClass;
	
	private Class<?> keyWordClass;

	static {
		testName.set("unknown");
	}
	
	
	@DataProvider(name = "LeadPage")
	public static Iterator<Object[]> getDataSet() throws Exception {
		List<LeadDataModel> dataSet = LeadDataHelper.retrievedataset();
		Collection<Object[]> data = new ArrayList<Object[]>();
		dataSet.forEach(item -> data.add(new Object[] { item }));
		return data.iterator();
		
	}
	
	@Test(dataProvider = "LeadPage")
	public void test_LeadPage(LeadDataModel handlerData) throws Exception {
		
		List<String> validationOperation = Arrays.asList(handlerData.getOperations().split(","));
		try {
			for (String singleOperation : validationOperation) {
				Method m = keyWordClass.getDeclaredMethod(singleOperation, LeadDataModel.class);
				m.invoke(objClass, handlerData);
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			ExtentConfigurer.getTest().log(Status.ERROR, "Error Occurred : " + e.getCause());
			keyWordClass.getDeclaredMethod("clearTab").invoke(objClass);
			driver.navigate().refresh();
			Assert.fail("Test Failed due to : " + e.getLocalizedMessage());
		}
		driver.navigate().refresh();
	}
	
	@BeforeMethod
	public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
		LeadDataModel handlerObj = (LeadDataModel) testData[0];
		if (testData.length > 0) {
			testName.set(handlerObj.getScenarioName());
			ctx.setAttribute("testName", testName.get());
		} else
			ctx.setAttribute("testName", method.getName());
	}
	
	
	
	@BeforeClass
	public void before() {
		ExtentConfigurer.getInstance(LEAD_PAGE);
		driver = new ChromeDriver(WebDriverConfig.getDriverConfigOptions());
		driver.manage().window().maximize();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(USERNAME, PASSWORD);
		try {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			keyWordClass = Class.forName("com.salesforce.automation.pageModel.LeadPage");
			objClass = keyWordClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
			
		} catch (Exception e) {
			driver.navigate().refresh();
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

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			//XlsOperationsUtility.captureScreenshot(driver, result.getName()+LocalDateTime.now());
			XlsOperationsUtility.captureScreenshot(driver, result.getName());
		}
	}

}
