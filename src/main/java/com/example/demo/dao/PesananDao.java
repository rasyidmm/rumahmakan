package com.example.demo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.PesananModel;
import com.example.demo.model.pojo.PojoPerhitungan;

@Repository
@Transactional
public class PesananDao extends MasterDao implements BaseMasterDao{

	@Override
	public <T> void save(T entity) throws Exception {
		// TODO Auto-generated method stub
		emx.persist(entity);
		
	}

	@Override
	public <T> void edit(T entity) throws Exception {
		emx.merge(entity);
		
	}

	@Override
	public <T> void delete(T entity) throws Exception {
		emx.remove(entity);
		
	}
	@SuppressWarnings("unchecked")
	public List<PesananModel> getAll() {
		List<PesananModel> list = emx.createQuery("From PesananModel").getResultList();
		return list;
	}
	@SuppressWarnings("unchecked")
	public PesananModel getById(UUID id) {
		List<PesananModel> item = emx.createQuery("From PesananModel where id=:id").setParameter("id", id).getResultList();
		return item.isEmpty() ? new PesananModel() : item.get(0);
		
	}

	

	@SuppressWarnings(  "unchecked" )
	public List<PojoPerhitungan> getPesananByIdPelanggan(UUID id) {
		List<PojoPerhitungan>list = new ArrayList<>();
		List<Object[]> listObj = new ArrayList<>();
		listObj = emx
				.createNativeQuery("select mmm.nama_makanan as namaMakanan,pm.jumlah_pesanan as jumlahPesanan,mmm.harga_makanan as hargaMakanan from pesanan_model pm join menu_makanan_model mmm on mmm.id =pm.makanan_model_id where pm.pelanggan_model_id=:id  ")
				.setParameter("id",id).getResultList();
		for (Object[] o : listObj) {
			PojoPerhitungan pojo = new PojoPerhitungan();
			pojo.setNamaMakanan((String)o[0]);
			pojo.setJumlahPesanan(((BigInteger) o[1]).longValue());
			pojo.setHargaMakanan(((BigInteger) o[2]).doubleValue());
			list.add(pojo);
		}
		return list;
	}

}
