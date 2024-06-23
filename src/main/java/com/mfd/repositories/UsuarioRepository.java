package com.mfd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfd.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
