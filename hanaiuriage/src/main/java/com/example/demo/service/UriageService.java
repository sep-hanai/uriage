package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.entity.Insert;
import com.example.demo.entity.StatusA;
import com.example.demo.entity.Uriage;
import com.example.demo.repository.AddRepository;
import com.example.demo.repository.StatusARepository;
import com.example.demo.repository.StatusBRepository;
import com.example.demo.repository.StatusCRepository;
import com.example.demo.repository.UriageRepository;

/**
 * 売上管理 Service
 */
@Service
public class UriageService {
	@Autowired
	UriageRepository uriageRepository;

	@Autowired
	AddRepository addRepository;

	@Autowired
	StatusARepository statusARepository;

	@Autowired
	StatusBRepository statusBRepository;

	@Autowired
	StatusCRepository statusCRepository;

	/**
	 * 全件検索
	 * @return 検索結果
	 * Page型で全件取得
	 */
	public List<Uriage> getList() {
        return uriageRepository.findAllOrderById();
    }
//	    public List<Uriage> getList(Pageable pageable) {
//	        return uriageRepository.findAllOrderById(pageable);
//	    }

	//顧客ID,Name取得
	public List<Client> getClient() {
		return addRepository.findAllOrderById();
	}
	//ステータスA取得
	public List<StatusA> getStatusA(){
		return statusARepository.findAllOrderById();
	}

	/**
	 * 顧客・ステータスIDからName取得
	 */
	public List<StatusA> getSelectName(String clientid, String statusid) {
		return statusARepository.findByName(clientid, statusid);
	}

	/**
	 * 顧客・ステータスIDからName取得
	 */
	public List<Client> getSelectClient(String clientid) {
		return addRepository.findByClient(clientid);
	}

	public String[] getErr(Insert insert) {
		String errAll[] = new String[10];

		String clientid = insert.getClientid();
		String subject = insert.getSubject();
		if(clientid=="" || subject=="") {
			errAll[1]="必須項目です。";
			errAll[4]="必須項目です。";
		}

		try {
		String date[] = new String[4];
		date[0] = insert.getOrderdate();
		date[1] = insert.getDeadline();
		date[2] = insert.getDuedate();
		date[3] = insert.getBillingdate();
		boolean empty = true;
		for (int i=0; i<date.length; i++) {
		  if(date[i]=="") {
		  }else if (date[i].matches(".*^[0-9]{4}/[0-9]{2}/[0-9]{}.*") != true || 8 < date[i].getBytes("Shift_JIS").length || (1 <= date[i].getBytes("Shift_JIS").length && 8 > date[i].getBytes("Shift_JIS").length)) {
		    empty = false;
		    break;
		  }
		}
		//エラー有り
		if(empty == false){
			errAll[2]="0000/00/00の形で入力してください。";
			errAll[6]="0000/00/00の形で入力してください。";
			errAll[7]="0000/00/00の形で入力してください。";
			errAll[8]="0000/00/00の形で入力してください。";
		}
		}catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
		String snumber = insert.getSnumber();
		int t = snumber.getBytes("Shift_JIS").length;
		if(snumber != "" && t != 4) {
			errAll[3]="S番号は半角数字4桁で入力してください。";
		}
		}catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return errAll;

	}
}
