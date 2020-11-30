package be.ipl.pfe.bizz.controllers;

import be.ipl.pfe.dal.models.HelloWorld;
import be.ipl.pfe.dal.dao.IHelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/")
public class HelloWorldController {
    @Autowired
    private IHelloWorldService helloWorldService;

    @GetMapping("hello")
    public HelloWorld HelloWorld() {
        HelloWorld helloWorld = helloWorldService.findAll().get(0);
        System.out.println("Premier test");
        return helloWorld;
    }


    @PostMapping("hello")
    public List<HelloWorld> HelloWorld(HelloWorld helloWorld) {
        List<HelloWorld> list = helloWorldService.findAll();
        return list;
    }
}
