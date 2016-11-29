package controller;

import models.Curriculum;
import sdk.Connection;

import java.util.ArrayList;
import java.util.Scanner;
import models.Book;


/**
 * Created by akrem_95 on 24/11/2016.
 */
public class Controller {

    Scanner input;

    public Controller() {
        input = new Scanner(System.in);
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
                menu();
        }
    }

    public void logIn () {

        String username;
        String password;

        System.out.println("Du har valgt login " +
                "\n\n Indtast brugernavn: ");
        username = input.nextLine();
        username = input.nextLine();
        System.out.println("Indtast adgangskode: ");
        password = input.nextLine();

        String token = Connection.authorizeLogin(username, password);
        if(token != null){
            System.out.println("Velkommen " + username +
                    "\n Du har nu følgende muligheder: \n [1] Vis alle bøger \n [2] Vis bestemt bog \n [3] Hvis mulige studier og semestre \n [4] Log ud");

            switch (input.nextInt()) {
                case 1:
                    printBooks();
                    userMenu();
                case 2:
                    printBook();
                    userMenu();
                case 3:
                    printCurriculums();
                    // curriculumChoice();
                    break;
                case 4:
                    menu();
                default:
                    System.out.println("Indtast gyldig valgmulighed! \n");
                    menu();
                }

            while(true);//Brug noget andet en true. CurrentUser != null
            }
                else {System.out.println("Inkorrekte oplysninger indtastet");
                logIn();}

        }

        public void userMenu(){

            System.out.println("\n \n Du har følgede valgmuligheder: \n [1] Vis alle bøger \n [2] Vis bestemt bog \n [3] Hvis mulige studier og semestre \n [4] Log ud");

            switch (input.nextInt()) {
                case 1:
                    printBooks();
                    userMenu();
                case 2:
                    printBook();
                    userMenu();
                case 3:
                    printCurriculums();

                case 4:
                    menu();
                default:
                    System.out.println("Indtast gyldig valgmulighed! \n");
                    menu();


            while(true);//Brug noget andet en true. CurrentUser != null
        }}


    public void printBooks() {
        ArrayList<Book> books = Connection.getBooks();
        System.out.println("Book It's bogregister: ");
        for (models.Book book : books) {
            System.out.println("ID: " + book.getBookID() + ", Titel: " + book.getTitle());
        }
    }
    public void printBook() {
        System.out.println("Indast ID på den ønskede bog");
        Book book = Connection.getBook(input.nextInt());
        System.out.println("ID: " + book.getBookID() + ", Titel: " + book.getTitle());
    }

    public void printCurriculums() {
        ArrayList<Curriculum> curriculums = Connection.getCurriculums();
        System.out.println("Book It's uddanelsesregister: ");
        for (models.Curriculum curriculum : curriculums) {
            System.out.println("ID: " + curriculum.getCurriculumID() + ", Uddanelse: " + curriculum.getEducation() + ", Semester: " + curriculum.getSemester());

        }
        printCurriculum();
    }

    public void printCurriculum() {
        System.out.println("\nIndtast ID for det ønskede semester");
        Curriculum curriculum = Connection.getCurriculum(input.nextInt());
        System.out.println("\n Du har valgt følgende semester: " + curriculum.getSemester() + ", som indeholder følgende bøger: " + curriculum);
    }
/*

    public void curriculumChoice() {
        System.out.println("[0] Tilbage til brugermenu \n [Indtast ID for detaljer om bestemt semester]");


        }
*/




    public void createUser() {

    }

    public void exitProgram() {

    }

}