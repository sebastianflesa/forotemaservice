package com.foringa.foringaforoservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TemaDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private Integer publicado;
    private LocalDate fechaCreacion;
    private Integer usuarioId;
    private Integer categoriaId;
}
