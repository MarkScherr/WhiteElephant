package home.whiteelephant.controller;

import home.whiteelephant.object.PersonGift;
import home.whiteelephant.service.PersonGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonGiftController {
    private static final String PERSON_URI = "/person";

    @Autowired
    private PersonGiftService service;

    @GetMapping(PERSON_URI + "/{name}")
    private PersonGift getGiftsByName(@PathVariable("name") String name) {
        return service.getGiftFromName(name);
    }

    @GetMapping(PERSON_URI + "/all")
    private List<PersonGift> getGiftsByName() {
        return service.getAllChosenGifts();
    }

    @GetMapping(PERSON_URI + "/{name}/{giftName}")
    private boolean setGiftsByName(@PathVariable("name") String name,
                                   @PathVariable("giftName") String giftName) {
        return service.addPersonGift(new PersonGift(name, giftName));
    }

    @DeleteMapping(PERSON_URI)
    private boolean deleteAllRecords() {
        return service.deleteAllRecords();
    }
}
