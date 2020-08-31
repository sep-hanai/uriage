package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Uriage;

/**
 * 売上管理repository
 */
@Repository
public interface UriageRepository extends JpaRepository<Uriage, Long>{
	/**
	 * 全件取得
	 * 売上テーブル=u
	 * マスターテーブル=m
	 * @return
	 */
	@Query(value = "SELECT uriage.id as id, uriagemasta.clientname as clientname, uriage.orderdate as orderdate, uriage.snumber as snumber, "
			+ "uriage.subject as subject, uriage.quantity as quantity, uriage.deadline as deadline, "
			+ "uriage.duedate as duedate, uriage.billingdate as billingdate, uriage.estimate as estimate, uriage.decision as decision,"
			+ " uriagemasta.statusname as statusname, uriage.note as note, uriage.delete_flg as delete_flg "
			+ "from uriage"
			+ " join uriagemasta on uriagemasta.clientid = uriage.clientid "
			+ "WHERE uriage.delete_flg=0 ORDER BY uriage.id", nativeQuery = true)
	List<Uriage> findAllOrderById();

	//全件取得
//	@Query("SELECT  FROM  WHERE uriage.delete_flg=0 ORDER BY uriage.id")
//	Page<Uriage> findAllOrderById(Pageable pageable);
}
