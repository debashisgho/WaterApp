package com.dgtech.app.WaterApp.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class EntityGenericDaoImpl<E> implements EntityGenericDao<E> {
	
	
	private static EntityManager em =null;
	
	@Override
	public void add(E entity) {
		    setUpConnection();
		    EntityTransaction tx = em.getTransaction();
		    tx.begin();
			em.persist(entity);
			tx.commit();		
		    
	}

	
	@Override
	public void update(E entity) {
		setUpConnection();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(entity);		
		tx.commit();
	}
	
	
	@Override
	public void deleteById(Long uniqueId) {
		setUpConnection();
		EntityTransaction tx = em.getTransaction();
		List<E> entityList = searchById(uniqueId);
		E singleEntity = entityList.get(0);
		tx.begin();		
		em.remove(singleEntity);
		tx.commit();		
	}

		
	public void setUpConnection() {
		if(em ==null){
	    em = Persistence.createEntityManagerFactory("WaterAppPU").createEntityManager();
		}
	}

	public EntityManager getEm() {
		return em;
	}

		
	}





