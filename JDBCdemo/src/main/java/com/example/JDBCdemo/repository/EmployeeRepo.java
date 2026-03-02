package com.example.JDBCdemo.repository;

import com.example.JDBCdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Employee employee){
        String sql="insert into employee(id,name,tech) values(?,?,?)";
        jdbcTemplate.update(sql,employee.getId(),employee.getName(),employee.getTech());
        System.out.println("Employee Added");
    }

    public List<Employee>  findAll(){
        String sql="select * from employee";
        List<Employee> employees=jdbcTemplate.query(sql,(rs,row)->{
            Employee employee=new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setTech(rs.getString("tech"));
            return employee;
        });

        return employees;
    }
}
