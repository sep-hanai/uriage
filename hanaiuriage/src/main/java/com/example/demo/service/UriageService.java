package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Uriage;
import com.example.demo.repository.UriageRepository;

/**
 * 売上管理 Service
 */
@Service
public class UriageService {
	@Autowired
	UriageRepository uriageRepository;

	/**
	 * 全件検索
	 * @return 検索結果
	 * Page型で全件取得
	 */
	    public Page<Uriage> getList(Pageable pageable) {
	        return uriageRepository.findAllOrderById(pageable);
	    }
}
