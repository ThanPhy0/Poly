package com.thanphyo.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.thanphyo.db.CRUD;
import com.thanphyo.model.Items;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddController implements Initializable {

	CRUD crud;
	Items items;

	@FXML
	private int idforUpdate;

	@FXML
	public Button btnSave;

	@FXML
	public TextField name;
	@FXML
	private TextField cp;
	@FXML
	private TextField myanmar;
	@FXML
	private TextField simee;
	@FXML
	private TextField investment;
	@FXML
	private TextField profit;
	@FXML
	private TextField price;
	@FXML
	private Label date;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.getDateTime(date);
	}

	public void saveBtn() {
		System.out.println(name.getText());
		crud = new CRUD();

		if (name.getText().isEmpty()) {
			System.out.println("insert name!");
		} else if (cp.getText().isEmpty()) {
			System.out.println("insert cp!");
		} else if (myanmar.getText().isEmpty()) {
			System.out.println("insert myanmar!");
		} else if (simee.getText().isEmpty()) {
			System.out.println("insert simee!");
		} else if (investment.getText().isEmpty()) {
			System.out.println("insert investment!");
		} else if (profit.getText().isEmpty()) {
			System.out.println("insert profit!");
		} else if (price.getText().isEmpty()) {
			System.out.println("insert price!");
		} else {
			if (btnSave.getText() == "Update") {
//				System.out.println("Update");
				update();
			} else {
//				System.out.println("Save");
				save();
			}
		}

	}

	public void save() {
		crud.CreatedataBase(name.getText(), date.getText(), Integer.parseInt(cp.getText()),
				Integer.parseInt(myanmar.getText()), Integer.parseInt(simee.getText()),
				Integer.parseInt(investment.getText()), Integer.parseInt(profit.getText()),
				Integer.parseInt(price.getText()));
	}

	public void update() {
		crud.UpdateRow(name.getText(), date.getText(), Integer.parseInt(cp.getText()),
				Integer.parseInt(myanmar.getText()), Integer.parseInt(simee.getText()),
				Integer.parseInt(investment.getText()), Integer.parseInt(profit.getText()),
				Integer.parseInt(price.getText()), idforUpdate);
	}

	public void updateItems(int id, String Name, int CP, int Myanmar, int Simee, int Investment, int Profit,
			int Price) {
		idforUpdate = id;
		name.setText(Name);
		cp.setText(String.valueOf(CP));
		myanmar.setText(String.valueOf(Myanmar));
		simee.setText(String.valueOf(Simee));
		investment.setText(String.valueOf(Investment));
		profit.setText(String.valueOf(Profit));
		price.setText(String.valueOf(Price));
		btnSave.setText("Update");
	}

	public void delete() {

	}

}
