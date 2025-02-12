package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	// ログアウト処理
	@RequestMapping("/logout")
	public String logout() {
		// セッションを無効化（ログアウト処理）
		return "logout"; // logout.jsp に遷移
	}
}