package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 売上管理 表示用Entity
 */
@Data
@Entity
public class Uriage implements Serializable{
	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/**
	 * 顧客名
	 */
	private String clientname;
	/**
	 * 受注日
	 */
	private String orderdate;
	/**
	 * S番号
	 */
	private String snumber;
	/**
	 * 件名
	 */
	private String subject;
	/**
	 * 数量
	 */
	private String quantity;
	/**
	 * 納入指定日
	 */
	private String deadline;
	/**
	 * 納入日
	 */
	private String duedate;
	/**
	 * 請求日
	 */
	private String billingdate;
	/**
	 * 見積金額
	 */
	private String estimate;
	/**
	 * 受注金額
	 */
	private String decision;
	/**
	 * ステータス名
	 */
	private String statusname;
	/**
	 * 備考
	 */
	private String note;
	/**
	 * 削除フラグ
	 */
	private String delete_flg;
}

