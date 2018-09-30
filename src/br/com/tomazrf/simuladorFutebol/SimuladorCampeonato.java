package br.com.tomazrf.simuladorFutebol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimuladorCampeonato {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<Jogador> listaTime1 = new ArrayList<Jogador>();
		Scanner sc1 = new Scanner(new File("./equipes/barcelona.txt"));
		String nomeTime1 = sc1.nextLine();
		while(sc1.hasNextLine()){
			String[] jogadorString = sc1.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime1.add(jogador);
		}
		sc1.close();
		
		List<Jogador> listaTime2 = new ArrayList<Jogador>();
		Scanner sc2 = new Scanner(new File("./equipes/realmadrid.txt"));
		String nomeTime2 = sc2.nextLine();
		while(sc2.hasNextLine()){
			String[] jogadorString = sc2.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime2.add(jogador);
		}
		sc2.close();
		
		List<Jogador> listaTime3 = new ArrayList<Jogador>();
		Scanner sc3 = new Scanner(new File("./equipes/psg.txt"));
		String nomeTime3 = sc3.nextLine();
		while(sc3.hasNextLine()){
			String[] jogadorString = sc3.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime3.add(jogador);
		}
		sc3.close();
		
		List<Jogador> listaTime4 = new ArrayList<Jogador>();
		Scanner sc4 = new Scanner(new File("./equipes/manchestercity.txt"));
		String nomeTime4 = sc4.nextLine();
		while(sc4.hasNextLine()){
			String[] jogadorString = sc4.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime4.add(jogador);
		}
		sc4.close();
		
		List<Jogador> listaTime5 = new ArrayList<Jogador>();
		Scanner sc5 = new Scanner(new File("./equipes/liverpool.txt"));
		String nomeTime5 = sc5.nextLine();
		while(sc5.hasNextLine()){
			String[] jogadorString = sc5.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime5.add(jogador);
		}
		sc5.close();
		
		List<Jogador> listaTime6 = new ArrayList<Jogador>();
		Scanner sc6 = new Scanner(new File("./equipes/juventus.txt"));
		String nomeTime6 = sc6.nextLine();
		while(sc6.hasNextLine()){
			String[] jogadorString = sc6.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime6.add(jogador);
		}
		sc6.close();
		
		List<Jogador> listaTime7 = new ArrayList<Jogador>();
		Scanner sc7 = new Scanner(new File("./equipes/bayern.txt"));
		String nomeTime7 = sc7.nextLine();
		while(sc7.hasNextLine()){
			String[] jogadorString = sc7.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime7.add(jogador);
		}
		sc7.close();
		
		List<Jogador> listaTime8 = new ArrayList<Jogador>();
		Scanner sc8 = new Scanner(new File("./equipes/atleticomadrid.txt"));
		String nomeTime8 = sc8.nextLine();
		while(sc8.hasNextLine()){
			String[] jogadorString = sc8.nextLine().split(",");
			Jogador jogador = new Jogador(jogadorString[0], jogadorString[1], Integer.parseInt(jogadorString[2]));
			listaTime8.add(jogador);
		}
		sc8.close();
		
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
		
		Time time5 = new Time(listaTime5, nomeTime5);
		
		for(Jogador jogador : time5.getJogadores())
			jogador.setTime(time5);
		
		Time time6 = new Time(listaTime6, nomeTime6);
		
		for(Jogador jogador : time6.getJogadores())
			jogador.setTime(time6);
		
		Time time7 = new Time(listaTime7, nomeTime7);
		
		for(Jogador jogador : time7.getJogadores())
			jogador.setTime(time7);
		
		Time time8 = new Time(listaTime8, nomeTime8);
		
		for(Jogador jogador : time8.getJogadores())
			jogador.setTime(time8);
		
		List<Time> listaTimes = new ArrayList<>();
		listaTimes.add(time1);
		listaTimes.add(time2);
		listaTimes.add(time3);
		listaTimes.add(time4);
		listaTimes.add(time5);
		listaTimes.add(time6);
		listaTimes.add(time7);
		listaTimes.add(time8);
		
		Campeonato campeonato = new Campeonato(listaTimes);
		
		campeonato.executaCampeonato();
		
	}
}