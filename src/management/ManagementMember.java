package management;

import fileCSV.ReadAndWrite;
import person.Member;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagementMember {

    List<Member> memberList;
    Member member = new Member();
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public ManagementMember() throws FileNotFoundException {
        memberList = new ArrayList<>();
        readAndWrite.readFile(memberList);
    }

    public List<Member> getMemberList() {

        return memberList;
    }

    public void add(Member member) {
        memberList.add(member);
    }

    public void edit(String name, Member member) throws IOException {
        memberList.set(findByName(name), member);
        readAndWrite.writeFile(memberList);
    }

    public void delete(String name) throws IOException {
        memberList.remove(findByName(name));
        readAndWrite.writeFile(memberList);
    }

    public int findByName(String name) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void showAll() {
        for (Member inf :
                memberList) {
            System.out.println(inf);
        }
    }

}
