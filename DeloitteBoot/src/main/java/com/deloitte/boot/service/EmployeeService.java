package com.deloitte.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.boot.model.Employee;
import com.deloitte.boot.repo.EmployeeRepo;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	public Employee addEmployee(Employee emp)
	{
		String empId=generateId(emp.getEmpName());
		emp.setEmpId(empId);
		if(validateEmployee(emp))
		return repo.save(emp);
		else
			throw new RuntimeException("Invalid inputs");
	}

	public boolean validateEmployee(Employee emp) {
		if(emp.getDob().isAfter(LocalDate.of(1995, 12, 31)) || emp.getDob().isBefore(LocalDate.of(1900, 01, 01)))
			return false;
		if(emp.getEmpName().length()<4 || emp.getEmpName().length()>15)
			return false;
		if(emp.getSal()<25000 || emp.getSal()>80000)
			return false;
		
		return true;
		
	}
	
	public String generateId(String empName) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		int id=(int) (rand.nextDouble()*9999);
		String empCode=empName.substring(0,2)+id;
		return empCode;
	}
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employee getEmployee(String empId) {
	
		if(repo.findByEmpId(empId) != null)
			return repo.findByEmpId(empId);
		else
			throw new RuntimeException("Employee ID not found!");
	}
	
	public boolean deleteEmployee(String empId) {
		
		Employee emp=repo.findByEmpId(empId);
		if(emp!=null) {
		repo.delete(emp);
		return true;
		}
		return false;
		
		
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee e=repo.findByEmpId(emp.getEmpId());
		
		if(e!=null) {
			e.setSal(emp.getSal());
			if(validateEmployee(e))
				return repo.save(e);
		}
		throw new RuntimeException("Employee ID not found!");
	}
}
