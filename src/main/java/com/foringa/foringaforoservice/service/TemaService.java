package com.foringa.foringaforoservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foringa.foringaforoservice.dto.ComentarioDTO;
import com.foringa.foringaforoservice.dto.TemaDTO;
import com.foringa.foringaforoservice.model.Tema;

@Service
public interface TemaService {
    Tema crearTema(TemaDTO tema);

    Tema guardarTema(TemaDTO temaDTO);

    List<TemaDTO> listarTemas();

    List<TemaDTO> listarTemasPorCategoria(Long id);

    TemaDTO listarTemaPorId(Long id);

    TemaDTO comentarTema(Long id, ComentarioDTO comentarioDTO);

}
