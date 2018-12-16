package com.netcracker.travel.converter;

import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TourDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CustomerMapper {
    @Mappings({
            @Mapping(target = "id", source = "customer.id"),
            @Mapping(target="firstName", source = "customer.firstName"),
            @Mapping(target="lastName", source = "customer.lastName"),
            @Mapping(target="username", source = "customer.username"),
            @Mapping(target="password", source = "customer.password"),
            @Mapping(target="email", source = "customer.email"),
            @Mapping(target="activationCode", source = "customer.activationCode"),
            @Mapping(target="phoneNumber", source = "customer.phoneNumber"),
            @Mapping(target="cardNumber", source = "customer.cardNumber"),
            @Mapping(target="passportInfo", source = "customer.passportInfo"),
            @Mapping(target="dateOfBirth", source = "customer.dateOfBirth"),
            @Mapping(target="role", source = "customer.role")})
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mappings({
            @Mapping(target = "id", source = "customerDTO.id"),
            @Mapping(target="firstName", source = "customerDTO.firstName"),
            @Mapping(target="lastName", source = "customerDTO.lastName"),
            @Mapping(target="username", source = "customerDTO.username"),
            @Mapping(target="password", source = "customerDTO.password"),
            @Mapping(target="email", source = "customerDTO.email"),
            @Mapping(target="activationCode", source = "customerDTO.activationCode"),
            @Mapping(target="phoneNumber", source = "customerDTO.phoneNumber"),
            @Mapping(target="cardNumber", source = "customerDTO.cardNumber"),
            @Mapping(target="passportInfo", source = "customerDTO.passportInfo"),
            @Mapping(target="dateOfBirth", source = "customerDTO.dateOfBirth"),
            @Mapping(target="role", source = "customerDTO.role")})
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);

    Tour tourDTOtoTour(TourDTO tourDto);

    TourDTO tourToTourDTO(Tour tour);
}
