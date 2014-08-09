package com.dgtech.app.WaterApp.ejb;

import java.util.List;

public interface EntityGenericDao <E>{
	
	public void add(E entity);
	public void deleteById(Long uniqueId);
	public void update(E entity);
	public List<E> searchById(Long uniqueId);
	public List<E> listAll();
}



