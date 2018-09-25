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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    Button btnAddProduct;
    @FXML
    Button btnModifyProduct;
    @FXML
    private Label labelIMS;

    @FXML
    private void HandleBtnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void HandleBtnAddPart(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Add;
        InventoryManufacture.ChangeScene("PartView.fxml", btnAddPart);
    }

    @FXML
    private void HandleBtnModifyPart(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Modify;
        InventoryManufacture.ChangeScene("PartView.fxml", btnModifyPart);
    }

    @FXML
    private void HandleBtnAddProduct(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Add;
        InventoryManufacture.ChangeScene("ProductView.fxml", btnAddProduct);
    }

    @FXML
    private void HandleBtnModifyProduct(ActionEvent event) throws IOException {
        InventoryManufacture.actionIntent = ActionIntent.Modify;
        InventoryManufacture.ChangeScene("ProductView.fxml", btnModifyProduct);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
