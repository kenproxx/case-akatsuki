package fileCSV;

import management.ManagementMember;
import person.Member;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    final String PATH_FILE_USER = "D:\\Java\\Module 2\\akatsuki\\management-akatsuki\\src\\fileCSV\\userlist.csv";
    final String PATH_FILE_ACCOUNT = "D:\\Java\\Module 2\\akatsuki\\management-akatsuki\\src\\fileCSV\\acclist.csv";

    public void readFile(List<Member> members) throws FileNotFoundException {
        FileReader fileReader = new FileReader(PATH_FILE_USER);
        Scanner scanner = new Scanner(fileReader);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            members.add(new Member(arr[0],Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),arr[3],Integer.parseInt(arr[4]),arr[5]));

        }

    }

    public void writeFile(List<Member> members) {

    }

    public void readAccList(String user,String pass) throws FileNotFoundException {
        FileReader fileReader = new FileReader(PATH_FILE_ACCOUNT);
        Scanner scanner = new Scanner(fileReader);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            if (arr[0].equals(user) && arr[1].equals(pass)) {
                System.out.println("Login Success!");

            } else {
                System.out.println("Account Not Found!");
            }

        }
    }

}
