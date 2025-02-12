//在庫一覧と低在庫リストを取得して画面に表示するコントローラー
package jp.co.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;

@Controller
public class SelectController {

	@Autowired
	private CoffeeDAO coffeeDAO;

	// 在庫一覧を表示
	@RequestMapping("/inventoryList")
	public String listInventory(Model model) {
		// CoffeeDAOを使って全ての在庫情報を取得（物理削除に対応）
		List<CoffeeDTO> coffeeList = coffeeDAO.getAllCoffees();
		model.addAttribute("coffeeList", coffeeList);
		return "inventoryList"; // inventoryList.jsp に遷移
	}

	// 低在庫リストを表示
	@RequestMapping("/lowInventoryList")
	public String listLowInventory(Model model) {
		// CoffeeDAOを使って低在庫のコーヒーのみ取得
		List<CoffeeDTO> lowInventoryList = coffeeDAO.getLowInventoryCoffees();
		model.addAttribute("coffeeList", lowInventoryList);
		return "lowInventoryList"; // lowInventoryList.jsp に遷移
	}
}
