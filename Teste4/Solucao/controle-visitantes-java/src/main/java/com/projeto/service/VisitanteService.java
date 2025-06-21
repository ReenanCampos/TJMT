package com.projeto.service;

import com.projeto.model.Visitante;
import com.projeto.repository.VisitanteRepository;

import java.time.LocalDateTime;
import java.util.List;

public class VisitanteService {

	private final VisitanteRepository repository = new VisitanteRepository();

	public void registrarEntrada(Visitante v) {
		int id = repository.salvar(v);
		if (id > 0) {
			System.out.println("Visitante registrado com ID: " + id + ", aguardando aprovação.");
		} else {
			System.out.println("Erro ao registrar visitante.");
		}
	}

	public void aprovarEntrada(int id) {
		Visitante v = repository.buscarPorId(id);

		if (v == null) {
			System.out.println("Visitante não encontrado.");
			return;
		}

		if (v.isAprovado()) {
			System.out.println("Entrada já está aprovada para visitante ID: " + id);
			return;
		}

		repository.aprovarEntrada(id);
		System.out.println("Entrada aprovada para visitante ID: " + id);
	}

	public void registrarSaida(int id) {
		Visitante v = repository.buscarPorId(id);

		if (v == null) {
			System.out.println("Visitante não encontrado.");
			return;
		}

		if (!v.isAprovado()) {
			System.out.println("Não é possível registrar saída. A entrada ainda não foi aprovada.");
			return;
		}

		if (v.getHorarioSaida() != null) {
			System.out.println("A saída já foi registrada para visitante ID: " + id);
			return;
		}

		repository.registrarSaida(id, LocalDateTime.now());
		System.out.println("Saída registrada para visitante ID: " + id);
	}

	public List<Visitante> listarVisitantesPresentes() {
		return repository.listarPresentes();
	}

}

