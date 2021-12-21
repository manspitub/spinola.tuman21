package com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.modelo;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class DefaultErrorAttributes extends org.springframework.boot.web.servlet.error.DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAtributes = super.getErrorAttributes(webRequest,options);
        Map<String, Object> result = Map.of(
                "estado", errorAtributes.get("status"),
                "codigo", HttpStatus.valueOf((int) errorAtributes.get("status")).name(),
                "fecha", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm")),
                "ruta", errorAtributes.get("Path")
        );

        if(errorAtributes.containsKey("mesaje")){
            result.put("mesaje", errorAtributes.get("mesaje"));
        }

        if(errorAtributes.containsKey("errors")){
            result.put("subErrores", errorAtributes.get("errors"));
        }
        return result;
    }
}