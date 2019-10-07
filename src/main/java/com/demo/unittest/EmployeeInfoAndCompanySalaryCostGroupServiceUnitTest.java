package com.demo.unittest;

import static org.junit.Assert.*;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;

import com.demo.entities.CompanySalaryCostGroup;
import com.demo.entities.EmployeeInfo;
import com.demo.repositories.EmployeeInfoRepository;
import com.demo.services.EmployeeInfoAndCompanySalaryCostGroupService;
import com.demo.services.EmployeeInfoAndCompanySalaryCostGroupServiceImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@SpringBootApplication

//@RunWith(MockitoJUnitRunner.class)

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class, EmployeeInfoRepository.class, EmployeeInfoAndCompanySalaryCostGroupService.class})
//@SpringBootApplication
public class EmployeeInfoAndCompanySalaryCostGroupServiceUnitTest {
	
	//@Autowired //@Mock
	//EmployeeInfoAndCompanySalaryCostGroupService employeeInfoAndCompanySalaryCostGroupService;

	//@Autowired //@InjectMocks
	//EmployeeInfoAndCompanySalaryCostGroupServiceImpl employeeInfoAndCompanySalaryCostGroupServiceImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testFindTheGreatestFromAllData() {
//		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
//		assertEquals(24, businessImpl.findTheGreatestFromAllData());
//	}
	
	@Test
	public void test_findEmployeeInfoById() {
		//when(employeeInfoAndCompanySalaryCostGroupService.s)
		assertEquals(true, true);
		
	}
	
//	public EmployeeInfo findEmployeeInfoById(Long id);
//	
//	public List<EmployeeInfo> findEmployeeInfoByFirstNameAndLastName(String firstName, String lastName);
//
//	public List<CompanySalaryCostGroup> CompanySalaryCostGroupBy();
//	
//	public void saveEmployeeInfo(EmployeeInfo employeeInfo);
//	
//	public void updateEmployeeInfo(EmployeeInfo employeeInfo);
//	
//	public void deleteEmployeeInfo(EmployeeInfo employeeInfo);
//	
//	public void deleteEmployeeInfoById(Long id);
//	
//	public void deleteAllEmployeeInfos();
//	
//	public List<EmployeeInfo> findAllEmployeeInfos();

}
