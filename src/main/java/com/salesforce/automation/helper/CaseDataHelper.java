package com.salesforce.automation.helper;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.salesforce.automation.constants.SalesForceConstants;
import com.salesforce.automation.datamodel.AccountContractDataModel;
import com.salesforce.automation.datamodel.CaseDataModel;
import com.salesforce.automation.utility.XlsOperationsUtility;

public class CaseDataHelper 
{	
	public static ArrayList<CaseDataModel> retrievedataset() throws Exception {
	ArrayList<CaseDataModel> datalist = new ArrayList<CaseDataModel>();
	XlsOperationsUtility xlsUtility = new XlsOperationsUtility(SalesForceConstants.CASE_DATA_SHEET);
	XSSFSheet dataSheet = xlsUtility.getdataSheet(0);
	Iterator<Row> row = dataSheet.iterator();
	row.next();
	while (row.hasNext()) {
		Row row1 = row.next();
		if (row1.getCell(1).toString().equalsIgnoreCase("Y")) {
			
			CaseDataModel handlerObj = new CaseDataModel();
			handlerObj.setScenarioName(row1.getCell(0).toString());
			handlerObj.setScenarioRunningStatus(row1.getCell(1).toString());
			handlerObj.setOperations(row1.getCell(2).toString());
			handlerObj.setAppLauncherSearch(row1.getCell(3).toString());
			handlerObj.setGlobalSearch(row1.getCell(4).toString());
			handlerObj.setCaseType(row1.getCell(5).toString());
			handlerObj.setCategory(row1.getCell(6).toString());
			handlerObj.setSubCategory(row1.getCell(7).toString());
			handlerObj.setAuthenticationMode(row1.getCell(8).toString());
			handlerObj.setBarcode(row1.getCell(9).toString());
			handlerObj.setCustomerName(row1.getCell(10).toString());
			handlerObj.setMobileNumber(row1.getCell(11).toString());
			handlerObj.setStatusCode(row1.getCell(12).toString());
			handlerObj.setDvuMakerUser(row1.getCell(13).toString());
			handlerObj.setDvuMakerStatusCode(row1.getCell(14).toString());
			handlerObj.setDvuCheckerUser(row1.getCell(15).toString());
			handlerObj.setDvuCheckerStatusCode(row1.getCell(16).toString());
			handlerObj.setDeMakerUser(row1.getCell(17).toString());
			handlerObj.setDeMakerStatusCode(row1.getCell(18).toString());
			handlerObj.setDispatchDestination(row1.getCell(19).toString());
			handlerObj.setLandmark(row1.getCell(20).toString());
			handlerObj.setDispatchMode(row1.getCell(21).toString());
			handlerObj.setRlOpsUser(row1.getCell(22).toString());
			handlerObj.setRlOpsStatusCode(row1.getCell(23).toString());
			handlerObj.setNewEmailId(row1.getCell(24).toString());
			handlerObj.setAccountName(row1.getCell(25).toString());
			handlerObj.setErrorMessage(row1.getCell(26).toString());
			handlerObj.setCallBackDate(row1.getCell(27).toString());
			handlerObj.setCallBackTime(row1.getCell(28).toString());
			handlerObj.setBocUser(row1.getCell(29).toString());
			handlerObj.setBocStatusCode(row1.getCell(30).toString());
			handlerObj.setDvuCheckerStatus1(row1.getCell(31).toString());
			handlerObj.setJournalNumber(row1.getCell(32).toString());
			handlerObj.setDeCheckerUser(row1.getCell(33).toString());
			handlerObj.setDeCheckerStatus(row1.getCell(34).toString());
			handlerObj.setCustomerId(row1.getCell(35).toString());
			handlerObj.setCaseId(row1.getCell(36).toString());
			handlerObj.setGrdUser(row1.getCell(37).toString());
			handlerObj.setGrdStatusCode(row1.getCell(38).toString());
			handlerObj.setDepartment(row1.getCell(39).toString());
			handlerObj.setWealthOpsUser(row1.getCell(40).toString());
			handlerObj.setWealthOpsStatusCode(row1.getCell(41).toString());
			handlerObj.setWealthOpsDepartment(row1.getCell(42).toString());
			handlerObj.setWcOpsUser(row1.getCell(43).toString());
			handlerObj.setWcOpsStatusCode(row1.getCell(44).toString());
			handlerObj.setWcOpsDepartment(row1.getCell(45).toString());
			handlerObj.setCsoUser(row1.getCell(46).toString());
			handlerObj.setCsoStatusCode(row1.getCell(47).toString());
			handlerObj.setCsoDepartment(row1.getCell(48).toString());
			handlerObj.setCmsOpsUser(row1.getCell(49).toString());
			handlerObj.setCmsOpsStatusCode(row1.getCell(50).toString());
			handlerObj.setCmsOpsDepartment(row1.getCell(51).toString());			
			handlerObj.setReconsOpsUser(row1.getCell(52).toString());
			handlerObj.setReconOpsStatusCode(row1.getCell(53).toString());
			handlerObj.setReconOpsDepartment(row1.getCell(54).toString());						
			handlerObj.setWealthProductTeamUser(row1.getCell(55).toString());
			handlerObj.setWealthProductTeamStatusCode(row1.getCell(56).toString());
			handlerObj.setWealthProductTeamDepartment(row1.getCell(57).toString());	
			handlerObj.setWealthProductTeamBranch(row1.getCell(58).toString());
			handlerObj.setBranchUser(row1.getCell(59).toString());			
			handlerObj.setBranchStatusCode(row1.getCell(60).toString());
			handlerObj.setBranchDepartment(row1.getCell(61).toString());
			handlerObj.setGrdDepartment(row1.getCell(62).toString());
			handlerObj.setIoUser(row1.getCell(63).toString());
			handlerObj.setIoStatusCode(row1.getCell(64).toString());
			handlerObj.setIoDepartment(row1.getCell(65).toString());
			handlerObj.setGrdStatusCode1(row1.getCell(66).toString());
			handlerObj.setResolutionComment(row1.getCell(67).toString());
			handlerObj.setUserFieldForAssigned(row1.getCell(68).toString());
			handlerObj.setTransactionReferenceNo(row1.getCell(69).toString());
			handlerObj.setDisputeAmt(row1.getCell(70).toString());
			handlerObj.setDisputeStage(row1.getCell(71).toString());
			handlerObj.setBbopsUser(row1.getCell(72).toString());
			handlerObj.setBbOpsStatusCode(row1.getCell(73).toString());
			handlerObj.setBbOpsStatusCode1(row1.getCell(74).toString());
			handlerObj.setHomeSaverOpsUser(row1.getCell(75).toString());
			handlerObj.setHomeSaverOpsStatusCode(row1.getCell(76).toString());
			handlerObj.setHomeSaverOpsStatusCode1(row1.getCell(77).toString());
			handlerObj.setBbOpsDVUMakerUser(row1.getCell(78).toString());
			handlerObj.setBbOpsDVUMakerStatusCode(row1.getCell(79).toString());
			handlerObj.setBbOpsDVUCheckerUser(row1.getCell(80).toString());
			handlerObj.setBbOpsDVUCheckerStatusCode(row1.getCell(81).toString());
			handlerObj.setBbOpsDEMakerUser(row1.getCell(82).toString());
			handlerObj.setBbOpsDEMakerStatusCode(row1.getCell(83).toString());
			handlerObj.setBbOpsDECheckerUser(row1.getCell(84).toString());
			handlerObj.setBbOpsDECheckerStatuscode(row1.getCell(85).toString());
			handlerObj.setWealthProductTeamStatusCode1(row1.getCell(86).toString());
			handlerObj.setReconOpsStatusCode1(row1.getCell(87).toString());		
			handlerObj.setTransactionDisputeStatus(row1.getCell(88).toString());
			handlerObj.setWcOpsStatusCode1(row1.getCell(89).toString());
			
			
			
			datalist.add(handlerObj);
		}
		
	}
	
	return datalist;

}

}