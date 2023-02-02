package com.thanphyo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thanphyo.model.Items;
import com.thanphyo.model.Tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CRUD implements MySQL {

	boolean dbConnected = false;
	Connection con = null;
	Items items;
	Tables tables;
	int count = 0;

	@Override
	public void Connection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(DBInfo.url, DBInfo.userName, DBInfo.password);
				dbConnected = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void CreatedataBase(String datetime, String name, int cp, int myan, int simee, int invest, int profit,
			int price) {
		// TODO Auto-generated method stub
		Connection();
		getID();
		if (dbConnected != false) {
			try {
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery("select id form today");

				PreparedStatement prepStmt = con.prepareStatement(DBInfo.create, Statement.RETURN_GENERATED_KEYS);
				prepStmt.setInt(1, count + 1);
				prepStmt.setString(2, datetime);
				prepStmt.setString(3, name);
				prepStmt.setInt(4, cp);
				prepStmt.setInt(5, myan);
				prepStmt.setInt(6, simee);
				prepStmt.setInt(7, invest);
				prepStmt.setInt(8, profit);
				prepStmt.setInt(9, price);
				prepStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("connection error");
		}
	}

	@Override
	public ObservableList<Items> observableList() {
		// TODO Auto-generated method stub
		ObservableList<Items> list = FXCollections.observableArrayList();
		Connection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(DBInfo.selectstarfrom);
			while (rs.next()) {
				items = new Items(rs.getInt("id"), rs.getString("datetime"), rs.getString("name"), rs.getInt("cp"),
						rs.getInt("myan"), rs.getInt("simee"), rs.getInt("invest"), rs.getInt("profit"),
						rs.getInt("price"));
				list.add(items);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void getID() {
		// TODO Auto-generated method stub

		Connection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(DBInfo.selectstarfrom);
			while (rs.next()) {
				count++;
			}
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void DeleteRow(int id) {
		// TODO Auto-generated method stub
		Connection();
		try {
			PreparedStatement prepStmt = con.prepareStatement(DBInfo.deleterow);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			adjustID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void adjustID() {
		// TODO Auto-generated method stub
		Connection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(DBInfo.selectstarfrom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ObservableList<Tables> getTabelHistory() {
		// TODO Auto-generated method stub
		ObservableList<Tables> list = FXCollections.observableArrayList();
		Connection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(DBInfo.showtable);
			while (rs.next()) {
				tables = new Tables(rs.getString("Tables_in_test"));
				list.add(tables);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void UpdateRow(String datetime, String name, int cp, int myan, int simee, int invest, int profit, int price,
			int id) {
		// TODO Auto-generated method stub
		Connection();
		if (dbConnected != false) {
			try {
				PreparedStatement prpstmt = con.prepareStatement(DBInfo.updaterow);
				prpstmt.setString(1, datetime);
				prpstmt.setString(2, name);
				prpstmt.setInt(3, cp);
				prpstmt.setInt(4, myan);
				prpstmt.setInt(5, simee);
				prpstmt.setInt(6, invest);
				prpstmt.setInt(7, profit);
				prpstmt.setInt(8, price);
				prpstmt.setInt(9, id);
				prpstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
