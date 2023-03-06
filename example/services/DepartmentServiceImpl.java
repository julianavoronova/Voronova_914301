package com.example.services;

import com.example.models.Department;
import com.example.repo.DepartmentRepo;
import com.example.repo.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepo.deleteById(id);

    }

    @Override
    public Department get(Integer id) {
        return departmentRepo.findById(id).get();
    }
}
