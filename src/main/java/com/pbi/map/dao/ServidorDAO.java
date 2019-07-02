package com.pbi.map.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pbi.map.entity.ServidorEntity;

@Repository
public interface ServidorDAO extends JpaRepository<ServidorEntity, Integer> {
	
	@Query("SELECT obj FROM ServidorEntity obj WHERE obj.nome LIKE %:nome%")
	List<ServidorEntity> search(@Param("nome") String nome);
	
}
