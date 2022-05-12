package Menu;

import fileCSV.ReadAndWrite;
import management.ManagementMember;
import person.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    String str = "", noResult = "No Result!";
    int choice, age, village, level;
    String name, choice2, name2, domestic, skill, user, pass;


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


    public void menuMain() throws IOException {
        str = """
                                
                --- Akatsuki ---
                    1. Login
                    2. Register
                    
                """;
        System.out.println(str);
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case FIRST_CHOICE:
                    boolean check = true;
                    while (check) {
                        System.out.println("Username");
                        user = scanner.nextLine();
                        System.out.println("Password");
                        pass = scanner.nextLine();
                        if (user.equals("admin") && pass.equals("admin")) {
                            System.out.println("Login Success!");
                            menuManager();
                        } else if (user.equals("user") && pass.equals("user")) {
                            System.out.println("Login Success!");
                            menuCustomer();
                        } else if (readAndWrite.readAcc(user.toLowerCase()) && pass.equals("1")) {
                            System.out.println("Login Success!");
                            menuMember();
                        }

                    }

                case SECOND_CHOICE:
                    System.out.println("Coming Soon!");
                    menuMain();
                    break;
                default:
                    System.out.println(noResult);
                    menuMain();
            }
        } catch (Exception e) {
            System.out.println("Error");
            scanner.nextLine();
            menuMain();
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
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case FIRST_CHOICE:

                    break;
                case SECOND_CHOICE:
                    break;
                case THIRD_CHOICE:
                    break;
                default:
                    System.out.println(noResult);
                    menuMember();
            }
        } catch (Exception e) {
            System.out.println("Error!");
            menuMember();
        }
    }

    public void menuManager() throws IOException {

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
        try {
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
                    member.getMemberList().add(new Member(name, age, village, domestic, level, skill));

                    menuManager();
                    break;
                case SECOND_CHOICE:
                    scanner.nextLine();
                    System.out.println("Enter the name to find?");
                    name2 = scanner.nextLine();
                    if (member.findByName(name2) != -1) {
                        System.out.println("What is your name?");
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
                        member.edit(name2, new Member(name, age, village, domestic, level, skill));
                        System.out.println("Edit member success!!!");
                    } else {
                        System.out.println(noResult);
                    }
                    menuManager();

                    break;
                case THIRD_CHOICE:
                    System.out.println("Enter the name to find?");
                    scanner.nextLine();
                    name2 = scanner.nextLine();
                    int index = member.findByName(name2);
                    if (index != -1) {
                        System.out.println("Are you sure delete? y/n");
                        name = scanner.nextLine();
                        if (name.toLowerCase().equals("y")) {

                            member.delete(name2);
                            System.out.println("Delete Member Success!");
                        } else {
                            System.out.println("Cancel Success!");
                        }
                    } else {
                        System.out.println(noResult);
                    }
                    menuManager();
                    break;
                case FOURTH_CHOICE:
                    System.out.println("Member List of Akatsuki!");
                    if (member.getMemberList().size() != 0) {
                        member.showAll();
                    } else {
                        System.out.println(noResult);
                    }
                    menuManager();
                    break;
                case FIFTH_CHOICE:
                    readAndWrite.readMissionList();
                    menuManager();
                    break;
                case SIXTH_CHOICE:
                    menuMain();
                    break;
                default:
                    System.out.println(noResult);
                    menuManager();
            }
        } catch (Exception e) {
            System.out.println("Error!");
            scanner.nextLine();
            menuManager();
        }
    }

    public void menuCustomer() throws IOException {
        str = """
                                
                --- Customer ---
                    1. Request Mission
                    2. Logout
                    
                """;
        System.out.println(str);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case FIRST_CHOICE:
                    scanner.nextLine();
                    System.out.println("Enter the mission you want we to do!");
                    String mission = scanner.nextLine();
                    readAndWrite.writeMissionList(mission + ",0");
                    System.out.println("Request Success!");
                    menuCustomer();
                    break;
                case SECOND_CHOICE:
                    menuMain();
                    break;
                default:
                    System.out.println(noResult);
                    menuCustomer();
            }
        } catch (Exception e) {
            System.out.println("Error!");
            scanner.nextLine();
            menuCustomer();
        }
    }
}
