package br.com.tomazrf.simuladorFutebol;

import java.util.ArrayList;
import java.util.List;

public class EstatisticaPartida {
	
	private List<Jogador> golsTimeCasa;
	private List<Jogador> golsTimeFora;
	
	public EstatisticaPartida(){
		this.golsTimeCasa = new ArrayList<>();
		this.golsTimeFora = new ArrayList<>();
	}
	
	public List<Jogador> getGolsTimeCasa() {
		return golsTimeCasa;
	}
	public List<Jogador> getGolsTimeFora() {
		return golsTimeFora;
	}

}
