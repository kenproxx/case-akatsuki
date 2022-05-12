package fileCSV;

import management.ManagementMember;
import person.Member;


import Menu.Menu;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {

    final String PATH_FILE_USER = "D:\\Java\\Module 2\\akatsuki\\management-akatsuki\\src\\fileCSV\\member_List.csv";
    final String PATH_FILE_ACCOUNT = "D:\\Java\\Module 2\\akatsuki\\management-akatsuki\\src\\fileCSV\\acclist.csv";
    final String PATH_FILE_MISSION = "D:\\Java\\Module 2\\akatsuki\\management-akatsuki\\src\\fileCSV\\missionList.csv";

    public ReadAndWrite() throws FileNotFoundException {
    }

    public void readFile(List<Member> members) throws FileNotFoundException {
        FileReader fileReader = new FileReader(PATH_FILE_USER);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            members.add(new Member(arr[0],Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),arr[3],Integer.parseInt(arr[4]),arr[5]));

        }

    }

    public void writeFile(List<Member> members) throws IOException {
        FileWriter fileWriter = new FileWriter(PATH_FILE_USER);
        for (Member mber :
                members) {
            fileWriter.write(mber.getName() + "," + mber.getAge() + "," + mber.getVillage() + "," + mber.getDomestic()
                    + "," + mber.getLevel() + "," + mber.getSkill() +"\n");
        }


        fileWriter.close();
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
    public boolean readAcc(String user) throws FileNotFoundException {
        FileReader fileReader = new FileReader(PATH_FILE_USER);
        Scanner scanner = new Scanner(fileReader);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            if (arr[0].toLowerCase().equals(user) ) {
                return true;
            }

        }

            System.out.println("Account Not Found!");

        return false;
    }

    public void readMissionList() throws IOException {
        FileReader fileReader = new FileReader(PATH_FILE_MISSION);
        Scanner scanner = new Scanner(fileReader);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            String status;
            if (arr[1].equals("0")) {
                 status = "Doing!";
            } else {
                 status = "Done!";
            }
            System.out.println(arr[0] + " - " + status);

        }
        fileReader.close();
    }
    public void writeMissionList(String str) throws IOException {
        FileWriter fileWriter = new FileWriter(PATH_FILE_MISSION,true);
        fileWriter.write("\n" +str  );

        fileWriter.close();
    }
}
