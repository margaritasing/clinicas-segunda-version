package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Paciente;

public interface PacienteRepository {

	Paciente save(Paciente nuevoPaciente);

	List<Paciente> findAll();

}
