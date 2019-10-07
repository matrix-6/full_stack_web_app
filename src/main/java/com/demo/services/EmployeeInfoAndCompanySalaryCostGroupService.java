package com.demo.services;

import java.util.List;

import com.demo.entities.CompanySalaryCostGroup;
import com.demo.entities.EmployeeInfo;

public interface EmployeeInfoAndCompanySalaryCostGroupService {
	
	public EmployeeInfo findEmployeeInfoById(Long id);
	
	public List<EmployeeInfo> findEmployeeInfoByFirstNameAndLastName(String firstName, String lastName);

	public List<CompanySalaryCostGroup> CompanySalaryCostGroupBy();
	
	public void saveEmployeeInfo(EmployeeInfo employeeInfo);
	
	public void updateEmployeeInfo(EmployeeInfo employeeInfo);
	
	public void deleteEmployeeInfo(EmployeeInfo employeeInfo);
	
	public void deleteEmployeeInfoById(Long id);
	
	public void deleteAllEmployeeInfos();
	
	public List<EmployeeInfo> findAllEmployeeInfos();
	
	public boolean isEmployeeInfoExist(EmployeeInfo employeeInfo);
	
}
