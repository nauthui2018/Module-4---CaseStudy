package com.nauthui7.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tags")
@Where(clause="tag_active=1")
public class Tag implements Serializable {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "tag_name")
    private String name;
    @Column(name = "tag_active")
    private int active;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Blog> blogs;

    public Tag() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getActive() {
        return active;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
