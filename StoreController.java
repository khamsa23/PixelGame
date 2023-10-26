/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixel;

import Models.Installation;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lilas Al Araj
 */
public class StoreController implements Initializable {

    @FXML
    private Button Overwatch;
    @FXML
    private Button Minecraft;
    @FXML
    private Button Call_of_Duty;
    @FXML
    private Button Red_Dead_redemption_2;
    @FXML
    private Button The_Forest;
    @FXML
    private Button Friday_the_13th;
    @FXML
    private Button Among_Us;
    @FXML
    private Button Stray;
    @FXML
    private Button backbutton;
    @FXML
    private Button libraryBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void HandleInstall(ActionEvent event) {

        try {
            String game = ((Button) event.getSource()).getId();

            Installation installation = new Installation(game, new Date().toString());
            Pixel.user.addInstallation(installation);
            Alert alertInformation = new Alert(Alert.AlertType.CONFIRMATION);
            alertInformation.setTitle("Success");
            alertInformation.setHeaderText("Successed Install");
            alertInformation.setContentText("you have been installed " + game.replaceAll("_", " ") + " successfully");
            alertInformation.showAndWait();
        } catch (Exception e) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("Error");
            alertInformation.setHeaderText("Failed Install");
            alertInformation.setContentText("Oops, please try again.");
            alertInformation.showAndWait();
        }
    }

    @FXML
    private void HandleBackHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        Stage stage = (Stage) backbutton.getScene().getWindow();;
        stage.setScene(scene);
    }

    @FXML
    private void HandleLibrarySwitch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Library.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        Stage stage = (Stage) libraryBtn.getScene().getWindow();;
        stage.setScene(scene);
    }

}
