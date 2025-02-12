package jp.co.example.DTO;

import java.sql.Timestamp;

public class CoffeeDTO {
	private int coffeeId;
	private String coffeeName;
	private int price;
	private int number;
	private int threshold;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp deletedAt;

	public CoffeeDTO() {
	}

	public CoffeeDTO(int coffeeId, String coffeeName, int price, int number, int threshold, Timestamp createdAt,
			Timestamp updatedAt, Timestamp deletedAt) {
		this.coffeeId = coffeeId;
		this.coffeeName = coffeeName;
		this.price = price;
		this.number = number;
		this.threshold = threshold;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
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
}
