/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixel;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lilas Al Araj
 */
public class HomepageController implements Initializable {

    @FXML
    private Button storeButton;
    @FXML
    private Button libraryButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void swichtostore(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        Stage stage = (Stage) storeButton.getScene().getWindow();;
        stage.setScene(scene);
    }

    @FXML
    private void swichtolibrary(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Library.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        Stage stage = (Stage) libraryButton.getScene().getWindow();;
        stage.setScene(scene);
    }

}
