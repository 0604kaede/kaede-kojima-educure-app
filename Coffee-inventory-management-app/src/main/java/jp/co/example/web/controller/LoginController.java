//ユーザーのログイン・ログアウト処理を行い、ログイン成功時にメニュー画面へ遷移させるコントローラー
package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.example.DAO.UsersDAO;
import jp.co.example.DTO.UsersDTO;
import jp.co.example.web.controller.form.LoginForm;

@Controller
@RequestMapping("/")
public class LoginController {
	private final UsersDAO usersDAO;
	private final HttpSession session;

	public LoginController(UsersDAO usersDAO, HttpSession session) {
		this.usersDAO = usersDAO;
		this.session = session;
	}

	// ログイン画面表示
	@GetMapping("login")
	public String showLoginForm(Model model) {
		// 空のログインフォームオブジェクトをモデルに追加
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	// ログイン処理
	@PostMapping("login")
	public String login(LoginForm form, Model model) {
		// ユーザーIDの入力チェック
		if (form.getUserId() == null || form.getUserId().trim().isEmpty()) {
			model.addAttribute("errorMessage", "ユーザーIDを入力してください。");
			return "login";// 入力が空の場合、エラーメッセージを表示してログイン画面に戻る
		}

		int userId;
		try {
			// ユーザーIDを数値に変換
			userId = Integer.parseInt(form.getUserId().trim());
		} catch (NumberFormatException e) {
			model.addAttribute("errorMessage", "ユーザーIDは数値で入力してください。");
			return "login"; // 数値変換に失敗した場合、エラーメッセージを表示してログイン画面に戻る
		}

		// ユーザーIDを使ってデータベースからユーザー情報を取得
		UsersDTO user = usersDAO.findById(userId);
		// ユーザーが存在しない、またはパスワードが一致しない場合はエラー
		if (user == null || !user.getPassword().equals(form.getPassword())) {
			model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
			return "login";// エラーメッセージを表示してログイン画面に戻る
		}
		// ユーザー情報をセッションに保存（ログイン状態を維持）
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("roleId", user.getRoleId()); // 1=管理者, それ以外=一般ユーザー

		// ログイン成功時はメニュー画面（adminMenu.jsp）へ遷移
		return "adminMenu";
	}

	// ログアウト処理
	@GetMapping("logout")
	public String logout() {
		// セッションを無効化（ログアウト処理）
		session.invalidate(); 
		return "logout";// logout.jsp に遷移
	}
}
