package com.jdbc.budgettracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.budgettracker.core.BudgetTrackerDto;
import com.jdbc.budgettracker.dao.BudgetTrackerInsertDao;
import com.jdbc.budgettracker.dao.BudgetTrackerSearchDao;

public class BudgetTrackerSearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BudgetTrackerDto budgetTrackerDto;
		BudgetTrackerSearchDao budgetTrackerSearchDao = null;

		request.setCharacterEncoding("Windows-31J");

		// request id
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		}
		catch (NumberFormatException e) {
			System.out.println(id + " は数値ではありません。 ");
		}

		// request date
		String dateStr = request.getParameter("date");
		java.util.Date date1 = null;
		try {
			date1 = (java.util.Date) new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	    java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

		// request store name
		String storeName = request.getParameter("storeName");

		// request product name
		String productName = request.getParameter("productName");

		// request product type
		String productType = request.getParameter("productType");

		// request price
		int price = 0;
		try {
			price = Integer.parseInt(request.getParameter("price"));
		}
		catch (NumberFormatException e) {
			System.out.println(price + " は数値ではありません。 ");
		}

		budgetTrackerDto = new BudgetTrackerDto();
		budgetTrackerDto.setId(id);
		budgetTrackerDto.setDate(sqlDate);
		budgetTrackerDto.setStoreName(storeName);
		budgetTrackerDto.setProductName(productName);
		budgetTrackerDto.setProductType(productType);
		budgetTrackerDto.setPrice(price);

		budgetTrackerSearchDao = new BudgetTrackerSearchDao();
		

		try {
			rset = (ResultSet) budgetTrackerSearchDao.selectQuery();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("result", rset);

		request.getRequestDispatcher("/search.jsp").forward(request, response);

	}

}
