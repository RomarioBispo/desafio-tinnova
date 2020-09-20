package br.com.tinnova.desafio.exercicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExercicioSomaMultiplo {
	
	public static int calculaSomaMultiplos(int numero) {
		log.debug("calculando soma dos numeros multiplos de 3 e 5 para o valor: {}", numero);
		int somaMultiplos = 0;
		for (int i = 1; i <= numero; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				log.debug("numero multiplo de 3 ou 5: {}", i);
				somaMultiplos+=i;
			}
		}
		log.debug("Soma dos numeros multiplos de 3 e 5 calculado: {}", somaMultiplos);
		return somaMultiplos;
	}
	
	public static void main (String[] args) {
		calculaSomaMultiplos(9);
	}
}
