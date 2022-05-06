import fileCSV.ReadAndWrite;
import management.ManagementMember;
import person.Member;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    String str = "";
    int choice, age,village,level;
    String name,domestic,skill, user,pass;

    Scanner scanner = new Scanner(System.in);
    final int FIRST_CHOICE = 1;
    final int SECOND_CHOICE = 2;
    final int THIRD_CHOICE = 3;
    final int FOURTH_CHOICE = 4;
    final int FIFTH_CHOICE = 5;
    final int SIXTH_CHOICE = 6;

    ManagementMember member = new ManagementMember();
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public Menu() throws FileNotFoundException {
    }

    public void menuMain() throws FileNotFoundException {
        str = """
                                
                --- Akatsuki ---
                    1. Login
                    2. Register
                    
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case FIRST_CHOICE:
                System.out.println("Username");
                scanner.nextLine();
                user = scanner.nextLine();
                System.out.println("Password");
                pass = scanner.nextLine();
                readAndWrite.readAccList(user,pass);

                break;
            case SECOND_CHOICE:
                break;

        }
    }

    public void menuMember() {
        str = """
                
                --- Member ---
                    1. Information
                    2. Mission
                    3. Logout
                    
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case FIRST_CHOICE:

                break;
            case SECOND_CHOICE:
                break;
            case THIRD_CHOICE:
                break;

        }
    }

    public void menuManager() {

        str = """
                
                --- Manager ---
                    1. Add Member
                    2. Edit Member
                    3. Remove Member
                    4. Show All Member
                    5. Mission List
                    6. Logout
                    
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case FIRST_CHOICE:
                System.out.println("What is your name?");
                scanner.nextLine();
                name = scanner.nextLine();

                System.out.println("How old are you?");
                age = scanner.nextInt();
                System.out.println("Your village? \n" +
                        "1. Konoha \n" +
                        "2. Kiri \n" +
                        "3. Suna \n" +
                        "4. Iwa \n" +
                        "5. Kumo \n");
                village = scanner.nextInt();
                System.out.println("Your clan?");
                scanner.nextLine();
                domestic = scanner.nextLine();
                System.out.println("Your level? \n" +
                        "1. Gennin \n" +
                        "2. Chunin \n" +
                        "3. Jounin \n");
                level = scanner.nextInt();
                System.out.println("Your skill?");
                scanner.nextLine();
                skill = scanner.nextLine();
                System.out.println("Add member success!!!");
                member.getMemberList().add(new Member(name,age,village,domestic,level,skill));
                menuManager();
                break;
            case SECOND_CHOICE:
                break;
            case THIRD_CHOICE:
                break;
            case FOURTH_CHOICE:
                System.out.println("Member List of Akatsuki!");
                member.showAll();
                menuManager();
                break;
            case FIFTH_CHOICE:
                break;
            case SIXTH_CHOICE:
                break;

        }
    }

    public void menuCustomer() {
        str = """
                
                --- Customer ---
                    1. Information
                    2. Request Mission
                    3. Logout
                    
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case FIRST_CHOICE:
                break;
            case SECOND_CHOICE:
                break;
            case THIRD_CHOICE:
                break;

        }
    }
}
