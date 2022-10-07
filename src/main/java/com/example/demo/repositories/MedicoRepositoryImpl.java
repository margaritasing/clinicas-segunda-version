package com.example.demo.repositories;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Clinica;
import com.example.demo.entities.DiaSemanaEnum;
import com.example.demo.entities.Medico;
import com.example.demo.entities.Paciente;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository {
	
	private List<Medico> medicos = new ArrayList<>();
	
	public void inicializarMedicos() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaNacimientoUno = null;
		Date fechaTurnoMedicoUno = null;
		Date fechaNacimientoDos = null;
		Date fechaTurnoMedicoDos = null;
		
		try {
			fechaNacimientoUno = dateFormat.parse("1988-01-12");
			fechaTurnoMedicoUno = dateFormat.parse("2022-09-21");
			fechaNacimientoDos = dateFormat.parse("1995-04-18");
			fechaTurnoMedicoDos = dateFormat.parse("2022-09-21");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Paciente> pacientes = Arrays.asList(
				new Paciente(1, "Julieta", "Gomez", "jugomez@email.com", 29, fechaNacimientoUno, "31236789", "123456", fechaTurnoMedicoUno, new ArrayList<>()), 
				new Paciente(2, "Carolina", "Galvez", "asdasdasd", 15, fechaNacimientoDos, "31236789", "123456", fechaTurnoMedicoDos, new ArrayList<>())
			);
		
		medicos.add(new Medico(1, "Carolina", "Glew", "cglew@email.com", "11111111", new Clinica(1, "Riobamba 2020", "Trinidad", "1111111"), DiaSemanaEnum.LUNES, true, pacientes));
		medicos.add(new Medico(2, "Monica", "Marshall", "mmarshal@email.com", "22222", new Clinica(1, "Riobamba 2020", "Trinidad", "1111111"), DiaSemanaEnum.JUEVES, true, pacientes));
	}

	@Override
	public Medico save(Medico nuevoMedico) {
		
		if(medicos.isEmpty()) {
			inicializarMedicos();
		}
		
		nuevoMedico.setMedicoId(medicos.size() + 1);
		medicos.add(nuevoMedico);
		return nuevoMedico;
	}

	@Override
	public List<Medico> findAll() {
		return medicos;
	}

}
