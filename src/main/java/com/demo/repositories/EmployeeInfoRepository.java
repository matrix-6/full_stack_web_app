package com.demo.repositories;

import com.demo.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {
	
	public EmployeeInfo findEmployeeInfoById(Long id);
		
	// table name, column name are POJO entity class name, and fields' name, not DB table name, and column name
	@Query("select new com.demo.entities.EmployeeInfo(e.sFirstName, e.sLastName, e.sCompany, e.sAddress, e.dSalary) from EmployeeInfo e where e.sFirstName = :fname and e.sLastName = :lname")
	public List<EmployeeInfo> findEmployeeInfoByFirstNameAndLastName(@Param("fname")String firstName, @Param("lname")String lastName);

	@Query("select new com.demo.entities.CompanySalaryCostGroup(e.sCompany, sum(e.dSalary)) from EmployeeInfo e group by e.sCompany")
	public List<CompanySalaryCostGroup> CompanySalaryCostGroupBy();	
}
