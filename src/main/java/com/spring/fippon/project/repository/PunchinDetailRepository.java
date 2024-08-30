package com.spring.fippon.project.repository;

import com.spring.fippon.project.entity.PunchinDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunchinDetailRepository extends JpaRepository<PunchinDetail, Long> {
}
