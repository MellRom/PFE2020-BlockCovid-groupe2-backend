package be.ipl.pfe.dal.dao;

import be.ipl.pfe.bizz.dto.UserDto;

public interface IUserService {
    UserDto checkConnection(UserDto userDto);
}
