package jp.co.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jp.co.example.DAO.UsersDAO;
import jp.co.example.DTO.UsersDTO;
import jp.co.example.web.controller.form.LoginForm;

@Controller
public class UserController {

	@Autowired
	private UsersDAO usersDAO;
	@Autowired

	HttpSession session;
	// ユーザー登録画面の表示
	@RequestMapping("/userRegister")
	public String showUserRegisterForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "userRegister"; // userRegister.jsp に遷移
	}

	// ユーザー登録処理
	@RequestMapping("/userRegisterComplete")
	public String registerUser(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUserName(loginForm.getUserId()); // loginForm.getUserId()はString型
		userDTO.setPassword(loginForm.getPassword());

		// ユーザーをデータベースに追加
		usersDAO.insert(userDTO);

		model.addAttribute("message", "ユーザー登録が完了しました。");
		return "userRegisterComplete"; // userRegisterComplete.jsp に遷移
	}

	// ユーザー編集画面
	@RequestMapping("/userEdit")
	public String showUserEditForm(@RequestParam("userId") int userId, Model model) {
		UsersDTO user = usersDAO.findById(userId);

		// ユーザーが存在すれば編集画面を表示
		if (user != null) {
			model.addAttribute("user", user);
			return "userEdit"; // userEdit.jsp に遷移
		}

		// ユーザーが見つからない場合は、エラーメッセージを表示してユーザー編集画面に戻す
		model.addAttribute("errorMessage", "指定されたユーザーが存在しません。");
		return "userEdit"; // userEdit.jsp に遷移 (エラーメッセージを表示)
	}

	// ユーザー削除処理
	@RequestMapping("/userDelete")
	public String deleteUser(LoginForm form, Model model) {
	String userName = (String)session.getAttribute("userName");
			// ユーザー削除の実行
			usersDAO.delete(userName);
			System.out.println("else");
			// 削除後のメッセージ
			model.addAttribute("message", "ユーザーが削除されました。");

		// 削除完了ページに遷移
		return "deleteComplete"; // deleteComplete.jsp に遷移
	}

	@RequestMapping(value = "/userEditConfirm")
	public String showUserEditConfirm(@ModelAttribute UsersDTO usersDTO, LoginForm form, Model model) {
	    String userName = form.getUserName();
	    UsersDTO user = usersDAO.findByuserName(userName);
	    if (user == null || !user.getPassword().equals(form.getPassword())) {
	        model.addAttribute("errorMessage", "指定されたユーザーが存在しません。");
	        return "userEdit";
	    }
	    session.setAttribute("userName",userName);
	    model.addAttribute("user", user); // ユーザー情報をモデルに追加
	    return "userEditConfirm"; // userEditConfirm.jsp に遷移
	}
}
	