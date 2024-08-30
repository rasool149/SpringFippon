package com.spring.fippon.project.repository;

import com.spring.fippon.project.entity.ActivityDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDetailRepository extends JpaRepository<ActivityDetail, Long> {
}
