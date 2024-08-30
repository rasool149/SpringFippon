package com.spring.fippon.project.controller;

import com.spring.fippon.project.entity.PunchinDetail;
import com.spring.fippon.project.service.PunchinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/punchin")
public class PunchinDetailController {

    @Autowired
    private PunchinService punchinService;

    @PostMapping("/add")
    public PunchinDetail addPunchinDetail(@RequestBody PunchinDetail punchinDetail) {
        return punchinService.setPunchinDetail(punchinDetail);
    }

    @GetMapping("/all")
    public List<PunchinDetail> getAllPunchinDetails() {
        return punchinService.getPunchinDetail();
    }
}
