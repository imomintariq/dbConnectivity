package Main;

import Entities.Student;
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

    public static void main(String [] args){


        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPath = "StartingScreen.fxml";
        URL url = getClass().getClassLoader().getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), 735, 360);
        stage.setTitle("Kameti Management System");
        stage.setScene(scene);
        stage.show();
    }
}
