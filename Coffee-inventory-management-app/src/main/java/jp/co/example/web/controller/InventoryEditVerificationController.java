package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;
import jp.co.example.web.controller.form.InventoryEditVerificationForm;

@Controller
public class InventoryEditVerificationController {
	private final CoffeeDAO coffeeDAO;

	public InventoryEditVerificationController(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	@PostMapping("inventoryEditVerification")
	public String verifyEdit(InventoryEditVerificationForm form, Model model) {
		// フォームのコーヒーIDを元にデータベースから商品情報を取得
		CoffeeDTO coffee = coffeeDAO.findById(form.getCoffeeId());

		// 商品が存在する場合、フォームの内容でデータを更新
		if (coffee != null) {
			coffee.setCoffeeName(form.getCoffeeName());
			coffee.setPrice(form.getPrice());
			coffee.setNumber(form.getNumber());
			coffee.setThreshold(form.getThreshold());

			// 更新内容をデータベースに反映
			coffeeDAO.update(coffee);

			// 成功メッセージを設定し、編集完了画面へ遷移
			model.addAttribute("message", "在庫が更新されました。");
			return "editComplete"; // editComplete.jsp に遷移
		}

		// 商品が見つからなかった場合、エラーメッセージを設定し編集画面へ戻る
		model.addAttribute("errorMessage", "商品が見つかりませんでした。");
		return "inventoryEdit"; // inventoryEdit.jsp に戻る
	}
}
