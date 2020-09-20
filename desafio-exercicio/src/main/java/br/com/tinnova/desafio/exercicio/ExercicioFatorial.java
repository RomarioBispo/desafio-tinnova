package br.com.tinnova.desafio.exercicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExercicioFatorial {
	public static int calcularFatorial(int valor) {
		int fatorial = 1;
		log.debug("Fatorial a ser calculado: {}", valor);
		for (int i = 1; i <= valor; i++) {
			if (valor == 1 || valor == 0) {
				return 1;
			}
			fatorial *= i;
		}
		log.debug("Fatorial calculado: {}", fatorial);
		return fatorial;
	}
	
	public static void main (String[] args) {
		calcularFatorial(5);
		calcularFatorial(6);
		calcularFatorial(7);
	}

}
