package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 売上管理 Clientマスタ引用Entity
 */
@Data
@Entity
public class Client implements Serializable {
	/**
	 * 顧客ID
	 */
	@Id
	private String clientid;

	/**
	 * 顧客名
	 */
	private String clientname;
}
