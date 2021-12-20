package Main;

import Entities.User;
import Entities.Kameti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
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

    public boolean LogIn(String Username, String Password) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();

        List<User> UserList = session.createQuery("FROM User").getResultList();

            for(int i=0;i<UserList.size();i++) {
                System.out.println(UserList.get(i).getId());
                System.out.println(UserList.get(i).getPassword());

                if(UserList.get(i).getId().equals(Username) && UserList.get(i).getPassword().equals(Password)){
                    System.out.println("found");
                    return true;
                }
            }

            System.out.println("not found");
            return false;
    }

    public void AddAKameti(String KametiName, String KametiFrequency, String Rule1, String Rule2, String Rule3, String Rule4, String Rule5, String isPrivate, int KametiPayout, LocalDate LC,int kametiDuration)
    {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();
        Kameti K = new Kameti();
        //SETTING VALUES
        K.setKametiName(KametiName);
        K.setKametiDuration(kametiDuration);
        K.setFrequency(KametiFrequency);
        K.setRule1(Rule1);
        K.setRule2(Rule2);
        K.setRule3(Rule3);
        K.setRule4(Rule4);
        K.setRule5(Rule5);
        K.setIsPrivate(isPrivate);
        K.setTotalPayout(KametiPayout);
        K.setStartDate(LC);
        K.setTotalMembers(10);
        K.setIndivisualShare(1000);
        K.setId(1);
        trans.commit();

    }
}
