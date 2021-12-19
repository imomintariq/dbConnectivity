package Controllers;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXML;

public class StartingScreen {

    @FXML
    private ImageView KametiLogoImage;
    Image image1 = new Image("@images/kameti logo.png") ;
    Image image2 = new Image("@images/kameti logo.png")  ;
    ImageView imageView = new ImageView();
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), image1)),
            new KeyFrame(Duration.seconds(3), new KeyValue(imageView.imageProperty(), image2)),
            new KeyFrame(Duration.seconds(8), new KeyValue(imageView.imageProperty(), null))
    );
     //   timeline.play();
    StackPane root = new StackPane();
}
