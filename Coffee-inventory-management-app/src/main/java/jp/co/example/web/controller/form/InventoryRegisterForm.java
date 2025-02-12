package jp.co.example.web.controller.form;

public class InventoryRegisterForm {

	// コーヒー名（coffeeName）: 新規コーヒーを登録する際に使用されるコーヒーの名前
	private String coffeeName;

	// 価格（price）: 新規コーヒーを登録する際に使用されるコーヒーの価格
	private int price;

	// 在庫数（number）: 新規コーヒーを登録する際に使用されるコーヒーの在庫数
	private int number;

	// 在庫閾値（threshold）: 在庫数がこの閾値を下回ると警告が表示されるコーヒーの在庫閾値
	private int threshold;

	// ゲッター・セッター

	// コーヒー名（coffeeName）を取得するためのゲッターメソッド
	public String getCoffeeName() {
		return coffeeName;
	}

	// コーヒー名（coffeeName）を設定するためのセッターメソッド
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	// 価格（price）を取得するためのゲッターメソッド
	public int getPrice() {
		return price;
	}

	// 価格（price）を設定するためのセッターメソッド
	public void setPrice(int price) {
		this.price = price;
	}

	// 在庫数（number）を取得するためのゲッターメソッド
	public int getNumber() {
		return number;
	}

	// 在庫数（number）を設定するためのセッターメソッド
	public void setNumber(int number) {
		this.number = number;
	}

	// 在庫閾値（threshold）を取得するためのゲッターメソッド
	public int getThreshold() {
		return threshold;
	}

	// 在庫閾値（threshold）を設定するためのセッターメソッド
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
}
