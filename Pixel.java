
package pixel;

import Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pixel extends Application{

     public static  Models.User user = new User();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {

        // Login.fxml و التي قمنا بتجهيزها في الملف Button يمثل الحاوية التي فيها Parent هنا قمنا بإنشاء كائن من الكلاس
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        // فيها. أي ما فيه سيوضع كمجتوى فيها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root);

        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في الكائن scene هنا وضعنا الكائن
        stage.setScene(scene);

        // هنا وضعنا عنوان للنافذة
        stage.setTitle("Lily Hotel");

        // هنا قمنا بإظهار النافذة
        stage.show();

    }
    
}
