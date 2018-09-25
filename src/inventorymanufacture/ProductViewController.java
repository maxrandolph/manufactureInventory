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

/**
 * FXML Controller class
 *
 * @author maxra
 */
public class ProductViewController implements Initializable {

    @FXML
    Label labelActionProduct;

    @FXML
    Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelActionProduct.setText(InventoryManufacture.actionIntent == ActionIntent.Add ? "Add Product" : "Modify Product");
    }

    @FXML
    private void HandleBtnCancel(ActionEvent event) throws IOException {
        InventoryManufacture.ChangeScene("MainView.fxml", btnCancel);
    }
}
