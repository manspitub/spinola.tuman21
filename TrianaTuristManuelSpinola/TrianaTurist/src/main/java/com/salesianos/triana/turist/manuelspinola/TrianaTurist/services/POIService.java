package com.salesianos.triana.turist.manuelspinola.TrianaTurist.services;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.POIDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.POIDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository repo;
    private final POIDto dto;
    private final POIDtoConverter poiDtoConverter;

    public POI create(POIDto poiDto){
        return repo.save(POI.builder()
                .category(poiDto.getCategory())
                .coverPhoto(poiDto.getCoverPhoto())
                .descripcion(poiDto.getDescripcion())
                .date(LocalDateTime.now())
                .name(poiDto.getName())
                .photo2(poiDto.getPhoto2())
                .ruta(poiDto.getRuta())
                .photo3(poiDto.getPhoto3())
                .location(poiDto.getLocation())
                .build());
    }

    public List<POIDto> findAll(){
        List<POIDto> poiDtos = repo.findAll().stream()
                .map(poiDtoConverter::poiToGetPOIDTO)
                .collect(Collectors.toList());
        return poiDtos;
    }

    public POI findOne(@PathVariable Long id){
        POI poi = repo.findById(id).orElse(null);
        return poi;
    }

    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }



}
