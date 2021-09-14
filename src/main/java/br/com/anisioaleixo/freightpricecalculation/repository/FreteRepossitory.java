package br.com.anisioaleixo.freightpricecalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anisioaleixo.freightpricecalculation.data.model.Frete;

@Repository
public interface FreteRepossitory extends JpaRepository<Frete, Long>{

}
