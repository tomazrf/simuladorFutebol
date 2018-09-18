package br.com.tomazrf.simuladorFutebol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimuladorPartida {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<Jogador> listaTimeCasa = new ArrayList<Jogador>();
		Scanner sc = new Scanner(new File("./equipes/franca.txt"));
		String nomeTimeCasa = sc.nextLine();
		while(sc.hasNextLine()){
			String[] jogadorString = sc.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTimeCasa.add(jogador);
		}
		sc.close();
		
		List<Jogador> listaTimeFora = new ArrayList<Jogador>();
		Scanner sc2 = new Scanner(new File("./equipes/belgica.txt"));
		String nomeTimeFora = sc2.nextLine();
		while(sc2.hasNextLine()){
			String[] jogadorString = sc2.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTimeFora.add(jogador);
		}
		sc2.close();
		
		Time timeCasa = new Time(listaTimeCasa, nomeTimeCasa);
		
		for(Jogador jogador : timeCasa.getJogadores())
			jogador.setTime(timeCasa);
		
		Time timeFora = new Time(listaTimeFora, nomeTimeFora);
		
		for(Jogador jogador : timeFora.getJogadores())
			jogador.setTime(timeFora);
		
		double somaDeGols = 0;
		int vitoriasTime1 = 0;
		int vitoriasTime2 = 0;
		int empates = 0;

		int numeroDeJogos = 90;
		
		PrintWriter pw = new PrintWriter(new File("resultado.txt"));
		PrintWriter pwa = new PrintWriter(new File("artilharia.txt"));
		
		List<Time> listaTimes = new ArrayList<>();
		listaTimes.add(timeCasa);
		listaTimes.add(timeFora);
		
		Campeonato campeonato = new Campeonato(listaTimes);
		
		for(int j=0; j<numeroDeJogos; j++){
			
			Partida partida = new Partida(timeCasa, timeFora);
			partida.executaPartida();
			campeonato.getListaPartidas().add(partida);
			
			somaDeGols += (partida.getPlacarTimeCasa() + partida.getPlacarTimeFora());
			if(partida.getPlacarTimeCasa()>partida.getPlacarTimeFora()){
				++vitoriasTime1;
			}
			else if(partida.getPlacarTimeCasa()<partida.getPlacarTimeFora()){
				++vitoriasTime2;
			}
			else{
				++empates;
			}
			System.out.println("Resultado final: " + partida.getPlacarTimeCasa() + " x " + partida.getPlacarTimeFora());
			pw.write("Resultado final: " + partida.getPlacarTimeCasa() + " x " + partida.getPlacarTimeFora());
			pw.println("");
			pw.flush();
		}
		List<Jogador> listaArtilheiros = campeonato.calculaArtilharia();
		for(Jogador jogador : listaArtilheiros){
			pwa.write(jogador.desempenhoTemporada());
			pwa.println("");
			pwa.flush();
		}	
		pw.println("");
		System.out.println("Média de gols: " + somaDeGols/numeroDeJogos);
		pw.write("Média de gols: " + somaDeGols/numeroDeJogos);
		pw.println("");
		System.out.println("Vitórias Time 1: " + vitoriasTime1);
		pw.write("Vitórias Time 1: " + vitoriasTime1);
		pw.println("");
		System.out.println("Vitórias Time 2: " + vitoriasTime2);
		pw.write("Vitórias Time 2: " + vitoriasTime2);
		pw.println("");
		System.out.println("Empates: " + empates);
		pw.write("Empates: " + empates);
		pw.flush();
		pwa.close();
		pw.close();
	}
}