package be.ipl.pfe.bizz.controllers;


import be.ipl.pfe.bizz.dto.VisitDto;
import be.ipl.pfe.dal.dao.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl2020-groupe2.herokuapp.com"})
@RestController
@RequestMapping("/citizen/")
public class CitizenController {

    @Autowired
    private ICitizenService citizenService;

    @GetMapping("inscription")
    public ResponseEntity inscription(){
        return ResponseEntity.ok(citizenService.inscription());
    }

    @PostMapping("visit")
    public ResponseEntity visit(@RequestBody VisitDto visitDto) {
        return ResponseEntity.ok(citizenService.visit(visitDto));
    }
}

