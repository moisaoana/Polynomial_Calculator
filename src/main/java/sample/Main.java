
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Models.Monomial;
import sample.Models.Operations;
import sample.Models.Polynomial;


import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url=new File("src/main/java/sample/View.fxml").toURI().toURL();
        Parent root=FXMLLoader.load(url);
        primaryStage.setTitle("Polynomial Calculator");
        primaryStage.setScene(new Scene(root, 600, 520));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

