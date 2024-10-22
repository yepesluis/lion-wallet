package com.luisyepes.lionwallet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.luisyepes.lionwallet.domain.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {

	List<Category> findByName(String name);

}
