package com.nauthui7.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(targetEntity = Blog.class)
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

    public List<Blog> getCustomers() {
        return blogs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
