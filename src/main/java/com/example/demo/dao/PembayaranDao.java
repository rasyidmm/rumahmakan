package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.PembayaranModel;

@Repository
@Transactional
public class PembayaranDao extends MasterDao implements BaseMasterDao{

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
	public List<PembayaranModel> getAll() {
		List<PembayaranModel> list = emx.createQuery("From PembayaranModel").getResultList();
		return list;
	}
	@SuppressWarnings("unchecked")
	public PembayaranModel getById(UUID id) {
		List<PembayaranModel> item = emx.createQuery("From PembayaranModel where id=:id").setParameter("id", id).getResultList();
		return item.isEmpty() ? new PembayaranModel() : item.get(0);
		
	}

	@SuppressWarnings("unchecked")
	public PembayaranModel getByIdPelanggan(UUID id) {
		List<PembayaranModel> item = emx.createQuery("From PembayaranModel where pelangganModel.id=:id").setParameter("id", id).getResultList();
		return item.isEmpty() ? new PembayaranModel() : item.get(0);
	}

}
