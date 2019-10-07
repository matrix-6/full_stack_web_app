package com.demo.services;

import com.demo.repositories.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.CompanySalaryCostGroup;
import com.demo.entities.EmployeeInfo;

@Service("employeeInfoAndCompanySalaryCostGroupService")
@Transactional
public class EmployeeInfoAndCompanySalaryCostGroupServiceImpl implements EmployeeInfoAndCompanySalaryCostGroupService {
	
	@Autowired
	private EmployeeInfoRepository employeeInfoRepository;

	@Override
	public EmployeeInfo findEmployeeInfoById(Long id) {
		EmployeeInfo employeeInfo = employeeInfoRepository.findEmployeeInfoById(id);		
		return employeeInfo;
	}
		
	@Override
	public List<EmployeeInfo> findEmployeeInfoByFirstNameAndLastName(String firstName, String lastName) {
		List<EmployeeInfo> employeeInfoList = employeeInfoRepository.findEmployeeInfoByFirstNameAndLastName(firstName, lastName);		
		System.out.println("serviceImpl -> findEmployeeInfoByFirstNameAndLastName -> employeeInfoList: " + employeeInfoList.toString());
		return employeeInfoList;
	}
		
	@Override
	public List<CompanySalaryCostGroup> CompanySalaryCostGroupBy() {
		List<CompanySalaryCostGroup> companySalaryCostGroupList = employeeInfoRepository.CompanySalaryCostGroupBy();		
		return companySalaryCostGroupList;
	}
	
	@Override
	public void saveEmployeeInfo(EmployeeInfo employeeInfo) {
		System.out.println("saveEmployeeInfo -> employeeInfo:" + employeeInfo.toString());
		employeeInfoRepository.save(employeeInfo);
	}
	
	@Override
	public void updateEmployeeInfo(EmployeeInfo employeeInfo) {
		saveEmployeeInfo(employeeInfo);
	}
	
	@Override
	public void deleteEmployeeInfo(EmployeeInfo employeeInfo) {
		employeeInfoRepository.delete(employeeInfo);
	}
	
	@Override
	public void deleteEmployeeInfoById(Long id) {
		employeeInfoRepository.delete(id);
	}
	
	@Override
	public void deleteAllEmployeeInfos() {
		employeeInfoRepository.deleteAll();
	}
	
	@Override
	public List<EmployeeInfo> findAllEmployeeInfos() {
		return employeeInfoRepository.findAll();
	}
	
	@Override
	public boolean isEmployeeInfoExist(EmployeeInfo employeeInfo) {
		return this.findEmployeeInfoByFirstNameAndLastName(employeeInfo.getsFirstName(), employeeInfo.getsLastName()).size() > 0;
	}
}
