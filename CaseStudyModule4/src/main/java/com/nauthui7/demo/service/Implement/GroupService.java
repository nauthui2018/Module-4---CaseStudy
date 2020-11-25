package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.Tag;
import com.nauthui7.demo.repository.GroupRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements BaseService<Tag> {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Tag> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return groupRepository.save(tag);
    }

    @Override
    public Tag findById(int id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Tag remove(int id) {
        Tag tag = findById(id);
        groupRepository.delete(tag);
        return tag;
    }
}
