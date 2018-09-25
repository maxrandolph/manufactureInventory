/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanufacture;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author maxra
 */
public class InventoryManufacture extends Application {

    public static ActionIntent actionIntent;
    public static Stage stage;
    public static Parent root;

    @Override
    public void start(Stage stage) throws Exception {
        actionIntent = ActionIntent.Add;

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

}
