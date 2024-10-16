package com.luisyepes.lionwallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisyepes.lionwallet.domain.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
