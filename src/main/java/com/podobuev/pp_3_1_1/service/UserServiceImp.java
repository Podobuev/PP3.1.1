package com.podobuev.pp_3_1_1.service;

import com.podobuev.pp_3_1_1.model.User;
import com.podobuev.pp_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {

                return StreamSupport.stream(Spliterators.spliteratorUnknownSize(userRepository.findAll().iterator(), Spliterator.ORDERED), false)
                        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.save(user);
    }
}
