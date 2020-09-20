package br.com.tinnova.desafio.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VeiculoDTO {
	private String veiculo;
	private String marca;
	private Integer ano;
	private String text;
	private Boolean vendido;
	private LocalDateTime created;
	private LocalDateTime upated;
}

