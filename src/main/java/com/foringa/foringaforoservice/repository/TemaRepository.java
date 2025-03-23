package com.foringa.foringaforoservice.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foringa.foringaforoservice.dto.TemaDTO;
import com.foringa.foringaforoservice.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    Tema save(Tema tema);
    List<Tema> findAll();
    Optional<Tema> findById(Long id);

    @Query("SELECT t FROM Tema t WHERE t.categoria.id = ?1")
    List<Tema> findByCategoriaId(Long categoriaId);

}
