package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.PlaceDto;
import be.ipl.pfe.bizz.dto.WebUserDto;
import be.ipl.pfe.dal.dao.IWebUserService;
import be.ipl.pfe.dal.models.Place;
import be.ipl.pfe.dal.models.WebUser;
import be.ipl.pfe.dal.repositories.PlaceRepository;
import be.ipl.pfe.dal.repositories.WebUserRepository;
//import org.mindrot.bcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebUserService implements IWebUserService {

    @Autowired
    private WebUserRepository webUserRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public WebUserDto checkConnection(WebUserDto webUserDto) {
        WebUser webUser = modelMapper.map(webUserDto, WebUser.class);
        webUser = webUserRepository.checkConnexion(webUser.getLogin(), webUser.getPassword());
        /*if(!BCrypt.checkpw(webUserDto.getPassword(), webUser.getPassword())){
            return null;
        }*/
        if(webUser == null){
            return null;
        }
        webUserDto = modelMapper.map(webUser, WebUserDto.class);
        return webUserDto;
    }

    public WebUserDto insertUser(WebUserDto webUserDto) {
        WebUser webUser = modelMapper.map(webUserDto, WebUser.class);
        if(webUserRepository.checkLogin(webUser.getLogin()) != null){
            return null;
        }
        /*if(!hashPassword(webUser)){
            return null;
        }*/

        webUser = webUserRepository.save(webUser);
        webUserDto.setPassword("");
        webUserDto.setUser_id(webUser.getUser_id());
        return webUserDto;
    }

    //Establishment

    @Override
    public PlaceDto insertPlace(PlaceDto placeDto) {
        Place place = modelMapper.map(placeDto, Place.class);
        placeRepository.save(place);
        return placeDto;
    }


    @Override
    public WebUserDto getPlacesForEstablishment(WebUserDto webUserDto) {
        Optional<WebUser> webUser = webUserRepository.findById(webUserDto.getUser_id());
        webUserDto = modelMapper.map(webUser.get(), WebUserDto.class);
        return webUserDto;
    }

    /*private boolean hashPassword(WebUser webUser) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(webUser.getPassword(), salt);
        if (hashedPassword.equals(webUser.getPassword())){
            throw new IllegalArgumentException("probleme hashing");
        }
        webUser.setPassword(hashedPassword);
        System.out.println("WebUserDtoPassword: " + webUser.getPassword());
        return true;
    }*/
}
