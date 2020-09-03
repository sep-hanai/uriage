package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

/**
 * 売上管理 マスタ引用Entity
 */
@Data
@Entity
public class AddEntity implements Serializable {
	/**
	 * 顧客ID
	 */
	private String clientid;

	/**
	 * 顧客名
	 */
	private String clientname;

	/**
	 * ステータスID
	 */
	private String statusid;

	/**
	 * ステータス名
	 */
	private String statusname;
}
