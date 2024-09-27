package com.example.demo.Form.Deficiencia;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class DeficienciaForm {
    @NotBlank(message = "Preencha o campo nome.")
    private String nome;
}
