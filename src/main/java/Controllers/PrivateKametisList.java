package Controllers;

import Main.KametiDatabaseHandler;
import Main.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class PrivateKametisList implements Initializable { //for admin
    @FXML
    private ListView<String> kametiList = new ListView<String>();

    private String selectedRow;
    private ArrayList<String> selectedKameti;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        selectedKameti = new ArrayList<>();
        KametiDatabaseHandler kms = new KametiDatabaseHandler();
        ArrayList<String> k = kms.retrievePrivateKametis();
        kametiList.getItems().addAll(k);
        kametiList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedRow = kametiList.getSelectionModel().getSelectedItem();//getting current selection

                selectedKameti.clear();
                StringTokenizer st = new StringTokenizer(selectedRow," ");
                while (st.hasMoreTokens()) {
                    selectedKameti.add(st.nextToken());
                }
                System.out.println("Selected kameti Name = " + selectedKameti.get(0) + ".");

                //System.out.println(currentCandidate);

            }
        });
    }

    @FXML
    public void backButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("AdminPages/AdminDashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Admin Dashboard Page not Loaded");
        }
    }
}
