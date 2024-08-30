package com.spring.fippon.project.service;

import com.spring.fippon.project.entity.PunchinDetail;
import com.spring.fippon.project.repository.PunchinDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PunchinServiceimpl implements PunchinService {

    @Autowired
    private PunchinDetailRepository punchinDetailRepository;

    @Override
    public PunchinDetail setPunchinDetail(PunchinDetail punchinDetail) {
        // Calculate distance traveled based on latitude and longitude
        double distance = calculateDistance(
                punchinDetail.getPunchInLatitude(),
                punchinDetail.getPunchInLongitude(),
                punchinDetail.getPunchOutLatitude(),
                punchinDetail.getPunchOutLongitude()
        );

        // Set the calculated distance
        punchinDetail.setDistanceTraveled(distance);

        // Save to the database
        return punchinDetailRepository.save(punchinDetail);
    }

    @Override
    public List<PunchinDetail> getPunchinDetail() {
        return punchinDetailRepository.findAll();
    }

    /**
     * Calculates the distance traveled based on GPS coordinates using the Haversine formula.
     *
     * @param lat1 Latitude of the punch-in location
     * @param lon1 Longitude of the punch-in location
     * @param lat2 Latitude of the punch-out location
     * @param lon2 Longitude of the punch-out location
     * @return Distance in kilometers
     */
    private double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        if (lat1 == null || lon1 == null || lat2 == null || lon2 == null) {
            return 0.0;
        }

        final int R = 6371; // Radius of the Earth in kilometers

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Convert to kilometers
        return R * c;
    }
}
