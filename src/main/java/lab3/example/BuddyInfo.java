package lab3.example;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "BuddyInfo")

public class BuddyInfo {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String number;

    public BuddyInfo() {
    }

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "(Name:" + getName() + "|" + "Address:" + getAddress() + "|" + "Number:" + getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(name, buddyInfo.name) && Objects.equals(address, buddyInfo.address) && Objects.equals(number, buddyInfo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, number);
    }
    /**  public static void main(String[] args) {
       org.example.BuddyInfo buddy = new org.example.BuddyInfo("Homer","210 beatrice dr","6131231234");
       System.out.println("Hello " + buddy.getName());
    }*/
}
