package bg.tu_varna.sit.a2.f23621757.user;

import bg.tu_varna.sit.a2.f23621757.book.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(String username, String password, boolean isAdmin) {
        User user = new User(username, password, isAdmin);
        userList.add(user);
    }

    public void remove(String userName) {
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                userList.remove(user);
                break;
            }
        }
    }

    public void logIn(String username, String password, CurrentUser currentUser) {
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("Welcome " + username);
                currentUser.setHasLoggedIn(true);
                currentUser.setAdmin(user.isAdmin());
                return;
            }
        }
        System.out.println("Incorrect username or password");
    }

    public void readFromFile(String fileName) {
        String filePath = System.getProperty("user.dir") + File.separator + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = new User();
                user.setUsername(line = reader.readLine());
                user.setPassword(line = reader.readLine());
                user.setAdmin(Boolean.parseBoolean(line = reader.readLine()));
                line = reader.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
