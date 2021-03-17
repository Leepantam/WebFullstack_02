package com.leepantam.s1.bankbook;

public class BankBookDTO {
	private int ACCOUNT_NUMBER;
	private String ACCOUNT_NAME;
	private double INTEREST_RATE;
	private String CAN_MAKE;
	
	
	
	public int getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}
	public void setACCOUNT_NUMBER(int aCCOUNT_NUMBER) {
		ACCOUNT_NUMBER = aCCOUNT_NUMBER;
	}
	public String getACCOUNT_NAME() {
		return ACCOUNT_NAME;
	}
	public void setACCOUNT_NAME(String aCCOUNT_NAME) {
		ACCOUNT_NAME = aCCOUNT_NAME;
	}
	public double getINTEREST_RATE() {
		return INTEREST_RATE;
	}
	public void setINTEREST_RATE(double iNTEREST_RATE) {
		INTEREST_RATE = iNTEREST_RATE;
	}
	public String getCAN_MAKE() {
		return CAN_MAKE;
	}
	public void setCAN_MAKE(String cAN_MAKE) {
		CAN_MAKE = cAN_MAKE;
	}
	
}
