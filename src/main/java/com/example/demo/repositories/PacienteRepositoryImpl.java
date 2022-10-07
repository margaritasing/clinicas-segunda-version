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
public class PacienteRepositoryImpl implements PacienteRepository {

	private List<Paciente> pacientes = new ArrayList<>();

	public void inicializarPacientes() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaNacimiento = null;
		Date fechaTurnoMedico = null;
		Date otraFechaNacimiento = null;
		Date otraFechaTurnoMedico = null;
		try {
			fechaNacimiento = dateFormat.parse("1988-01-12");
			fechaTurnoMedico = dateFormat.parse("2022-09-21");
			otraFechaNacimiento = dateFormat.parse("1999-04-08");
			otraFechaTurnoMedico = dateFormat.parse("2022-09-21");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Medico> medicos = new ArrayList<Medico>();
		medicos.add(new Medico(1, "Carolina", "Glew", "cglew@email.com", "11111111", new Clinica(1, "Riobamba 2020", "Trinidad", "1111111"), DiaSemanaEnum.LUNES, true, new ArrayList<>()));
		Paciente unPaciente = new Paciente(1, "Julieta", "Gomez", "jugomez@email.com", 29, fechaNacimiento, "31236789", "123456", fechaTurnoMedico, medicos);
		Paciente otroPaciente = new Paciente(2, "Carolina", "Perez", "asdasdasdasd", 18, otraFechaNacimiento, "34568123", "1234444456", otraFechaTurnoMedico, medicos);
		pacientes.addAll(Arrays.asList(unPaciente, otroPaciente));
	}

	@Override
	public Paciente save(Paciente nuevoPaciente) {
		
		if(pacientes.isEmpty()) {
			inicializarPacientes();
		}

		nuevoPaciente.setPacienteId(pacientes.size() + 1);
		pacientes.add(nuevoPaciente);
		return nuevoPaciente;
	}

	@Override
	public List<Paciente> findAll() {
		return pacientes;
	}

}
