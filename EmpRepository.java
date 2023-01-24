package com.gloify.OneToMany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gloify.OneToMany.model.Employee;
@Repository
public interface EmpRepository  extends JpaRepository<Employee, Integer>{
	List<Employee> findByName(String name);

}
