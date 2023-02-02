package com.thanphyo.db;

import com.thanphyo.model.Items;
import com.thanphyo.model.Tables;

import javafx.collections.ObservableList;

public interface MySQL {
	void Connection();

	void CreatedataBase(String datetime, String name, int cp, int myan, int simee, int invest, int profit, int price);

	void DeleteRow(int id);
	
	void UpdateRow(String datetime, String name, int cp, int myan, int simee, int invest, int profit,
			int price, int id);

	void adjustID();

	ObservableList<Items> observableList();

	ObservableList<Tables> getTabelHistory();

	void getID();
}