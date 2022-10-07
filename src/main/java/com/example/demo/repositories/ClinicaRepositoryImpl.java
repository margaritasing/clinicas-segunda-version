package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Clinica;

@Repository
public class ClinicaRepositoryImpl implements ClinicaRepository {
	
	private List<Clinica> clinicas = new ArrayList<>();
	
	public void inicializarClinicas() {		
		clinicas.add(new Clinica(1, "Riobamba 2020", "Trinidad", "1111111"));
	}

	@Override
	public Clinica save(Clinica nuevaClinica) {
		
		if(clinicas.isEmpty()) {
			inicializarClinicas();
		}
		
		nuevaClinica.setClinicaId(clinicas.size() + 1);
		clinicas.add(nuevaClinica);
		return nuevaClinica;
	}

	public List<Clinica> findAll() {
		return clinicas;
	}

}
