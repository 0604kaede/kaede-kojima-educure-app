//ユーザーが入力した在庫情報をデータベースに保存し、登録完了画面を表示するコントローラー
package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;
import jp.co.example.web.controller.form.InventoryRegisterForm;

@Controller
public class InventoryRegisterController {
	private final CoffeeDAO coffeeDAO;

	// コンストラクタ
	public InventoryRegisterController(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	// 在庫登録フォーム表示
	@GetMapping("inventoryRegister")
	public String showInventoryRegisterForm(Model model) {
		// 空のフォームオブジェクトをモデルに追加（フォーム入力用）
		model.addAttribute("inventoryRegisterForm", new InventoryRegisterForm());
		return "inventoryRegister"; // inventoryRegister.jsp に遷移
	}

	// 在庫登録処理
	@PostMapping("inventoryRegister")
	public String registerInventory(InventoryRegisterForm form, Model model) {
		// フォームから受け取ったデータを CoffeeDTO に格納
		CoffeeDTO coffee = new CoffeeDTO();
		coffee.setCoffeeName(form.getCoffeeName());
		coffee.setPrice(form.getPrice());
		coffee.setNumber(form.getNumber());
		coffee.setThreshold(form.getThreshold());

		// CoffeeDAO を使ってデータベースに在庫情報を保存
		coffeeDAO.save(coffee);

		// 在庫登録完了メッセージを設定
		model.addAttribute("message", "在庫が登録されました。");
		// 登録完了画面（registerComplete.jsp）へ遷移
		return "registerComplete";
	}
}