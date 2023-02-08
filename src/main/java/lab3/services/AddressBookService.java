package lab3.services;

import lab3.example.AddressBook;
import lab3.repo.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public void deleteAddressBook(Long id) {
        addressBookRepository.deleteById(id);
    }
}

