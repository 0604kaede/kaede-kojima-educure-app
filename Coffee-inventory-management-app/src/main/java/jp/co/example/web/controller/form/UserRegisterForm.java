package jp.co.example.web.controller.form;

public class UserRegisterForm {

	// ユーザー名（userName）: 新規ユーザー登録時に入力されるユーザー名
	private String userName;

	// パスワード（password）: 新規ユーザー登録時に入力されるパスワード
	private String password;

	// 権限ID（roleId）: 新規ユーザーに割り当てられる役割（権限）のID
	private int roleId;

	// ゲッター・セッター

	// ユーザー名（userName）を取得するためのゲッターメソッド
	public String getUserName() {
		return userName;
	}

	// ユーザー名（userName）を設定するためのセッターメソッド
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// パスワード（password）を取得するためのゲッターメソッド
	public String getPassword() {
		return password;
	}

	// パスワード（password）を設定するためのセッターメソッド
	public void setPassword(String password) {
		this.password = password;
	}

	// 権限ID（roleId）を取得するためのゲッターメソッド
	public int getRoleId() {
		return roleId;
	}

	// 権限ID（roleId）を設定するためのセッターメソッド
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
