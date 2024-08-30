package com.spring.fippon.project.repository;

import com.spring.fippon.project.entity.UserDetail;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class UserDetailRepositoryTest {
    @Autowired
    UserDetailRepository userDetailRepository;
    @Test
    public void insertUsername() {
        UserDetail userDetail = new UserDetail();
        userDetail.setUsername("admin");
        userDetail.setPassword("admin");
        userDetail.setEmail("admin@admin.com");
        userDetail.setPhone("1234567890");

        // Save the UserDetails object to the database
        UserDetail savedUser = userDetailRepository.save(userDetail);

        // Check if the user was saved correctly
        assertNotNull(savedUser.getId()); // Check that the ID is generated
        assertEquals("admin", savedUser.getUsername());
    }




}