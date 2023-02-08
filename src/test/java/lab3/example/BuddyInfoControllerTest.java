package lab3.example;

import lab3.repo.AddressBookRepository;
import lab3.repo.BuddyInfoRepository;
import lab3.services.AddressBookService;
import lab3.services.BuddyInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import lab3.services.AddressBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Optional;

import static java.util.EnumSet.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.*;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(PER_CLASS)
public class BuddyInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookRepository addressBookRepository;
    @MockBean
    private BuddyInfoRepository buddyInfoRepository;

    @BeforeEach
    public void setUp() {
        BuddyInfo buddy = new BuddyInfo("Yahya","123 Sesame Street", "999-999-9999");
        when(buddyInfoRepository.findById(1L)).thenReturn(java.util.Optional.of(buddy));
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        when(addressBookRepository.findById(1L)).thenReturn(java.util.Optional.of(addressBook));
    }


    @Test
    public void testAddBuddyForm() throws Exception {
        mockMvc.perform(get("/addbuddy"))
                .andExpect(status().isOk())
                .andExpect(view().name("addBuddyForm"));
    }

    @Test
    public void testAddBuddySubmit() throws Exception {
        mockMvc.perform(post("/submit")
                        .param("name", "Yahya")
                        .param("number", "999-999-9999")
                        .param("address", "123 Sesame Street"))
                .andExpect(status().isOk())
                .andExpect(view().name("addBuddySubmit"))
                .andExpect(model().attribute("name", "Yahya"));

        verify(buddyInfoRepository, times(1)).save(any(BuddyInfo.class));
        verify(addressBookRepository, times(1)).save(any(AddressBook.class));
    }

    @Test
    public void testRemoveBuddy() throws Exception {


        // Mocking the endpoint for removing a buddy and checking for success status code
        mockMvc.perform(post("/remove")
                        .param("name", "Yahya")
                        .param("number", "999-999-9999")
                        .param("address", "123 Sesame Street"))
                .andExpect(status().isOk());

        // Verifying that the addressBook.removeBuddy method and buddyInfoRepository.delete method were called
        verify(addressBookRepository, times(1)).save(any(AddressBook.class));
        verify(buddyInfoRepository, times(1)).delete(any(BuddyInfo.class));


    }

    @Test
    public void testDisplayBuddies() throws Exception {
        BuddyInfo buddy = new BuddyInfo("Yahya","123 Sesame Street", "999-999-9999");
        AddressBook addressbook = new AddressBook();
        addressbook.addBuddy(buddy);
        mockMvc.perform(get("/buddies"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("buddies",addressbook.getList()))
                .andExpect(view().name("displaybuddies"));
    }
}

