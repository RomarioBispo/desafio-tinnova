package br.com.tinnova.desafio.service.contract;

import java.util.List;

import br.com.tinnova.desafio.dto.VeiculoDTO;

public interface VeiculoService {
	public void create(VeiculoDTO veiculoDTO);
	public List<VeiculoDTO> findAll();
	public VeiculoDTO findById(Long id);
	public void update(VeiculoDTO veiculoDTO, Long id);
	public void delete(Long id);
}
