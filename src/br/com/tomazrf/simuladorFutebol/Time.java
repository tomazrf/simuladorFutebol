package br.com.tomazrf.simuladorFutebol;

import java.util.Comparator;
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
	
	public static Comparator<Time> getPontosComparator() {
        return new Comparator<Time>() {
        	public int compare(Time a, Time b) 
            { 
                return b.pontosNaTemporadaAtual - a.pontosNaTemporadaAtual; 
            } 
        };
    }
	
}
