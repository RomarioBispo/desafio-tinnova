package br.com.tinnova.desafio.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class VeiculoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	private LocalDateTime created;
	private LocalDateTime upated;
}

