package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.WebUserDto;
import be.ipl.pfe.dal.dao.IWebUserService;
import be.ipl.pfe.dal.models.Doctor;
import be.ipl.pfe.dal.models.Establishment;
import be.ipl.pfe.dal.models.WebUser;
import be.ipl.pfe.dal.repositories.DoctorRepository;
import be.ipl.pfe.dal.repositories.EstablishmentRepository;
import be.ipl.pfe.dal.repositories.WebUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserService implements IWebUserService {

    @Autowired
    private WebUserRepository webUserRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Override
    public WebUserDto checkConnection(WebUserDto webUserDto) {
        WebUser webUser = modelMapper.map(webUserDto, WebUser.class);
        webUser = webUserRepository.checkConnexion(webUser.getLogin(), webUser.getPassword());
        webUserDto = modelMapper.map(webUser, WebUserDto.class);
        return webUserDto;
    }

    public WebUserDto insertUser(WebUserDto webUserDto) {
        WebUser webUser = modelMapper.map(webUserDto, WebUser.class);
        webUser = webUserRepository.save(webUser);
        webUserDto.setPassword("");
        webUserDto.setUser_id(webUser.getUser_id());
        if(webUserDto.getRole().equals("doctor")){
            Doctor doctor = new Doctor(webUser.getUser_id());
            doctorRepository.save(doctor);
        }else if((webUserDto.getRole().equals("establishment"))){
            Establishment establishment = new Establishment(webUser.getUser_id(), webUserDto.getAdress());
            establishmentRepository.save(establishment);
        }

        return webUserDto;
    }
}
