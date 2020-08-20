package com.salesforce.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.salesforce.automation.constants.SalesForceConstants;


public class XlsOperationsUtility
{

	XSSFWorkbook wb;
	XSSFSheet Sheet1;

	public XlsOperationsUtility(String fileName) throws Exception {
		try {
			File src = new File(System.getProperty("user.dir") + SalesForceConstants.RESOURCE_PATH + fileName);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			throw new Exception("Unable to locate the file " + e.getMessage());
		}
	}
	
	public XSSFSheet getdataSheet(int sheetnumber) {
		Sheet1 = wb.getSheetAt(sheetnumber);
		return Sheet1;

	}
	
	public int getRowCount(XSSFSheet Sheet) {

		return Sheet.getLastRowNum() - Sheet.getFirstRowNum();

	}
	
	
	
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");
		} 
		
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshots" + e.getMessage());
			
		} 
		
		
	}
	
}
