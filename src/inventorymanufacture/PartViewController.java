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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author maxra
 */
public class PartViewController implements Initializable {

    @FXML
    Button btnCancel;

    @FXML
    RadioButton radioInHouse;
    @FXML
    RadioButton radioOutsourced;
    @FXML
    ToggleGroup radioToggleGroup;
    @FXML
    Label labelActionPart;

    @FXML
    private void HandleBtnCancel(ActionEvent event) throws IOException {
        InventoryManufacture.ChangeScene("MainView.fxml", btnCancel);
    }

//    @FXML
//    private void ChangeScene(String fxmlFile) throws IOException {
//        Stage stage;
//        Parent root;
//        stage = (Stage) btnCancel.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelActionPart.setText(InventoryManufacture.actionIntent == ActionIntent.Add ? "Add Part" : "Modify Part");
    }

}
