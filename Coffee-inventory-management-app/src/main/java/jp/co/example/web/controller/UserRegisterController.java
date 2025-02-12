package jp.co.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.DAO.UsersDAO;
import jp.co.example.DTO.UsersDTO;
import jp.co.example.web.controller.form.UserRegisterForm;

@Controller
public class UserRegisterController {

	@Autowired
	private UsersDAO usersDAO;

	// ユーザー登録画面の表示
	@GetMapping("/userRegister")
	public String showUserRegisterForm(Model model) {
		// 新しいUserRegisterFormオブジェクトを model に追加
		model.addAttribute("userRegisterForm", new UserRegisterForm());
		return "userRegister"; // userRegister.jsp に遷移
	}

	// ユーザー登録処理
	@PostMapping("/userRegister")
	public String registerUser(@ModelAttribute UserRegisterForm userRegisterForm, Model model) {
		// UserRegisterForm から UsersDTO に値をセット
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUserName(userRegisterForm.getUserName());
		userDTO.setPassword(userRegisterForm.getPassword());

		// String 型の roleId を int 型に変換
		try {
			int roleId = userRegisterForm.getRoleId(); // すでに int 型で取得
			userDTO.setRoleId(roleId); // UsersDTO に roleId をセット
		} catch (Exception e) {
			model.addAttribute("error", "無効な役割 ID です。");
			return "userRegister"; // エラーメッセージを表示して登録画面に戻る
		}

		// ユーザー情報をデータベースに追加
		usersDAO.insert(userDTO);

		// 完了メッセージを model に追加
		model.addAttribute("message", "ユーザーが正常に登録されました。");
		return "userRegisterComplete"; // userRegisterComplete.jsp に遷移
	}
}