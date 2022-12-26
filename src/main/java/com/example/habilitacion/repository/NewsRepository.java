
package com.example.habilitacion.repository;

import com.example.habilitacion.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer>{
    
}
