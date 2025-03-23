package com.foringa.foringaforoservice.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion; 

    @OneToMany(mappedBy = "categoria")
    private List<Tema> temas;
}
