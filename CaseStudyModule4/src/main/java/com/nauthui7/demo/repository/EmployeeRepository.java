package com.nauthui7.demo.repository;

import com.nauthui7.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends JpaRepository<Blog, Integer> {
}
