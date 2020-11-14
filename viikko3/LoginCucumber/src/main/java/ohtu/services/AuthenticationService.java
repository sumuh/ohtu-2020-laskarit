package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        
        if (userDao.findByName(username) != null) {
            return true;
        }
        
        if (username.length() < 3 || password.length() < 8) {
            return true;
        }
        
        String usernameRegex = "[a-zA-Z]*";
        String passwordRegex = "[a-zA-Z]*[^a-zA-Z]+";
        
        Pattern usernamePattern = Pattern.compile(usernameRegex);
        Matcher usernameMatcher = usernamePattern.matcher(username); 
        boolean b1 = usernameMatcher.matches();
        
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password); 
        boolean b2 = passwordMatcher.matches();
        
        if (!b1 || !b2) {
            return true;
        }

        return false;
    }
}
