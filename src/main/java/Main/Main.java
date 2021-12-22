package Main;

import Music.Music;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class Main extends Application{

    private static Stage stg;

    public static void main(String [] args){

        Music music = new Music();
        music.run();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
/*      KametiManagementSystem kms = new KametiManagementSystem();
        kms.retrieveKametis();*/
        stg = stage;
        String fxmlPath = "StandardUserPages/LogIn.fxml";
        URL url = getClass().getClassLoader().getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(), 630, 450);
        stage.setTitle("myKameti");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{
        URL url = getClass().getClassLoader().getResource(fxml);
        Parent pane = FXMLLoader.load(url);
        stg.getScene().setRoot(pane);

    }


}
