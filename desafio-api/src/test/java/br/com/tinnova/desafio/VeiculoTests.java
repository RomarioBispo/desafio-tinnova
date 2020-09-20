package br.com.tinnova.desafio;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tinnova.desafio.domain.VeiculoModel;
import br.com.tinnova.desafio.dto.VeiculoDTO;
import br.com.tinnova.desafio.repository.VeiculoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class VeiculoTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private VeiculoRepository MockedRepository;

	@Test
	void whenFindByIdDontExistsThenShouldReturnNotFound() {
		BDDMockito.when(MockedRepository.findById(1L)).thenReturn(Optional.empty());
		ResponseEntity<VeiculoDTO> res =	restTemplate.getForEntity("/veiculos/1", VeiculoDTO.class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	void whenFindByIdExistsThenShouldReturn() {
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setAno(2012);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setDescricao("descricao");
		veiculo.setMarca("marca");
		veiculo.setVeiculo("veiculo");
		veiculo.setVendido(false);
		
		BDDMockito.when(MockedRepository.findById(1L)).thenReturn(Optional.of(veiculo));
		ResponseEntity<VeiculoDTO> res =	restTemplate.getForEntity("/veiculos/1", VeiculoDTO.class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(res.getBody().getAno()).isEqualTo(2012);
		assertThat(res.getBody().getMarca()).isEqualTo("marca");
		assertThat(res.getBody().getVendido()).isEqualTo(false);
	}
	
	@Test
	void whenFindAllAndEmptyDatabaseThenShouldReturnEmpty() {
		BDDMockito.when(MockedRepository.findAll()).thenReturn(Collections.<VeiculoModel>emptyList());
		ResponseEntity<VeiculoDTO[]> res =	restTemplate.getForEntity("/veiculos", VeiculoDTO[].class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(res.getBody().length).isEqualTo(0);
	}
	
}
