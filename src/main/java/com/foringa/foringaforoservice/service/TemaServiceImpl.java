package com.foringa.foringaforoservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foringa.foringaforoservice.dto.ComentarioDTO;
import com.foringa.foringaforoservice.dto.TemaDTO;
import com.foringa.foringaforoservice.model.Categoria;
import com.foringa.foringaforoservice.model.Comentario;
import com.foringa.foringaforoservice.model.Tema;
import com.foringa.foringaforoservice.repository.CategoriaRepository;
import com.foringa.foringaforoservice.repository.ComentarioRepository;
import com.foringa.foringaforoservice.repository.TemaRepository;

import jakarta.transaction.Transactional;

@Service
public class TemaServiceImpl implements TemaService {
    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Transactional
    @Override
    public Tema crearTema(TemaDTO temaDTO) {
        Tema tema = new Tema();
        tema.setTitulo(temaDTO.getTitulo());
        tema.setContenido(temaDTO.getContenido());
        tema.setFechaCreacion(temaDTO.getFechaCreacion());
        tema.setPublicado(temaDTO.getPublicado());
        tema.setUsuarioId(temaDTO.getUsuarioId());
        Categoria categoria = categoriaRepository.findById(Long.valueOf(temaDTO.getCategoriaId())).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        tema.setCategoria(categoria);

        return temaRepository.save(tema);
    }

    @Override
    public Tema guardarTema(TemaDTO temaDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarTema'");
    }

    @Override
    public List listarTemas() {
        List<Tema> temas = temaRepository.findAll();
        return temas.stream().map(tema -> {
            TemaDTO temaDTO = new TemaDTO();
            temaDTO.setId(tema.getId());
            temaDTO.setTitulo(tema.getTitulo());
            temaDTO.setContenido(tema.getContenido());
            temaDTO.setFechaCreacion(tema.getFechaCreacion());
            temaDTO.setUsuarioId(tema.getUsuarioId());
            temaDTO.setPublicado(tema.getPublicado());
            Categoria categoria = tema.getCategoria();
            temaDTO.setCategoriaId(categoria.getId().intValue());
            return temaDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<TemaDTO> listarTemasPorCategoria(Long id) {
        List<Tema> temas = temaRepository.findByCategoriaId(id);
        return temas.stream().map(tema -> {
            TemaDTO temaDTO = new TemaDTO();
            temaDTO.setId(tema.getId());
            temaDTO.setTitulo(tema.getTitulo());
            temaDTO.setContenido(tema.getContenido());
            temaDTO.setFechaCreacion(tema.getFechaCreacion());
            temaDTO.setUsuarioId(tema.getUsuarioId());
            temaDTO.setPublicado(tema.getPublicado());
            Categoria categoria = tema.getCategoria();
            temaDTO.setCategoriaId(categoria.getId().intValue());
            return temaDTO;
        }).collect(Collectors.toList());
        
    }

    @Override
    public TemaDTO listarTemaPorId(Long id) {
        Optional<Tema> tema = temaRepository.findById(id);
        if (tema.isPresent()) {
            TemaDTO temaDTO = new TemaDTO();
            temaDTO.setId(tema.get().getId());
            temaDTO.setTitulo(tema.get().getTitulo());
            temaDTO.setContenido(tema.get().getContenido());
            temaDTO.setFechaCreacion(tema.get().getFechaCreacion());
            temaDTO.setUsuarioId(tema.get().getUsuarioId());
            temaDTO.setPublicado(tema.get().getPublicado());
            Categoria categoria = tema.get().getCategoria();
            temaDTO.setCategoriaId(categoria.getId().intValue());
            return temaDTO;
        } else {
            return null;
            
        }
    }

    @Override
    public TemaDTO comentarTema(Long id, ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();
        comentario.setContenido(comentarioDTO.getContenido());
        //private LocalDate fechaComentario;
        comentario.setFechaCreacion(comentarioDTO.getFechaCreacion());
        comentario.setUsuarioId(comentarioDTO.getUsuarioId());
        Tema tema = temaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tema no encontrado"));
        comentario.setTema(tema);
        comentarioRepository.save(comentario);
        return listarTemaPorId(id);

    }

    




}
