package com.example.demo.Controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;

import jakarta.validation.Valid;

@Controller
public class DeficienciaController {
    @Autowired
    private DeficienciaRepository deficienciaRepository;
    @Autowired
    private CategoriaRepository  categoriaRepository;

     @GetMapping("/deficiencia/create")
    public String create(Model model) {
        DeficienciaForm deficienciaForm = new deficienciaForm();
        List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();

        deficienciaForm.setListDeficiencias(listaDeficiencias);

        model.addAttribute("DeficienciaForm", deficienciaForm);
        return "deficiencia/create";
    }
     @PostMapping("/deficiencia/create")
    public String create(@Valid DeficienciaForm deficienciaForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
        deficienciaForm.setListDeficiencias(listaDeficiencias);

        model.addAttribute("deficienciaForm", deficienciaForm);
        
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/deficiencia/create";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Salvo com sucesso!");
        deficienciaService.create(deficienciaForm);        
        return "redirect:/deficiencia"
    }
}
