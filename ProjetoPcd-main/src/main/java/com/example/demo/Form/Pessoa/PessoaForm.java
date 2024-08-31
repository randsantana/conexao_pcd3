package com.example.demo.Form.Pessoa;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.Enum.Sexo;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.DeficienciaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class PessoaForm {

    @NotBlank(message = "Preencha o campo nome.")
    private String nome;
    
    @NotNull(message = "Preencha o campo data de nascimento.")
    @Past(message = "Data invalida.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "Preencha o campo sexo.")
    private int sexo;

    @NotNull(message = "Qual sua deficiencia?")
    private Deficiencia deficiencia;
    private List<Deficiencia> listDeficiencias;
    
    @NotBlank(message = "Preencha o CEP.")
    @Size(min = 5, max = 9, message = "Preencha com um CEP valido")
    private String cep;
    
    
    private String uf;

    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    
    }
    

