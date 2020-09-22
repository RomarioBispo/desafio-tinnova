package br.com.tinnova.desafio.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.tinnova.desafio.domain.VeiculoModel;
import br.com.tinnova.desafio.dto.VeiculoDTO;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CustomVeiculoRepositoryImpl implements CustomVeiculoRepository{
	
	private final EntityManager em;
	@Override
	public List<VeiculoModel> findByFilters(VeiculoDTO veiculoDTO) {
		 	CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<VeiculoModel> cq = cb.createQuery(VeiculoModel.class);
		 
		    Root<VeiculoModel> veiculo = cq.from(VeiculoModel.class);
		    List<Predicate> predicates = new ArrayList<>();
		    
		    if (veiculoDTO.getVendido() != null) {
		        predicates.add(cb.equal(veiculo.get("vendido"), veiculoDTO.getVendido()));
		    }
		    
		    if (veiculoDTO.getAno() != null) {
		        predicates.add(cb.equal(veiculo.get("ano"), veiculoDTO.getAno()));
		    }
		    
		    if (veiculoDTO.getMarca() != null) {
		        predicates.add(cb.equal(veiculo.get("marca"), veiculoDTO.getMarca()));
		    }
		    
		    if (veiculoDTO.getVeiculo() != null) {
		        predicates.add(cb.equal(veiculo.get("veiculo"), veiculoDTO.getVeiculo()));
		    }
		    if (veiculoDTO.getCreatedLastWeek() !=null) {
		    	predicates.add(cb.between(veiculo.get("created"), LocalDateTime.now().minusWeeks(1), LocalDateTime.now()));
		    }
		   
		    cq.where(predicates.toArray(new Predicate[0]));
		    return em.createQuery(cq).getResultList();
	}
	
	@Override
	public List<VeiculoDTO> findByMarca() {
		CriteriaBuilder cbSub = em.getCriteriaBuilder();
    	
		CriteriaQuery<Object[]> cqSub = cbSub.createQuery(Object[].class);
		Root<VeiculoModel> v = cqSub.from(VeiculoModel.class);

		cqSub
		.multiselect(v.get("marca"), cbSub.count(v.get("marca")))
		.groupBy(v.get("marca"));

		List<Object[]> objs = em.createQuery(cqSub).getResultList();
		List<VeiculoDTO> veiculos = new ArrayList<>();
		
		for (Object[] obj: objs) {
			VeiculoDTO veiculo = new VeiculoDTO ();
			veiculo.setMarca(obj[0].toString());
			veiculo.setQuantidadeVeiculos(Long.valueOf(obj[1].toString()));
			veiculos.add(veiculo);
		}
		return veiculos;
	}
	
	@Override
	public List<VeiculoDTO> findByAno() {
		CriteriaBuilder cbSub = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cqSub = cbSub.createQuery(Object[].class);
		Root<VeiculoModel> v = cqSub.from(VeiculoModel.class);
		
		cqSub
		.multiselect(v.get("ano"), cbSub.count(v.get("veiculo")))
		.groupBy(v.get("ano"));

		List<Object[]> objs = em.createQuery(cqSub).getResultList();
		
		List<VeiculoDTO> veiculos = new ArrayList<>();

		for (Object[] obj : objs) {
			VeiculoDTO veiculo = new VeiculoDTO();
			veiculo.setAno(Integer.parseInt(obj[0].toString()));
			veiculo.setQuantidadeVeiculos(Long.valueOf(obj[1].toString()));
			veiculos.add(veiculo);
		}
		return veiculos;
	}

}
