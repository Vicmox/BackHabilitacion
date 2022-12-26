package com.example.habilitacion.controller;

import com.example.habilitacion.entity.News;
import com.example.habilitacion.repository.NewsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @GetMapping
    public List<News> getNewsAll() {

        return newsRepository.findAll();
    }

    @GetMapping("/{id}")
    public News getNewsbyId(@PathVariable Integer id) {

        Optional<News> news = newsRepository.findById(id);

        if (news.isPresent()) {
            return news.get();
        }

        return null;

    }

    @PostMapping
    public News postNews(@RequestBody News news) {

        newsRepository.save(news);

        return news;

    }

    @PutMapping("/{id}")
    public News putNewsbyId(@PathVariable Integer id, @RequestBody News news) {

        Optional<News> newsCurrent = newsRepository.findById(id);

        if (newsCurrent.isPresent()) {

            News newsReturn = newsCurrent.get();

            newsReturn.setTitulo(news.getTitulo());
            newsReturn.setDesarrollo(news.getDesarrollo());
            newsReturn.setFecha(news.getFecha());
            newsReturn.setUrl(news.getUrl());
            newsReturn.setResumen(news.getResumen());

            newsRepository.save(newsReturn);

            return newsReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public News deleteNewsbyId(@PathVariable Integer id) {

        Optional<News> news = newsRepository.findById(id);

        if (news.isPresent()) {

            News newsReturn = news.get();

            newsRepository.deleteById(id);

            return newsReturn;
        }

        return null;

    }
}
