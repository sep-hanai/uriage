package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.entity.StatusA;
import com.example.demo.entity.StatusB;
import com.example.demo.entity.StatusC;
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

	//ステータスB取得
	public List<StatusB> getStatusB() {
		return statusBRepository.findAllOrderById();
	}

	//ステータスC取得
	public List<StatusC> getStatusC() {
		return statusCRepository.findAllOrderById();
	}
}
