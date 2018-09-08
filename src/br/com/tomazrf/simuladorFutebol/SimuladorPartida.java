package br.com.tomazrf.simuladorFutebol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimuladorPartida {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("./equipes/time1.txt"));
		List<String[]> time1 = new ArrayList<>();	
		while(sc.hasNextLine()){
			String[] posicao = sc.nextLine().split(",");
			time1.add(posicao);
		}
		sc.close();
		
		Scanner sc2 = new Scanner(new File("./equipes/time2.txt"));
		List<String[]> time2 = new ArrayList<>();	
		while(sc2.hasNextLine()){
			String[] posicao = sc2.nextLine().split(",");
			time2.add(posicao);
		}
		sc2.close();
		
		double somaDeGols = 0;
		int vitoriasTime1 = 0;
		int vitoriasTime2 = 0;
		int empates = 0;
		
		double setor0 = 0;
		double setor1 = 0;
		double setor2 = 0;
		double setor3 = 0;
		double setor4 = 0;
		
		int numeroDeJogos = 90;
		
		PrintWriter pw = new PrintWriter(new File("resultado.txt"));
		
		for(int j=0; j<numeroDeJogos; j++){
			
			int setorCampo = 2;
			int placarTime1 = 0;
			int placarTime2 = 0;
			
			for(int i = 0; i<90 ; i++){
				//System.out.println("Minuto: " + i);
				//System.out.println("Setor Campo: " + setorCampo);
				
				switch(setorCampo){
				case 0:
					++setor0;
					break;
				case 1:
					++setor1;
					break;
				case 2:
					++setor2;
					break;
				case 3:
					++setor3;
					break;
				case 4:
					++setor4;
					break;
				}
				setorCampo = atualizaSetorCampo(setorCampo, time1, time2);
				if(setorCampo>4){
					setorCampo = 2;
					++placarTime1;
					//System.out.println("Gol do time 1. Placar: " + placarTime1 + " x " + placarTime2);
				}
				else if(setorCampo<0){
					setorCampo = 2;
					++placarTime2;
					//System.out.println("Gol do time 2. Placar: " + placarTime1 + " x " + placarTime2);
				}
			}
			somaDeGols += (placarTime1 + placarTime2);
			if(placarTime1>placarTime2){
				++vitoriasTime1;
			}
			else if(placarTime1<placarTime2){
				++vitoriasTime2;
			}
			else{
				++empates;
			}
			System.out.println("Resultado final: " + placarTime1 + " x " + placarTime2);
			pw.write("Resultado final: " + placarTime1 + " x " + placarTime2);
			pw.println("");
			pw.flush();
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
		pw.close();
		/*System.out.println("setor 0: " + setor0);
		System.out.println("setor 1: " + setor1);
		System.out.println("setor 2: " + setor2);
		System.out.println("setor 3: " + setor3);
		System.out.println("setor 4: " + setor4);*/
		System.out.println("media meio-campo: " + (setor1/(setor1 + setor3)));
	}
	
	public static int atualizaSetorCampo(int setorCampo, List<String[]> time1, List<String[]> time2){
		
		int resultadoDisputaSetor = disputaSetor(setorCampo, time1, time2);
		
		if(resultadoDisputaSetor > 0){
			return ++setorCampo;
		}
		else if(resultadoDisputaSetor < 0){
			return --setorCampo;
		}
		return setorCampo;
	}
	
	public static int disputaSetor(int setorCampo, List<String[]> time1, List<String[]> time2){
		
		int[] posicaoTimesCampo = calculaPosicaoTimes(setorCampo);
		
		double somaSetorTime1 = somaSetor(time1.get(posicaoTimesCampo[0]));
		double somaSetorTime2 = somaSetor(time2.get(posicaoTimesCampo[1]));
		
		double diferencaSetores = calculaMediaSetores(time1.get(posicaoTimesCampo[0]),time2.get(posicaoTimesCampo[1]));
		double fatorEquilibrio1 = 1;
		double fatorEquilibrio2 = 1;
		
		if(diferencaSetores <= -30){
			fatorEquilibrio1 = 2.1;
		}
		else if(diferencaSetores <= -25){
			fatorEquilibrio1 = 1.85;
		}
		else if(diferencaSetores <= -20){
			fatorEquilibrio1 = 1.65;
		}
		else if(diferencaSetores < -10){
			fatorEquilibrio1 = 1.45;
		}
		else if(diferencaSetores >= 30){
			fatorEquilibrio2 = 2.1;
		}
		else if(diferencaSetores >= 25){
			fatorEquilibrio2 = 1.85;
		}
		else if(diferencaSetores >= 20){
			fatorEquilibrio2 = 1.65;
		}
		else if(diferencaSetores > 10){
			fatorEquilibrio2 = 1.45;
		}
		
		switch(setorCampo){
		case 0 :
			somaSetorTime1 *= (2.1 + fatorEquilibrio1);
			somaSetorTime2 *= (fatorEquilibrio2);
			break;
		case 1 :
			somaSetorTime1 *= (2.1 + fatorEquilibrio1);
			somaSetorTime2 *= (fatorEquilibrio2);
			break;
		case 2 :
			somaSetorTime1 *= (0.1 + fatorEquilibrio1);
			somaSetorTime2 *= (fatorEquilibrio2);
			break;
		case 3 :
			somaSetorTime2 *= (1.9 + fatorEquilibrio2);
			somaSetorTime1 *= (fatorEquilibrio1);
			break;
		case 4 :
			somaSetorTime2 *= (1.9 + fatorEquilibrio2);
			somaSetorTime1 *= (fatorEquilibrio1);
			break;
		default :
			break;
		}
		
		Random rand = new Random();
		double fatorTime1 = (double)(rand.nextInt(100) + 1)/100;
		double fatorTime2 = (double)(rand.nextInt(100) + 1)/100;

		/*Random rand1 = new Random();
		Random rand2 = new Random();
		double fatorTime1 = (double)(rand1.nextInt(10) + 1)/10;
		double fatorTime2 = (double)(rand2.nextInt(10) + 1)/10;*/
		
		/*if(setorCampo == 2){
			System.out.println("somaFator time 1: " + somaSetorTime1 * fatorTime1);
			System.out.println("somaFator time 2: " + somaSetorTime2 * fatorTime2);
		}*/
		
		if(somaSetorTime1 * fatorTime1 > somaSetorTime2 * fatorTime2){
			return 1;
		}
		else if(somaSetorTime1 * fatorTime1 < somaSetorTime2 * fatorTime2){
			return -1;
		}
		
		return 0;
	}
	
	private static double calculaMediaSetores(String[] time1, String[] time2) {
		
		double mediaTime1 = somaSetor(time1)/time1.length;
		double mediaTime2 = somaSetor(time2)/time2.length;
		
		return mediaTime1 - mediaTime2;
	}

	public static int somaSetor(String[] strings){
		int soma = 0;
		
		for(String jogador : strings){
			soma += Integer.parseInt(jogador);
		}
		
		return soma;
	}
	
	public static int[] calculaPosicaoTimes(int setorCampo){
		
		switch(setorCampo){
		case 0:
			return new int[]{0,3};
		case 1:
			return new int[]{1,3};
		case 2:
			return new int[]{2,2};
		case 3:
			return new int[]{3,1};
		case 4:
			return new int[]{3,0};
		}
		
		return new int[]{0,0};
	}

}