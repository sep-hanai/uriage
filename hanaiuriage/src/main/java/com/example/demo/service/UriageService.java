package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AddEntity;
import com.example.demo.entity.Uriage;
import com.example.demo.repository.AddRepository;
import com.example.demo.repository.UriageRepository;

/**
 * 売上管理 Service
 */
@Service
public class UriageService {
	@Autowired
	UriageRepository uriageRepository;
	AddRepository addRepository;

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
	public List<AddEntity> getId() {
		return addRepository.findAllOrderById();
	}
}
