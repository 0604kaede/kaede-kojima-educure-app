package jp.co.example.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jp.co.example.DAO.UsersDAO;
import jp.co.example.DTO.RoleDTO;
import jp.co.example.DTO.UsersDTO;

@Repository
public class UsersDAOlmpl implements UsersDAO {
	private final JdbcTemplate jdbcTemplate;

	public UsersDAOlmpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// UsersDTO にマッピングする RowMapper
	private static class UsersRowMapper implements RowMapper<UsersDTO> {
		@Override
		public UsersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new UsersDTO(
					rs.getInt("user_id"),
					rs.getString("user_name"),
					rs.getString("password"),
					rs.getInt("role_id"),
					rs.getTimestamp("created_at"),
					rs.getTimestamp("updated_at"),
					rs.getTimestamp("deleted_at"));
		}
	}

	@Override
	public List<UsersDTO> findAll() {
		String sql = "SELECT * FROM users WHERE deleted_at IS NULL";
		return jdbcTemplate.query(sql, new UsersRowMapper());
	}

	@Override
	public UsersDTO findById(int userId) {
		String sql = "SELECT * FROM users WHERE user_id = ? AND deleted_at IS NULL";
		try {
			return jdbcTemplate.queryForObject(sql, new UsersRowMapper(), userId);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int insert(UsersDTO user) {
		// user_idを手動で設定しない
		String sql = "INSERT INTO users (user_name, password, role_id, created_at, updated_at) " +
				"VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// PreparedStatementの設定
		int affectedRows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, new String[] { "user_id" }); // 自動生成されたカラムを指定
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getRoleId());
			return ps;
		}, keyHolder);

		// 登録成功時に生成された user_id を取得
		if (affectedRows > 0 && keyHolder.getKey() != null) {
			int generatedUserId = keyHolder.getKey().intValue(); // 自動生成されたuser_idを取得
			System.out.println("Generated user_id: " + generatedUserId);
			return generatedUserId; // 自動生成されたIDを返す
		} else {
			System.out.println("Registration failed.");
			return -1; // 登録失敗の場合
		}
	}

	@Override
	public int update(UsersDTO user) {
		String sql = "UPDATE users SET user_name = ?, password = ?, role_id = ?, updated_at = CURRENT_TIMESTAMP " +
				"WHERE user_id = ?";
		return jdbcTemplate.update(sql, user.getUserName(), user.getPassword(), user.getRoleId(), user.getUserId());
	}

	@Override
	public boolean delete(String userName) {
		String sql = "DELETE from users WHERE user_name =? \n"
				+ "";
		return jdbcTemplate.update(sql, userName) > 0;
	}

	@Override
	public UsersDTO findByuserName(String userName) {
		String sql = "SELECT * FROM users WHERE user_name = ? AND deleted_at IS NULL";
		try {
			return jdbcTemplate.queryForObject(sql, new UsersRowMapper(), userName);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<UsersDTO> findAllWithRoles() {
		String sql = "SELECT u.user_id, u.user_name, u.role_id, r.role_name " +
				"FROM users u LEFT JOIN role r ON u.role_id = r.role_id WHERE u.deleted_at IS NULL";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			int roleId = rs.getInt("role_id");
			RoleDTO role = new RoleDTO(roleId, rs.getString("role_name"));
			return new UsersDTO(
					rs.getInt("user_id"),
					rs.getString("user_name"),
					null, // パスワードは取得しない
					roleId,
					null, // created_at は取得しない
					null,
					null,
					role // RoleDTOを設定
			);
		});
	}
}