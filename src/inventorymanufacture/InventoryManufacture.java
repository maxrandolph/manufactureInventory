/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanufacture;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author maxra
 */
public class InventoryManufacture extends Application {

    // App-wide stuff. ActionIntent is used to determine whether an object is
    // being modified or added. This allows us to use one view class for both
    // actions.
    public static ActionIntent actionIntent;
    public static Inventory inventory;
    
    // These refer to what part or product is currently selected.
    public static Part activePart;
    public static Product activeProduct;

    // JavaFX stuff
    public static Stage stage;
    public static Parent root;

    @Override
    public void start(Stage stage) throws Exception {
        actionIntent = ActionIntent.Add;
        inventory = new Inventory();

        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public static void ChangeScene(String fxmlFile, Button buttonClicked) throws IOException {
        stage = (Stage) buttonClicked.getScene().getWindow();
        root = FXMLLoader.load(InventoryManufacture.class.getResource(fxmlFile));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void SetTextFieldNumeric(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

}
