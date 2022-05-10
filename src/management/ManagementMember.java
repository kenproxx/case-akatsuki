package management;

import fileCSV.ReadAndWrite;
import person.Member;

import java.awt.*;
import java.io.FileNotFoundException;
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

    public void edit(String name, Member member) {
        memberList.set(findByName(name), member);
    }

    public void delete(String name) {
        memberList.remove(findByName(name));
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
