package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import org.springframework.stereotype.Component;

@Component

public class RouteDtoConverter {

    private Route createRouteToRoute(RouteDto r){
        return new Route(
                r.getName(),
                r.getSteps()
        );
    }

    public RouteDto routeToGetRouteDto(Route r){
        return RouteDto
                .builder()
                .name(r.getName())
                .steps(r.getSteps())
                .build();
    }

}
