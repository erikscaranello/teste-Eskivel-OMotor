package com.test.dao;

import java.util.List;

import com.test.daoGeneric.Dao;
import com.test.model.entities.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	List<Usuario> listaUsuarios();
	
	
}
