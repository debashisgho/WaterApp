package com.dgtech.app.WaterApp.services.rs;

import java.util.List;

import com.dgtech.app.WaterApp.ejb.EntityGenericDao;

public interface ResourceGeneric<E> {
	
 public void createResource(EntityGenericDao<E> entityDao, E entity);
 public void deleteResourceById(EntityGenericDao<E> entityDao, final Long uniqueId);
 public void updateResource(EntityGenericDao<E> entityDao, E entity);
 
 public String getAllResourcesJson(EntityGenericDao<E> entityDao);
 public String getSingleResourceJson(EntityGenericDao<E> entityDao, final Long uniqueId);

 
 public String buildResourceJson(List<E> resourceList);
 public E parseSingleResourceFromJson(String jsonString) throws Exception;

}
