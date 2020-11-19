package com.salesforce.automation.helper;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.salesforce.automation.constants.SalesForceConstants;
import com.salesforce.automation.datamodel.AccountContractDataModel;
import com.salesforce.automation.utility.XlsOperationsUtility;

public class AccountContractDataHelper {

	public static ArrayList<AccountContractDataModel> retrievedataset() throws Exception {

		ArrayList<AccountContractDataModel> datalist = new ArrayList<AccountContractDataModel>();
		XlsOperationsUtility xlsUtility = new XlsOperationsUtility(SalesForceConstants.ACCOUNT_CONTRACT_DATA_SHEET);
		XSSFSheet dataSheet = xlsUtility.getdataSheet(0);
		Iterator<Row> row = dataSheet.iterator();
		row.next();
		while (row.hasNext()) {
			Row row1 = row.next();
			if (row1.getCell(1).toString().equalsIgnoreCase("Y")) {
				AccountContractDataModel handlerObj = new AccountContractDataModel();
				handlerObj.setScenarioName(row1.getCell(0).toString());
				handlerObj.setScenarioRunningStatus(row1.getCell(1).toString());
				handlerObj.setOperations(row1.getCell(2).toString());
				handlerObj.setCustomer_number_BP(row1.getCell(3).toString());
				handlerObj.setBill_number_CA(row1.getCell(4).toString());
				handlerObj.setSupply_location_ID(row1.getCell(5).toString());
				handlerObj.setContract_owner(row1.getCell(6).toString());
				handlerObj.setPhoneCTINumber(row1.getCell(7).toString());
				handlerObj.setPayersName(row1.getCell(8).toString());
				handlerObj.setSummaryBillRep(row1.getCell(9).toString());
				handlerObj.setZipCode(row1.getCell(10).toString());
				handlerObj.setAddress(row1.getCell(11).toString());
				handlerObj.setIssueNum(row1.getCell(12).toString());
				handlerObj.setBuildingName(row1.getCell(13).toString());
				handlerObj.setBuildingNumber(row1.getCell(14).toString());
				handlerObj.setRoomNumber(row1.getCell(15).toString());
				handlerObj.setRequestorKana(row1.getCell(16).toString());
				handlerObj.setContactNumber(row1.getCell(17).toString());
				handlerObj.setPaymentMethod(row1.getCell(18).toString());
				handlerObj.setFinanceInst(row1.getCell(19).toString());
				handlerObj.setAccNumber(row1.getCell(20).toString());
				datalist.add(handlerObj);
			}

		}

		return datalist;

	}

}
