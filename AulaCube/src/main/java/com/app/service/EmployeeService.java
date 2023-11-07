package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EmployeeDto;
import com.app.exception.EmployeeNotFoundException;
import com.app.model.mongoDb.Department;
import com.app.model.postgreSql.Employee;

import com.app.repository.mongoDb.DepartmentRepository;
import com.app.repository.postgreSql.EmployeeRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    public Employee addEmployee(String firstName, String lastName, String email, String departmentId) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setDepartmentId(departmentId);

            // Generate timestamps
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            employee.setCreatedAt(currentTime);
            employee.setUpdatedAt(currentTime);

            // Save the employee
            return employeeRepository.save(employee);
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while adding an employee: " + e.getMessage());
        }
    }

    public List<EmployeeDto> getAllEmployees() {
        try {
            List<EmployeeDto> employees = new ArrayList<>();

            List<Employee> employeeEntities = employeeRepository.findAll(); // Fetch employees from PostgreSQL

            for (Employee employeeEntity : employeeEntities) {
                // For each employee, fetch departmentName from MongoDB using departmentId
                String departmentName = fetchDepartmentName(employeeEntity.getDepartmentId());

                // Create an EmployeeDto with the necessary fields and add it to the list
                EmployeeDto employeeDto = new EmployeeDto();
                employeeDto.setId(employeeEntity.getId());
                employeeDto.setFirstName(employeeEntity.getFirstName());
                employeeDto.setLastName(employeeEntity.getLastName());
                employeeDto.setEmail(employeeEntity.getEmail());
                employeeDto.setDepartmentName(departmentName);
                employeeDto.setCreatedAt(employeeEntity.getCreatedAt());
                employeeDto.setUpdatedAt(employeeEntity.getUpdatedAt());

                employees.add(employeeDto);
            }

            return employees;
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while fetching all employees: " + e.getMessage());
        }
    }

    public EmployeeDto getEmployeeById(Long id) {
        try {
            Optional<Employee> employeeOptional = employeeRepository.findById(id);
            if (employeeOptional.isPresent()) {
                Employee employee = employeeOptional.get();
                EmployeeDto employeeDto = new EmployeeDto();
                employeeDto.setId(employee.getId());
                employeeDto.setFirstName(employee.getFirstName());
                employeeDto.setLastName(employee.getLastName());
                employeeDto.setEmail(employee.getEmail());
                employeeDto.setCreatedAt(employee.getCreatedAt());
                employeeDto.setUpdatedAt(employee.getUpdatedAt());

                // Fetch departmentName from MongoDB using departmentId
                String departmentName = fetchDepartmentName(employee.getDepartmentId());
                employeeDto.setDepartmentName(departmentName);

                return employeeDto;
            } else {
                throw new EmployeeNotFoundException("Employee not found with ID: " + id);
            }
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while fetching an employee by ID: " + e.getMessage());
        }
    }

    public void deleteEmployeeById(Long id) {
        try {
            Optional<Employee> employeeOptional = employeeRepository.findById(id);
            if (employeeOptional.isPresent()) {
                employeeRepository.deleteById(id);
            } else {
                throw new EmployeeNotFoundException("Employee not found with ID: " + id);
            }
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while deleting an employee by ID: " + e.getMessage());
        }
    }

    public Employee updateEmployeeById(Long id, String newFirstName, String newLastName, String newEmail, String newDepartmentId) {
        try {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);

            if (optionalEmployee.isPresent()) {
                Employee existingEmployee = optionalEmployee.get();
                existingEmployee.setFirstName(newFirstName);
                existingEmployee.setLastName(newLastName);
                existingEmployee.setEmail(newEmail);
                existingEmployee.setDepartmentId(newDepartmentId);
                existingEmployee.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

                

                return employeeRepository.save(existingEmployee);
            }

            return null;
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while updating an employee by ID: " + e.getMessage());
        }
    }

    public String fetchDepartmentName(String departmentId) {
        try {
            // Fetch departmentName from MongoDB using departmentId
            Department department = departmentRepository.findByDepartmentId(departmentId);

            if (department != null) {
                return department.getDepartmentName();
            } else {
                return "N/A";
            }
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while fetching department name: " + e.getMessage());
        }
    }


    }

