package jp.co.example.DAO;

import java.util.List;

import jp.co.example.DTO.RoleDTO;

public interface RoleDAO {
	// 全てのロール情報を取得するメソッド
	List<RoleDTO> findAll();
	// 指定された roleId に対応するロール情報を取得するメソッド
	RoleDTO findById(int roleId);
}
