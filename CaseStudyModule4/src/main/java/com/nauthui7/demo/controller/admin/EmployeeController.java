package com.nauthui7.demo.controller.admin;

import com.nauthui7.demo.service.Implement.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String index() {
        return "employee";
    }
}
