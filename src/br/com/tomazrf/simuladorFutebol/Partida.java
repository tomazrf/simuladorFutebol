package br.com.tomazrf.simuladorFutebol;

import java.util.List;
import java.util.Random;

public class Partida {

	private int placarTimeCasa;
	private int placarTimeFora;
	private Time timeCasa;
	private Time timeFora;
	
	public int getPlacarTimeCasa() {
		return placarTimeCasa;
	}
	public int getPlacarTimeFora() {
		return placarTimeFora;
	}
	public Time getTimeCasa() {
		return timeCasa;
	}
	public Time getTimeFora() {
		return timeFora;
	}
	
	public Partida(Time timeCasa, Time timeFora){
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
	}
	
	public void executaPartida(){
		int setorCampo = 2;
		
		for(int i = 0; i<90 ; i++){

			setorCampo = atualizaSetorCampo(setorCampo, this.timeCasa.getJogadores(), this.timeFora.getJogadores());
			if(setorCampo>4){
				setorCampo = 2;
				++this.placarTimeCasa;
			}
			else if(setorCampo<0){
				setorCampo = 2;
				++this.placarTimeFora;
			}
		}
		System.out.println("Resultado final: " + this.placarTimeCasa + " x " + this.placarTimeFora);

	}
	
	private int atualizaSetorCampo(int setorCampo, List<Jogador> timeCasa, List<Jogador> timeFora){
		
		int resultadoDisputaSetor = disputaSetor(setorCampo, timeCasa, timeFora);
		
		if(resultadoDisputaSetor > 0){
			return ++setorCampo;
		}
		else if(resultadoDisputaSetor < 0){
			return --setorCampo;
		}
		return setorCampo;
	}
	
	private int disputaSetor(int setorCampo, List<Jogador> timeCasa, List<Jogador> timeFora){
		
		int[] posicaoTimesCampo = calculaPosicaoTimes(setorCampo);
		
		double somaSetorTime1 = somaSetor(timeCasa,posicaoTimesCampo[0]);
		double somaSetorTime2 = somaSetor(timeFora,posicaoTimesCampo[1]);
		
		double diferencaSetores = calculaMediaSetores(timeCasa,timeFora, posicaoTimesCampo);
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
	
	private double calculaMediaSetores(List<Jogador> timeCasa, List<Jogador> timeFora, int[] posicaoTimesCampo) {
		
		double mediaTime1 = somaSetor(timeCasa, posicaoTimesCampo[0])/calculaQtdJogadoresSetor(timeCasa, posicaoTimesCampo[0]);
		double mediaTime2 = somaSetor(timeFora, posicaoTimesCampo[1])/calculaQtdJogadoresSetor(timeFora, posicaoTimesCampo[1]);
		
		return mediaTime1 - mediaTime2;
	}
	
	private int calculaQtdJogadoresSetor(List<Jogador> jogadores, int posicaoCampo) {
		
		int qtdJogadoresSetor = 0;
		
		for(Jogador jogador : jogadores){
			if(verificaPosicaoJogador(jogador, posicaoCampo))
				++qtdJogadoresSetor;	
		}
		
		return qtdJogadoresSetor;
	}

	private int somaSetor(List<Jogador> jogadores, int posicaoTimesCampo){
		int soma = 0;
		
		for(Jogador jogador : jogadores){
			if(verificaPosicaoJogador(jogador, posicaoTimesCampo))
				soma += jogador.getNivel();	
		}
		
		return soma;
	}
	
	private int[] calculaPosicaoTimes(int setorCampo){
		
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
	
	private boolean verificaPosicaoJogador(Jogador jogador, int posicaoCampo){
		
		switch(posicaoCampo){
		case 0:
			if(jogador.getPosicao().equals(Jogador.codigoGoleiro))
				return true;
		case 1:
			if(jogador.getPosicao().equals(Jogador.codigoDefensor))
				return true;
		case 2:
			if(jogador.getPosicao().equals(Jogador.codigoMeioCampo))
				return true;
		case 3:
			if(jogador.getPosicao().equals(Jogador.codigoAtacante))
				return true;
		}
		
		return false;
	}
}