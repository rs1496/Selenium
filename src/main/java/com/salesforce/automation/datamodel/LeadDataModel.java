package com.salesforce.automation.datamodel;

public class LeadDataModel {
	
	private String scenarioName;
	private String scenarioRunningStatus;
	private String operations;
	private String branchUser;
	private String recordType;
	private String product;
	private String lastname;
	private String leadSource;
	private String channelPartner;
	
	
	
	
	
	
	public String getChannelPartner() {
		return channelPartner;
	}
	public void setChannelPartner(String channelPartner) {
		this.channelPartner = channelPartner;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public String getBranchUser() {
		return branchUser;
	}
	public void setBranchUser(String branchUser) {
		this.branchUser = branchUser;
	}
	public String getScenarioName() {
		return scenarioName;
	}
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}
	public String getScenarioRunningStatus() {
		return scenarioRunningStatus;
	}
	public void setScenarioRunningStatus(String scenarioRunningStatus) {
		this.scenarioRunningStatus = scenarioRunningStatus;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}

	
	
	
	
}
