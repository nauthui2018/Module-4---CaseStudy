package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.User;
import com.nauthui7.demo.repository.UserRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User remove(int id) {
        User user = findById(id);
        userRepository.delete(user);
        return user;
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }
}
