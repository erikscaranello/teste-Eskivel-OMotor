package com.test.service;

import java.math.BigInteger;
import java.util.List;

import com.test.dto.UsuarioDTO;
import com.test.model.entities.Usuario;

public interface UsuarioService {

	List<Usuario> listaUsuarios();

	Usuario listaUsuarios(BigInteger id);

	void delete(BigInteger id);

	void insertUsuario(UsuarioDTO usuarioDto);

	void updateUsuario(Usuario usuario);

}
