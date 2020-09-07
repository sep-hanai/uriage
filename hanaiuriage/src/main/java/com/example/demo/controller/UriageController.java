package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Client;
import com.example.demo.entity.StatusA;
import com.example.demo.entity.StatusB;
import com.example.demo.entity.StatusC;
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
//		 List<Uriage> uriagePage = uriageService.getList(pageable);
		List<Uriage> uriagePage = uriageService.getList();
//		 PageWrapper<Uriage> page = new PageWrapper<Uriage>(playerPage, "/index");
//		 model.addAttribute("page", page);
//		 model.addAttribute("jyusyolist", playerPage.getContent());
//       model.addAttribute("uriageForm", new UriageForm());
		 model.addAttribute("uriagePage",uriagePage);
       return "top";
   }

	/**
	 * 新規登録画面へ遷移
	 * @return 登録画面表示
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model) {
		//顧客ID、Name取得
		List<Client> addClient = uriageService.getClient();
		model.addAttribute("addClient", addClient);

		//ステータスA取得
		List<StatusA> addStatusA = uriageService.getStatusA();
		model.addAttribute("addStatusA", addStatusA);

		//ステータスB取得
		List<StatusB> addStatusB = uriageService.getStatusB();
		model.addAttribute("addStatusB", addStatusB);

		//ステータスC取得
		List<StatusC> addStatusC = uriageService.getStatusC();
		model.addAttribute("addStatusC", addStatusC);

		model.addAttribute("uriage", new Uriage());
		return "add";
	}
}
