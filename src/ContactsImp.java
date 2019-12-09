import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsImp {

    //do we need to add the folder?
    final static String folder = "src";
    final static String fileName = "Contacts.txt";
    public static String contactName;
    public static String contactNum;
    public static List<String> lines;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path file = Paths.get(folder, fileName);
        Personages ethan = new Personages("ethan", "1234567893");
        Personages jacob = new Personages("jacob", "2344567893");
        String newHuman = ethan.getName() + " | " + ethan.getNumber();
        String newerHuman = jacob.getName() + " | " + jacob.getNumber();
        String header = "Name  | Phone Number \n--------------------";
        List<String> contactList = Arrays.asList(header, newHuman, newerHuman);
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            Files.write(file, contactList);
            List<String> lines = Files.readAllLines(file);
            while (true) {
                System.out.println("1. View contacts.");
                System.out.println("2. Add a new contact.");
                System.out.println("3. Search contacts by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                String userInput = sc.nextLine();

                switch (userInput) {
                    case "1": {
                        for (String line : lines) {
                            System.out.println(line);
                        }
                    }
                    case "2": {
                        System.out.println("Please enter contact's name: ");
                        String nameInput = sc.nextLine();
                        System.out.println("Please enter their phone number: ");
                        String numInput = sc.nextLine();
                        Personages person = new Personages(nameInput, numInput);


                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }





        }

    }

