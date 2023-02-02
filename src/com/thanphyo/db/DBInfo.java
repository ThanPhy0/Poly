package com.thanphyo.db;

public class DBInfo {
	public static final String url = "jdbc:mysql://localhost:3306/test";
	public static final String userName = "thanphyo";
	public static final String password = "271999than";
	public static final String create = "insert into today (id, datetime, name, cp, myan, simee, invest, profit, price) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String selectstarfrom = "select * from today";

	public static final String deleterow = "delete from today where id =?";
	public static final String showtable = "show tables";

	public static final String updaterow = "update today set datetime=?, name=?, cp=?, myan=?, simee=?, invest=?, profit=?, price=? where id=?";

	public static final String adjustId1 = "set @autoid :=0";
	public static final String adjustId2 = "update today set id = @autoid := (@autoid+1)";
	public static final String adjustId3 = "alter table today auto_increment = 1";
}
