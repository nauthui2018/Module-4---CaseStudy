package com.nauthui7.demo.controller.api;

import com.nauthui7.demo.model.Tag;
import com.nauthui7.demo.service.Implement.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APITag {
    @Autowired
    TagService tagService;

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> findAll() {
        List<Tag> allTags = tagService.findAll();
        if (allTags == null) {
            return new ResponseEntity<List<Tag>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Tag>>(allTags, HttpStatus.OK);
    }

    @RequestMapping(value = "/tag/active/{active}", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> findAllByActive(@PathVariable("active") int active) {
        List<Tag> activeTags = tagService.findByActive(active);
        if (activeTags == null) {
            return new ResponseEntity<List<Tag>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Tag>>(activeTags, HttpStatus.OK);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tag> delete(@PathVariable("id") int id) {
        Tag tag = tagService.remove(id);
        return new ResponseEntity<Tag>(tag, HttpStatus.OK);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        Tag newTag = tagService.save(tag);
        return new ResponseEntity<Tag>(newTag, HttpStatus.OK);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> getOne(@PathVariable("id") int id) {
        Tag tag = tagService.findById(id);
        return new ResponseEntity<Tag>(tag, HttpStatus.OK);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.PUT)
    public ResponseEntity<Tag> update(@RequestBody Tag tag) {
        tagService.save(tag);
        return new ResponseEntity<Tag>(tag, HttpStatus.OK);
    }
}
