package be.ipl.pfe.bizz.controllers;

import be.ipl.pfe.bizz.dto.PlaceDto;
import be.ipl.pfe.bizz.dto.WebUserDto;
import be.ipl.pfe.dal.dao.IWebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl-groupe2-fron.herokuapp.com/", "*"})
@RestController
@RequestMapping("/")
public class WebUserController {
    @Autowired
    private IWebUserService userService;

    @PostMapping("connexion")
    public ResponseEntity connexion(@RequestBody WebUserDto webUserDto) {
        WebUserDto toSend = userService.checkConnection(webUserDto);
        if(toSend== null){
            return ResponseEntity.badRequest().body("Login ou mot de passe incorrect");
        }
        return ResponseEntity.ok(toSend);
    }

    @PostMapping("inscription")
    public ResponseEntity inscription(@RequestBody WebUserDto webUserDto){
        WebUserDto toSend = userService.insertUser(webUserDto);
        if(toSend == null){
            return ResponseEntity.badRequest().body("Login déjà existant");
        }
         return ResponseEntity.ok(toSend);
    }


    //Establishment
    @PostMapping("establishment/insert_place")
    public ResponseEntity insertPlace(@RequestBody PlaceDto placeDto){
        return ResponseEntity.ok(userService.insertPlace(placeDto));
    }

    @PostMapping("establishment/modify_place")
    public ResponseEntity deletePlace(@RequestBody PlaceDto placeDto){
        return ResponseEntity.ok(userService.insertPlace(placeDto));
    }

    @PostMapping("establishment/list_places")
    public ResponseEntity getPlacesForEstablishment(@RequestBody WebUserDto webUserDto){
        return ResponseEntity.ok(userService.getPlacesForEstablishment(webUserDto).getPlaces());
    }
}
