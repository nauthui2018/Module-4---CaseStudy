package com.nauthui7.demo.repository;

import com.nauthui7.demo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GroupRepository extends JpaRepository<Tag, Integer> {
}
