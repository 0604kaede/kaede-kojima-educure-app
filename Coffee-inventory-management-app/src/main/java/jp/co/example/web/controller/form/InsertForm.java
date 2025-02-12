package jp.co.example.web.controller.form;

public class InsertForm {
	// コーヒー名（coffeeName）
	private String coffeeName;
	// 価格（price）
	private int price;
	// 在庫数（number）
	private int number;
	// 在庫閾値（threshold）
	private int threshold;

	// Getter と Setter

	// コーヒー名（coffeeName）を取得
	public String getCoffeeName() {
		return coffeeName;
	}

	// コーヒー名（coffeeName）を設定
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	// 価格（price）を取得
	public int getPrice() {
		return price;
	}

	// 価格（price）を設定
	public void setPrice(int price) {
		this.price = price;
	}

	// 在庫数（number）を取得
	public int getNumber() {
		return number;
	}

	// 在庫数（number）を設定
	public void setNumber(int number) {
		this.number = number;
	}

	// 在庫閾値（threshold）を取得
	public int getThreshold() {
		return threshold;
	}

	// 在庫閾値（threshold）を設定
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
}
