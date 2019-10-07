package com.demo.controllers;

import com.demo.entities.CompanySalaryCostGroup;
import com.demo.entities.EmployeeInfo;
import com.demo.services.*;
import com.demo.utils.CustomErrorType;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class RestApiController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	EmployeeInfoAndCompanySalaryCostGroupService employeeInfoAndCompanySalaryCostGroupService;
	
		
	// ------------------- Retrieve Company Salary Cost Group ---------------------------------------------
	@RequestMapping(value = "/companySalaryCostGroup/", method = RequestMethod.GET)
	public ResponseEntity<List<CompanySalaryCostGroup>> listAllCompanySalaryCostGroup() {
		List<CompanySalaryCostGroup> companySalaryCostGroupList = employeeInfoAndCompanySalaryCostGroupService.CompanySalaryCostGroupBy();
		if (companySalaryCostGroupList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		System.out.println("listAllCompanySalaryCostGroup -> " + companySalaryCostGroupList);
		return new ResponseEntity<List<CompanySalaryCostGroup>>(companySalaryCostGroupList, HttpStatus.OK);
	}
		
	// ------------------- Retrieve All EmployeeInfos ---------------------------------------------
	@RequestMapping(value = "/employeeInfo/", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeInfo>> listAllEmployeeInfos() {
		List<EmployeeInfo> employeeInfoList = employeeInfoAndCompanySalaryCostGroupService.findAllEmployeeInfos();
		if (employeeInfoList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		System.out.println("employeeInfo --> " + employeeInfoList.toString());
		return new ResponseEntity<List<EmployeeInfo>>(employeeInfoList, HttpStatus.OK);
	}

	// ------------------- Retrieve Single EmployeeInfo ------------------------------------------
	@RequestMapping(value = "/employeeInfo/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeInfo(@PathVariable("id") long id) {
		logger.info("Fetching EmployeeInfo with id {}", id);
		EmployeeInfo employeeInfo = employeeInfoAndCompanySalaryCostGroupService.findEmployeeInfoById(id);
		if (employeeInfo == null) {
			logger.error("EmployeeInfo with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("EmployeeInfo with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmployeeInfo>(employeeInfo, HttpStatus.OK);
	}

	// ------------------- Create a EmployeeInfo -------------------------------------------
	@RequestMapping(value = "/employeeInfo/", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployeeInfo(@RequestBody EmployeeInfo employeeInfo, UriComponentsBuilder ucBuilder) {
		logger.info("Creating EmployeeInfo : {}", employeeInfo);

		if (employeeInfoAndCompanySalaryCostGroupService.isEmployeeInfoExist(employeeInfo)) {
			logger.error("Unable to create. A EmployeeInfo with name {} already exist", employeeInfo.getsFirstName() + " " + employeeInfo.getsLastName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A EmployeeInfo with name " + 
			employeeInfo.getsFirstName() + " " + employeeInfo.getsLastName() + " already exist."),HttpStatus.CONFLICT);
		}
		employeeInfoAndCompanySalaryCostGroupService.saveEmployeeInfo(employeeInfo);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/employeeInfo/{id}").buildAndExpand(employeeInfo.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a EmployeeInfo ------------------------------------------------
	@RequestMapping(value = "/employeeInfo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployeeInfo(@PathVariable("id") long id, @RequestBody EmployeeInfo employeeInfo) {
		logger.info("Updating EmployeeInfo with id {}", id);

		EmployeeInfo currentEmployeeInfo = employeeInfoAndCompanySalaryCostGroupService.findEmployeeInfoById(id);

		if (currentEmployeeInfo == null) {
			logger.error("Unable to update. EmployeeInfo with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. EmployeeInfo with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentEmployeeInfo.setsFirstName(employeeInfo.getsFirstName());
		currentEmployeeInfo.setsLastName(employeeInfo.getsLastName());
		currentEmployeeInfo.setsCompany(employeeInfo.getsCompany());
		currentEmployeeInfo.setsAddress(employeeInfo.getsAddress());
		currentEmployeeInfo.setdSalary(employeeInfo.getdSalary());

		employeeInfoAndCompanySalaryCostGroupService.updateEmployeeInfo(currentEmployeeInfo);
		return new ResponseEntity<EmployeeInfo>(currentEmployeeInfo, HttpStatus.OK);
	}

	// ------------------- Delete a EmployeeInfo -----------------------------------------
	@RequestMapping(value = "/employeeInfo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployeeInfo(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting EmployeeInfo with id {}", id);

		EmployeeInfo employeeInfo = employeeInfoAndCompanySalaryCostGroupService.findEmployeeInfoById(id);
		if (employeeInfo == null) {
			logger.error("Unable to delete. EmployeeInfo with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. EmployeeInfo with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		employeeInfoAndCompanySalaryCostGroupService.deleteEmployeeInfoById(id);
		return new ResponseEntity<EmployeeInfo>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All EmployeeInfos-----------------------------
	@RequestMapping(value = "/EmployeeInfo/", method = RequestMethod.DELETE)
	public ResponseEntity<EmployeeInfo> deleteAllEmployeeInfos() {
		logger.info("Deleting All EmployeeInfos");

		employeeInfoAndCompanySalaryCostGroupService.deleteAllEmployeeInfos();
		return new ResponseEntity<EmployeeInfo>(HttpStatus.NO_CONTENT);
	}

}
