package be.ipl.pfe.dal.daoImpl;

import be.ipl.pfe.bizz.dto.CitizenDto;
import be.ipl.pfe.bizz.dto.VisitDto;
import be.ipl.pfe.dal.dao.ICitizenService;
import be.ipl.pfe.dal.models.Citizen;
import be.ipl.pfe.dal.models.QrCodeCovid;
import be.ipl.pfe.dal.models.Visit;
import be.ipl.pfe.dal.repositories.CitizenRepository;
import be.ipl.pfe.dal.repositories.QrCodeCovidRepository;
import be.ipl.pfe.dal.repositories.VisitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@ConfigurationProperties(prefix = "constant")
@Service
public class CitizenService implements ICitizenService {

    //constant in file application.properties
    @Value("${constant.interval}")
    private int INTERVAL;
    @Value("${constant.message_covid}")
    private String MESSAGE_COVID;

    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private QrCodeCovidRepository qrCodeCovidRepository;

    @Override
    public CitizenDto inscription() {
        Citizen citizen = new Citizen();
        citizen.setCitizen_id(UUID.randomUUID().toString());
        while (citizenRepository.checkId(citizen.getCitizen_id()) != null) {
            citizen.setCitizen_id(UUID.randomUUID().toString());
        }
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
    public Set<String> positiveCovid(CitizenDto citizenDto) {
        Optional<Citizen> citizen1 = citizenRepository.findById(citizenDto.getCitizen_id());
        if (qrCodeCovidRepository.findById(citizenDto.getId_qrcode()).isPresent()) {
            return null;
        }
        QrCodeCovid qrCodeCovid = new QrCodeCovid(citizenDto.getId_qrcode());
        qrCodeCovidRepository.save(qrCodeCovid);
        Citizen cit = citizen1.get();
        Set<String> citizenSet = new HashSet<>();
        Citizen citizen = modelMapper.map(citizenDto, Citizen.class);
        cit.getVisits()
                .forEach(v -> {
                    visitRepository
                            .selectContactCitizen(v.getCitizen().getCitizen_id(), v.getPlace().getPlace_id(), Timestamp.valueOf(v.getEntrance_date().toLocalDateTime().minus(INTERVAL, ChronoUnit.MINUTES)), Timestamp.valueOf(v.getEntrance_date().toLocalDateTime().plus(INTERVAL, ChronoUnit.MINUTES)), Timestamp.valueOf(citizen.getSick_since().toLocalDateTime().minus(10, ChronoUnit.DAYS)))
                            .forEach(c -> citizenSet.add(c.getCitizen_id()));
                });
        citizenSet.forEach(s -> {
            simpMessagingTemplate.convertAndSendToUser(s, "/covid/notification", MESSAGE_COVID);
        });
        citizenRepository.save(citizen);
        return citizenSet;
    }
}