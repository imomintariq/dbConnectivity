package Controllers;

import Main.Main;
import javafx.scene.input.MouseEvent;

public class AllComplaints {
    public void backButtonClicked(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("AdminPages/AdminDashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Admin Dashboard Page not Loaded");
        }
    }
}
