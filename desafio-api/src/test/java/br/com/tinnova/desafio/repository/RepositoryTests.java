package br.com.tinnova.desafio.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.tinnova.desafio.domain.VeiculoModel;
import br.com.tinnova.desafio.dto.VeiculoDTO;

@DataJpaTest
class RepositoryTests {
	
	@Autowired
	private VeiculoRepository repository;
	
	@Test
	void WhenVeiculoCriadoThenSuccess() {
		assertThat(repository.findAll().size()).isEqualTo(0);
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setAno(2012);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setDescricao("descricao");
		veiculo.setMarca("marca");
		veiculo.setVeiculo("veiculo");
		veiculo.setVendido(false);
		veiculo = repository.save(veiculo);
		assertThat(repository.findAll().size()).isEqualTo(1);
	}
	
	@Test
	void deleteShouldRemoveData() {
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setAno(2012);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setDescricao("descricao");
		veiculo.setMarca("marca");
		veiculo.setVeiculo("veiculo");
		veiculo.setVendido(false);
		veiculo = repository.save(veiculo);
		assertThat(repository.findAll().size()).isEqualTo(1);
		repository.delete(veiculo);
		assertThat(repository.findAll().size()).isEqualTo(0);
	}
	
	@Test
	void updateShouldPersistData() {
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setAno(2012);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setDescricao("descricao");
		veiculo.setMarca("marca");
		veiculo.setVeiculo("veiculo");
		veiculo.setVendido(false);
		veiculo = repository.save(veiculo);
		assertThat(repository.findById(veiculo.getId()).get().getVendido()).isEqualTo(false);
		veiculo.setVendido(true);
		veiculo = repository.save(veiculo);
		assertThat(repository.findById(veiculo.getId()).get().getVendido()).isEqualTo(true);
		
	}
	
	@Test
	void whenFindByFilterVendidoThenShouldReturn() {
		
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setAno(2012);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setDescricao("descricao");
		veiculo.setMarca("marca");
		veiculo.setVeiculo("veiculo");
		veiculo.setVendido(true);
		veiculo = repository.save(veiculo);
		
		VeiculoModel veiculo2 = new VeiculoModel();
		veiculo2.setAno(2012);
		veiculo2.setCreated(LocalDateTime.now());
		veiculo2.setUpdated(LocalDateTime.now());
		veiculo2.setDescricao("descricao");
		veiculo2.setMarca("marca");
		veiculo2.setVeiculo("veiculo");
		veiculo2.setVendido(false);
		repository.save(veiculo2);
		
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		veiculoDTO.setVendido(true);
		
		List<VeiculoModel> veiculoList = repository.findByFilters(veiculoDTO);
		
		assertThat(veiculoList.size()).isEqualTo(1);
		assertThat(veiculo).isEqualTo(veiculoList.get(0));
	}
	
	@Test
	void whenFindByFilterAnoThenShouldReturn() {
		VeiculoModel veiculo = new VeiculoModel();
		veiculo.setAno(2012);
		veiculo.setCreated(LocalDateTime.now());
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setDescricao("descricao");
		veiculo.setMarca("marca");
		veiculo.setVeiculo("veiculo");
		veiculo.setVendido(true);
		veiculo = repository.save(veiculo);
		
		VeiculoModel veiculo2 = new VeiculoModel();
		veiculo2.setAno(2013);
		veiculo2.setCreated(LocalDateTime.now());
		veiculo2.setUpdated(LocalDateTime.now());
		veiculo2.setDescricao("descricao");
		veiculo2.setMarca("marca");
		veiculo2.setVeiculo("veiculo");
		veiculo2.setVendido(false);
		veiculo2 = repository.save(veiculo2);
		
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		veiculoDTO.setAno(2012);
		
		List<VeiculoModel> veiculoList = repository.findByFilters(veiculoDTO);

		assertThat(veiculoList.size()).isEqualTo(1);
		assertThat(veiculo).isEqualTo(veiculoList.get(0));
	}
}