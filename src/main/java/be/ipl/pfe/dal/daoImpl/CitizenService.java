package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.CitizenDto;
import be.ipl.pfe.bizz.dto.VisitDto;
import be.ipl.pfe.dal.dao.ICitizenService;
import be.ipl.pfe.dal.models.Citizen;
import be.ipl.pfe.dal.models.Visit;
import be.ipl.pfe.dal.repositories.CitizenRepository;
import be.ipl.pfe.dal.repositories.VisitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Service
public class CitizenService implements ICitizenService {

    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CitizenDto inscription() {
        Citizen citizen = new Citizen();
        citizen = citizenRepository.save(citizen);
        CitizenDto citizenDto = modelMapper.map(citizen, CitizenDto.class);
        return citizenDto;
    }

    @Override
    public VisitDto visit(VisitDto visitDto) {
        Visit visit = modelMapper.map(visitDto, Visit.class);
        visit.setEntrance_date(Timestamp.valueOf(LocalDateTime.now()));
        visit = visitRepository.save(visit);
        visitDto = modelMapper.map(visit, VisitDto.class);
        return visitDto;
    }

    @Override
    public CitizenDto positiveCovid(CitizenDto citizenDto) {
        Citizen citizen = modelMapper.map(citizenDto, Citizen.class);
        citizen.setSick_since(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println("coucou");
        citizen = citizenRepository.save(citizen);
        citizenDto = modelMapper.map(citizen, CitizenDto.class);
        return citizenDto;
    }
}