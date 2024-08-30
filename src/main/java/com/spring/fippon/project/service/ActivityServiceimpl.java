package com.spring.fippon.project.service;

import com.spring.fippon.project.entity.ActivityDetail;
import com.spring.fippon.project.repository.ActivityDetailRepository; // Ensure this is imported
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceimpl implements ActivityService {

    private final ActivityDetailRepository activityDetailRepository;

    @Autowired
    public ActivityServiceimpl(ActivityDetailRepository activityDetailRepository) {
        this.activityDetailRepository = activityDetailRepository;
    }

    @Override
    public ActivityDetail saveActivityDetail(ActivityDetail activityDetail) {
        return activityDetailRepository.save(activityDetail);
    }

    @Override
    public List<ActivityDetail> getAllActivityDetail() {
        return activityDetailRepository.findAll();
    }

    @Override
    public ActivityDetail getActivityDetailById(Long id) {
        Optional<ActivityDetail> activityDetail = activityDetailRepository.findById(id);
        return activityDetail.orElse(null);
    }

    @Override
    public void deleteActivityDetail(Long id) {
        activityDetailRepository.deleteById(id);
    }

    @Override
    public ActivityDetail setActivityDetail(ActivityDetail activityDetail) {
        // If you intend to use this method, make sure it's implemented properly.
        return null;
    }
}
