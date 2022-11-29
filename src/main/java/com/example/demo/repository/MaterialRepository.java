package com.example.demo.repository;

import com.example.demo.entity.Material;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    public Optional<Material> findByNombreMaterial(String nombreMaterial);
    
    public boolean existsByNombreMaterial(String nombreMaterial);

}
