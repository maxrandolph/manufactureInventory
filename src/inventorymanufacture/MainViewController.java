/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanufacture;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author maxra
 */
public class MainViewController implements Initializable {

    @FXML
    Button btnAddPart;
    @FXML
    Button btnModifyPart;
    @FXML
    Button btnDeletePart;

    @FXML
    Button btnAddProduct;
    @FXML
    Button btnModifyProduct;
    @FXML
    Button btnDeleteProduct;

    @FXML
    Label labelIMS;

    @FXML
    TableView<Part> tablePart;

    @FXML
    TableColumn<Part, Integer> colPartId;
    @FXML
    TableColumn<Part, String> colPartName;
    @FXML
    TableColumn<Part, String> colInventoryLevel;
    @FXML
    TableColumn<Part, Double> colPriceCostPerUnit;

    @FXML
    private void HandleBtnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void HandleBtnAddPart(ActionEvent event) throws IOException {
        System.out.println(InventoryManufacture.inventory.getAllParts());
        InventoryManufacture.activePart = new Inhouse(InventoryManufacture.inventory.getNewPartId(), "New Part", 5.00, 1, 4, 0, 0);
        InventoryManufacture.actionIntent = ActionIntent.Add;
        InventoryManufacture.ChangeScene("PartView.fxml", btnAddPart);
    }

    @FXML
    private void HandleBtnModifyPart(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Modify;
        InventoryManufacture.activePart = tablePart.getSelectionModel().getSelectedItem();
        InventoryManufacture.ChangeScene("PartView.fxml", btnModifyPart);
    }

    @FXML
    private void HandleBtnDeletePart(ActionEvent event) throws IOException {
        InventoryManufacture.inventory.deletePart(tablePart.getSelectionModel().getSelectedItem());
        tablePart.getSelectionModel().clearSelection();
        btnModifyPart.setDisable(true);
        btnDeletePart.setDisable(true);
    }

    @FXML
    private void HandleBtnAddProduct(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Add;
        InventoryManufacture.ChangeScene("ProductView.fxml", btnAddProduct);
    }

    @FXML
    private void HandleBtnModifyProduct(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Modify;
        InventoryManufacture.activePart = tablePart.getSelectionModel().getSelectedItem();
        InventoryManufacture.ChangeScene("ProductView.fxml", btnModifyProduct);
    }

    @FXML
    private void HandleBtnDeleteProduct(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Modify;
        InventoryManufacture.ChangeScene("ProductView.fxml", btnModifyProduct);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Init table data
        colPartId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        colPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        colPriceCostPerUnit.setCellValueFactory(new PropertyValueFactory<>("price"));
        colInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        tablePart.setItems(InventoryManufacture.inventory.getAllParts());

        // Enable delete and modify buttons when a row is selected.
        tablePart.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnModifyPart.setDisable(false);
                btnDeletePart.setDisable(false);
            }
        });
    }
}
