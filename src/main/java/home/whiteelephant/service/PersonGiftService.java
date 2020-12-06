package home.whiteelephant.service;

import home.whiteelephant.object.PersonGift;
import home.whiteelephant.repositories.PersonGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonGiftService {

    @Autowired
    private PersonGiftRepository repository;

    public PersonGift getGiftFromName(String name) {
        return repository.findByName(name);
    }

    public boolean addPersonGift(PersonGift personGift) {
        PersonGift otherPersonsGift = repository.findByGiftName(personGift.getGiftName());
        if (otherPersonsGift != null) {
            repository.delete(otherPersonsGift);
        }
        PersonGift currentGift = repository.findByName(personGift.getName());
        if (currentGift != null) {
            repository.delete(currentGift);
        }
        PersonGift savedPersonGift = repository.save(personGift);
        return savedPersonGift.getName().equals(personGift.getName());
    }

    public List<PersonGift> getAllChosenGifts() {
        return repository.findAll();
    }

    public boolean deleteAllRecords() {
        List<PersonGift> allGifts = getAllChosenGifts();
        for (PersonGift gift : allGifts) {
            repository.delete(gift);
        }
        return true;
    }
}
