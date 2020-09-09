package com.example.demo.model.pojo;

import java.util.List;

import com.example.demo.model.PelangganModel;
import com.example.demo.model.PembayaranModel;

public class PojoDetailPembayaran {
	private PelangganModel pelanggan;
	private List<PojoPerhitungan>makanan;
	private PembayaranModel pembayaran;
	public PelangganModel getPelanggan() {
		return pelanggan;
	}
	public void setPelanggan(PelangganModel pelanggan) {
		this.pelanggan = pelanggan;
	}
	
	public List<PojoPerhitungan> getMakanan() {
		return makanan;
	}
	public void setMakanan(List<PojoPerhitungan> makanan) {
		this.makanan = makanan;
	}
	public PembayaranModel getPembayaran() {
		return pembayaran;
	}
	public void setPembayaran(PembayaranModel pembayaran) {
		this.pembayaran = pembayaran;
	}
	
}
