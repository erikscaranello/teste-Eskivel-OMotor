package com.test.daoGeneric;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public interface Dao<T> extends Serializable {

	void save(T t);

	void delete(T t);

	public List<T> selectAll();

	public T selectOne(BigInteger id);

	Boolean contains(T t);
	
	void refresh(T t);

	T load(T t, BigInteger id);
	
	T merge(T t);
}
