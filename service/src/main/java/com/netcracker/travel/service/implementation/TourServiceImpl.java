package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.repository.TourRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TourServiceImpl {

    private final TourRepository tourRepository;
    private final TourConverter tourConverter;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, TourConverter tourConverter) {
        this.tourRepository = tourRepository;
        this.tourConverter = tourConverter;
    }

    @Transactional
    public List<TourDto> getAll() {
        return StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public TourDto add(TourDto tourDto) {
        tourDto.setId(UUID.randomUUID().toString().replace("-", ""));
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    @Transactional
    public TourDto update(TourDto tourDto) {
        return tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
    }

    @Transactional
    public TourDto get(String id) {
        TourDto tourDto = new TourDto();
        BeanUtils.copyProperties(tourRepository.findOne(id), tourDto);
        return tourDto;
    }

    @Transactional
    public void delete(String id) {
            tourRepository.delete(id);
    }
}
