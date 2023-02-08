package lab3.repo;

import lab3.example.AddressBook;

import lab3.example.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {


}