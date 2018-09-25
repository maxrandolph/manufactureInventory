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
    Button btnSave;
    @FXML
    RadioButton radioInHouse;
    @FXML
    RadioButton radioOutsourced;
    @FXML
    ToggleGroup radioToggleGroup;
    @FXML
    Label labelActionPart;
    @FXML
    Label labelCompanyMachine;
    @FXML
    TextField fieldId;
    @FXML
    TextField fieldName;
    @FXML
    TextField fieldInv;
    @FXML
    TextField fieldPrice;
    @FXML
    TextField fieldMax;
    @FXML
    TextField fieldMin;
    @FXML
    TextField fieldCompany;

    Part currentPart;

    @FXML
    private void HandleBtnCancel(ActionEvent event) throws IOException {
        InventoryManufacture.ChangeScene("MainView.fxml", btnCancel);
    }

    @FXML
    private void HandleBtnSave(ActionEvent event) throws IOException {
        currentPart.setPartID(Integer.decode(fieldId.getText()));
        currentPart.setInStock(Integer.decode(fieldInv.getText()));
        currentPart.setPrice(Double.parseDouble(fieldPrice.getText()));
        currentPart.setMin(Integer.decode(fieldMin.getText()));
        currentPart.setMax(Integer.decode(fieldMax.getText()));
        currentPart.setName(fieldName.getText());

        // if the part already exists then update it with stuff.
        if (InventoryManufacture.inventory.lookupPart(Integer.decode(fieldId.getText())) != null) {
            {
                InventoryManufacture.inventory.updatePart(currentPart.getPartID(), currentPart);
            }
        } else {
            InventoryManufacture.inventory.addPart(currentPart);
        }
        InventoryManufacture.ChangeScene("MainView.fxml", btnCancel);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        currentPart = InventoryManufacture.activePart;
        ChangeListener removableListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    fieldCompany.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        };
        fieldCompany.textProperty().addListener(removableListener);

        labelActionPart.setText(InventoryManufacture.actionIntent == ActionIntent.Add ? "Add Part" : "Modify Part");

        radioInHouse.setUserData("inhouse");
        radioOutsourced.setUserData("outsourced");

        radioToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_val, Toggle new_val) {
                if (radioToggleGroup.getSelectedToggle() != null) {
                    if ("outsourced".equals(radioToggleGroup.getSelectedToggle().getUserData().toString())) {
                        fieldCompany.setPromptText("Company Name");
                        labelCompanyMachine.setText("Company Name");
                        fieldCompany.setText("");
                        fieldCompany.textProperty().removeListener(removableListener);

                    } else {
                        fieldCompany.setPromptText("Machine ID");
                        labelCompanyMachine.setText("Machine ID");
                        fieldCompany.setText("");
                        fieldCompany.textProperty().addListener(removableListener);
                    }
                }
            }
        });

        FillPartFields();

        // Allow only numbers in numeric fields.
        InventoryManufacture.SetTextFieldNumeric(fieldMin);
        InventoryManufacture.SetTextFieldNumeric(fieldMax);
        InventoryManufacture.SetTextFieldNumeric(fieldInv);

    }

    private void FillPartFields() {
        if (InventoryManufacture.activePart == null) {
            fieldId.setText(Integer.toString(InventoryManufacture.inventory.getNewPartId()));
        } else {
            fieldId.setText(Integer.toString(InventoryManufacture.activePart.getPartID()));
            fieldName.setText(InventoryManufacture.activePart.getName());
            fieldInv.setText(Integer.toString(InventoryManufacture.activePart.getInStock()));
            fieldMin.setText(Integer.toString(InventoryManufacture.activePart.getMin()));
            fieldMax.setText(Integer.toString(InventoryManufacture.activePart.getMax()));
            fieldPrice.setText(Double.toString(InventoryManufacture.activePart.getPrice()));
        }
    }

}
