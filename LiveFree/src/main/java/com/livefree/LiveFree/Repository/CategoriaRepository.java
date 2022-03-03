package com.livefree.LiveFree.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livefree.LiveFree.Model.Categoria;
import com.livefree.LiveFree.util.EAtendimento;
import com.livefree.LiveFree.util.ECategoria;
import com.livefree.LiveFree.util.EMotivo;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	//public List<Categoria> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
	
	public List<Categoria> findAllByCategoriaAndAtendimentoAndMotivo(ECategoria categoria, EAtendimento atendimento, EMotivo motivo);

	public List<Categoria> findAllByAtendimentoAndMotivo(EAtendimento atendimento, EMotivo motivo);
	
	public List<Categoria> findAllByCategoriaAndMotivo(ECategoria categoria,EMotivo motivo);

	public List<Categoria> findAllByCategoriaAndAtendimento(ECategoria categoria,EAtendimento atendimento);
	
	public List<Categoria> findAllByCategoria(ECategoria categoria);
	
	public List<Categoria> findAllByAtendimento(EAtendimento atendimento);
	
	public List<Categoria> findAllByMotivo(EMotivo motivo);
	
	
}
