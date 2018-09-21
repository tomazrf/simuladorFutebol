package br.com.tomazrf.simuladorFutebol;

import java.util.List;

public class Time {

	private String nome;
	private List<Jogador> jogadores;
	private int pontosNaTemporadaAtual;
	
	public Time(List<Jogador> jogadores, String nome){
		this.jogadores = jogadores;
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public int getPontosNaTemporadaAtual() {
		return pontosNaTemporadaAtual;
	}

	public void vitoriaPartida() {
		this.pontosNaTemporadaAtual += 3;
	}
	public void empatePartida() {
		this.pontosNaTemporadaAtual += 1;
	}
	
}
