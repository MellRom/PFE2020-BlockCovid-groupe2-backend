package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.dal.dao.IDoctorService;
import be.ipl.pfe.dal.repositories.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper modelMapper;

}
