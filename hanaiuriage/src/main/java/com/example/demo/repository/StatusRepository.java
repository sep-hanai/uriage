package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository <Status, Long>{
	@Query(value = "SELECT DISTINCT statusid, statusname FROM uriagemasta ORDER BY mastaid ASC", nativeQuery = true)
	List<Status> findAllOrderById();
}
