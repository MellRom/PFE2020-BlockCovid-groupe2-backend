package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.UserDto;
import be.ipl.pfe.dal.dao.IUserService;
import be.ipl.pfe.dal.models.Doctor;
import be.ipl.pfe.dal.models.Establishment;
import be.ipl.pfe.dal.models.User;
import be.ipl.pfe.dal.repositories.DoctorRepository;
import be.ipl.pfe.dal.repositories.EstablishmentRepository;
import be.ipl.pfe.dal.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Override
    public UserDto checkConnection(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.checkConnexion(user.getLogin(), user.getPassword());
        userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public UserDto insertUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        userDto.setPassword("");
        userDto.setId(user.getId());
        if(userDto.getRole()=="docteur"){
            Doctor doctor = new Doctor(user.getId());
            doctorRepository.save(doctor);
        }else{
            Establishment establishment = new Establishment(user.getId(), userDto.getAdress());
            establishmentRepository.save(establishment);
        }
        return userDto;
    }
}
