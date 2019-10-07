package com.demo.unittest;

import com.demo.*;
import com.demo.entities.*;
import com.demo.repositories.*;

import junit.framework.Assert;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootApplication
public class EmployeeInfoRepositoryTest {
	
	@Autowired
	private EmployeeInfoRepository employeeInfoRepository;
 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		EmployeeInfo testEmployeeInfo1 = new EmployeeInfo("testFirstName1", "testLastName1", "testCompany1", "testAddress1", 1111.11);
		employeeInfoRepository.save(testEmployeeInfo1);
		employeeInfoRepository.flush();
	}

	@After
	public void tearDown() throws Exception {
	}

	 // write test cases here
	@Test
	public void test_saveEmployeeInfo() {		
		assertEquals(7, employeeInfoRepository.count());
	}
	
	@Test
	public void test_findEmployeeInfoByFirstNameAndLastName() {
		EmployeeInfo found = employeeInfoRepository.findEmployeeInfoByFirstNameAndLastName("testFirstName1", "testLastName1").get(0);
		assertEquals(found.getsFirstName(), "testFirstName1");
	    assertEquals(found.getsLastName(), "testLastName1");
	}
	
	@Test
	public void test_CompanySalaryCostGroupBy() {
		List<CompanySalaryCostGroup> companySalaryCostGroupList = employeeInfoRepository.CompanySalaryCostGroupBy();
		for (CompanySalaryCostGroup cscg : companySalaryCostGroupList) {
			System.out.println("sumSalary: " + cscg.getdSumSalary());
			if (cscg.getsCompany().equalsIgnoreCase("IBM")) {
				System.out.println("IBM: " + cscg.getdSumSalary());
				assertEquals(true, new Double(cscg.getdSumSalary()).equals(new Double(12222.21d)));
			} else if (cscg.getsCompany().equalsIgnoreCase("HSBC")) {
				System.out.println("HSBC: " + cscg.getdSumSalary());
				assertEquals(true, new Double(cscg.getdSumSalary()).equals(new Double(9999.99d)));
			} else if (cscg.getsCompany().equalsIgnoreCase("Pline")) {
				System.out.println("Pline: " + cscg.getdSumSalary());
				assertEquals(true, new Double(cscg.getdSumSalary()).equals(new Double(17777.76d)));
			} else if (cscg.getsCompany().equalsIgnoreCase("testCompany1"))  {
				System.out.println("testCompany1:" + cscg.getdSumSalary());
				assertEquals(true, new Double(cscg.getdSumSalary()).equals(new Double(3333.33d)));
			}
		}
	}	
}
