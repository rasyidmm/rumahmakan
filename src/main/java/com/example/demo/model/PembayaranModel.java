package com.example.demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Entity
@Cacheable
@SuppressWarnings("serial")
public class PembayaranModel extends BaseEntity {
	private Double totalPembayaran;
	@OneToOne
	private PelangganModel pelangganModel;
	public Double getTotalPembayaran() {
		return totalPembayaran;
	}
	public void setTotalPembayaran(Double totalPembayaran) {
		this.totalPembayaran = totalPembayaran;
	}
	public PelangganModel getPelangganModel() {
		return pelangganModel;
	}
	public void setPelangganModel(PelangganModel pelangganModel) {
		this.pelangganModel = pelangganModel;
	}
	
	

}
