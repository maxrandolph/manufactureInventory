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
    private Label label;

    @FXML
    private void HandleBtnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void HandleBtnAdd(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) btnAddPart.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("AddPartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
