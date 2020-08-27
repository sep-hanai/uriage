package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Uriage;

/**
 * 売上管理repository
 */
@Repository
public interface UriageRepository extends JpaRepository<Uriage, Long>{
	//全件取得
	@Query("SELECT u FROM Uriage u WHERE u.delete_flg=0 ORDER BY u.id")
	Page<Uriage> findAllOrderById(Pageable pageable);
}
