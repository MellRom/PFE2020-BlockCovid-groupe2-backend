package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.PlaceDto;
import be.ipl.pfe.dal.dao.IEstablishmentService;
import be.ipl.pfe.dal.models.Place;
import be.ipl.pfe.dal.repositories.EstablishmentRepository;
import be.ipl.pfe.dal.repositories.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstablishmentService implements IEstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PlaceDto insertPlace(PlaceDto placeDto) {
        Place place = modelMapper.map(placeDto, Place.class);
        placeRepository.save(place);
        return placeDto;
    }

    @Override
    public PlaceDto deletePlace(PlaceDto placeDto) {
        Place place = modelMapper.map(placeDto, Place.class);
        placeRepository.deleteById(place.getPlace_id());
        return placeDto;
    }

    @Override
    public List<PlaceDto> getPlacesForEstablishment(PlaceDto placeDto) {
        List<Place> places = placeRepository.getPlacesForEstablishment(placeDto.getId_establishment());
        List<PlaceDto> placeDtos = new ArrayList<>();
        for (Place p : places) {
            placeDtos.add(modelMapper.map(p, PlaceDto.class));
        }
        return placeDtos;
    }
}
