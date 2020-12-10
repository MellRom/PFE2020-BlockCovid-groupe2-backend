package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.PlaceDto;
import be.ipl.pfe.bizz.dto.WebUserDto;
import be.ipl.pfe.dal.dao.IWebUserService;
import be.ipl.pfe.dal.models.Place;
import be.ipl.pfe.dal.models.WebUser;
import be.ipl.pfe.dal.repositories.PlaceRepository;
import be.ipl.pfe.dal.repositories.WebUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public WebUserDto checkConnection(WebUserDto webUserDto) {
        WebUser webUser = modelMapper.map(webUserDto, WebUser.class);
        webUser = webUserRepository.checkLogin(webUser.getLogin());
        if (webUser == null) {
            return null;
        }
        if (!passwordEncoder.matches(webUserDto.getPassword(), webUser.getPassword())) {
            return null;
        }
        webUser.setPassword("");
        webUserDto = modelMapper.map(webUser, WebUserDto.class);
        return webUserDto;
    }

    public WebUserDto insertUser(WebUserDto webUserDto) {
        WebUser webUser = modelMapper.map(webUserDto, WebUser.class);
        if (webUserRepository.checkLogin(webUser.getLogin()) != null) {
            return null;
        }
        webUser.setPassword(passwordEncoder.encode(webUser.getPassword()));
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
}
