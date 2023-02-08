package lab3.example;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressBookTest {
    @Test
    public void testAddBuddy() {
        BuddyInfo buddy = new BuddyInfo("Ed ", "Top", "613");
        BuddyInfo buddy2 = new BuddyInfo("EDD", "Mid", "911");
        BuddyInfo buddy3 = new BuddyInfo("EDDY", "Bot", "411");

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.addBuddy(buddy2);
        addressBook.addBuddy(buddy3);

        assertEquals(addressBook.getList().get(0), buddy);

    }


    @Test
    public void testRemoveBuddy() {


    }

    @Test
    public void testTestEquals() {
        BuddyInfo buddy = new BuddyInfo("john" ,"carleton","613");
        AddressBook addressBook = new AddressBook();
        AddressBook addressBook2 = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook2.addBuddy(buddy);
        assertEquals(addressBook,addressBook2);

    }
}