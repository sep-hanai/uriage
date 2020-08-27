package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.UriageService;

public class UriageController {

	@Autowired
	UriageService uriageService;
	/**
	 * 案件一覧画面
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
//		 Page<Uriage> playerPage = uriageService.getList(pageable);
//		 PageWrapper<Uriage> page = new PageWrapper<Uriage>(playerPage, "/index");
//		 model.addAttribute("page", page);
//		 model.addAttribute("jyusyolist", playerPage.getContent());
//       model.addAttribute("inputForm", new UriageForm());

       return "top";
   }
}
