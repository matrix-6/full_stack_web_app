package com.demo.unittest;

import org.springframework.stereotype.Service;

import com.demo.entities.EmployeeInfo;
import com.demo.repositories.EmployeeInfoRepository;

@Service
public class RegisterEmployeeInfoUseCase {
	private final EmployeeInfoRepository employeeInfoRepository;
	
	public RegisterEmployeeInfoUseCase(EmployeeInfoRepository employeeInfoRepository) {
		this.employeeInfoRepository = employeeInfoRepository;
	}
	
	public EmployeeInfo registerEmployeeInfo(EmployeeInfo employeeInfo) {
		return employeeInfoRepository.save(employeeInfo);
	}

}
