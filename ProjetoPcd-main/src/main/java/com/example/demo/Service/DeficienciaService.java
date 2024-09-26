package com.example.demo.Service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;

@Service
public class DeficienciaService {
    @Autowired
    private DeficienciaRepository deficienciaRepository;

    private CategoriaRepository categoriaRepository;

    public List<Deficiencia> findAll
}
