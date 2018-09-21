package br.com.tomazrf.simuladorFutebol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partida {

	private int placarTimeCasa;
	private int placarTimeFora;
	private Time timeCasa;
	private Time timeFora;
	private EstatisticaPartida estatistica;
	
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
		this.estatistica = new EstatisticaPartida();
	}
	
	public void executaPartida(){
		int setorCampo = 2;
		
		for(int i = 0; i<90 ; i++){
			setorCampo = atualizaSetorCampo(setorCampo, this.timeCasa.getJogadores(), this.timeFora.getJogadores());
			if(setorCampo>4){
				setorCampo = 2;
				++this.placarTimeCasa;
				Jogador autorDoGolCasa = verificaAutorGol(this.timeCasa.getJogadores());
				autorDoGolCasa.somaGol();
				this.estatistica.getGolsTimeCasa().add(autorDoGolCasa);
			}
			else if(setorCampo<0){
				setorCampo = 2;
				++this.placarTimeFora;
				Jogador autorDoGolFora = verificaAutorGol(this.timeFora.getJogadores());
				autorDoGolFora.somaGol();
				this.estatistica.getGolsTimeFora().add(autorDoGolFora);
			}
		}
		
		if(this.getPlacarTimeCasa()>this.getPlacarTimeFora()){
			this.getTimeCasa().vitoriaPartida();
		}
		else if(this.getPlacarTimeCasa()<this.getPlacarTimeFora()){
			this.getTimeFora().vitoriaPartida();
		}
		else{
			this.getTimeCasa().empatePartida();
			this.getTimeFora().empatePartida();
		}
	}
	
	private Jogador verificaAutorGol(List<Jogador> jogadores) {
		
		Random rand = new Random();
		int fatorGol = rand.nextInt(100);
		List<Jogador> listaPosicao = new ArrayList<>();
		int posicaoCampo = 0;
		
		if(fatorGol<10){
			posicaoCampo = 1;
		}
		else if(fatorGol<40){
			posicaoCampo = 2;
		}
		else{
			posicaoCampo = 3;
		}
		
		for(Jogador jogador : jogadores){
			if(verificaPosicaoJogador(jogador, posicaoCampo))
				listaPosicao.add(jogador);	
		}

		return listaPosicao.get(rand.nextInt(listaPosicao.size()));
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
			break;
		case 1:
			if(jogador.getPosicao().equals(Jogador.codigoDefensor))
				return true;
			break;
		case 2:
			if(jogador.getPosicao().equals(Jogador.codigoMeioCampo))
				return true;
			break;
		case 3:
			if(jogador.getPosicao().equals(Jogador.codigoAtacante))
				return true;
			break;
		}
		
		return false;
	}
}
