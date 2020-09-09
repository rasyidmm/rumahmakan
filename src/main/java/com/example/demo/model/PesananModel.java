package com.example.demo.model;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
@SuppressWarnings("serial")
public class PesananModel extends BaseEntity {
	@ManyToOne
	private MenuMakananModel makananModel;
	@ManyToOne
	private PelangganModel pelangganModel;
	private Long jumlahPesanan;
	private String Status;
	
	public MenuMakananModel getMakananModel() {
		return makananModel;
	}
	public void setMakananModel(MenuMakananModel makananModel) {
		this.makananModel = makananModel;
	}
	public PelangganModel getPelangganModel() {
		return pelangganModel;
	}
	public void setPelangganModel(PelangganModel pelangganModel) {
		this.pelangganModel = pelangganModel;
	}
	
	public Long getJumlahPesanan() {
		return jumlahPesanan;
	}
	public void setJumlahPesanan(Long jumlahPesanan) {
		this.jumlahPesanan = jumlahPesanan;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
