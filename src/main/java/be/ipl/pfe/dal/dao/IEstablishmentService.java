package be.ipl.pfe.dal.dao;

import be.ipl.pfe.bizz.dto.PlaceDto;

import java.util.List;

public interface IEstablishmentService {

    PlaceDto insertPlace(PlaceDto PlaceDto);

    PlaceDto deletePlace(PlaceDto placeDto);

    List<PlaceDto> getPlacesForEstablishment(PlaceDto placeDto);
}
