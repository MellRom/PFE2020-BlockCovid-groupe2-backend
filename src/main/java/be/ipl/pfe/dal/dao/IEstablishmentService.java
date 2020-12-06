package be.ipl.pfe.dal.dao;

import be.ipl.pfe.bizz.dto.EstablishmentDto;
import be.ipl.pfe.bizz.dto.PlaceDto;


public interface IEstablishmentService {

    PlaceDto insertPlace(PlaceDto PlaceDto);

    PlaceDto deletePlace(PlaceDto placeDto);

    EstablishmentDto getPlacesForEstablishment(EstablishmentDto establishmentDto);
}
