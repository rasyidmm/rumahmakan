package com.example.demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@Cacheable
@SuppressWarnings("serial")
public class MenuMakananModel extends BaseEntity {

	private String namaMakanan;
	private String descripsiMakanan;
	private Long hargaMakanan;
	private Boolean statusMakanan;
	@ManyToOne
	private JenisMakanan jenisMakanan;
	public String getNamaMakanan() {
		return namaMakanan;
	}
	public void setNamaMakanan(String namaMakanan) {
		this.namaMakanan = namaMakanan;
	}
	public String getDescripsiMakanan() {
		return descripsiMakanan;
	}
	public void setDescripsiMakanan(String descripsiMakanan) {
		this.descripsiMakanan = descripsiMakanan;
	}
	public Long getHargaMakanan() {
		return hargaMakanan;
	}
	public void setHargaMakanan(Long hargaMakanan) {
		this.hargaMakanan = hargaMakanan;
	}
	
	public Boolean getStatusMakanan() {
		return statusMakanan;
	}
	public void setStatusMakanan(Boolean statusMakanan) {
		this.statusMakanan = statusMakanan;
	}
	public JenisMakanan getJenisMakanan() {
		return jenisMakanan;
	}
	public void setJenisMakanan(JenisMakanan jenisMakanan) {
		this.jenisMakanan = jenisMakanan;
	}
	
	
	

}
