package com.jdbc.budgettracker.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import com.jdbc.budgettracker.core.BudgetTrackerDto;

public class BudgetTrackerSearchDao {

	BudgetTrackerDto btd;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	private static Connection getConnection() {

		try {
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

	// select all
	@SuppressWarnings("unchecked")
	public List<BudgetTrackerDto> selectQuery()
			throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		List<BudgetTrackerDto> budgetList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = BudgetTrackerSearchDao.getConnection();

		StringBuffer sql = new StringBuffer();

		sql.append("select * from budget_table where ProductName like '%");

		btd = new BudgetTrackerDto();
		int id = btd.getId();
		if (id != 0) {
			sql.append("and id ='" + id + "'");
		}

		Date date = btd.getDate();
		if (date != null) {
			sql.append("and date ='" + date + "'");
		}

		String storeName = btd.getStoreName();
		if (storeName != "") {
			sql.append("and StoreName ='" + storeName + "'");
		}

		String productName = btd.getProductName();
		if (productName != "") {
			sql.append("and ProductName ='" + productName + "'");
		}

		String productType = btd.getProductType();
		if (productType != "") {
			sql.append("and ProductType ='" + productType + "'");
		}

		int price = btd.getPrice();
		if (price != 0) {
			sql.append("and Price ='" + price + "'");
		}

		System.out.println(sql);

		pstmt = conn.prepareStatement(new String(sql));

		pstmt.execute();

		rset = pstmt.executeQuery();
		return (List<BudgetTrackerDto>) rset;

	}

}
