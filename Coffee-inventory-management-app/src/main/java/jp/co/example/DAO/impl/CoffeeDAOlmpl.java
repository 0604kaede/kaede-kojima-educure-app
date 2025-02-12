package jp.co.example.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.example.DAO.CoffeeDAO;
import jp.co.example.DTO.CoffeeDTO;

@Repository
public class CoffeeDAOlmpl implements CoffeeDAO {
	private final JdbcTemplate jdbcTemplate;

	public CoffeeDAOlmpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static class CoffeeRowMapper implements RowMapper<CoffeeDTO> {
		public CoffeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CoffeeDTO(
					rs.getInt("coffee_id"),
					rs.getString("coffee_name"),
					rs.getInt("price"),
					rs.getInt("number"),
					rs.getInt("threshold"),
					rs.getTimestamp("created_at"),
					rs.getTimestamp("updated_at"),
					rs.getTimestamp("deleted_at"));
		}
	}

	@Override
	public CoffeeDTO findById(int coffeeId) {
		String sql = "SELECT * FROM coffee WHERE coffee_id = ? AND deleted_at IS NULL";
		try {
		return jdbcTemplate.queryForObject(sql, new CoffeeRowMapper(), coffeeId);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(CoffeeDTO coffee) {
		// coffee_nameがnullの場合、空文字に設定
		String coffeeName = (coffee.getCoffeeName() != null) ? coffee.getCoffeeName() : "";

		String sql = "UPDATE coffee SET coffee_name = ?, price = ?, number = ?, threshold = ?, updated_at = CURRENT_TIMESTAMP WHERE coffee_id = ?";
		jdbcTemplate.update(sql, coffeeName, coffee.getPrice(), coffee.getNumber(), coffee.getThreshold(),
				coffee.getCoffeeId());
	}

	@Override
	public boolean delete(int coffeeId) {
		String sql = "DELETE FROM coffee WHERE coffee_id = ?";
		int rowsAffected = jdbcTemplate.update(sql, coffeeId);
		return rowsAffected > 0; // 削除成功ならtrue
	}

	@Override
	public List<CoffeeDTO> findLowStock() {
		String sql = "SELECT * FROM coffee WHERE number < threshold AND deleted_at IS NULL";
		return jdbcTemplate.query(sql, new CoffeeRowMapper());
	}

	// 新たに実装する必要のあるメソッド

	@Override
	public void insert(CoffeeDTO coffee) {
		String sql = "INSERT INTO coffee (coffee_name, price, number, threshold, created_at, updated_at) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
		jdbcTemplate.update(sql, coffee.getCoffeeName(), coffee.getPrice(), coffee.getNumber(), coffee.getThreshold());
	}

	@Override
	public void save(CoffeeDTO coffee) {
		if (coffee.getCoffeeId() == 0) {
			insert(coffee); // 新規追加
		} else {
			update(coffee); // 更新
		}
	}

	@Override
	public List<CoffeeDTO> findLowInventory() {
		String sql = "SELECT * FROM coffee WHERE number < threshold AND deleted_at IS NULL";
		return jdbcTemplate.query(sql, new CoffeeRowMapper());
	}

	@Override
	public List<CoffeeDTO> getAllCoffees() {
		String sql = "SELECT * FROM coffee WHERE deleted_at IS NULL";
		return jdbcTemplate.query(sql, new CoffeeRowMapper());
	}

	@Override
	public void addCoffee(CoffeeDTO coffee) {
		insert(coffee); // 新規追加メソッド
	}

	@Override
	public List<CoffeeDTO> findAll() {
		String sql = "SELECT * FROM coffee WHERE deleted_at IS NULL";
		return jdbcTemplate.query(sql, new CoffeeRowMapper());
	}

	@Override
	public List<CoffeeDTO> getLowInventoryCoffees() {
		String sql = "SELECT * FROM coffee WHERE number < threshold";
		return jdbcTemplate.query(sql, new CoffeeRowMapper());
	}

}
