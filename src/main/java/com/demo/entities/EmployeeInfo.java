package com.demo.entities;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee_info")
public class EmployeeInfo implements java.io.Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="id")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name="first_name")
	@NotNull
	private String sFirstName;
	
	@Column(name="last_name")
	@NotNull
	private String sLastName;
	
	@Column(name="company")
	private String sCompany;
	
	@Column(name="address")
	private String sAddress;
	
	@Column(name="salary")
	private double dSalary;
	
	public EmployeeInfo() {}
	
	public EmployeeInfo(String firstName, String lastName, String company, String address, double salary) {
		this.sFirstName = firstName.trim();
		this.sLastName = lastName.trim();
		this.sCompany = company.trim();
		this.sAddress = address.trim();
		this.dSalary = salary;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getsCompany() {
		return sCompany;
	}

	public void setsCompany(String sCompany) {
		this.sCompany = sCompany;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public double getdSalary() {
		return dSalary;
	}

	public void setdSalary(double dSalary) {
		this.dSalary = dSalary;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EmployeeInfo employeeInfo = (EmployeeInfo) o;

		if (Double.compare(employeeInfo.dSalary, this.dSalary) != 0) return false;
		if (this.id != null ? !this.id.equals(employeeInfo.id) : employeeInfo.id != null) return false;
		if ( (employeeInfo.sFirstName != null || employeeInfo.sLastName != null) ? !(this.sFirstName + this.sLastName).equals(employeeInfo.sFirstName + employeeInfo.sLastName) : employeeInfo.sFirstName != null || employeeInfo.sLastName != null) return false;
		return this.sAddress != null ? this.sAddress.equals(employeeInfo.sAddress) : employeeInfo.sAddress == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = this.id != null ? this.id.hashCode() : 0;
		result = 31 * result + ( (this.sFirstName != null || this.sLastName != null) ? this.sFirstName.hashCode() + this.sLastName.hashCode() : 0);
		result = 31 * result + (this.sAddress != null ? this.sAddress.hashCode() : 0);
		temp = Double.doubleToLongBits(this.dSalary);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder("Employee_Info[");
		sBuilder.append("id: " + this.id + ", ");
		sBuilder.append("first_name: " + this.sFirstName + ", ");
		sBuilder.append("last_name: " + this.sLastName + ", ");
		sBuilder.append("company: " + this.sCompany + ", ");
		sBuilder.append("address: " + this.sAddress + ", ");
		sBuilder.append("salary: " + this.dSalary + "]");
		return sBuilder.toString();
	}

}
