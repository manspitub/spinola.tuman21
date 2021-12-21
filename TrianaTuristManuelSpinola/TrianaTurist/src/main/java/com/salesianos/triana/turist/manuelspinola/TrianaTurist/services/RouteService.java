package com.salesianos.triana.turist.manuelspinola.TrianaTurist.services;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.RouteDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.RouteDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.ListEntityNotFoundException;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.PoiAlreadyExistsInRouteException;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.POIRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {


    private final RouteRepository repo;
    private final POIRepository poiRepo;
    private final RouteDtoConverter converter;
    private final POIService poiService;


    public Route create(RouteDto routeDto) {
        return repo.save(Route.builder()
                .name(routeDto.getName())
                .steps(routeDto.getSteps())
                .build());
    }

    public List<Route> findAll() {
        List<Route> result = repo.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }

    public Route findOne(@PathVariable Long id) {
        Route ruta = repo.findById(id).orElse(null);

        return ruta;
    }

    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    public Route addStepToRoute(Long idRoute, Long idPoi) {
        Route ruta = findOne(idRoute);
        POI step = poiService.findOne(idPoi);
        if (ruta.getSteps().contains(step)) {
            throw new PoiAlreadyExistsInRouteException(idPoi.toString(), idRoute.toString());
        } else {
            ruta.addStep(step);
            repo.save(ruta);
            poiRepo.save(step);
            return ruta;
        }

    }
}
