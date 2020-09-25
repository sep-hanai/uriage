package com.example.demo.form;
import java.io.Serializable;

import lombok.Data;

@Data
public class UriageForm implements Serializable{
	/**
	 * id
	 */
	private Long id;
	/**
	 * 顧客id
	 */
	private String clientid;
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
	 * ステータスid
	 */
	private String statusid;
	/**
	 * 備考
	 */
	private String note;
	/**
	 * 削除フラグ
	 */
	private String delete_flg;
}
