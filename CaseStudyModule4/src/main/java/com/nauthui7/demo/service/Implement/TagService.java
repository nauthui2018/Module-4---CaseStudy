package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.Tag;
import com.nauthui7.demo.model.User;
import com.nauthui7.demo.repository.TagRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements BaseService<Tag> {
    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag findById(int id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag remove(int id) {
        Tag tag = findById(id);
        tag.setActive(0);
        tagRepository.save(tag);
        return tag;
    }

    public List<Tag> findByActive(int active) {
        List<Tag> tags = tagRepository.findByActive(active);
        return tags;
    }
}
