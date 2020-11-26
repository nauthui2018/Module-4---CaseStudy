package com.nauthui7.demo.repository;

import com.nauthui7.demo.model.Tag;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagRepository extends JpaRepository<Tag, Integer> {
    public List<Tag> findByActive(int active);
}
