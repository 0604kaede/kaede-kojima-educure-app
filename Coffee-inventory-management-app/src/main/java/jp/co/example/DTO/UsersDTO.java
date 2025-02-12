package jp.co.example.DTO;

import java.sql.Timestamp;

public class UsersDTO {
	private int userId;
	private String userName;
	private String password;
	private int roleId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp deletedAt;
	private RoleDTO role; // 追加: RoleDTOをフィールドとして保持

	// 既存のコンストラクタ
	public UsersDTO(int userId, String userName, String password, int roleId, Timestamp createdAt, Timestamp updatedAt,
			Timestamp deletedAt) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// 新しいコンストラクタ（RoleDTOを追加）
	public UsersDTO(int userId, String userName, String password, int roleId, Timestamp createdAt, Timestamp updatedAt,
			Timestamp deletedAt, RoleDTO role) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.role = role; // RoleDTOを設定
	}

	// デフォルトコンストラクタを追加
	public UsersDTO() {
		// 必要な初期化処理があれば追加
	}

	// ゲッターとセッター（必要に応じて）
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
}