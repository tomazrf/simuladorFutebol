package br.com.tomazrf.simuladorFutebol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Campeonato {
	
	public static int temporada = 0;
	
	private List<Time> listaTimes;
	private List<Partida> listaPartidas;
	
	public Campeonato(List<Time> listaTimes){
		this.listaTimes = listaTimes;
		this.listaPartidas = new ArrayList<>();
	}
	
	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}
	
	public List<Time> getListaTimes() {
		return listaTimes;
	}

	public List<Jogador> calculaArtilharia(){
		
		List<Jogador> jogadoresCampeonato = new ArrayList<>();
		
		for(Time time : listaTimes){
			for(Jogador jogador : time.getJogadores()){
				jogadoresCampeonato.add(jogador);
			}
		}
		
		Collections.sort(jogadoresCampeonato, Jogador.getGolsComparator());
		
		return jogadoresCampeonato;
	}
	
}
