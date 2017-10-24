package com.test.rest.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.UsuarioDTO;
import com.test.model.entities.Usuario;
import com.test.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertUsuario(@RequestBody UsuarioDTO usuarioDto) {
		usuarioService.insertUsuario(usuarioDto);
	}
	
	@RequestMapping(value = "/listaUsuarios")
	public List<Usuario> listaUsuarios() {
		return usuarioService.listaUsuarios();
	}
	
	@RequestMapping("/listaUsuarios/{id}")
	public Usuario listaUsuarios(@PathVariable BigInteger id) {
		return usuarioService.listaUsuarios(id);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable BigInteger id) {
		usuarioService.delete(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Usuario usuario) {
//		usuarioService.updateUsuario(usuario);
	}
	
	
}
