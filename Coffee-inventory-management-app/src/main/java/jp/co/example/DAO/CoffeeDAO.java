package jp.co.example.DAO;

import java.util.List;

import jp.co.example.DTO.CoffeeDTO;

public interface CoffeeDAO {
	// 全コーヒーの在庫情報を取得
	List<CoffeeDTO> findAll();

	// コーヒーIDでコーヒー情報を取得
	CoffeeDTO findById(int coffeeId);

	// 新しいコーヒーを追加する
	void insert(CoffeeDTO coffee);

	// コーヒー情報を更新する
	void update(CoffeeDTO coffee);

	// 指定されたコーヒーを削除する
	boolean delete(int coffeeId);

	// 新しいコーヒーを追加する（insert メソッドの別名または補助メソッド？）
	void addCoffee(CoffeeDTO coffeeDTO);

	// コーヒー情報を保存する（insert または update の補助メソッド？）
	void save(CoffeeDTO coffeeDTO);

	// 在庫閾値以下のコーヒーリストを取得する
	List<CoffeeDTO> findLowStock();

	// 低在庫の商品を取得する
	List<CoffeeDTO> findLowInventory();

	// 全てのコーヒーの情報を取得する（`findAll` と似ているが目的が異なる可能性あり）
	List<CoffeeDTO> getAllCoffees();
	
	List<CoffeeDTO> getLowInventoryCoffees();
}
