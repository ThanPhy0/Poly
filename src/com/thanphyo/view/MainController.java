package com.thanphyo.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thanphyo.db.CRUD;
import com.thanphyo.model.Items;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {

	CRUD crud;
	Items items;

	@FXML
	private TableView<Items> table;
	@FXML
	private TableColumn<Items, Integer> idCol;
	@FXML
	private TableColumn<Items, String> datetimeCol;
	@FXML
	private TableColumn<Items, String> nameCol;
	@FXML
	private TableColumn<Items, Integer> cpCol;
	@FXML
	private TableColumn<Items, Integer> myanCol;
	@FXML
	private TableColumn<Items, Integer> simeeCol;
	@FXML
	private TableColumn<Items, Integer> investCol;
	@FXML
	private TableColumn<Items, Integer> profitCol;
	@FXML
	private TableColumn<Items, Integer> priceCol;
	@FXML
	private Label dateandtime;

//	private ObservableList<ItemsCons> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setTableView();
		Main main = new Main();
		main.getDateTime(dateandtime);

		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		System.out.println(table.getId());
	}

	public void setTableView() {
		crud = new CRUD();
		ObservableList<Items> list = crud.observableList();

		idCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("id"));
		datetimeCol.setCellValueFactory(new PropertyValueFactory<Items, String>("datetime"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Items, String>("name"));
		cpCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("cp"));
		myanCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("myan"));
		simeeCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("simee"));
		investCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("invest"));
		profitCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("profit"));
		priceCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("price"));

		table.setItems(list);
	}

	public void addBtn() {
		Stage stage = new Stage();
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("add_view.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete() {
		ObservableList<Items> items = table.getSelectionModel().getSelectedItems();
//		System.out.println(items.get(0).getId());
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (Items out : items) {
			data.add(out.getId());
//			System.out.println(out.getId());
		}
		for (int out : data) {
			crud.DeleteRow(out);
//			System.out.println(out);
		}
	}

	public void edit(ActionEvent event) {
		if (table.getSelectionModel().getSelectedItem() == null) {
			System.out.println("Select you want to edit item!");
		} else {
			Stage stage = new Stage();
			Scene scene;
			Parent root;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("add_view.fxml"));
				root = loader.load();
				AddController adc = loader.getController();
				adc.updateItems(table.getSelectionModel().getSelectedItem().getId(),
						table.getSelectionModel().getSelectedItem().getDatetime(),
						table.getSelectionModel().getSelectedItem().getCp(),
						table.getSelectionModel().getSelectedItem().getMyan(),
						table.getSelectionModel().getSelectedItem().getSimee(),
						table.getSelectionModel().getSelectedItem().getInvest(),
						table.getSelectionModel().getSelectedItem().getProfit(),
						table.getSelectionModel().getSelectedItem().getPrice());
//				stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
				scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void refreshTable() {
		table.refresh();
	}

	public void historyBtn(ActionEvent event) {
		Stage stage;
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("table_history.fxml"));
			root = loader.load();
//			stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			
			stage = new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
