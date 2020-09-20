package br.com.tinnova.desafio.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.tinnova.desafio.domain.VeiculoModel;
import br.com.tinnova.desafio.dto.VeiculoDTO;
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
		veiculo.setUpated(LocalDateTime.now());
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
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		if (veiculo.isPresent()) {
			veiculoDTO = toDTO(veiculo.get());
		}
		return veiculoDTO;
	}

	@Override
	public void update(VeiculoDTO veiculoDTO, Long id) {
		Optional<VeiculoModel> veiculoOpt = repository.findById(id);
		
		if (veiculoOpt.isPresent()) {
			VeiculoModel veiculo = veiculoOpt.get();
			veiculo.setAno(veiculoDTO.getAno());
			veiculo.setMarca(veiculoDTO.getMarca());
			veiculo.setDescricao(veiculoDTO.getDescricao());
			veiculo.setUpated(LocalDateTime.now());
			veiculo.setVeiculo(veiculoDTO.getVeiculo());
			veiculo.setVendido(veiculoDTO.getVendido());
			repository.save(veiculo);
		}
	}

	@Override
	public void delete(Long id) {
		Optional<VeiculoModel> veiculo = repository.findById(id);
		if (veiculo.isPresent()) {
			repository.delete(veiculo.get());
		}
	}

}
