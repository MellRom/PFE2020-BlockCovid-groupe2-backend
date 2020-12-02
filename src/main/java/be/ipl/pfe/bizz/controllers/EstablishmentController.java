package be.ipl.pfe.bizz.controllers;

import be.ipl.pfe.dal.dao.IEstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl2020-groupe2.herokuapp.com"})
@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

    @Autowired
    private IEstablishmentService establishmentService;

}
