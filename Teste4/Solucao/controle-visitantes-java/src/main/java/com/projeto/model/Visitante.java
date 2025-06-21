package com.projeto.model;

import java.time.LocalDateTime;

public class Visitante {

	private int id;
	private String nome;
	private String motivo;
	private LocalDateTime horarioEntrada;
	private LocalDateTime horarioSaida;
	private boolean aprovado;

	public Visitante() {
	}

	public Visitante(String nome, String motivo) {
		this.nome = nome;
		this.motivo = motivo;
		this.horarioEntrada = LocalDateTime.now();
		this.aprovado = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDateTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalDateTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
}
