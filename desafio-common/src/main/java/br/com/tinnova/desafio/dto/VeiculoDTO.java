package br.com.tinnova.desafio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VeiculoDTO {
	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
}

