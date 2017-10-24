package com.test.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UsuarioDao;
import com.test.daoGeneric.DaoImpl;
import com.test.model.entities.Usuario;

@Repository
public class UsuarioDaoImpl extends DaoImpl<Usuario> implements UsuarioDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listaUsuarios() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		return criteria.list();
	}
}
