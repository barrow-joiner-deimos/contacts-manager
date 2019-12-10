import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
    private static Object ArrayList;
    static String header = "Name  | Phone Number \n--------------------";
    static List<String> start;
    static int newIndex;


    static Path file = Paths.get(folder, fileName);

        static ArrayList<String> contactList = new ArrayList<>();
//        List<String> contactList = Arrays.asList(header, newHuman, newerHuman);

    public static void main(String[] args) throws IOException {
        contactList.add(header);
        start = Files.readAllLines(file);
        Scanner sc = new Scanner(System.in);
        if (start.size() == 0) {
            Files.write(file, Arrays.asList(header));
            }
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            boolean theFlag = true;
            List<String> lines = Files.readAllLines(file);
            while (theFlag) {
                System.out.println("1. View contacts.");
                System.out.println("2. Add a new contact.");
                System.out.println("3. Search contacts by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                String userInput = sc.nextLine();

                switch (userInput) {
                    case "1": {
                        lines = Files.readAllLines(file);
                        for (String line : lines) {
                            System.out.println(line);
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Please enter contact's name: ");
                        String nameInput = sc.nextLine();
                        System.out.println("Please enter their phone number: ");
                        String numInput = sc.nextLine();
                        Personages person = new Personages(nameInput, numInput);
                        String newestHuman = person.getName() + " | " + person.getNumber();
                        contactList.add(newestHuman.toLowerCase());
                        Files.write(file, Arrays.asList(newestHuman.toLowerCase()), StandardOpenOption.APPEND);
                        lines = Files.readAllLines(file);
                        break;
                    }
                    case "3": {
                        System.out.println("Enter the name or number of contact");
                        userInput = sc.nextLine();
                        int i = 0;
                        boolean newFlag = true;
                        while (newFlag) {
                            for (String contact : lines) {
                                if (contact.contains(userInput.toLowerCase())) {
                                    System.out.println(contact);
                                    newFlag = false;
                                    break;
                                }
                                i++;
                                if (i == lines.size()) {
                                    System.out.println("Invalid user");
                                    System.out.println("Please try again or type \"exit\"");
                                    userInput = sc.nextLine();
                                    i = 0;
                                    if (userInput.equalsIgnoreCase("exit")) {
                                        newFlag = false;
                                        break;
                                    }
                                }
                            }
                        } break;
                    }
                    case "4": {
                        System.out.println("Enter contact name to delete: ");
                        ArrayList<String> removeList = new ArrayList<>();
                        userInput = sc.nextLine();
                        for (String contact: lines) {
                            if (contact.contains(userInput)) {
                                continue;
                            }
                            removeList.add(contact);
                        }
                        Files.write(file, removeList);
                        break;
                    }
                    case "5": {
                        theFlag = false;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}

