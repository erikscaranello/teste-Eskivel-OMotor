package com.test.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UsuarioDao;
import com.test.dto.UsuarioDTO;
import com.test.model.entities.Usuario;
import com.test.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> listaUsuarios() {
		return usuarioDao.listaUsuarios(); 
	}

	@Override
	public Usuario listaUsuarios(BigInteger id) {
		return usuarioDao.selectOne(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(BigInteger id) {
		Usuario usuario = usuarioDao.selectOne(id);
		usuarioDao.delete(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertUsuario(UsuarioDTO usuarioDto) {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioDto.getId());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setNome(usuarioDto.getNome());
		usuario.setSexo(usuarioDto.getSexo());
		usuario.setTelefone(usuarioDto.getTelefone());
		
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUsuario(Usuario usuario) {
//		usuarioDao.save(usuario);
	}
}
