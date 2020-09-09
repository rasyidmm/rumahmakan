package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.factory.DaoFac;
import com.example.demo.model.PesananModel;

@Service
public class PesananService {
	@Autowired
	DaoFac dao;

	public void add(PesananModel pesanan) {
		try {
			PesananModel pesan = new  PesananModel();
			pesan.setJumlahPesanan((long) 2);
			pesan.setMakananModel(dao.getMenuMakananDao().getById(pesanan.getMakananModel().getId()));
			pesan.setPelangganModel(dao.getPelangganDao().getById(pesanan.getPelangganModel().getId()));
			pesan.setStatus("Diproses");
			dao.getPesananDao().save(pesan);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public List<PesananModel> getAll() {
		return dao.getPesananDao().getAll();
	}

	public void update(PesananModel pesanan) {
		try {
			PesananModel pesan =dao.getPesananDao().getById(pesanan.getId());
			pesan.setJumlahPesanan(pesanan.getJumlahPesanan());
			pesan.setMakananModel(dao.getMenuMakananDao().getById(pesanan.getMakananModel().getId()));
			pesan.setPelangganModel(dao.getPelangganDao().getById(pesanan.getPelangganModel().getId()));
			pesan.setStatus("Diproses");
			dao.getPesananDao().edit(pesan);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}

	public PesananModel getById(UUID id) {
		return dao.getPesananDao().getById(id);
	}

	public void delete(UUID id) throws Exception {
		PesananModel data = dao.getPesananDao().getById(id);
		if(data!=null) {
			dao.getPesananDao().delete(data);
		}else {
			 throw new Exception("item tidak ditemukan");
		}
		
	}

	public void pesananDone(UUID id) {
		try {
			PesananModel pesan = dao.getPesananDao().getById(id);
			pesan.setStatus("Done");
			dao.getPesananDao().edit(pesan);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}

}
