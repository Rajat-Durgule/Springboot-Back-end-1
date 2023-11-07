package com.app.repository.mongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.mongoDb.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    // You can define custom query methods here if needed.
	
	Department findByDepartmentId(String departmentId);
}
