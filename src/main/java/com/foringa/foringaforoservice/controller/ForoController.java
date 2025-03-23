package com.foringa.foringaforoservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.foringa.foringaforoservice.dto.ResponseDTO;
import com.foringa.foringaforoservice.dto.ComentarioDTO;
import com.foringa.foringaforoservice.dto.TemaDTO;
import com.foringa.foringaforoservice.model.Categoria;
import com.foringa.foringaforoservice.model.Tema;
import com.foringa.foringaforoservice.service.TemaService;

@RestController
@RequestMapping("/foro")
public class ForoController {
    
    @Autowired
    private TemaService temaService;

    @PostMapping("/temas/crear")
    public ResponseEntity<ResponseDTO> crearTema(@RequestBody TemaDTO temaDTO) {
        Tema tema = temaService.crearTema(temaDTO);
        if (tema == null) {
        ResponseDTO response = new ResponseDTO(false, "Error al crear el tema", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            ResponseDTO response = new ResponseDTO(false, "Tema creado con exito", temaDTO);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/temas")
    public ResponseEntity<ResponseDTO> listarTemas() {
        List<TemaDTO> temas = temaService.listarTemas();
        if (temas == null) {
            ResponseDTO response = new ResponseDTO(false, "Error al listar los temas", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            ResponseDTO response = new ResponseDTO(true, "Temas listados con éxito", temas);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/temas/categoria/{id}")
    public ResponseEntity<ResponseDTO> listarTemasPorCategoria(@PathVariable Long id) {
        List<TemaDTO> temas = temaService.listarTemasPorCategoria(id);
        if (temas == null) {
            ResponseDTO response = new ResponseDTO(false, "Error al listar los temas", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            ResponseDTO response = new ResponseDTO(true, "OK", temas);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/temas/{id}")
    public ResponseEntity<ResponseDTO> listarTemaPorId(@PathVariable Long id) {
        TemaDTO tema = temaService.listarTemaPorId(id);
        if (tema == null) {
            ResponseDTO response = new ResponseDTO(false, "Error al listar el tema", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            ResponseDTO response = new ResponseDTO(true, "OK", tema);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/temas/{id}/comentar")
    public ResponseEntity<ResponseDTO> comentarTema(@PathVariable Long id, @RequestBody ComentarioDTO comentario) {
        TemaDTO tema = temaService.comentarTema(id, comentario);
        if (tema == null) {
            ResponseDTO response = new ResponseDTO(false, "Error al comentar el tema", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            ResponseDTO response = new ResponseDTO(true, "OK", tema);
            return ResponseEntity.ok(response);
        }
    }

    
}
