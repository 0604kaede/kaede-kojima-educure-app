package jp.co.example.DAO;

import java.util.List;

import jp.co.example.DTO.UsersDTO;

public interface UsersDAO {
	// すべてのユーザー情報を取得するメソッド
	List<UsersDTO> findAll();

	// 指定された userId に対応するユーザー情報を取得するメソッド
	UsersDTO findById(int userId);

	// ユーザーを新規登録し、生成されたユーザーIDを返すメソッド
	int insert(UsersDTO user); // ユーザーを登録し、生成されたIDを返す

	// 指定されたユーザーの情報を更新し、影響を受けた行数を返すメソッド
	int update(UsersDTO user); // 更新し、影響を受けた行数を返す

	// 指定された userId のユーザーを削除するメソッド
	boolean delete(String userName);

	// ロール情報を含むすべてのユーザー情報を取得するメソッド
	List<UsersDTO> findAllWithRoles();
	
	UsersDTO findByuserName(String userName);
}
