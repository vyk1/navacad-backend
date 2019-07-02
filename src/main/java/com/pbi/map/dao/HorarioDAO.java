package com.pbi.map.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbi.map.entity.HorarioEntity;

@Repository
public interface HorarioDAO extends JpaRepository<HorarioEntity, Integer> {
	
}
