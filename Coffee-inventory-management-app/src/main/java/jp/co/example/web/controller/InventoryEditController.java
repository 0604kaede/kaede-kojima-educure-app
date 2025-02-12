//コーヒー商品の在庫編集フォームを表示し、商品IDで検索した在庫情報を確認・編集できるようにするコントローラー
package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;
import jp.co.example.web.controller.form.InventoryEditForm;

@Controller
public class InventoryEditController {
	private final CoffeeDAO coffeeDAO;

	// コンストラクタ
	public InventoryEditController(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	// 在庫編集フォーム表示（商品IDで検索）
	@GetMapping("inventoryEdit")
	public String showInventoryEditForm(Model model) {
		model.addAttribute("inventoryEditForm", new InventoryEditForm());
		return "inventoryEdit"; // inventoryEdit.jsp に遷移
	}

	// 商品IDで在庫情報を取得して編集フォームを表示
	@PostMapping("inventoryEdit")
	public String editInventory(InventoryEditForm form, Model model) {
		int coffeeId = form.getCoffeeId();
		CoffeeDTO coffee = coffeeDAO.findById(coffeeId);
		if (coffee != null) {
			model.addAttribute("coffee", coffee);
		} else {
			model.addAttribute("errorMessage", "商品が見つかりませんでした。");
			return "inventoryEdit";
		}
		return "inventoryEditConfirm"; // inventoryEditConfirm.jsp に遷移
	}
}