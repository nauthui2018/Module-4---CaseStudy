package com.nauthui7.demo.controller.admin;

import com.nauthui7.demo.service.Implement.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tag")
    public String index() {
        return "tag";
    }
}
