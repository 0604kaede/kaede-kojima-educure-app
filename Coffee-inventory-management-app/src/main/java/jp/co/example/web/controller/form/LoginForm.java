package jp.co.example.web.controller.form;

public class LoginForm {

	// ユーザーID（userId）: ログインフォームで使用するユーザーID（文字列型に変更）
	private String userId;

	// パスワード（password）: ログインフォームで使用するパスワード
	private String password;
	
	private String userName;

	// ゲッター・セッター

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// ユーザーID（userId）を取得するためのゲッターメソッド
	public String getUserId() {
		return userId;
	}

	// ユーザーID（userId）を設定するためのセッターメソッド
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// パスワード（password）を取得するためのゲッターメソッド
	public String getPassword() {
		return password;
	}

	// パスワード（password）を設定するためのセッターメソッド
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
