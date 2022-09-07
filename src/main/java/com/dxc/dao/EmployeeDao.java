package com.dxc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dxc.model.Employee;

@Component
public class EmployeeDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	// add employee
	@Transactional
	public void addEmployee(Employee emp) {
		hibernateTemplate.save(emp);
	}
	
	// get all employee
	public List<Employee> getAllEmp() {
		return hibernateTemplate.loadAll(Employee.class);
	}
	
	// get employee by id
	public Employee getEmpById(Long id) {
		// load method = lazy initializer, get method is not
		return hibernateTemplate.get(Employee.class, id);
	}
	
	// update employee
	@Transactional
	public void updateEmp(Employee emp) {
		hibernateTemplate.update(emp);
	}
	
	// delete employee
	@Transactional
	public void deleteEmp(Long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employee.class, id));
	}
}
