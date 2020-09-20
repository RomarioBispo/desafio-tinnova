package br.com.tinnova.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinnova.desafio.domain.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long>, CustomVeiculoRepository {

}
