package com.dgtech.app.WaterApp.services.rs;

import java.util.List;

import com.dgtech.app.WaterApp.ejb.EntityGenericDao;

public abstract class ResourceGenericImpl<E> implements ResourceGeneric<E> {
	
	@Override
	public String getAllResourcesJson(EntityGenericDao<E> entityDao) {
		List<E> entityList = entityDao.listAll();
    	return buildResourceJson(entityList);
	}

	@Override
	public String getSingleResourceJson(EntityGenericDao<E> entityDao, final Long uniqueId) {
		List<E> entityList = entityDao.searchById(uniqueId);
		return buildResourceJson(entityList);
	}

	@Override
	public void createResource(EntityGenericDao<E> entityDao, E entity) {
		entityDao.add(entity);
	}

	@Override
	public void deleteResourceById(EntityGenericDao<E> entityDao, Long uniqueId) {
		entityDao.deleteById(uniqueId); 
	}

	@Override
	public void updateResource(EntityGenericDao<E> entityDao, E entity) {
		entityDao.update(entity);
		
	}

	
	

	
}
