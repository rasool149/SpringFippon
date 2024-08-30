package com.spring.fippon.project.controller;

import com.spring.fippon.project.entity.ActivityDetail;
import com.spring.fippon.project.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityDetailController {

    private final ActivityService activityService;

    @Autowired
    public ActivityDetailController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/add")
    public ResponseEntity<ActivityDetail> addActivityDetail(@RequestBody ActivityDetail activityDetail) {
        ActivityDetail savedActivity = activityService.saveActivityDetail(activityDetail);
        return ResponseEntity.ok(savedActivity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ActivityDetail>> getAllActivityDetails() {
        List<ActivityDetail> activities = activityService.getAllActivityDetail();
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDetail> getActivityDetailById(@PathVariable Long id) {
        ActivityDetail activity = activityService.getActivityDetailById(id);
        if (activity != null) {
            return ResponseEntity.ok(activity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteActivityDetail(@PathVariable Long id) {
        activityService.deleteActivityDetail(id);
        return ResponseEntity.noContent().build();
    }
}
