package com.thanphyo.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.thanphyo.db.CRUD;
import com.thanphyo.model.Tables;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableHistoryController implements Initializable {

	@FXML
	private TableView<Tables> table;
	@FXML
	private TableColumn<Tables, String> tableHistoryCol;

	CRUD crud;
	Tables tables;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		showHistory();
	}

	public void showHistory() {
		crud = new CRUD();
		ObservableList<Tables> list = crud.getTabelHistory();
		tableHistoryCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("Tables_in_test"));
		table.setItems(list);
//		System.out.println(list);
	}

}
