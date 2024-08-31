package com.example.demo.Model;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;

import com.example.demo.Enum.Sexo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ativo", nullable = false)
    @ColumnDefault("true")
    private boolean ativo = true;

    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;
    
    @Column(name = "nome", nullable = false, length = 100, unique = false)
    private String nome;
    
    @Column(name = "sexo", nullable = false)
    @ColumnDefault("2")
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo = Sexo.NAO_INFORMADO;

    @ManyToOne
    @JoinColumn(name = "deficiencia_id")
    private Deficiencia deficiencia;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    public Pessoa(String nome, LocalDate dataNascimento, Sexo sexo){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    
    }

}

    