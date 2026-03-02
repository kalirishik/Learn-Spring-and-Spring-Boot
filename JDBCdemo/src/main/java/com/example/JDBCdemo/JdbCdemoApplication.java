package com.example.JDBCdemo;

import com.example.JDBCdemo.model.Employee;
import com.example.JDBCdemo.repository.EmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbCdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JdbCdemoApplication.class, args);

		Employee employee=context.getBean(Employee.class);

		employee.setId(111);
		employee.setName("Kali Rishi");
		employee.setTech("Java");

		EmployeeRepo employeeRepo=context.getBean(EmployeeRepo.class);

		employeeRepo.save(employee);

		System.out.println(employeeRepo.findAll());
	}

}
