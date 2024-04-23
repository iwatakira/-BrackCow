package com.example.demo.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 社員データのリポジトリ
 * MySQLのデータベース操作や取得を行う
 */
@Repository
public class EmployeeRepository {
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * テーブルのすべてのデータを取得
	 * @return 全てのデータのリスト
	 * @throws DataAccessException データのアクセスに失敗したときの例外
	 */
	public List<EmployeeData> getAllData() throws DataAccessException {
		String query = "SELECT * FROM employees;";
		List<Map<String, Object>> queryList = jdbc.queryForList(query);
		
		List<EmployeeData> dataList = new ArrayList<>();
		queryList.forEach(map -> {
			EmployeeData data = mapToData(map);
			
			dataList.add(data);
		});
		
		return dataList;
	}
	
	/**
	 * データの数を取得
	 * @return データの数
	 * @throws DataAccessException データのアクセスに失敗したときの例外
	 */
	public int count() throws DataAccessException {
		String query = "SELECT COUNT(*) FROM employees;";
		int count = jdbc.queryForObject(query, Integer.class);
		return count;
	}
	
	/**
	 * 社員IDからデータの有無を取得
	 * @param id 社員ID
	 * @return データの有無
	 */
	public boolean existFromId(int id) throws DataAccessException {
		String query = String.format("SELECT COUNT(*) FROM employees WHERE id = %d;", id);
		int count = jdbc.queryForObject(query, Integer.class);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * IDからデータを取得
	 * @param id 社員ID
	 * @return 取得するデータ
	 * @throws DataAccessException データのアクセスに失敗したときの例外
	 */
	public EmployeeData getFromID(int id) throws DataAccessException {
		String query = String.format("SELECT * FROM employees WHERE id = %d;", id);
		List<Map<String, Object>> queryList = jdbc.queryForList(query);
		
		if(queryList.size() == 1) {
			Map<String, Object> map = queryList.get(0);
			
			EmployeeData data = mapToData(map);
			
			return data;
		} else {
			System.out.println("データの数が無効です");
			return null;
		}
	}
	
	/**
	 * データを追加
	 * @param data 追加するデータ
	 * @throws DataAccessException データのアクセスに失敗したときの例外
	 */
	public void insert(EmployeeData data) throws DataAccessException {
		String query = "INSERT INTO employees ( id,"
				+ "password,"
				+ "name,"
				+ "admin,"
				+ "working,"
				+ "inWorkTime,"
				+ "outWorkTime)"
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		int rowNum = jdbc.update(query,
				data.getId(),
				data.getPassword(),
				data.getName(),
				data.isAdmin(),
				data.isWorking(),
				data.getInWorkTime(),
				data.getOutWorkTime());
		
		if(rowNum != 0) {
			System.out.println("正常に終了しませんでした");
		}
	}
	
	/**
	 * 社員IDからデータを削除する
	 * @param id 社員ID
	 * @throws DataAccessException データのアクセスに失敗したときの例外
	 */
	public void deleteFromId(int id) throws DataAccessException {
		String query = String.format("DELETE FROM employees WHERE id = %d;", id);
		int rowNum = jdbc.update(query);
		
		if(rowNum != 0) {
			System.out.println("正常に終了しませんでした");
		}
	}
	
	/**
	 * Mapからデータを取得
	 * @param map
	 * @return
	 */
	private EmployeeData mapToData(Map<String, Object> map) {
		EmployeeData data = new EmployeeData(
			(int) map.get("id"),
			(int) map.get("password"),
			(String) map.get("name"),
			(boolean) map.get("admin"),
			(boolean) map.get("working"),
			(String) map.get("inworktime"),
			(String) map.get("outworktime")
		);
		
		return data;
	}
}
