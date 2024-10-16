package com.luisyepes.lionwallet.dao;

import org.springframework.data.repository.CrudRepository;

import com.luisyepes.lionwallet.domain.Movement;

public interface MovementDao extends CrudRepository<Movement, Long> {

}
