package com.example.demo.Model;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;

import com.example.demo.Enum.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
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

    public Pessoa(LocalDate dataNascimento, Deficiencia deficiencia, Endereco endereco, Long id, String nome) {
        this.dataNascimento = dataNascimento;
        this.deficiencia = deficiencia;
        this.endereco = endereco;
        this.id = id;
        this.nome = nome;
    }
}