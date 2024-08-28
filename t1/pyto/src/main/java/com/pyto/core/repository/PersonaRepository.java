package com.pyto.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pyto.core.model.PersonaModel;

public interface PersonaRepository extends JpaRepository<PersonaModel, Integer>{

}
