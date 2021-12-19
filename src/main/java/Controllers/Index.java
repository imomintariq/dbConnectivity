package Controllers;

import Entities.Student;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Index {

    @FXML
    private TextField password;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField username;


    @FXML
    void SignInButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }

    }

    @FXML
    void signUpButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("SignUp.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }

/*    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Student.class);
        *//*SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        *//*//
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();

        Student s =  new Student();
        s.setId(69);
        s.setFirstName("Aloo");
        s.setLastName("Pyaaz");
        session.save(s);


        trans.commit();
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
}