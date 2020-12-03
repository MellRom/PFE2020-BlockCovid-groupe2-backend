package be.ipl.pfe.bizz.controllers;

import be.ipl.pfe.bizz.dto.PlaceDto;
import be.ipl.pfe.bizz.dto.WebUserDto;
import be.ipl.pfe.dal.dao.IEstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl2020-groupe2.herokuapp.com"})
@RestController
@RequestMapping("/establishment/")
public class EstablishmentController {

    @Autowired
    private IEstablishmentService establishmentService;

    @PostMapping("ajout_lieu")
    public ResponseEntity insertPlace(@RequestBody PlaceDto placeDto){
        return ResponseEntity.ok(establishmentService.insertPlace(placeDto));
    }

    @PostMapping("delete_lieu")
    public ResponseEntity deletePlace(@RequestBody PlaceDto placeDto){
        return ResponseEntity.ok(establishmentService.deletePlace(placeDto));
    }

    @PostMapping("liste_lieux")
    public ResponseEntity getPlacesForEstablishment(@RequestBody PlaceDto placeDto){
        return ResponseEntity.ok(establishmentService.getPlacesForEstablishment(placeDto));
    }
}
