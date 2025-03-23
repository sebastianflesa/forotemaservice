package com.foringa.foringaforoservice.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foringa.foringaforoservice.model.Categoria;
import com.foringa.foringaforoservice.model.Tema;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findById(Long categoriaId);
    
}
