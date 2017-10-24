package com.test.daoGeneric;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DaoImpl<T> implements Dao<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> entityClass;

	public DaoImpl(Class<T> clazzToSet) {
		this.entityClass = clazzToSet;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public void save(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<T> selectAll() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(entityClass);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public T selectOne(BigInteger id) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq("id", id));
		criteria.setMaxResults(1);

		return (T) criteria.uniqueResult();

	}

	@Override
	public Boolean contains(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.contains(t);
	}

	@Override
	public void refresh(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.refresh(t);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(T t, BigInteger id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (T) session.get(t.getClass(), id);
	}

	@Override
	public T merge(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(t);
		return t;
	}
	
//	public void clear() {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.clear();
//	}
//
//	@Override
//	public void flush() {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.flush();
//	}
}
