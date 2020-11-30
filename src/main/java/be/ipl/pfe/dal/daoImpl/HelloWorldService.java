package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.HelloWorldDto;
import be.ipl.pfe.dal.models.HelloWorld;
import be.ipl.pfe.dal.dao.IHelloWorldService;
import be.ipl.pfe.dal.repositories.HelloWorldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloWorldService implements IHelloWorldService {

    @Autowired
    private HelloWorldRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<HelloWorld> findAll() {
        List<HelloWorld> helloWorlds = (List<HelloWorld>) repository.findAll();
        List<HelloWorldDto> helloWorldsDto = new ArrayList<>();
        List<HelloWorld> imageList = (List<HelloWorld>) repository.findAll();
        for (HelloWorld i : imageList) {
            helloWorldsDto.add(modelMapper.map(i, HelloWorldDto.class));
        }
        return helloWorlds;
    }
}
