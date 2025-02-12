package jp.co.example.web.controller.form;

public class InventoryEditForm {

	// コーヒーID（coffeeId）: 編集するコーヒーの商品IDを保持するためのフィールド
	private int coffeeId;

	// ゲッター・セッター

	// コーヒーID（coffeeId）を取得するためのゲッターメソッド
	public int getCoffeeId() {
		return coffeeId;
	}

	// コーヒーID（coffeeId）を設定するためのセッターメソッド
	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}
}
