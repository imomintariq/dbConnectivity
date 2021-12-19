package Main;

import Entities.Student;
import javafx.scene.Parent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;


public class Main extends Application{

    private static Stage stg;

    public static void main(String [] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Love u baby momin");
        stg = stage;
        String fxmlPath = "SignUp.fxml";
        URL url = getClass().getClassLoader().getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), 735, 360);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{
        URL url = getClass().getClassLoader().getResource(fxml);
        Parent pane = FXMLLoader.load(url);
        stg.getScene().setRoot(pane);

    }
}
