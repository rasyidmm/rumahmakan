package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.PelangganModel;

@Repository
@Transactional
public class PelangganDao extends MasterDao implements BaseMasterDao {

	@Override
	public <T> void save(T entity) throws Exception {
		// TODO Auto-generated method stub
		emx.persist(entity);
		
	}

	@Override
	public <T> void edit(T entity) throws Exception {
		emx.merge(entity);
		
	}

	@Override
	public <T> void delete(T entity) throws Exception {
		emx.remove(entity);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PelangganModel> getAll() {
		List<PelangganModel> list = emx.createQuery("From PelangganModel").getResultList();
		return list;
	}
	@SuppressWarnings("unchecked")
	public PelangganModel getById(UUID id) {
		List<PelangganModel> item = emx.createQuery("From PelangganModel where id=:id").setParameter("id", id).getResultList();
		return item.isEmpty() ? new PelangganModel() : item.get(0);
		
	}


}
