package com.example.demo.service;

import com.example.demo.entity.Material;
import com.example.demo.repository.MaterialRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MaterialService {

    @Autowired
    MaterialRepository materialRepo;

    //create
    public void save(Material material) { //En lugar de "nombreMaterial" estaba escrito "material"
        materialRepo.save(material); //En lugar de "nombreMaterial" estaba escrito "material"
    }

    //read
    public List<Material> list() {
        return materialRepo.findAll();
    }

    public Optional<Material> getById(int id) {
        return materialRepo.findById(id);
    }

    public Optional<Material> getByNombre(String nombreMaterial) {
        return materialRepo.findByNombreMaterial(nombreMaterial);
    }

    //update
    //delete
    public void delete(int id) {
        materialRepo.deleteById(id);
    }

    public boolean existById(int id) {
        return materialRepo.existsById(id);
    }

    public boolean existsByNombre(String nombreMaterial) {//En lugar de "nombreMaterial" estaba escrito "nombre"
        return materialRepo.existsByNombreMaterial(nombreMaterial);//En lugar de "nombreMaterial" estaba escrito "nombre"
    }

}
