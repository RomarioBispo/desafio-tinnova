package br.com.tinnova.desafio.exercicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExercicioBubbleSort {
	
	public static int[] ordenacaoBubbleSort(int[] vetor) {
		int tamanhoVetor = vetor.length;
		int aux;
		int posicaoAtual;
		int proximaPosicao;
		log.debug("vetor desordenado: {}", vetor);
		for (int i = 0; i < tamanhoVetor; i++) {
			for (int j = 1; j < (tamanhoVetor - i); j++) {
				posicaoAtual = j - 1;
				proximaPosicao = j;
				if (vetor[proximaPosicao] < vetor[posicaoAtual]) {
					aux = vetor[proximaPosicao];
					vetor[proximaPosicao] = vetor[posicaoAtual];
					vetor[posicaoAtual] = aux;
				}
			}
		}
		log.debug("vetor ordenado: {}", vetor);
		return vetor;
	}
	
	public static void main (String[] args) {
		int[] vetorDesordenado = new int[] {5, 3, 2, 4, 7, 1, 0, 6};
		ordenacaoBubbleSort(vetorDesordenado);
	}
}
