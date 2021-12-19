package com.salesianos.triana.turist.manuelspinola.TrianaTurist.services;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.RouteDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.RouteDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {


    private final RouteRepository repo;
    private final RouteDto dto;
    private final RouteDtoConverter converter;


    public Route create(RouteDto routeDto){
        return repo.save(Route.builder()
                .name(routeDto.getName())
                .steps(routeDto.getSteps())
                .build());
    }

    public List<RouteDto> findAll(){
        List<RouteDto> rutas = repo.findAll().stream()
                .map(converter::routeToGetRouteDto).collect(Collectors.toList());

        return rutas;
    }

    public Route findOne(@PathVariable Long id){
        Route ruta = repo.findById(id).orElse(null);

        return ruta;
    }

    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }

}
