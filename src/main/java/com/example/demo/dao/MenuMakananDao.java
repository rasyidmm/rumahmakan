package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MenuMakananModel;

@Repository
@Transactional
public class MenuMakananDao extends MasterDao implements BaseMasterDao{

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
	public List<MenuMakananModel> getAll() {
		List<MenuMakananModel> list = emx.createQuery("From MenuMakananModel").getResultList();
		return list;
	}
	@SuppressWarnings("unchecked")
	public MenuMakananModel getById(UUID id) {
		List<MenuMakananModel> item = emx.createQuery("From MenuMakananModel where id=:id").setParameter("id", id).getResultList();
		return item.isEmpty() ? new MenuMakananModel() : item.get(0);
		
	}

}
