package bg.tu_varna.sit.a2.f23621757.user;

import bg.tu_varna.sit.a2.f23621757.book.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класът {@code UserList} управлява списък от потребители.
 * Позволява добавяне, премахване, проверка, влизане и зареждане от файл.
 */
public class UserList {
    private List<User> userList;

    /**
     * Създава нов празен списък от потребители.
     */
    public UserList() {
        userList = new ArrayList<>();
    }

    /**
     * Връща списъка с потребители.
     *
     * @return списък от {@code User} обекти
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Добавя нов потребител към списъка.
     *
     * @param username потребителско име
     * @param password парола
     * @param isAdmin  дали потребителят е администратор
     */
    public void add(String username, String password, boolean isAdmin) {
        User user = new User(username, password, isAdmin);
        userList.add(user);
    }

    /**
     * Проверява дали дадено потребителско име вече съществува в списъка.
     *
     * @param username потребителското име за проверка
     * @return {@code true} ако потребителското име съществува, {@code false} в противен случай
     */
    public boolean checkForUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Премахва потребител от списъка по потребителско име.
     *
     * @param userName името на потребителя, който ще бъде премахнат
     */
    public void remove(String userName) {
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                userList.remove(user);
                System.out.println("Successfully removed " + userName + "!\n");
                return;
            }
        }
    }

    /**
     * Извършва опит за вход в системата с дадени потребителско име и парола.
     * При успешно влизане, настройва текущия потребител.
     *
     * @param username     потребителско име
     * @param password     парола
     * @param currentUser  обект на текущия потребител, който ще бъде актуализиран при успех
     */
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

    /**
     * Зарежда потребителите от файл.
     *
     * @param fileName име на файла от който ще се чете
     */
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
