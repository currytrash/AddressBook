package lab3.example;

import lab3.controllers.AddressBookController;
import lab3.repo.AddressBookRepository;
import lab3.services.AddressBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookService addressBookServiceservice;

    @Test
    public void createAddressBookTest() throws Exception {

        this.mockMvc.perform(get("/addAddressBook"))
                .andExpect(status().isOk())
                .andExpect(view().name("createAddressBook"));
    }
}
