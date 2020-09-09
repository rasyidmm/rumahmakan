package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.JenisMakanan;

@Repository
@Transactional
public class JenisMakananDao extends MasterDao implements BaseMasterDao {

	@Override
	public <T> void save(T entity) throws Exception {
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
	public List<JenisMakanan> getAll() {
		List<JenisMakanan> list = emx.createQuery("From JenisMakanan").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public JenisMakanan getById(UUID id) {
		List<JenisMakanan> item = emx.createQuery("From JenisMakanan where id=:id").setParameter("id", id).getResultList();
		return item.isEmpty() ? new JenisMakanan() : item.get(0);
		
	}

	
}
