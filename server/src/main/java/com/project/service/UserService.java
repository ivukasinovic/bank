package com.project.service;

import com.project.domain.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User findOne(Long id);

    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);

    void delete(Long id);

    User findByEmailAndPassword(String email,String password);

    void confirmEmailAdress(Long id);

}
