package bg.tu_varna.sit.a2.f23621757.application;

import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;

import java.util.Scanner;

public class ApplicationLibrary {
    public static void main(String[] args) {
        ConsolePrinter.welcome();
        CurrentUser currentUser = new CurrentUser(false, false, "");

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            command = scanner.next();
            if(command.equals("books")){

            }else if(command.equals("users")){

            }else{

            }
        } while (!command.equals("exit"));
    }
}
