package Main;

import Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class KametiManagementSystem {

    public void registerAUser(String username, String password, String email, String cnic, String firstName, String lastName, String phoneNumber, String confirmedPassword) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();


        User user= new User();
        //member.setId();
        //member.
        user.setId(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCnic(cnic);
        user.setPhoneNumber(phoneNumber);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        session.save(user);


        trans.commit();

    }
    public boolean LogIn(String Username, String Passowrd) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
    List<User> UserList = session.createQuery("FROM User").getResultList();

            for(int i=0;i<UserList.size();i++)
            {
                System.out.println(UserList.get(i).getId());
                System.out.println(UserList.get(i).getPassword());
            }  return true;
    }
}
