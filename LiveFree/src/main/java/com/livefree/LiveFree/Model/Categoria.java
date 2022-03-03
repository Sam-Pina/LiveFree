package com.livefree.LiveFree.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.livefree.LiveFree.util.EAtendimento;
import com.livefree.LiveFree.util.ECategoria;
import com.livefree.LiveFree.util.EMotivo;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private @Enumerated(EnumType.STRING) ECategoria categoria;
	private @Enumerated(EnumType.STRING) EAtendimento atendimento;
	private @Enumerated(EnumType.STRING) EMotivo motivo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ECategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoria categoria) {
		this.categoria = categoria;
	}

	public EAtendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(EAtendimento atendimento) {
		this.atendimento = atendimento;
	}

	public EMotivo getMotivo() {
		return motivo;
	}

	public void setMotivo(EMotivo motivo) {
		this.motivo = motivo;
	}

}
