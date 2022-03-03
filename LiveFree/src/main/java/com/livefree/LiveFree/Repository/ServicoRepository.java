package com.livefree.LiveFree.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livefree.LiveFree.Model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

	public List<Servico> findAllByAvaliacao(int avaliacao);
}
