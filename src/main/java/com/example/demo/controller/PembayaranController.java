package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.factory.ServiceFac;
import com.example.demo.model.pojo.PojoDetailPembayaran;
import com.example.demo.util.RestResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({"/api/v1/pembayaran"})
public class PembayaranController {
	@Autowired
	ServiceFac service;
	RestResponse result;
	@SuppressWarnings("unchecked")
	@PutMapping(value = "/{id}")
	ResponseEntity<?>PembayaranByIdPelanggan(@PathVariable UUID id){
		result = new RestResponse<>();
		try {
			PojoDetailPembayaran dibayar = service.getPembayaranService().Pembayaran(id);
			result.setSuccess(true);
			result.setDatas(dibayar);
			result.setMessage("Pembayaran Sukses");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
}
