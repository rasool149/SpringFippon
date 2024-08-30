package com.spring.fippon.project.service;

import com.spring.fippon.project.entity.ActivityDetail;

import java.util.List;

public interface ActivityService {
    ActivityDetail setActivityDetail(ActivityDetail activityDetail);
    List<ActivityDetail> getAllActivityDetail();
    ActivityDetail getActivityDetailById(Long id);
    void deleteActivityDetail(Long id);
    ActivityDetail saveActivityDetail(ActivityDetail activityDetail);
}
