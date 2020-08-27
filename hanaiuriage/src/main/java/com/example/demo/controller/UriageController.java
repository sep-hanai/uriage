package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Uriage;
import com.example.demo.service.UriageService;

@Controller
public class UriageController {

	@Autowired
	UriageService uriageService;
	/**
	 * 案件一覧画面
	 * @param pageable
	 * @param model
	 * @return 案件一覧画面
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(@PageableDefault(page = 0, size = 10) Pageable pageable,Model model) {
		 Page<Uriage> uriagePage = uriageService.getList(pageable);
//		 PageWrapper<Uriage> page = new PageWrapper<Uriage>(playerPage, "/index");
//		 model.addAttribute("page", page);
//		 model.addAttribute("jyusyolist", playerPage.getContent());
//       model.addAttribute("inputForm", new UriageForm());

       return "top";
   }
}
