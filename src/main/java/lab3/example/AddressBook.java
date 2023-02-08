package lab3.example;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AddressBook")
public class AddressBook {
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = BuddyInfo.class)
    private List<BuddyInfo> buddyList;


    public AddressBook() {
        buddyList = new ArrayList<>();
    }
    public void addBuddy (BuddyInfo bud){
        buddyList.add(bud);
    }

    public void removeBuddy(BuddyInfo bud) {
        buddyList.remove(bud);
    }


    public List<BuddyInfo> getList() {
        return this.buddyList;
    }
    public void printBook(){
        List<BuddyInfo> buddyList = this.buddyList;
        for(BuddyInfo bud :buddyList){
            System.out.println(bud.toString());
    }}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(buddyList, that.buddyList);
    }

    public BuddyInfo getBuddy(int i) {
        return this.buddyList.get(i);
    }
}


