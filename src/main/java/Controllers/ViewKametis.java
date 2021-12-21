package Controllers;

import Main.Main;
import Main.KametiManagementSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class ViewKametis implements Initializable {



    @FXML
    private Button backButton;

    @FXML
    private Button chooseButton;

    @FXML
    private ListView<String> joinedkametiList;

    @FXML
    private ListView<String> ownedKametiList;

    private String selectedRow;
    private ArrayList<String> selectedKameti;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        selectedKameti = new ArrayList<>();
        loadJoinedKametis();
        loadCreatedKametis();
    }

    private void loadCreatedKametis() {
        KametiManagementSystem kms = new KametiManagementSystem();
        ArrayList<String> k = kms.retrieveOwnedKametis();
        ownedKametiList.getItems().addAll(k);
        ownedKametiList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedRow = ownedKametiList.getSelectionModel().getSelectedItem();//getting current selection

                selectedKameti.clear();
                StringTokenizer st = new StringTokenizer(selectedRow," ");
                while (st.hasMoreTokens()) {
                    selectedKameti.add(st.nextToken());
                }
                System.out.println("Selected kameti Id = " + selectedKameti.get(0) + ".");

            }
        });
    }

    private void loadJoinedKametis() {
        KametiManagementSystem kms = new KametiManagementSystem();
        ArrayList<String> k = kms.retrieveJoinedKametis();
        joinedkametiList.getItems().addAll(k);
        joinedkametiList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedRow = joinedkametiList.getSelectionModel().getSelectedItem();//getting current selection

                selectedKameti.clear();
                StringTokenizer st = new StringTokenizer(selectedRow," ");
                while (st.hasMoreTokens()) {
                    selectedKameti.add(st.nextToken());
                }
                System.out.println("Selected kameti Id = " + selectedKameti.get(0) + ".");

            }
        });
    }

    @FXML
    void backButtonClicked(MouseEvent event) {

        Main main = new Main();
        try {
            main.changeScene("DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }

    }

    @FXML
    void chooseButtonClicked(MouseEvent event) {


    }

}
