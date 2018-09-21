package br.com.tomazrf.simuladorFutebol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimuladorCampeonato {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<Jogador> listaTime1 = new ArrayList<Jogador>();
		Scanner sc1 = new Scanner(new File("./equipes/franca.txt"));
		String nomeTime1 = sc1.nextLine();
		while(sc1.hasNextLine()){
			String[] jogadorString = sc1.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime1.add(jogador);
		}
		sc1.close();
		
		List<Jogador> listaTime2 = new ArrayList<Jogador>();
		Scanner sc2 = new Scanner(new File("./equipes/belgica.txt"));
		String nomeTime2 = sc2.nextLine();
		while(sc2.hasNextLine()){
			String[] jogadorString = sc2.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime2.add(jogador);
		}
		sc2.close();
		
		List<Jogador> listaTime3 = new ArrayList<Jogador>();
		Scanner sc3 = new Scanner(new File("./equipes/uruguai.txt"));
		String nomeTime3 = sc3.nextLine();
		while(sc3.hasNextLine()){
			String[] jogadorString = sc3.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime3.add(jogador);
		}
		sc3.close();
		
		List<Jogador> listaTime4 = new ArrayList<Jogador>();
		Scanner sc4 = new Scanner(new File("./equipes/japao.txt"));
		String nomeTime4 = sc4.nextLine();
		while(sc4.hasNextLine()){
			String[] jogadorString = sc4.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime4.add(jogador);
		}
		sc4.close();
		
		Time time1 = new Time(listaTime1, nomeTime1);
		
		for(Jogador jogador : time1.getJogadores())
			jogador.setTime(time1);
		
		Time time2 = new Time(listaTime2, nomeTime2);
		
		for(Jogador jogador : time2.getJogadores())
			jogador.setTime(time2);
		
		Time time3 = new Time(listaTime3, nomeTime3);
		
		for(Jogador jogador : time3.getJogadores())
			jogador.setTime(time3);
		
		Time time4 = new Time(listaTime4, nomeTime4);
		
		for(Jogador jogador : time4.getJogadores())
			jogador.setTime(time4);
		
		List<Time> listaTimes = new ArrayList<>();
		listaTimes.add(time1);
		listaTimes.add(time2);
		listaTimes.add(time3);
		listaTimes.add(time4);
		
		Campeonato campeonato = new Campeonato(listaTimes);
		
		campeonato.executaCampeonato();
		
	}
}