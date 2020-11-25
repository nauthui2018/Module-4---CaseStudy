package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.Blog;
import com.nauthui7.demo.repository.EmployeeRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements BaseService<Blog> {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Blog> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return employeeRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Blog remove(int id) {
        Blog blog = findById(id);
        employeeRepository.delete(blog);
        return blog;
    }
}
