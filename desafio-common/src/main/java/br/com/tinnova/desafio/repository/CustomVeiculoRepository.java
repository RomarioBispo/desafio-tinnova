package br.com.tinnova.desafio.repository;

import java.util.List;

import br.com.tinnova.desafio.domain.VeiculoModel;
import br.com.tinnova.desafio.dto.VeiculoDTO;

public interface CustomVeiculoRepository {
	public List<VeiculoModel> findByFilters(VeiculoDTO veiculoDTO);
	List<VeiculoDTO> findByMarca();
	List<VeiculoDTO> findByAno();
}
