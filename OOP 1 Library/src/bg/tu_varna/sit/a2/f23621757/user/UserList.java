package bg.tu_varna.sit.a2.f23621757.user;

import bg.tu_varna.sit.a2.f23621757.book.Book;

import java.io.*;
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

    public boolean checkForUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void remove(String userName) {
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                userList.remove(user);
                System.out.println("Successfully removed " + userName + "!\n");
                return;
            }
        }
    }

    public void logIn(String username, String password, CurrentUser currentUser) {
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("Welcome " + username + "!");
                currentUser.setHasLoggedIn(true);
                currentUser.setAdmin(user.isAdmin());
                System.out.println("You successfully logged in!\n");
                return;
            }
        }
        System.out.println("Incorrect username or password!\n");
    }

    public void readFromFile(String fileName) {
        String projectRoot = System.getProperty("user.dir");
        File file = new File(projectRoot, "myFiles/" + fileName);

        if (!file.exists()) {
            System.out.println("USer file doesn't exist");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = new User();
                user.setUsername(line);
                user.setPassword(line = reader.readLine());
                user.setAdmin(Boolean.parseBoolean(line = reader.readLine()));
                userList.add(user);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
