package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.dal.dao.IWebUserService;
import be.ipl.pfe.dal.repositories.HelloWorldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EstablishmentService implements IWebUserService {

    @Autowired
    private HelloWorldRepository repository;
    @Autowired
    private ModelMapper modelMapper;
}
