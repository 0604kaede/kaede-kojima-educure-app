package jp.co.example.DAO.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.DAO.RoleDAO;
import jp.co.example.DTO.RoleDTO;

@Repository    //データベースとやりとりするクラスと知らせる
public class RoleDAOImpl implements RoleDAO {
	// JdbcTemplateをインスタンス変数として保持。これでSQL実行が可能になる
	private final JdbcTemplate jdbcTemplate;

	// コンストラクタ：RoleDAOImplがインスタンス化されるときに、JdbcTemplateを受け取って設定する
	public RoleDAOImpl(JdbcTemplate jdbcTemplate) {
		// SpringによってJdbcTemplateが注入される
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<RoleDTO> findAll() {
		//SQLクエリを定義：roleテーブルからすべてのレコードを取得する
		String sql = "SELECT * FROM role";
		
		// jdbcTemplateを使ってSQLクエリを実行し、結果をRoleDTOのリストとして取得
		return jdbcTemplate.query(sql, (rs, rowNum) -> new RoleDTO(rs.getInt("role_id"), rs.getString("role_name")));
	}

	@Override
	public RoleDTO findById(int roleId) {
		//SQLクエリを定義：role_idが指定されたroleIdと一致するレコードを取得
		String sql = "SELECT * FROM role WHERE role_id = ?";
		
		// jdbcTemplateを使ってSQLクエリを実行し、結果をRoleDTOオブジェクトとして取得
		return jdbcTemplate.queryForObject(sql,
				// 結果セット(rs)からrole_idとrole_nameを取り出し、RoleDTOオブジェクトを生成
				(rs, rowNum) -> new RoleDTO(rs.getInt("role_id"), rs.getString("role_name")), roleId); // クエリに引数roleIdを渡す
	}
}
