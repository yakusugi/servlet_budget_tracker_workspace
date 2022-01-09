package com.jdbc.budgettracker.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import com.jdbc.budgettracker.core.BudgetTrackerDto;

public class BudgetTrackerInsertDao {
	BudgetTrackerDto btd;
//	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	private Connection myConn;
	private static final String INSERTINTOBUDGETTABLE = "INSERT INTO budget_table(id,date,store_name, product_name, product_type, price) VALUE (?,?,?,?,?,?);";

	private static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get db properties
			Properties props = new Properties();
			props.load(new FileInputStream(
					"/home/yosuke/git/servlet_budget_tracker_workspace/budget_tracker_servlet/WebContent/WEB-INF/sql/config_budgettracker.properties"));

			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");
			Connection con = DriverManager.getConnection(dburl, user, password);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	//Insert
		public void insertIntoTable(BudgetTrackerDto btd) throws SQLException {
			int rowsCount = 0;

			PreparedStatement pstmt = null;
			try {
				// DBに接続
				myConn = BudgetTrackerInsertDao.getConnection();

				pstmt = myConn.prepareStatement(INSERTINTOBUDGETTABLE);
				pstmt.setInt(1, btd.getId());
				Date date = btd.getDate();
				long timeInMilliSeconds = date.getTime();
				java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);
				pstmt.setDate(2, sqlDate);
				pstmt.setString(3, btd.getStoreName());
				pstmt.setString(4, btd.getProductName());
				pstmt.setString(5, btd.getProductType());
				pstmt.setInt(6, btd.getPrice());
				// SQL文発行
				pstmt.executeUpdate();
				System.out.println("Successfully added");
				pstmt.close();

				// rowsCount = pstmt.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Errorが発生しました！\n" + e + "\n");
			} finally {
				// リソースの開放
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException ignore) {
					}
				}
				if (myConn != null) {
					try {
						myConn.close();
					} catch (SQLException ignore) {
					}
				}
			}

		}
	
	

}
