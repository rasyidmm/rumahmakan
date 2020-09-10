package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.factory.DaoFac;
import com.example.demo.model.JenisMakanan;

@Service
public class JenisMakananService {
	@Autowired
	DaoFac dao;
	
	public void addJenis(JenisMakanan jenisMakanan) throws Exception {
		try {
			dao.getJenisMakananDao().save(jenisMakanan);
		} catch (Exception e) {
			e.getMessage();
		}
				
	}

	public List<JenisMakanan> getAll() {
		return  dao.getJenisMakananDao().getAll();
	}

	public JenisMakanan getById(UUID id) {
		
		return dao.getJenisMakananDao().getById(id);
	}

	public void getUpdate(JenisMakanan jenisMakanan) throws Exception {
		JenisMakanan jenis = dao.getJenisMakananDao().getById(jenisMakanan.getId());
		jenis.setJenisMakanan(jenisMakanan.getJenisMakanan());
		jenis.setDescription(jenisMakanan.getDescription());
		dao.getJenisMakananDao().edit(jenis);
	}

	public void delete(UUID id) throws Exception {
		
		JenisMakanan jenis = dao.getJenisMakananDao().getById(id);
		if(jenis !=null) {
			dao.getJenisMakananDao().delete(jenis);
		}else {
			 throw new Exception("item tidak ditemukan");
		}
		
	}

}
