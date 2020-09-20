package br.com.tinnova.desafio.dto;

import lombok.Data;

@Data
public class VeiculoDTO {
	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
}

