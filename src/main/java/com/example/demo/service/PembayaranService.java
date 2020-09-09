package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.factory.DaoFac;
import com.example.demo.model.PembayaranModel;
import com.example.demo.model.PesananModel;
import com.example.demo.model.pojo.PojoDetailPembayaran;
import com.example.demo.model.pojo.PojoPerhitungan;

@Service
public class PembayaranService {
	@Autowired
	DaoFac dao;

	public PojoDetailPembayaran Pembayaran(UUID id) throws Exception {
		List<PojoPerhitungan> makanan = dao.getPesananDao().getPesananByIdPelanggan(id);
		Double Jumlah = 0.0;
		for(PojoPerhitungan item :makanan ) {
			Double harga= item.getHargaMakanan().doubleValue();
			Double jumlahpesana = item.getJumlahPesanan().doubleValue();
			Jumlah = harga * jumlahpesana+Jumlah;
		}
		PembayaranModel pembayaranModel = new PembayaranModel();
		pembayaranModel.setPelangganModel(dao.getPelangganDao().getById(id));
		pembayaranModel.setTotalPembayaran(Jumlah);
		dao.getPembayaranDao().save(pembayaranModel);
		PojoDetailPembayaran detailPembayaran = new PojoDetailPembayaran();
		detailPembayaran.setPelanggan(dao.getPelangganDao().getById(id));
		detailPembayaran.setMakanan(makanan);
		detailPembayaran.setPembayaran(dao.getPembayaranDao().getByIdPelanggan(id));
		return detailPembayaran;
	}


}
