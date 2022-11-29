package com.example.demo.controller;

import com.example.demo.dto.MaterialDto;
import com.example.demo.entity.Material;
import com.example.demo.service.MaterialService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class MaterialController {

    @Autowired
    private MaterialService materialServ;

    //trae todos los registros de la base de datos
    @GetMapping("/vertodos")
    public ResponseEntity<List<Material>> list() {
        List<Material> materiales = materialServ.list();
        return ResponseEntity.status(HttpStatus.OK).body(materiales);
    }

    //traer un material por id
    @GetMapping("/ver/{id}")
    public ResponseEntity<Material> getById(@PathVariable("id") int id) {
        if (!materialServ.existById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Material material = materialServ.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(material);

    }

    //borrar un material {}
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!materialServ.existById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        materialServ.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //crear un material
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody MaterialDto dtoMaterial) {
        if (StringUtils.isBlank(dtoMaterial.getNombreMaterial())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            //017 API Rest - minuto 1:11:00 del video
        } else if (materialServ.existsByNombre(dtoMaterial.getNombreMaterial())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Material material = new Material(dtoMaterial.getNombreMaterial(), 
                dtoMaterial.getPrecioMaterial());

        materialServ.save(material);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //editar un material
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody MaterialDto dtoMaterial) {
        if (!materialServ.existById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 
        
        else if (StringUtils.isBlank(dtoMaterial.getNombreMaterial())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } 
        
        else if (materialServ.existsByNombre(dtoMaterial.getNombreMaterial())
                && materialServ.getByNombre(dtoMaterial.getNombreMaterial()).get().getId() != id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        Material material = materialServ.getById(id).get();
        material.setNombreMaterial(dtoMaterial.getNombreMaterial());
        material.setPrecioMaterial(dtoMaterial.getPrecioMaterial());
        
        materialServ.save(material);
        return ResponseEntity.status(HttpStatus.OK).build();
        
    }

}
