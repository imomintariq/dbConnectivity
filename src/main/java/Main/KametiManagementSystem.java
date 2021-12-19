package Main;
import Entities.Member;
import Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
}