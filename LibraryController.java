/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixel;

import Models.Installation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lilas Al Araj
 */
public class LibraryController implements Initializable {

    @FXML
    private Button storeButton;
    @FXML
    private Button backbutton;
    @FXML
    private TableView games_table;
    @FXML
    private TableColumn gameCol;
    @FXML
    private TableColumn dateCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Installation> data = FXCollections.observableArrayList(Pixel.user.getInstallations()
        );

        // تحديث عناصر الجدول عند كل مرة يتم الضغط فيها على الزر
        games_table.setItems(data);
        gameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfGame"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    public void HandleBackHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        Stage stage = (Stage) backbutton.getScene().getWindow();;
        stage.setScene(scene);
    }

    @FXML
    public void HandleStoreSwitch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Store.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        Stage stage = (Stage) storeButton.getScene().getWindow();;
        stage.setScene(scene);
    }
}
