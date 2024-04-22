package com.example.demo.database;

/**
 * 社員データ
 */
public class EmployeeData {
	private int id;
	private int password;
	private String name;
	private boolean admin;
	private boolean working;
	private String inWorkTime;
	private String outWorkTime;
	
	/**
	 * コンストラクタ
	 * @param id
	 * @param password
	 * @param name
	 * @param admin
	 * @param working
	 * @param inWorkTime
	 * @param outWorkTime
	 */
	public EmployeeData(int id, int password, String name, boolean admin, boolean working, String inWorkTime, String outWorkTime) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.admin = admin;
		this.working = working;
		this.inWorkTime = inWorkTime;
		this.outWorkTime = outWorkTime;
	}
	
	// ゲッター
	public int getId() { return id; }
	public int getPassword() { return password; }
	public String getName() { return name; }
	public boolean isAdmin() { return admin; }
	public boolean isWorking() { return working; }
	public String getInWorkTime() { return inWorkTime; }
	public String getOutWorkTime() { return outWorkTime; }
	
	@Override
	public String toString() {
		String data = String.format("Employees(id=%d, password=%d, name=%s, admin=%b, working=%b, inWorkTime=%s, outWorkTime=%s",
				id, password, name, admin, working, inWorkTime);
		return data;
	}
}
