package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.mongoDb.Department;
import com.app.model.mongoDb.Sequence;
import com.app.repository.mongoDb.DepartmentRepository;
import com.app.repository.mongoDb.SequenceRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private SequenceRepository sequenceRepository;

    public Department addDepartment(String departmentName) {
        try {
            Sequence sequence = sequenceRepository.findById("department_sequence").orElse(new Sequence("department_sequence", 0));
            long nextValue = sequence.getSeq() + 1;
            sequence.setSeq(nextValue);
            sequenceRepository.save(sequence);

            Department department = new Department();
            department.setDepartmentId(String.valueOf(nextValue));
            department.setDepartmentName(departmentName);
            department.setCreatedAt(new Date());
            department.setUpdatedAt(new Date());
            return departmentRepository.save(department);
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while adding a department: " + e.getMessage());
        }
    }

    public List<Department> getAllDepartments() {
        try {
            return departmentRepository.findAll();
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while fetching all departments: " + e.getMessage());
        }
    }

    public Department getDepartmentById(String id) {
        try {
            return departmentRepository.findById(id).orElse(null);
        } catch (Exception e) {

            throw new RuntimeException("An error occurred while fetching a department by ID: " + e.getMessage());
        }
    }

    public boolean deleteDepartmentById(String id) {
        try {
            if (departmentRepository.existsById(id)) {
                departmentRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while deleting a department by ID: " + e.getMessage());
        }
    }

    public Department updateDepartmentById(String id, String newDepartmentName) {
        try {
            Optional<Department> optionalDepartment = departmentRepository.findById(id);
            if (optionalDepartment.isPresent()) {
                Department existingDepartment = optionalDepartment.get();
                existingDepartment.setDepartmentName(newDepartmentName);
                existingDepartment.setUpdatedAt(new Date());
                return departmentRepository.save(existingDepartment);
            } else {
                return null;
            }
        } catch (Exception e) {
            
            throw new RuntimeException("An error occurred while updating a department by ID: " + e.getMessage());
        }
    }
    
    
}
