package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.dal.dao.IEstablishmentService;
import be.ipl.pfe.dal.repositories.EstablishmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService implements IEstablishmentService {

    @Autowired
    private EstablishmentRepository repository;
    @Autowired
    private ModelMapper modelMapper;

}
