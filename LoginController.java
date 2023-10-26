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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lilas Al Araj
 */
public class LoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wronglogin;
  
    @FXML
    private Button regiser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void userlogin(ActionEvent event) throws IOException {
        String password = this.password.getText();
        String user_name = this.username.getText();

        if (user_name.isEmpty()) {
            wronglogin.setText("insert username");
            return;
        }

        if (password.isEmpty()) {
            wronglogin.setText("insert password");
            return;
        }

        Pixel.user = new User(user_name, password);
        if (Pixel.user.CanLogin()) {
  
            Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

            // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
            Scene scene = new Scene(root);
            // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
            Stage stage = (Stage) login.getScene().getWindow();;
            stage.setScene(scene);
        } else {
            wronglogin.setText("username or password incorrect");
            return;
        }

    }

    @FXML
    private void register(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            
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
