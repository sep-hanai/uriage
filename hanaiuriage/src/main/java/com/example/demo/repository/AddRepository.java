package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;
@Repository
public interface AddRepository extends JpaRepository <Client, Long>{
	@Query(value = "SELECT DISTINCT clientid, clientname FROM uriagemasta ORDER BY mastaid ASC", nativeQuery = true)
	List<Client> findAllOrderById();

	@Query(value = "SELECT DISTINCT clientid, clientname FROM uriagemasta WHERE clientid LIKE :clientid", nativeQuery  = true)
	List<Client> findByClient(@Param("clientid") String clientid);
}
