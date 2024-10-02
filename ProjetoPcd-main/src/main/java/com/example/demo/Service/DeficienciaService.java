package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;

@Service
public class DeficienciaService{
    @Autowired
    private DeficienciaRepository deficienciaRepository;

    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public Deficiencia create(DeficienciaForm deficienciaForm){
        Deficiencia deficiencia = new Deficiencia();
        
        deficiencia.setNome(deficienciaForm.getNome());
        deficiencia.setCategoria(deficienciaForm.getCategoria());
        this.deficienciaRepository.save(deficiencia);

        return deficiencia;
    }
    public Deficiencia update(DeficienciaForm deficienciaForm, Long id) {
        Deficiencia deficiencia = deficienciaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Deficiência não encontrada"));

        deficiencia.setNome(deficienciaForm.getNome());
        deficiencia.setCategoria(deficienciaForm.getCategoria());
        
        return deficienciaRepository.save(deficiencia);
    }

    public void delete(Long id) {
        Deficiencia deficiencia = deficienciaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Deficiência não encontrada"));

        deficienciaRepository.delete(deficiencia);
    }
}