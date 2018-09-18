package br.com.tomazrf.simuladorFutebol;

import java.util.Comparator;
import java.util.List;

public class Jogador {
	
	private String nome;
	private int nivel;
	private String posicao;
	private Time time;
	private List<Integer> golsPorTemporada;
	private int golsNaTemporadaAtual;
	
	public static final String codigoGoleiro = "GK";
	public static final String codigoDefensor= "DE";
	public static final String codigoMeioCampo = "ME";
	public static final String codigoAtacante = "AT";
	
	public Jogador(String posicao, String nome, int nivel){
		this.nome = nome;
		this.nivel = nivel;
		this.posicao = posicao;
	}
	
	public String getNome() {
		return nome;
	}
	public int getNivel() {
		return nivel;
	}
	public String getPosicao() {
		return posicao;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public List<Integer> getGolsPorTemporada() {
		return golsPorTemporada;
	}
	public void setGolsPorTemporada(List<Integer> golsPorTemporada) {
		this.golsPorTemporada = golsPorTemporada;
	}
	public int getGolsNaTemporadaAtual() {
		return golsNaTemporadaAtual;
	}
	public void somaGol(){
		++this.golsNaTemporadaAtual;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	public String desempenhoTemporada(){
		return "Nome: " + nome + ", Gols: " + golsNaTemporadaAtual;
	}
	
	public static Comparator<Jogador> getGolsComparator() {
        return new Comparator<Jogador>() {
        	public int compare(Jogador a, Jogador b) 
            { 
                return b.golsNaTemporadaAtual - a.golsNaTemporadaAtual; 
            } 
        };
    }
	
	
	
}
