package com.demo.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompanySalaryCostGroup {

	private String sCompany;
	private double dSumSalary;
	
	public CompanySalaryCostGroup() {}
	
	public CompanySalaryCostGroup(String company, double sumSalary) {
		this.sCompany = company;
		this.dSumSalary = sumSalary;
	}
	
	public String getsCompany() {
		return sCompany;
	}
	
	public void setsCompany(String sCompany) {
		this.sCompany = sCompany;
	}
	
	public double getdSumSalary() {
		return new BigDecimal(this.dSumSalary).setScale(2, RoundingMode.HALF_UP).doubleValue(); //dSumSalary;
	}
	
	public void setbdSumSalary(double sumSalary) {		
		this.dSumSalary = new BigDecimal(sumSalary).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}	
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder("CompanySalaryCostGroup:[");
		sBuilder.append("sCompany: " + this.sCompany);
		sBuilder.append(", dSumSalary: " + this.dSumSalary);
		sBuilder.append("]");
		return sBuilder.toString();
	}
}
