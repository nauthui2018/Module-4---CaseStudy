package com.nauthui7.demo.controller.admin;

import com.nauthui7.demo.service.Implement.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/group")
    public String index() {
        return "group";
    }
}
