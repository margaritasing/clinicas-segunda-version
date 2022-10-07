package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Medico;

public interface MedicoRepository {

	Medico save(Medico nuevoMedico);

	List<Medico> findAll();

}
