package com.livefree.LiveFree.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livefree.LiveFree.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByEmail(String email);

	

}
