package com.example.demo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.JenisMakananService;
import com.example.demo.service.MenuMakananService;
import com.example.demo.service.PelangganService;
import com.example.demo.service.PembayaranService;
import com.example.demo.service.PesananService;

@Component
public class ServiceFac {
	@Autowired
	JenisMakananService jenisMakananService;
	public JenisMakananService getJenisMakananService() {
		return jenisMakananService;
	}
	
	@Autowired
	MenuMakananService menuMakananService;
	public MenuMakananService getMenuMakananService() {
		return menuMakananService;
	}
	
	@Autowired
	PelangganService pelangganService;
	public PelangganService getPelangganService() {
		return pelangganService;
	}
	
	@Autowired
	PembayaranService pembayaranService;
	public PembayaranService getPembayaranService() {
		return pembayaranService;
	}
	@Autowired
	PesananService pesananService;
	public PesananService getPesananService() {
		return pesananService;
	}
}
