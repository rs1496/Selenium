package com.salesforce.automation.helper;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.salesforce.automation.constants.SalesForceConstants;
import com.salesforce.automation.datamodel.OptimusCaseDataModel;
import com.salesforce.automation.utility.XlsOperationsUtility;



public class OptimusCaseDataHelper 
{	
	public static ArrayList<OptimusCaseDataModel> retrievedataset() throws Exception {
		
		ArrayList<OptimusCaseDataModel> datalist = new ArrayList<OptimusCaseDataModel>();
		XlsOperationsUtility xlsUtility = new XlsOperationsUtility(SalesForceConstants.Optimus_CASE_DATA_SHEET);
		XSSFSheet dataSheet = xlsUtility.getdataSheet(0);
		Iterator<Row> row = dataSheet.iterator();
		row.next();
		while (row.hasNext()) {
			Row row1 = row.next();
			if (row1.getCell(1).toString().equalsIgnoreCase("Y")) {
				
				OptimusCaseDataModel handlerObj = new OptimusCaseDataModel();
				handlerObj.setScenarioName(row1.getCell(0).toString());
				handlerObj.setScenarioRunningStatus(row1.getCell(1).toString());
				handlerObj.setOperations(row1.getCell(2).toString());
				handlerObj.setGlobalSearch(row1.getCell(3).toString());
				handlerObj.setAccountName(row1.getCell(4).toString());
				handlerObj.setStatusCode(row1.getCell(5).toString());
				handlerObj.setCaseType(row1.getCell(6).toString());
				handlerObj.setCategory(row1.getCell(7).toString());
				handlerObj.setSubCategory(row1.getCell(8).toString());
				handlerObj.setNewEmailId(row1.getCell(9).toString());
				handlerObj.setMobileNumber(row1.getCell(10).toString());
				handlerObj.setIsdCode(row1.getCell(11).toString());
				handlerObj.setNoOfChequeLeaves(row1.getCell(12).toString());
				handlerObj.setToChequeno(row1.getCell(13).toString());
				handlerObj.setStopReason(row1.getCell(14).toString());
				handlerObj.setFromChequeno(row1.getCell(15).toString());
				handlerObj.setPanNo(row1.getCell(16).toString());
				handlerObj.setReasonForReissue(row1.getCell(17).toString());
				handlerObj.setSwitchOn(row1.getCell(18).toString());
				handlerObj.setAuthenticationMode(row1.getCell(19).toString());
				handlerObj.setBarcode(row1.getCell(20).toString());
				handlerObj.setErrorMessage(row1.getCell(21).toString());
				handlerObj.setFreezeUnfreezeType(row1.getCell(22).toString());
				handlerObj.setFreezeUnfreezeSource(row1.getCell(23).toString());
				handlerObj.setReason(row1.getCell(24).toString());
				
				
				datalist.add(handlerObj);
				
			}
		
	}
		
		return datalist;

}
	
}

