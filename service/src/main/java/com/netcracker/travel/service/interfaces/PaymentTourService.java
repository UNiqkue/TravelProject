package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.TourDto;

import java.util.List;
import java.util.UUID;

public interface PaymentTourService {

    TourDto bookTour(UUID id, UUID customerId);
    TourDto buyTour(UUID id, UUID customerId);
    TourDto cancelTour(UUID tourId);
    List<TourDto> viewOrderedTours(UUID id);
}
