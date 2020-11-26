package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.Blog;
import com.nauthui7.demo.repository.BlogRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements BaseService<Blog> {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog remove(int id) {
        Blog blog = findById(id);
        blogRepository.delete(blog);
        return new Blog();
    }
}
