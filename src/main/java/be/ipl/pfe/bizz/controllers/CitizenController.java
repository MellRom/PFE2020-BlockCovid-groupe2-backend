package be.ipl.pfe.bizz.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl2020-groupe2.herokuapp.com"})
@RestController
@RequestMapping("/citizen/")
public class CitizenController {
}

