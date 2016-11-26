package controller;

import sdk.Connection;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class Controller {

    Scanner input;

    public Controller() {
        Scanner inputReader = new Scanner(System.in);
    }

    public void menu() {

        System.out.println("***** Velkommen til Book It! ***** " +
                "\n Du har nu følgende muligheder: \n [1] Login \n [2] Opret bruger \n [3] Afslut session");

        switch (input.nextInt()) {

            case 1:
                logIn();
                break;
            case 2:
                createUser();
                break;
            case 3:
                exitProgram();
                break;
            default:
                System.out.println("Indtast gyldig valgmulighed");
        }
    }

    public void logIn () {

        String username;
        String password;

        System.out.println("Du har valgt login \n Indtast brugernavn: ");
        username = input.nextLine();
        System.out.println("Indtast adgangskode: ");
        password = input.nextLine();

        String token = Connection.authorizeLogin(username, password);
        if(token != null){
            System.out.println("Velkommen " + username +
                    "\n Du har nu følgende muligheder: \n [1] Vis alle bøger \n [2] Vis bestemt bog \n [3] Hvis mulige studier og semestre");

            switch (input.nextInt()) {
                case 1:
                    printBooks();
                    break;
                case 2:
                    printBook();
                    break;
                case 3:
                    printCurriculums();
                    break;
                default:
                    System.out.println("Indtast gyldig valgmulighed");
                }

            while(true);//Brug noget andet en true. CurrentUser != null
            }
                else {System.out.println("Inkorrekte oplysninger indtastet");}
        }

    public void printBooks() {
        ArrayList<Book> books = Connection.getBooks();
        System.out.println("Book It's bogregister: ");
        for (Book book : books) {
            System.out.println("Bog ID: " + book.getBookID() + " Titel: " + book.getTitle());
        }
    }
    public void printBook() {
        System.out.println("Indast id på den ønskede bog");
        Book book = Connection.getBook(input.nextInt());
        System.out.println("id: " + book.getBookID() + " title: " + book.getTitle());
    }

    public void printCurriculums() {

    }

}