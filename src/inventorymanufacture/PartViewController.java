/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanufacture;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

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
    TextField fieldId;
    @FXML
    TextField fieldName;
    @FXML
    TextField fieldInv;
    @FXML
    TextField fieldMax;
    @FXML
    TextField fieldMin;
    @FXML
    TextField fieldCompany;

    @FXML
    private void HandleBtnCancel(ActionEvent event) throws IOException {
        InventoryManufacture.ChangeScene("MainView.fxml", btnCancel);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelActionPart.setText(InventoryManufacture.actionIntent == ActionIntent.Add ? "Add Part" : "Modify Part");

        radioInHouse.setUserData("inhouse");
        radioOutsourced.setUserData("outsourced");

        radioToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_Toggle) {
                if (radioToggleGroup.getSelectedToggle() != null) {
                    if (radioToggleGroup.getSelectedToggle().getUserData().toString() == "outsourced") {
                        fieldCompany.setDisable(false);
                    } else {
                        fieldCompany.setDisable(true);
                    }
                }
            }
        });
    }

}
