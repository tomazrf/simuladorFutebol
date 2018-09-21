package br.com.tomazrf.simuladorFutebol;

public class EstatisticaCampeonato {
	
	private int somaGols;
	private double mediaGols;
	
	public EstatisticaCampeonato(int somaGols, double mediaGols){
		this.mediaGols = mediaGols;
		this.somaGols = somaGols;
	}

	public int getSomaGols() {
		return somaGols;
	}
	public double getMediaGols() {
		return mediaGols;
	}
	
}
