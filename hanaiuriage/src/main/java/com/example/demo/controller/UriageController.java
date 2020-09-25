package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Client;
import com.example.demo.entity.Insert;
import com.example.demo.entity.StatusA;
import com.example.demo.entity.Uriage;
import com.example.demo.form.UriageForm;
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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
		//		 List<Uriage> uriagePage = uriageService.getList(pageable);
		List<Uriage> uriagePage = uriageService.getList();
		//		 PageWrapper<Uriage> page = new PageWrapper<Uriage>(playerPage, "/index");
		//		 model.addAttribute("page", page);
		//		 model.addAttribute("jyusyolist", playerPage.getContent());
		//       model.addAttribute("uriageForm", new UriageForm());
		model.addAttribute("uriagePage", uriagePage);
		return "top";
	}

	/**
	 * 戻るボタン押下
	 * @return 一覧画面表示
	 */
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public String back() {
		return "redirect:/";
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

		model.addAttribute("uriageForm", new UriageForm());
		return "add";
	}

	/**
	* 確認画面へ遷移
	* @return 確認画面表示
	 * @throws UnsupportedEncodingException
	*/
	@RequestMapping(value = "/addCheck", method = RequestMethod.POST)
	public String addcheck(@ModelAttribute UriageForm uriageForm, HttpServletRequest request, Model model,
			@RequestParam String clientid, String statusid) throws UnsupportedEncodingException {
		String[] errAll = uriageService.getErr(uriageForm);
		//エラー判定、配列の要素にerrmsgがあるかチェック
		boolean empty = true;
		for (int i = 0; i < errAll.length; i++) {
			if (errAll[i] != null) {
				empty = false;
				break;
			}
		}
		//エラー有り
		if (empty == false) {
			model.addAttribute("errAll", errAll);
			//顧客ID、Name取得
			List<Client> addClient = uriageService.getClient();
			model.addAttribute("addClient", addClient);

			//ステータスA取得
			List<StatusA> addStatusA = uriageService.getStatusA();
			model.addAttribute("addStatusA", addStatusA);

			return "add";
		} else {
			//エラー無し
			//顧客・ステータスのIDをパラメータにNameを呼び出す
			//ステータス有り、顧客・ステータスName取得
			String statusid1 = request.getParameter("statusid");
			if (statusid1 != "") {
				List<StatusA> nameAll = uriageService.getSelectName(clientid, statusid);
				model.addAttribute("nameAll", nameAll);
			} else {
				//ステータス無し、顧客Nameのみ取得
				List<Client> clientAll = uriageService.getSelectClient(clientid);
				model.addAttribute("clientAll", clientAll);
			}
			return "addCheck";
		}
	}

	/**
	 * 登録処理
	 * @param inputForm
	 * @return 一覧画面表示
	 */
	@PostMapping("/create")
	String regist(@ModelAttribute UriageForm uriageForm) {
		Insert insert = new Insert();
		BeanUtils.copyProperties(uriageForm, insert);
		uriageService.create(insert);
		return "redirect:/";
	}
}
