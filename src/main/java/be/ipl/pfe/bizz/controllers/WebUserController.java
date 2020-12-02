package be.ipl.pfe.bizz.controllers;

import be.ipl.pfe.bizz.dto.WebUserDto;
import be.ipl.pfe.dal.dao.IWebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl2020-groupe2.herokuapp.com"})
@RestController
@RequestMapping("/")
public class WebUserController {
    @Autowired
    private IWebUserService userService;

    @PostMapping("connexion")
    public ResponseEntity connexion(@RequestBody WebUserDto webUserDto) {
        return ResponseEntity.ok(userService.checkConnection(webUserDto));
    }

    @PostMapping("inscription")
    public ResponseEntity inscription(@RequestBody WebUserDto webUserDto){
         return ResponseEntity.ok(userService.insertUser(webUserDto));
    }
}
