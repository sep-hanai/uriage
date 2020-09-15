package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Client;
import com.example.demo.entity.Insert;
import com.example.demo.entity.StatusA;
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

		model.addAttribute("insert", new Insert());
		return "add";
	}

	/**
	* 確認画面へ遷移
	* @return 確認画面表示
	*/
	@RequestMapping(value = "/addCheck", method = RequestMethod.POST)
	public String addcheck(@ModelAttribute Insert insert, HttpServletRequest request, Model model, @RequestParam String clientid, String statusid) {
//顧客・ステータスのIDをパラメータにNameを呼び出す
		//ステータス有り

		List<StatusA> nameAll = uriageService.getSelectName(clientid, statusid);
		model.addAttribute("nameAll", nameAll);

			//serviceからメソッド呼び出し
//				JyusyorokuService svc = new JyusyorokuService();
//				String errAll[];
//				errAll = svc.err(name, address, tel);
//			//エラー判定
//			//エラー有り
//				if (errAll [0] != null || errAll [1] != null || errAll [2] != null) {
//				model.addAttribute("errAll", errAll);
//				return "add";
//				}else {
//			//エラー無し
//				model.addAttribute("clientid", clientid);
//				model.addAttribute("statusid", statusid);
		return "addCheck";
}}
