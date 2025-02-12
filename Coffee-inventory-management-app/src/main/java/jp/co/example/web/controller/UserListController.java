//データベースからユーザー一覧を取得し、userList.jsp に表示するコントローラー
package jp.co.example.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.example.DAO.UsersDAO;
import jp.co.example.DTO.UsersDTO;

@Controller
public class UserListController {
	private final UsersDAO usersDAO;

	public UserListController(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	@GetMapping("userList")
	public String userList(Model model) {
		//ユーザー一覧をデータベースから取得
		List<UsersDTO> userList = usersDAO.findAll();
		// 取得したユーザーリストを Model に追加
		model.addAttribute("userList", userList);
		return "userList"; // userList.jsp に遷移
	}
}