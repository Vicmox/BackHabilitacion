package com.example.habilitacion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "news")
public class News {

    @Id
    @SequenceGenerator(name = "news_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_id_seq")
    private int id;
    private String titulo;
    private String desarrollo;
    private String fecha;
    private String url;
    private String resumen;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
