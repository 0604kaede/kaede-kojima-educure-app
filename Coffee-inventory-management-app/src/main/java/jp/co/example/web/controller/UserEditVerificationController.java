package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.example.DAO.UsersDAO;
import jp.co.example.DTO.UsersDTO;

@Controller
public class UserEditVerificationController {
	private final UsersDAO usersDAO;

	public UserEditVerificationController(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	@PostMapping("userEditVerification")
	public String verifyEdit(int userId, String userName, String roleId, Model model) {
		// ユーザーIDに対応するユーザー情報を取得
		UsersDTO user = usersDAO.findById(userId);
		if (user != null) {
			// ユーザー情報を更新
			user.setUserName(userName);

			// roleId (String) を int に変換
			try {
				int parsedRoleId = Integer.parseInt(roleId); // String -> int へ変換
				user.setRoleId(parsedRoleId); // 更新された roleId を設定
			} catch (NumberFormatException e) {
				// roleId の変換に失敗した場合
				model.addAttribute("errorMessage", "無効な役割 ID です。");
				return "userEdit"; // userEdit.jsp に戻る
			}

			// 更新処理を実行
			usersDAO.update(user);

			// 更新成功メッセージを設定し、userEditComplete.jsp に遷移
			model.addAttribute("message", "ユーザー情報が更新されました。");
			return "userEditComplete"; // userEditComplete.jsp に遷移
		}

		// ユーザーが見つからなかった場合のエラーメッセージを設定し、userEdit.jsp に戻る
		model.addAttribute("errorMessage", "ユーザーが見つかりませんでした。");
		return "userEdit"; // userEdit.jsp に戻る
	}
}
