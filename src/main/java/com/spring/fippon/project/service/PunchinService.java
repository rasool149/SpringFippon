package com.spring.fippon.project.service;

import com.spring.fippon.project.entity.PunchinDetail;

import java.util.List;

public interface PunchinService {
    PunchinDetail setPunchinDetail(PunchinDetail punchinDetail);
    List<PunchinDetail> getPunchinDetail();

}
