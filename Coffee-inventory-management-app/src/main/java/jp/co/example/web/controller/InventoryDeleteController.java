//指定したコーヒー在庫情報を削除するためのクラス
package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.example.DAO.CoffeeDAO;

@Controller
public class InventoryDeleteController {
	private final CoffeeDAO coffeeDAO;

	public InventoryDeleteController(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	// 在庫削除処理（POSTリクエスト）
	@PostMapping("inventoryDelete")
	public String deleteInventory(@RequestParam("coffeeId") int coffeeId, RedirectAttributes redirectAttributes) {
		// 指定されたIDのコーヒーを削除
		boolean isDeleted = coffeeDAO.delete(coffeeId);

		if (isDeleted) {
			redirectAttributes.addFlashAttribute("message", "在庫が削除されました。");
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "削除対象の在庫が見つかりませんでした。");
		}

		return "redirect:/inventoryList"; // 在庫一覧ページにリダイレクト
	}
}

//InventoryDeleteControllerクラス:
//
//このクラスは、コーヒー在庫を削除するための処理を担当します。
//@Controllerアノテーションで、Spring MVCのコントローラーとして機能します。
//コンストラクタ（InventoryDeleteController）:
//
//CoffeeDAOをコンストラクタインジェクションで受け取り、DAOオブジェクトをコントローラー内で使用できるようにします。
//deleteInventoryメソッド（POSTメソッド）:
//
//引数で受け取った coffeeId（コーヒーのID）を使って、データベースからコーヒー情報を取得します。
//コーヒーが存在する場合、その情報を削除し、削除成功のメッセージをビューに渡します。
//コーヒーが存在しない場合、エラーメッセージを表示し、在庫一覧画面に戻ります。
