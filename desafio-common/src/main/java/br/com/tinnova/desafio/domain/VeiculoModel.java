package br.com.tinnova.desafio.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class VeiculoModel {
	@Id
	private String id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String text;
	private Boolean vendido;
	private LocalDateTime created;
	private LocalDateTime upated;
}

