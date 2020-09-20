package br.com.tinnova.desafio.repository;

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
		   
		    cq.where(predicates.toArray(new Predicate[0]));
		    return em.createQuery(cq).getResultList();
	}

}
