package Social;

import Users.Student;
import java.util.*;
import Enums.*;
import Social.*;

public class StudentOrganization {
    private List<Student> members;
    private String nameOrganization;
    private TypeOrganization organizationType;
    private Student headOrganization;
    private List<Party> listParty;

    public StudentOrganization() {
        members = new ArrayList<>();
        listParty = new ArrayList<>();
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public TypeOrganization getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(TypeOrganization organizationType) {
        this.organizationType = organizationType;
    }

    public Student getHeadOrganization() {
        return headOrganization;
    }

    public void setHeadOrganization(Student headOrganization) {
        this.headOrganization = headOrganization;
    }

    public List<Party> getListParty() {
        return listParty;
    }

    public void setListParty(List<Party> listParty) {
        this.listParty = listParty;
    }

    public int getMembersSize() {
        return members != null ? members.size() : 0;
    }

    public void createParty() {
    }

    public Student kickOneMember() {
        return null;
    }

    public Student joinMember() {
        return null;
    }

    public void voitingNewHead() {
        if (members == null || members.isEmpty()) {
            System.out.println("No members available for voting.");
            return;
        }
        Random random = new Random();
        headOrganization = members.get(random.nextInt(members.size()));
        System.out.println("New head of the organization is: " + headOrganization.getName());
    }



    public boolean isStudentMember(Student student) {
        return members != null && members.contains(student);
    }

    public boolean isStudentHead(Student student) {
        return headOrganization != null && headOrganization.equals(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOrganization that = (StudentOrganization) o;
        return Objects.equals(members, that.members) && Objects.equals(nameOrganization, that.nameOrganization) && organizationType == that.organizationType && Objects.equals(headOrganization, that.headOrganization) && Objects.equals(listParty, that.listParty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, nameOrganization, organizationType, headOrganization, listParty);
    }

    @Override
    public String toString() {
        return "StudentOrganization{" +
                "members=" + members +
                ", nameOrganization='" + nameOrganization + '\'' +
                ", organizationType=" + organizationType +
                ", headOrganization=" + headOrganization +
                ", listParty=" + listParty +
                '}';
    }
}
