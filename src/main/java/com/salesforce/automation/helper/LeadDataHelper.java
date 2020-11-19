package com.salesforce.automation.helper;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.salesforce.automation.constants.SalesForceConstants;
import com.salesforce.automation.datamodel.LeadDataModel;
import com.salesforce.automation.utility.XlsOperationsUtility;

public class LeadDataHelper
{
	public static ArrayList<LeadDataModel> retrievedataset() throws Exception {
		ArrayList<LeadDataModel> datalist = new ArrayList<LeadDataModel>();
		XlsOperationsUtility xlsUtility = new XlsOperationsUtility(SalesForceConstants.LEAD_DATA_SHEET);
		XSSFSheet dataSheet = xlsUtility.getdataSheet(0);
		Iterator<Row> row = dataSheet.iterator();
		row.next();
		while (row.hasNext()) {
			Row row1 = row.next();
			if (row1.getCell(1).toString().equalsIgnoreCase("Y")) {
				
				LeadDataModel handlerObj = new LeadDataModel();
				handlerObj.setScenarioName(row1.getCell(0).toString());
				handlerObj.setScenarioRunningStatus(row1.getCell(1).toString());
				handlerObj.setOperations(row1.getCell(2).toString());
				handlerObj.setBranchUser(row1.getCell(3).toString());
				handlerObj.setRecordType(row1.getCell(4).toString());
				handlerObj.setProduct(row1.getCell(5).toString());
				handlerObj.setLastname(row1.getCell(6).toString());
				handlerObj.setLeadSource(row1.getCell(7).toString());
				handlerObj.setChannelPartner(row1.getCell(8).toString());
				
				datalist.add(handlerObj);
			}
			
		}
		
		return datalist;

	}
}
