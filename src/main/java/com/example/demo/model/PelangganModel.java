package com.example.demo.model;
import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
@SuppressWarnings("serial")
public class PelangganModel extends BaseEntity {

	private String namaPelanggan;
	private String alamat;
	private String nomerHp;
	private String email;
	public String getNamaPelanggan() {
		return namaPelanggan;
	}
	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNomerHp() {
		return nomerHp;
	}
	public void setNomerHp(String nomerHp) {
		this.nomerHp = nomerHp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
