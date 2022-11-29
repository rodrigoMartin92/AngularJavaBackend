package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materiales")
@Getter @Setter @NoArgsConstructor
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombreMaterial")
    private String nombreMaterial;

    @Column(name = "precioMaterial")
    private double precioMaterial;

    public Material(String nombreMaterial, double precioMaterial) {
        this.nombreMaterial = nombreMaterial;
        this.precioMaterial = precioMaterial;
    }
}
