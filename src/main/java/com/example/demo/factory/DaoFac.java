package com.example.demo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.JenisMakananDao;
import com.example.demo.dao.MenuMakananDao;
import com.example.demo.dao.PelangganDao;
import com.example.demo.dao.PembayaranDao;
import com.example.demo.dao.PesananDao;

@Component
public class DaoFac {
	
	@Autowired
	JenisMakananDao jenisMakananDao;
	public JenisMakananDao getJenisMakananDao() {
		return jenisMakananDao;
	}
	
	@Autowired
	MenuMakananDao menuMakananDao;
	public MenuMakananDao getMenuMakananDao() {
		return menuMakananDao; 
	}
	
	@Autowired
	PelangganDao pelangganDao;
	public PelangganDao getPelangganDao() {
		return pelangganDao;
	}
	
	@Autowired
	PembayaranDao pembayaranDao;
	public PembayaranDao getPembayaranDao() {
		return pembayaranDao;
	}
	@Autowired
	PesananDao pesananDao;
	public PesananDao getPesananDao() {
		return pesananDao;
	}
}
