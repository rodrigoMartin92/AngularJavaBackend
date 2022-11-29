package com.example.demo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MaterialDto implements Serializable {

    @NotBlank
    private String nombreMaterial;

    @NotBlank
    private double precioMaterial;

}
