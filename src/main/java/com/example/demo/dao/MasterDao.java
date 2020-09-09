package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MasterDao {
	@PersistenceContext
	protected EntityManager emx;
}
