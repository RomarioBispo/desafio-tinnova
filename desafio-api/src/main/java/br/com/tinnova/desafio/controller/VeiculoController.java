package br.com.tinnova.desafio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.desafio.dto.VeiculoDTO;
import br.com.tinnova.desafio.service.contract.VeiculoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/veiculos")
@AllArgsConstructor
public class VeiculoController {
	private VeiculoService service;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<VeiculoDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/find")
	@ResponseStatus(value = HttpStatus.OK)
	public List<VeiculoDTO> find(VeiculoDTO veiculoDTO){
		return service.findByFilters(veiculoDTO);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public VeiculoDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody VeiculoDTO veiculoDTO) {
		service.create(veiculoDTO);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
		service.update(veiculoDTO, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
