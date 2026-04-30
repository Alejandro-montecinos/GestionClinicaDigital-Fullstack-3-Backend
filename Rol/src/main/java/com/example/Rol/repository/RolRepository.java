package com.example.Rol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Rol.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    
}
