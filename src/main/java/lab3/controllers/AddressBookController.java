package lab3.controllers;

import lab3.example.AddressBook;
import lab3.repo.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {
        private AddressBookRepository addressBookRepository;


        @Autowired
        public AddressBookController(AddressBookRepository addressBookRepository) {
                this.addressBookRepository = addressBookRepository;
        }

        @RequestMapping("/addAddressBook")
        public String createAddressBook(Model model){
                AddressBook addressBook = new AddressBook();
                addressBookRepository.save(addressBook);
                model.addAttribute("id",addressBook.getId());
                return "addAdressBook";
        }
}