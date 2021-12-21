package com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ApiError {

    private HttpStatus estado;
    private int codigo;
    private String mensaje;
    private String ruta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime fecha;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ApiSubError> subErrores;

    public ApiError(HttpStatus estado, String mensaje, String ruta){
        this.estado = estado;
        this.codigo = estado.value();
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
        this.ruta = ruta;
    }

    public ApiError(HttpStatus estado, String mensaje, String ruta, List<ApiSubError> subErrores){
        this(estado, mensaje, ruta);
        this.subErrores = subErrores;
    }

}