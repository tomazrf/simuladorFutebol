package br.com.tomazrf.simuladorFutebol;

import java.util.ArrayList;
import java.util.List;

public class EstatisticaCampeonato {
	
	private List<Partida> listaPartidas;
	
	public EstatisticaCampeonato(){
		this.listaPartidas = new ArrayList<>();
	}

	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}
	
}
