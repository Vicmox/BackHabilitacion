/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.habilitacion.repository;


import com.example.habilitacion.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author estudiante
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
