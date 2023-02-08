package lab3;

import lab3.repo.AddressBookRepository;
import lab3.repo.BuddyInfoRepository;
import lab3.example.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {
        private static final Logger log = LoggerFactory.getLogger(Application.class);
        private final BuddyInfoRepository repository1;
        private final AddressBookRepository repository2;

        @Autowired
        public Application(BuddyInfoRepository repository1, AddressBookRepository repository2) {
                this.repository1 = repository1;
                this.repository2 = repository2;
        }
        public static void main(String[] args) {
                SpringApplication.run(Application.class,args);
        }

       /* @Bean
        public CommandLineRunner demo() {
                return (args) -> {
                        System.out.println("Address Book w/ John and Peter : -----------");
                        BuddyInfo buddy = new BuddyInfo("john", "carleton", "613");
                        BuddyInfo buddy2 = new BuddyInfo("peter", "ottawaU", "613");
                        repository1.save(buddy);
                        repository1.save(buddy2);

                        // fetch all buddies
                        log.info("All buddies found with findAll():");
                        log.info("-------------------------------");
                        for (BuddyInfo buddyinfo : repository1.findAll()) {
                                log.info(buddyinfo.toString());
                        }
                        log.info("");
                        log.info("-------------------------------");
                        for (BuddyInfo buddyinfo : repository1.findByName("john")) {
                                log.info("Buddies with name john: " + buddyinfo.toString());

                        }
                        log.info("-------------------------------");
                        for (BuddyInfo buddyinfo : repository1.findByAddress("carleton")) {
                                log.info("Buddies with address carleton: " + buddyinfo.toString());

                        }
                        log.info("-------------------------------");
                        for (BuddyInfo buddyinfo : repository1.findByNumber("613")) {
                                log.info("Buddies with Buddies with number 613: " + buddyinfo.toString());

                        }


                };
        }*/
}