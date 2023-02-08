package lab3.example;



import static org.assertj.core.api.Assertions.assertThat;

import lab3.controllers.AddressBookController;
import lab3.controllers.BuddyInfoController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookController addressBookController;
    private BuddyInfoController buddyInfoController;


    @Test
    public void contextLoads() throws Exception {
       // assertThat(addressBookController).isNotNull();
        //assertThat(buddyInfoController).isNotNull();


    }
}