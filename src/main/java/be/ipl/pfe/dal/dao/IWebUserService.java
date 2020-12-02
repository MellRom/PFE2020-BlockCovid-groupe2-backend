package be.ipl.pfe.dal.dao;

import be.ipl.pfe.bizz.dto.WebUserDto;

public interface IWebUserService {
    WebUserDto checkConnection(WebUserDto webUserDto);

    WebUserDto insertUser(WebUserDto webUserDto);
}
