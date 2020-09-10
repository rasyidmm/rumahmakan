package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.factory.DaoFac;
import com.example.demo.model.MenuMakananModel;

@Service
public class MenuMakananService {
	@Autowired
	DaoFac dao;
	public void AddMenuMakanan(MenuMakananModel makananModel) throws Exception {
		try {
			MenuMakananModel menuMakananModel = new MenuMakananModel();
			menuMakananModel.setNamaMakanan(makananModel.getNamaMakanan());
			menuMakananModel.setDescripsiMakanan(makananModel.getDescripsiMakanan());
			menuMakananModel.setHargaMakanan(makananModel.getHargaMakanan());
			menuMakananModel.setStatusMakanan(true);
			menuMakananModel.setJenisMakanan(dao.getJenisMakananDao().getById(makananModel.getJenisMakanan().getId()));
			dao.getMenuMakananDao().save(menuMakananModel);
		} catch (Exception e) {
			e.getMessage();
		}
		
	
		
	}
	public List<MenuMakananModel> getAll() {
		return dao.getMenuMakananDao().getAll();
	}
	public MenuMakananModel getById(UUID id) {
		return dao.getMenuMakananDao().getById(id);
	}
	public void update(MenuMakananModel makananModel) {
		try {
			MenuMakananModel menuMakananModel = dao.getMenuMakananDao().getById(makananModel.getId());
			menuMakananModel.setNamaMakanan(makananModel.getNamaMakanan());
			menuMakananModel.setDescripsiMakanan(makananModel.getDescripsiMakanan());
			menuMakananModel.setHargaMakanan(makananModel.getHargaMakanan());
			menuMakananModel.setStatusMakanan(true);
			menuMakananModel.setJenisMakanan(dao.getJenisMakananDao().getById(makananModel.getId()));
			dao.getMenuMakananDao().edit(menuMakananModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void delete(UUID id) {
		MenuMakananModel makananModel = dao.getMenuMakananDao().getById(id);
		try {
			dao.getMenuMakananDao().delete(makananModel);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
