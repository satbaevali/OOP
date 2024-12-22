package Social;


import Users.Student;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private String partyName;
    private String partyDate;
    private List<Student> listMembers;
    private Student headAtTime;
    private String partyPlace;
    private int partyPrice;

    public Party() {
        listMembers = new ArrayList<>();
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public List<Student> getListMembers() {
        return listMembers;
    }

    public void setListMembers(List<Student> listMembers) {
        this.listMembers = listMembers;
    }

    public Student getHeadAtTime() {
        return headAtTime;
    }

    public void setHeadAtTime(Student headAtTime) {
        this.headAtTime = headAtTime;
    }

    public String getPartyPlace() {
        return partyPlace;
    }

    public void setPartyPlace(String partyPlace) {
        this.partyPlace = partyPlace;
    }

    public int getPartyPrice() {
        return partyPrice;
    }

    public void setPartyPrice(int partyPrice) {
        this.partyPrice = partyPrice;
    }

    public void getPhotos() {
        System.out.println("Fetching photos for the party.");
    }

    public int getEarnSum() {
        return partyPrice * (listMembers != null ? listMembers.size() : 0);
    }

    public void addMember(Student member) {
        if (!listMembers.contains(member)) {
            listMembers.add(member);
            System.out.println(member + " added to the party.");
        } else {
            System.out.println(member + " is already in the party.");
        }
    }

    public boolean removeMember(Student member) {
        return listMembers.remove(member);
    }
}

