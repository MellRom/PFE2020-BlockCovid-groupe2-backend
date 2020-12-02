package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.dal.dao.IUserService;
import be.ipl.pfe.dal.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

}
