package br.com.tomazrf.simuladorFutebol;

public class Jogador {
	
	private String nome;
	private int nivel;
	private String posicao;
	private Time time;
	
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

	@Override
	public String toString() {
		return nome;
	}
	
}
