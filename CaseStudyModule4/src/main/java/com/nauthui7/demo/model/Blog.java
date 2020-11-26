package com.nauthui7.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "blogs")
//@Where(clause="tag_active=0")
public class Blog implements Serializable {
    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "blog_title")
    private String title;

    @Column(name = "blog_content")
    private String content;

    @Column(name = "blog_author")
    private String author;

    @Column(name = "blog_publishedDate")
    private String publishedDate;

    @Column(name = "blog_modifiedDate")
    private String modifiedDate;

    @ManyToMany
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "blogs_tags",
            joinColumns = {
                    @JoinColumn(name = "blog_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "tag_id")
            }
    )
    private List<Tag> tags;

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
