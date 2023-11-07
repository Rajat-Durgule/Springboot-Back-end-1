package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.mongoDb.Department;
import com.app.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        try {
            Department addedDepartment = departmentService.addDepartment(department.getDepartmentName());
            return ResponseEntity.ok(addedDepartment);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        try {
            List<Department> departments = departmentService.getAllDepartments();
            return ResponseEntity.ok(departments);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        try {
            Department department = departmentService.getDepartmentById(id);
            if (department != null) {
                return ResponseEntity.ok(department);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable String id) {
        try {
            boolean deleted = departmentService.deleteDepartmentById(id);
            if (deleted) {
                return ResponseEntity.ok("Department with ID " + id + " has been deleted.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable String id, @RequestBody Map<String, String> request) {
        try {
            String newDepartmentName = request.get("newDepartmentName");
            Department updatedDepartment = departmentService.updateDepartmentById(id, newDepartmentName);
            if (updatedDepartment != null) {
                return ResponseEntity.ok(updatedDepartment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
