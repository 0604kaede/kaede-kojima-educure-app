//データベースから全てのコーヒー商品の在庫情報を取得し、在庫一覧画面に表示するコントローラー
package jp.co.example.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;

@Controller
public class InventoryListController {
	private final CoffeeDAO coffeeDAO;

	// コンストラクタで CoffeeDAO を受け取り、依存性注入を行う
	public InventoryListController(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	// 在庫一覧画面の表示
	@GetMapping("inventoryList")
	public String showInventoryList(Model model) {
		// データベースから全てのコーヒー商品の在庫情報を取得
		List<CoffeeDTO> coffeeList = coffeeDAO.findAll();
		// 取得した在庫情報をモデルに追加し、ビューへ渡す
		model.addAttribute("coffeeList", coffeeList);
		// 在庫一覧画面（inventoryList.jsp）へ遷移
		return "inventoryList";
	}

	@RequestMapping("/adminMenu")
	public String showAdminMenu() {
		return "adminMenu"; // adminMenu.jspを返す
	}
}