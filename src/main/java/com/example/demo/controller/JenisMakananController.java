package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.factory.ServiceFac;
import com.example.demo.model.JenisMakanan;
import com.example.demo.util.RestResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({"/api/v1/jenis-makanan"})
public class JenisMakananController {
	@Autowired
	ServiceFac service;
	@SuppressWarnings("rawtypes")
	RestResponse result;
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/")
	public ResponseEntity<?>Add(@RequestBody JenisMakanan jenisMakanan){
		result = new RestResponse<>();
		try {
			service.getJenisMakananService().addJenis(jenisMakanan);
			result.setSuccess(true);
			result.setMessage("Add Jenis Makanan Sukses");
			result.setDatas(jenisMakanan);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			result.setDatas(jenisMakanan);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/")
	public ResponseEntity<?>getall(){
		result = new RestResponse<>();
		try {
			List<JenisMakanan> list = service.getJenisMakananService().getAll();
			result.setSuccess(true);
			result.setMessage("Get All Jenis Makanan Sukses");
			result.setDatas(list);
			result.setCount((long) list.size());
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}	
	}
	@PutMapping(value = "/")
	public ResponseEntity<?>update(@RequestBody JenisMakanan jenisMakanan){
		try {
			service.getJenisMakananService().getUpdate(jenisMakanan);
			result.setSuccess(true);
			result.setMessage("Update Jenis Makanan Sukses");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>getById(@PathVariable UUID id){
		result = new RestResponse<>();
		try {
			JenisMakanan item = service.getJenisMakananService().getById(id);
			result.setSuccess(true);
			result.setMessage("Get By Id Jenis Makanan Sukses");
			result.setDatas(item);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?>Delete(@PathVariable UUID id){
		try {
			service.getJenisMakananService().delete(id);
			result.setSuccess(true);
			result.setMessage("Delete Jenis Makanan Sukses");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	
	

}
