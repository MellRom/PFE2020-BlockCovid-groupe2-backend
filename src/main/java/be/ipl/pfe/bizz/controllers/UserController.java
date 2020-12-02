package be.ipl.pfe.bizz.controllers;

import be.ipl.pfe.bizz.dto.UserDto;
import be.ipl.pfe.dal.dao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "https://blockcovid-pfeipl2020-groupe2.herokuapp.com"})
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("connexion")
    public ResponseEntity connexion(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.checkConnection(userDto));
    }
}
