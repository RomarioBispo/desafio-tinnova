package br.com.tinnova.desafio.exercicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExercicioEleitores {
	
	public static double calculaPercentual(int total, int razao) {
		
		return ( 100 * Double.valueOf(razao)/Double.valueOf(total));
	}
	
	public static double calculaPercentualVotosValidos(int totalEleitores, int totalVotosValidos) {
		double percentualVotosValidos =  calculaPercentual(totalEleitores, totalVotosValidos);
		log.debug("total de eleitores: {}, total de votos validos {}, percentual de votos validos :{}%", totalEleitores, totalVotosValidos, percentualVotosValidos);
		return percentualVotosValidos;
	}
	
	public static double calculaPercentualVotosBrancos(int totalEleitores, int totalVotosBrancos) {
		double percentualVotosBrancos =  calculaPercentual(totalEleitores, totalVotosBrancos);
		log.debug("total de eleitores: {}, total de votos brancos {}, percentual de votos brancos :{}%", totalEleitores, totalVotosBrancos, percentualVotosBrancos);
		return percentualVotosBrancos;
	}
	
	public static double calculaPercentualVotosNulos(int totalEleitores, int totalVotosNulos) {
		double percentualVotosNulos = calculaPercentual(totalEleitores, totalVotosNulos);
		log.debug("total de eleitores: {}, total de votos nulos {}, percentual de votos nulos :{}%", totalEleitores, totalVotosNulos, percentualVotosNulos);
		return percentualVotosNulos;
	}
	
	public static void main (String[] args) {
		
		int totalEleitores = 1000;
		int totalVotosValidos = 800;
		int totalVotosBrancos = 150;
		int totalVotosNulos = 50;
		
		calculaPercentualVotosValidos(totalEleitores, totalVotosValidos);
		calculaPercentualVotosBrancos(totalEleitores, totalVotosBrancos);
		calculaPercentualVotosNulos(totalEleitores, totalVotosNulos);
	}
}
