package com.nauthui7.demo.controller.api;

import com.nauthui7.demo.model.Tag;
import com.nauthui7.demo.service.Implement.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIGroup {
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> findAll() {
        List<Tag> allTags = groupService.findAll();
        if (allTags == null) {
            return new ResponseEntity<List<Tag>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Tag>>(allTags, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tag> delete(@PathVariable("id") int id) {
        Tag tag = groupService.remove(id);
        return new ResponseEntity<Tag>(tag, HttpStatus.OK);
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        Tag newTag = groupService.save(tag);
        return new ResponseEntity<Tag>(newTag, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> getOne(@PathVariable("id") int id) {
        Tag tag = groupService.findById(id);
        return new ResponseEntity<Tag>(tag, HttpStatus.OK);
    }

    @RequestMapping(value = "/group", method = RequestMethod.PUT)
    public ResponseEntity<Tag> update(@RequestBody Tag tag) {
        groupService.save(tag);
        return new ResponseEntity<Tag>(tag, HttpStatus.OK);
    }
}
