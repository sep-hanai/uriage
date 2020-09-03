package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AddEntity;
@Repository
public interface AddRepository extends JpaRepository <AddEntity, String>{
	@Query(value = "SELECT * FROM uriagemasta ORDER BY clientid ASC", nativeQuery = true)
	List<AddEntity> findAllOrderById();
}
