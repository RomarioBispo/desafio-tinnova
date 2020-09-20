package br.com.tinnova.desafio.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.tinnova.desafio.domain.VeiculoModel;
import br.com.tinnova.desafio.dto.VeiculoDTO;
import br.com.tinnova.desafio.exception.VeiculoNaoEncontradoException;
import br.com.tinnova.desafio.repository.VeiculoRepository;
import br.com.tinnova.desafio.service.contract.VeiculoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VeiculoServiceImpl implements VeiculoService {
	
	private final VeiculoRepository repository;
	private final ModelMapper mapper;
	
	private VeiculoModel fromDTO(VeiculoDTO veiculo) {
		 return mapper.map(veiculo, VeiculoModel.class);
	}
	private VeiculoDTO toDTO(VeiculoModel veiculo) {
		return mapper.map(veiculo, VeiculoDTO.class);
	}
	
	@Override
	public void create(VeiculoDTO veiculoDTO) {
		VeiculoModel veiculo = fromDTO(veiculoDTO);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		repository.save(veiculo);
	}

	@Override
	public List<VeiculoDTO> findAll() {
		List<VeiculoModel> listaVeiculos = repository.findAll();
		return listaVeiculos.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
	}

	@Override
	public VeiculoDTO findById(Long id) {
		Optional<VeiculoModel> veiculo = repository.findById(id);
		checkExists(veiculo);
		return toDTO(veiculo.get());
	}

	@Override
	public void update(VeiculoDTO veiculoDTO, Long id) {
		Optional<VeiculoModel> veiculoOpt = repository.findById(id);
		checkExists(veiculoOpt);
		VeiculoModel veiculo = fromDTO(veiculoDTO);
		veiculo.setUpdated(LocalDateTime.now());
		repository.save(veiculo);
	}

	@Override
	public void delete(Long id) {
		Optional<VeiculoModel> veiculo = repository.findById(id);
		checkExists(veiculo);
		repository.delete(veiculo.get());
	}
	
	private void checkExists(Optional<VeiculoModel> veiculo) {
		if (!veiculo.isPresent()) {
			 throw new VeiculoNaoEncontradoException("Veiculo Não Encontrado");
		}
	}
	@Override
	public List<VeiculoDTO> findByFilters(VeiculoDTO veiculoDTO) {
		return repository
				.findByFilters(veiculoDTO).stream()
		        .map(this::toDTO)
		        .collect(Collectors.toList());
	}

}
