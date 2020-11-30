package be.ipl.pfe.dal.dao;

import be.ipl.pfe.dal.models.HelloWorld;

import java.util.List;

public interface IHelloWorldService {

    List<HelloWorld> findAll();
}
