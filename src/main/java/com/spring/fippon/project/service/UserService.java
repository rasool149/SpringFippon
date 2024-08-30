package com.spring.fippon.project.service;

import com.spring.fippon.project.entity.UserDetail;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDetail saveUser(UserDetail userDetail);

    List<UserDetail> getAllUsers();

    UserDetail getUserById(Long id);

    UserDetail savedUser(UserDetail userDetail);
    List<UserDetail> getallUsers();
    UserDetail getUserById(int id);
    void deleteUser(Long id);
    double calculateDistance(Long userId);
}
