package com.rest.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.api.model.UserRegistration;
import com.rest.api.model.UserRegistrationDateCount;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Integer>{

	@Query(value="SELECT count(*) FROM user_registration WHERE date = CURDATE() and month(curdate())",
			nativeQuery = true)
	Integer getEachdayUserRegistrationCount();
	
	
	@Query(value="select date, count(*)  from user_registration  where month(date)= month(curdate()) group by date",
			nativeQuery = true)
	List<Object[]> getCountTable();
}
