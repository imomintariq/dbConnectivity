package Main;

import Entities.Student;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
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
        Image image1 = new Image("images/kameti logo.png");
        Image image2 = new Image("images/kameti logo.png");
        ImageView imageView = new ImageView();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), image1)),
                new KeyFrame(Duration.seconds(3), new KeyValue(imageView.imageProperty(), image2)),
                new KeyFrame(Duration.seconds(2), new KeyValue(imageView.imageProperty(), null))
        );
        timeline.play();
        String fxmlPath = "StartingScreen.fxml";
        URL url = getClass().getClassLoader().getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), 735, 360);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
