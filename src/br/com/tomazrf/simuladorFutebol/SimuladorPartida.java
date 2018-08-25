package br.com.tomazrf.simuladorFutebol;

import java.util.Random;

public class SimuladorPartida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] time1 = new int [][]{{44},{43, 44, 40, 42},{45, 40, 40, 43},{44, 40}};
		//int[] time1defesa = {43, 44, 40, 42}; 
		//int[] time1meio = {45, 40, 40, 43}; 
		//int[] time1ataque = {44, 40};
		
		int[][] time2 = new int [][]{{43},{42, 41, 40, 43},{43, 42, 42, 43},{42, 41}};
		/*int[] time2goleiro = {43};
		int[] time2defesa = {42, 41, 40, 43}; 
		int[] time2meio = {43, 42, 42, 43}; 
		int[] time2ataque = {42, 41};*/
		
		int setorCampo = 2;
		int placarTime1 = 0;
		int placarTime2 = 0;
	
		for(int i = 0; i<90 ; i++){
			System.out.println("Minuto: " + i);
			System.out.println("Setor Campo: " + setorCampo);
			setorCampo = atualizaSetorCampo(setorCampo, time1, time2);
			if(setorCampo>5){
				setorCampo = 2;
				++placarTime1;
				System.out.println("Gol do time 1. Placar: " + placarTime1 + " x " + placarTime2);
			}
			else if(setorCampo<0){
				setorCampo = 2;
				++placarTime2;
				System.out.println("Gol do time 2. Placar: " + placarTime1 + " x " + placarTime2);
			}
		}
		System.out.println("Resultado final: " + placarTime1 + " x " + placarTime2);
	}
	
	public static int atualizaSetorCampo(int setorCampo, int time1[][], int time2[][]){
		
		int resultadoDisputaSetor = disputaSetor(setorCampo, time1, time2);
		
		if(resultadoDisputaSetor > 0){
			return ++setorCampo;
		}
		else if(resultadoDisputaSetor < 0){
			return --setorCampo;
		}
		return setorCampo;
	}
	
	public static int disputaSetor(int setorCampo, int time1[][], int time2[][]){
		
		int[] posicaoTimesCampo = calculaPosicaoTimes(setorCampo);
		
		int somaSetorTime1 = somaSetor(time1[posicaoTimesCampo[0]]);
		int somaSetorTime2 = somaSetor(time2[posicaoTimesCampo[1]]);
		
		Random rand = new Random();
		double fatorTime1 = (double)(rand.nextInt(10) + 1)/10;
		double fatorTime2 = (double)(rand.nextInt(10) + 1)/10;
		
		//System.out.println("fator time 1: " + fatorTime1);
		//System.out.println("fator time 2: " + fatorTime2);
		
		if(somaSetorTime1 * fatorTime1 > somaSetorTime2 * fatorTime2){
			return 1;
		}
		else if(somaSetorTime1 * fatorTime1 < somaSetorTime2 * fatorTime2){
			return -1;
		}
		
		return 0;
	}
	
	public static int somaSetor(int[] setorTime){
		int soma = 0;
		
		for(int jogador : setorTime){
			soma += jogador;
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
