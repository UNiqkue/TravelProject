package com.netcracker.travel.converter;

import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.dto.TravelAgencyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TourMapper {
    @Mappings({
            @Mapping(target = "id", source = "tour.id"),
            @Mapping(target="name", source = "tour.name"),
            @Mapping(target="description", source = "tour.description"),
            @Mapping(target="country", source = "tour.country"),
            @Mapping(target="startDate", source = "tour.startDate"),
            @Mapping(target="endDate", source = "tour.endDate"),
            @Mapping(target="price", source = "tour.price"),
            @Mapping(target="type", source = "tour.type"),
            @Mapping(target="free", source = "tour.free")})
    TourDTO tourToTourDTO(Tour tour);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target="name", source = "dto.name"),
            @Mapping(target="description", source = "dto.description"),
            @Mapping(target="country", source = "dto.country"),
            @Mapping(target="startDate", source = "dto.startDate"),
            @Mapping(target="endDate", source = "dto.endDate"),
            @Mapping(target="price", source = "dto.price"),
            @Mapping(target="type", source = "dto.type"),
            @Mapping(target="free", source = "dto.free")})
    Tour tourDTOtoTour(TourDTO dto);

    TravelAgency travelAgencyDTOtoTravelAgency(TravelAgencyDTO travelAgencyDto);

    TravelAgencyDTO travelAgencyToTravelAgencyDTO(TravelAgency travelAgency);

    Customer customerDTOtoCustomer(CustomerDTO customerDto);

    CustomerDTO customerToCustomerDTO(Customer customer);

}
