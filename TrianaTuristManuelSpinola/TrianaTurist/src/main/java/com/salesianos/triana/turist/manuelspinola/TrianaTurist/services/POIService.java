package com.salesianos.triana.turist.manuelspinola.TrianaTurist.services;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.POIDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.POIDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.ListEntityNotFoundException;
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
    private final POIDtoConverter poiDtoConverter;

    public POI create(POIDto poiDto){
        return repo.save(POI.builder()
                .coverPhoto(poiDto.getCoverPhoto())
                .descripcion(poiDto.getDescripcion())
                .date(LocalDateTime.now())
                .name(poiDto.getName())
                .photo2(poiDto.getPhoto2())
                .routes(poiDto.getRuta())
                .photo3(poiDto.getPhoto3())
                .location(poiDto.getLocation())
                .build());
    }

    public List<POI> findAll(){
        List<POI> result = repo.findAll();

        if (result.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }

    public POI findOne(@PathVariable Long id){
        POI poi = repo.findById(id).orElse(null);
        return poi;
    }

    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }



}
