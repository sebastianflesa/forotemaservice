package com.foringa.foringaforoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foringa.foringaforoservice.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    Comentario save(Comentario comentario);
}
