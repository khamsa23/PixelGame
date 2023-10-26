/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixel;

import Models.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lilas Al Araj
 */
public class RegisterController implements Initializable {

    @FXML
    private Button register;
    
    @FXML
    private Button login;
    @FXML
    private TextField last_name;
    @FXML
    private TextField first_name;
    @FXML
    private TextField user_name;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void register(ActionEvent event) {
        String first_name = this.first_name.getText();
        String last_name = this.last_name.getText();
        String password = this.password.getText();
        String user_name = this.user_name.getText();

        if (first_name.isEmpty()) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("Error message");
            alertInformation.setHeaderText("failed registeration");
            alertInformation.setContentText("insert first name");
            alertInformation.showAndWait();
            return;
        }
        if (last_name.isEmpty()) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("Error message");
            alertInformation.setHeaderText("failed registeration");
            alertInformation.setContentText("insert last name");
            alertInformation.showAndWait();
            return;
        }
        if (user_name.isEmpty()) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("Error message");
            alertInformation.setHeaderText("failed registeration");
            alertInformation.setContentText("insert user name");
            alertInformation.showAndWait();
            return;
        }
        if (password.isEmpty()) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("Error message");
            alertInformation.setHeaderText("failed registeration");
            alertInformation.setContentText("insert password");
            alertInformation.showAndWait();
            return;
        }

        User user = new User(first_name, last_name, user_name, password);
        try {
            user.SaveToFile();
            Alert alertInformation = new Alert(Alert.AlertType.CONFIRMATION);
            alertInformation.setTitle("Success");
            alertInformation.setHeaderText("Successed registeration");
            alertInformation.setContentText("you have been sign up successfully");
            alertInformation.showAndWait();
            
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
            Scene scene = new Scene(root);
            // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
            Stage stage = (Stage) register.getScene().getWindow();;
            stage.setScene(scene);
        } catch (Exception e) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("Error message");
            alertInformation.setHeaderText("failed registeration");
            alertInformation.setContentText("Oops. please try again");
            alertInformation.showAndWait();
        }
    }

    
    @FXML
    private void login(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
            Scene scene = new Scene(root);
            // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
            Stage stage = (Stage) login.getScene().getWindow();;
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
