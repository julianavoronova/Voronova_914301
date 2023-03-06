package com.example.services;

import com.example.models.Department;
import com.example.models.Position;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment (Department department);
    public List<Department> getAllDepartments();

    public void deleteById (Integer id);

    public Department get(Integer id);

}
