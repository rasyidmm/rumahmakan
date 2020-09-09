package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.factory.DaoFac;
import com.example.demo.model.PelangganModel;

@Service
public class PelangganService {
	@Autowired
	DaoFac dao;

	public void add(PelangganModel pelanggan) {
		try {
			PelangganModel pelangganModel =  new PelangganModel();
			pelangganModel.setNamaPelanggan(pelanggan.getNamaPelanggan());
			pelangganModel.setAlamat(pelanggan.getAlamat());
			pelangganModel.setEmail(pelanggan.getEmail());
			pelangganModel.setNomerHp(pelanggan.getNomerHp());
			dao.getPelangganDao().save(pelangganModel);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		
	}

	public List<PelangganModel> getAll() {
		return dao.getPelangganDao().getAll();
	}

	public void update(PelangganModel pelanggan) {
		try {
			PelangganModel pelangganModel =  dao.getPelangganDao().getById(pelanggan.getId());
			pelangganModel.setNamaPelanggan(pelanggan.getNamaPelanggan());
			pelangganModel.setAlamat(pelanggan.getAlamat());
			pelangganModel.setEmail(pelanggan.getEmail());
			pelangganModel.setNomerHp(pelanggan.getNomerHp());
			dao.getPelangganDao().edit(pelangganModel);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}

	public PelangganModel getById(UUID id) {
		return dao.getPelangganDao().getById(id);
	}

	public void delete(UUID id) throws Exception {
		PelangganModel pelangganModel = dao.getPelangganDao().getById(id);
		if(pelangganModel !=null) {
			dao.getPelangganDao().delete(pelangganModel);
		}else {
			 throw new Exception("item tidak ditemukan");
		}
		
	}

}
