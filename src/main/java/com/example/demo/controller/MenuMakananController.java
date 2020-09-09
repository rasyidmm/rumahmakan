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
import com.example.demo.model.MenuMakananModel;
import com.example.demo.util.RestResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({"/api/v1/menu-makanan"})
public class MenuMakananController {
	@Autowired
	ServiceFac service;
	@SuppressWarnings("rawtypes")
	RestResponse result;
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/")
	ResponseEntity<?>Add(@RequestBody MenuMakananModel makananModel){
		result = new RestResponse<>();
		try {
			service.getMenuMakananService().AddMenuMakanan(makananModel);
			result.setSuccess(true);
			result.setMessage("Add Jenis Makanan Sukses");
			result.setDatas(makananModel);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			result.setDatas(makananModel);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/")
	ResponseEntity<?>getAll(){
		result = new RestResponse<>();
		try {
			List<MenuMakananModel> list = service.getMenuMakananService().getAll();
			result.setSuccess(true);
			result.setMessage("Add Jenis Makanan Sukses");
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
	ResponseEntity<?>Update(@RequestBody MenuMakananModel menumakanan){
		result = new RestResponse<>();
		try {
			service.getMenuMakananService().update(menumakanan);
			result.setSuccess(true);
			result.setMessage("Get All Jenis Makanan Sukses");
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
			MenuMakananModel data = service.getMenuMakananService().getById(id);
			result.setSuccess(true);
			result.setMessage("Add Jenis Makanan Sukses");
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
			service.getMenuMakananService().delete(id);
			result.setSuccess(true);
			result.setMessage("Add Jenis Makanan Sukses");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	
}
