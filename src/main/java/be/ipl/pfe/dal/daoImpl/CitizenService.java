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
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


@Service
public class CitizenService implements ICitizenService {

    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public CitizenDto inscription() {
        Citizen citizen = new Citizen();
        //citizen.setCitizen_id(UUID.randomUUID().toString());
        citizen = citizenRepository.save(citizen);
        CitizenDto citizenDto = modelMapper.map(citizen, CitizenDto.class);
        return citizenDto;
    }

    @Override
    public VisitDto visit(VisitDto visitDto) {
        Visit visit = modelMapper.map(visitDto, Visit.class);
        visit = visitRepository.save(visit);
        visitDto = modelMapper.map(visit, VisitDto.class);
        return visitDto;
    }

    @Override
    public Set<Citizen> positiveCovid(CitizenDto citizenDto) {
        Optional<Citizen> citizen1 = citizenRepository.findById(citizenDto.getCitizen_id());
        Citizen cit = citizen1.get();
        Set<Citizen> citizenSet = new HashSet<>();
        cit.getVisits()
                .forEach(v -> visitRepository
                        .selectContactCitizen(v.getCitizen().getCitizen_id(), v.getPlace().getPlace_id(),Timestamp.valueOf(v.getEntrance_date().toLocalDateTime().minus(1,ChronoUnit.HOURS)), Timestamp.valueOf(v.getEntrance_date().toLocalDateTime().plus(1,ChronoUnit.HOURS)))
                            .forEach(c -> citizenSet.add(c)));
        citizenSet.forEach(s -> System.out.println(s.getCitizen_id()));
        citizenSet.forEach(s -> template.convertAndSend("/socket/"+String.valueOf(s.getCitizen_id()), "Vous avez été récemment en contact avec une personne malade"));
        Citizen citizen = modelMapper.map(citizenDto, Citizen.class);
        citizenRepository.save(citizen);
        return citizenSet;
    }
}