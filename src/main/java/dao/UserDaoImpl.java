package dao;

import entities.User;
import misc.ConfigurationFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //Retrieves all the users in the database
    @Override
    public List<User> getUsers() {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM User";
        Query query = session.createQuery(hql);

        return query.list();
    }

    //Retrieves all the users of a certain type
    @Override
    public List<User> getUsersByType(String type) {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM User u WHERE u.userType = :userType";
        Query query = session.createQuery(hql);
        query.setParameter("userType", type);

        return query.list();
    }

    //Returns a user if they exist in the database with the corresponding username and password
    @Override
    public User checkUser(String username, String password) {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List results = query.list();

        if(results.isEmpty()){
            return null;
        }

        User user = (User) results.get(0);

        return user;
    }
}
