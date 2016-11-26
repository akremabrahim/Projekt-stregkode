package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import crypters.Crypter;
import models.Login;
import sdk.HTTPrequests;

import java.awt.print.Book;
import java.util.ArrayList;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class Connection {

    public static String authorizeLogin(String username, String password) {
        Login login = new Login(username, password);


        ClientResponse clientResponse = HTTPrequests.post(null, "/user/login", new Gson().toJson(login));
        String token = null;

        if (clientResponse == null) {
            System.out.println("Forbindelse til server ikke fundet");
        } else {
            String json = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                token = json;
            } else {
                System.out.println("");
            }
        }
        return token;
    }

    public static ArrayList<Book> getBooks() {
        ClientResponse clientResponse = HTTPrequests.get("book/");
        ArrayList<Book> books = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            String encryptedJson = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                String decryptedJson = Crypter.encryptDecryptKKK(encryptedJson);
                books = new Gson().fromJson(decryptedJson, new TypeToken<ArrayList<Book>>() {
                }.getType());
            } else {
                System.out.println("Server error! :-(");
            }
        }
        return books;
    }
    public static Book getBook (int id) {
        ClientResponse clientResponse = HTTPrequests.get("book/" + id);
        Book book = null;

        if (clientResponse == null) {
            System.out.println("SDK not found");
        } else {
            String encryptedJson = clientResponse.getEntity((String.class));
            if (clientResponse.getStatus() == 200) {
                String decryptedJson = Crypter.encryptDecryptKKK(encryptedJson);
                book = new Gson().fromJson(decryptedJson, Book.class);
            } else {
                System.out.println("Server error! :-(");
            }
        }
        return book;

    }
}



