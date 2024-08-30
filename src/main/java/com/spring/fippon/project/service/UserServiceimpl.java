package com.spring.fippon.project.service;

import com.spring.fippon.project.entity.UserDetail;
import com.spring.fippon.project.entity.PunchinDetail;
import com.spring.fippon.project.repository.UserDetailRepository;
import com.spring.fippon.project.repository.PunchinDetailRepository;
import com.spring.fippon.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private PunchinDetailRepository punchinDetailRepository;

    @Override
    public UserDetail saveUser(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public List<UserDetail> getAllUsers() {
        return userDetailRepository.findAll();
    }

    @Override
    public UserDetail getUserById(Long id) {
        return userDetailRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetail savedUser(UserDetail userDetail) {
        return null;
    }

    @Override
    public List<UserDetail> getallUsers() {
        return List.of();
    }

    @Override
    public UserDetail getUserById(int id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userDetailRepository.deleteById(id);
    }

    @Override
    public double calculateDistance(Long userId) {
        List<PunchinDetail> punchinDetails = punchinDetailRepository.findAll();
        // Logic to calculate the distance traveled based on punchin and punchout time
        double totalDistance = 0.0;
        for (PunchinDetail punchinDetail : punchinDetails) {
            if (Objects.equals(punchinDetail.getUser().getId(), userId) && punchinDetail.getPunchOutTime() != null) {
                Duration duration = Duration.between(punchinDetail.getPunchInTime(), punchinDetail.getPunchOutTime());
                double hours = duration.toMinutes() / 60.0;
                // Assuming speed in km/h (this value would depend on your business logic)
                double speed = 10; // Example speed
                totalDistance += hours * speed;
            }
        }
        return totalDistance;
    }
}
