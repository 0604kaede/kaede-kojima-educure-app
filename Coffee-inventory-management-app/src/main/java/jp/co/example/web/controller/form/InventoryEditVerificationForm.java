package jp.co.example.web.controller.form;

public class InventoryEditVerificationForm {

	// 編集対象のコーヒーの商品ID
	private int coffeeId;

	// 編集対象のコーヒーの名前
	private String coffeeName;

	// 編集対象のコーヒーの価格
	private int price;

	// 編集対象のコーヒーの現在の在庫数
	private int number;

	// 編集対象のコーヒーの在庫閾値（低在庫警告基準）
	private int threshold;

	// コーヒーIDを取得
	public int getCoffeeId() {
		return coffeeId;
	}

	// コーヒーIDを設定
	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	// コーヒー名を取得
	public String getCoffeeName() {
		return coffeeName;
	}

	// コーヒー名を設定
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	// 価格を取得
	public int getPrice() {
		return price;
	}

	// 価格を設定
	public void setPrice(int price) {
		this.price = price;
	}

	// 在庫数を取得
	public int getNumber() {
		return number;
	}

	// 在庫数を設定
	public void setNumber(int number) {
		this.number = number;
	}

	// 在庫閾値を取得
	public int getThreshold() {
		return threshold;
	}

	// 在庫閾値を設定
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
}
