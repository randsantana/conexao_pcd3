package com.example.demo.Service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Form.Pessoa.PessoaForm;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;

@Service
public class DeficienciaService {
    @Autowired
    private DeficienciaRepository deficienciaRepository;

    private CategoriaRepository categoriaRepository;

    public List<Deficiencia> findAll(){
        return DeficienciaRepository.findAll();
    }
    public Deficiencia create(DeficienciaForm deficienciaForm){
        Deficiencia deficiencia = new Deficiencia();
        deficiencia.setNome(deficienciaForm.getNome());


        return deficiencia;
    }
}