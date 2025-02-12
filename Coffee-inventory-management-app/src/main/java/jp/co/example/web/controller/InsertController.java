//コーヒー情報の新規登録クラス
package jp.co.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;
import jp.co.example.web.controller.form.InsertForm;

@Controller
public class InsertController {

	@Autowired
	private CoffeeDAO coffeeDAO;

	// 新規登録画面を表示
	@GetMapping("/inventoryRegister1")
	public String showInsertForm(Model model) {
		model.addAttribute("insertForm", new InsertForm()); // InsertFormオブジェクトをモデルに追加
		return "inventoryRegister"; // inventoryRegister.jsp に遷移
	}

	// 新規コーヒー情報を登録（POSTリクエスト）
	@PostMapping("/insert")
	public String insertCoffee(@ModelAttribute("insertForm") InsertForm insertForm, Model model) {
		CoffeeDTO coffeeDTO = new CoffeeDTO();// 新しいCoffeeDTOオブジェクトを作成
		coffeeDTO.setCoffeeName(insertForm.getCoffeeName());// フォームから入力されたコーヒー名を設定
		coffeeDTO.setPrice(insertForm.getPrice());// 価格を設定
		coffeeDTO.setNumber(insertForm.getNumber());// 個数を設定
		coffeeDTO.setThreshold(insertForm.getThreshold());// 閾値を設定

		// コーヒー情報をデータベースに追加
		coffeeDAO.addCoffee(coffeeDTO);

		// 完了画面に遷移
		model.addAttribute("message", "コーヒー情報が正常に登録されました。");
		return "registerComplete"; // registerComplete.jsp に遷移
	}
}

//InsertControllerクラス

//コントローラーレイヤーであり、HTTPリクエストを処理し、ビジネスロジックとビューの間でデータをやり取りします。
//@Controllerアノテーションを使って、Spring MVCのコントローラーとして機能します。
//showInsertFormメソッド（GETメソッド）:

//新規登録画面 (inventoryRegister.jsp) を表示するためのメソッドです。
//InsertFormをモデルに追加し、JSPに渡してフォームを表示します。
//insertCoffeeメソッド（POSTメソッド）:

//ユーザーがフォームで入力したコーヒーの情報（InsertForm）を受け取り、それを CoffeeDTO に変換します。
//変換した CoffeeDTO オブジェクトをDAO（coffeeDAO）に渡して、データベースに新しいコーヒー情報を追加します。
//登録が成功した場合、registerComplete.jsp 画面に遷移し、メッセージを表示します。
