package lab3.controllers;

import lab3.example.AddressBook;
import lab3.example.BuddyInfo;
import lab3.repo.AddressBookRepository;
import lab3.repo.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyInfoController {

    private  BuddyInfoRepository buddyInfoRepository;
    private  AddressBookRepository addressBookRepository;

    @Autowired
    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }
    @GetMapping("/addbuddy")
    public String addBuddyForm(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "addBuddyForm";
    }
    @PostMapping("/submit")
    public String addBuddySubmit(Model model, @ModelAttribute BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1L).get();
        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);
        buddyInfoRepository.save(buddyInfo);
        model.addAttribute("name",buddyInfo.getName());
        return "addBuddySubmit";
    }

    @GetMapping("/removebuddy")
    public String removeBuddyForm(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "removeBuddyForm";
    }
    @PostMapping("/remove")
    public String removeBuddySubmit(Model model, @ModelAttribute BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1L).get();
        addressBook.removeBuddy(buddyInfo);
        addressBookRepository.save(addressBook);
        buddyInfoRepository.delete(buddyInfo);
        model.addAttribute("name",buddyInfo.getName());
        return "removeBuddySubmit";
    }

    @GetMapping("/buddies")
    public String displayBuddies(Model model) {
        AddressBook addressBook = addressBookRepository.findById(1L).get();
        model.addAttribute("buddies", addressBook.getList());
        return "displaybuddies";
    }


}
