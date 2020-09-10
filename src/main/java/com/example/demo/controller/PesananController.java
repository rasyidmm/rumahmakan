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
import com.example.demo.model.PesananModel;
import com.example.demo.util.RestResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({"/api/v1/pesanan"})
public class PesananController {
	@Autowired
	ServiceFac service;
	@SuppressWarnings("rawtypes")
	RestResponse result;
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/")
	ResponseEntity<?>Add(@RequestBody PesananModel pesanan){
		result = new RestResponse<>();
		try {
			service.getPesananService().add(pesanan);
			result.setSuccess(true);
			result.setMessage("Add Pesanan Sukses");
			result.setDatas(pesanan);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			result.setDatas(pesanan);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/")
	ResponseEntity<?>getAll(){
		result = new RestResponse<>();
		try {
			List<PesananModel> list = service.getPesananService().getAll();
			result.setSuccess(true);
			result.setMessage("Get Pesanan Sukses");
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
	ResponseEntity<?>Update(@RequestBody PesananModel pesanan){
		result = new RestResponse<>();
		try {
			service.getPesananService().update(pesanan);
			result.setSuccess(true);
			result.setMessage("Update Pesanan Sukses");
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
	ResponseEntity<?>getById(@PathVariable UUID id){
		result = new RestResponse<>();
		try {
			PesananModel data = service.getPesananService().getById(id);
			result.setSuccess(true);
			result.setMessage("Get By Id Sukses");
			result.setDatas(data);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<?>delete(@PathVariable UUID id){
		try {
			service.getPesananService().delete(id);
			result.setSuccess(true);
			result.setMessage("Delete pesanan Sukses");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}

	@PutMapping(value = "/done/{id}")
	ResponseEntity<?>PesananDone(@PathVariable UUID id){
		try {
			service.getPesananService().pesananDone(id);
			result.setSuccess(true);
			result.setMessage("Change Status Pesanan Done Sukses");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	
}
