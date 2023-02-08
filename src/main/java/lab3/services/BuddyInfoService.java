package lab3.services;
import lab3.repo.BuddyInfoRepository;
import lab3.example.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@Component
public class BuddyInfoService {

    private final BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public BuddyInfoService(BuddyInfoRepository buddyInfoRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
    }

    public List<BuddyInfo> findBuddiesByName(String name) {
        return buddyInfoRepository.findByName(name);
    }

    public List<BuddyInfo> findBuddiesByAddress(String address) {
        return buddyInfoRepository.findByAddress(address);
    }

    public List<BuddyInfo> findBuddiesByNumber(String number) {
        return buddyInfoRepository.findByNumber(number);
    }
}
