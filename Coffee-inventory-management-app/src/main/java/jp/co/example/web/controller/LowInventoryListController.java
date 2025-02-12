//在庫数が閾値以下の商品を取得し、低在庫リスト画面に表示するコントローラー
package jp.co.example.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;

@Controller
public class LowInventoryListController {
	private final CoffeeDAO coffeeDAO;

	public LowInventoryListController(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	@GetMapping("lowInventoryList")
	public String lowInventoryList(Model model) {
		// CoffeeDAOを使って在庫が閾値以下の商品リストを取得
		List<CoffeeDTO> lowInventoryList = coffeeDAO.findLowInventory();
		// 取得した低在庫リストをモデルに追加
		model.addAttribute("lowInventoryList", lowInventoryList);
		return "lowInventoryList"; // lowInventoryList.jsp に遷移
	}
}