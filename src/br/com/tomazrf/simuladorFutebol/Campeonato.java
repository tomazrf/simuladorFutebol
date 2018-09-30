package br.com.tomazrf.simuladorFutebol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Campeonato {
	
	public static int temporada = 0;
	
	private List<Time> listaTimes;
	private List<Partida> listaPartidas;
	private EstatisticaCampeonato estatistica;
	
	public Campeonato(List<Time> listaTimes){
		this.listaTimes = listaTimes;
		this.listaPartidas = new ArrayList<>();
		this.geraTabela();
	}
	
	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}
	
	public List<Time> getListaTimes() {
		return listaTimes;
	}

	public EstatisticaCampeonato getEstatistica() {
		return estatistica;
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
	
	private List<Time> calculaPontuacao() {
		
		List<Time> timesCampeonato = new ArrayList<>();
		
		for(Time time : this.listaTimes){
			timesCampeonato.add(time);
		}
		
		Collections.sort(timesCampeonato, Time.getPontosComparator());
		
		return timesCampeonato;
	}
	
	private void geraTabela(){
		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(7)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(2)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(3)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(6)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(0)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(4)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(2)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(3)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(7)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(3)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(0)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(6)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(4)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(7)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(2)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(4)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(6)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(7)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(0)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(3)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(2)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(4)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(0)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(2)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(3)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(7)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(6)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(4)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(0)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(6)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(2)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(7)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(6)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(0)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(4)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(3)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(4), this.getListaTimes().get(0)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(1), this.getListaTimes().get(5)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(6), this.getListaTimes().get(3)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(7), this.getListaTimes().get(2)));

		this.listaPartidas.add(new Partida(this.getListaTimes().get(0), this.getListaTimes().get(1)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(5), this.getListaTimes().get(6)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(3), this.getListaTimes().get(7)));
		this.listaPartidas.add(new Partida(this.getListaTimes().get(2), this.getListaTimes().get(4)));

	}

	public void geraEstatisticas() {
		
		int somaGols = 0;
		double mediaGols;
		
		for(Partida partida : this.getListaPartidas()){
			somaGols += partida.getPlacarTimeCasa();
			somaGols += partida.getPlacarTimeFora();
		}
		
		mediaGols = (double)somaGols/this.getListaPartidas().size();
		
		this.estatistica = new EstatisticaCampeonato(somaGols,mediaGols);
	}

	public void executaCampeonato() throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(new File("resultado.txt"));
		PrintWriter pwa = new PrintWriter(new File("artilharia.txt"));
		
		for(Partida partida : this.getListaPartidas()){
			
			partida.executaPartida();
			
			System.out.println(partida.getTimeCasa().getNome() + ": " + partida.getPlacarTimeCasa() + " x " + partida.getTimeFora().getNome() + ": " + partida.getPlacarTimeFora());
			pw.write(partida.getTimeCasa().getNome() + ": " + partida.getPlacarTimeCasa() + " x " + partida.getTimeFora().getNome() + ": " + partida.getPlacarTimeFora());
			pw.println("");
			pw.flush();
		}
		List<Jogador> listaArtilheiros = this.calculaArtilharia();
		for(Jogador jogador : listaArtilheiros){
			pwa.write(jogador.desempenhoTemporada());
			pwa.println("");
			pwa.flush();
		}
		pw.println("");
		List<Time> listaTimesPontuacao = this.calculaPontuacao();
		for(Time time : listaTimesPontuacao){
			pw.write("Time: " + time.getNome() + ", Pontos: " + time.getPontosNaTemporadaAtual());
			pw.println("");
			pw.flush();
		}
		this.geraEstatisticas();

		pwa.close();
		pw.close();
	}
	
}
