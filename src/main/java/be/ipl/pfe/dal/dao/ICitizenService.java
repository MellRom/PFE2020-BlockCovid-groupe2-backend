package be.ipl.pfe.dal.dao;

import be.ipl.pfe.bizz.dto.CitizenDto;
import be.ipl.pfe.bizz.dto.VisitDto;

public interface ICitizenService {

    CitizenDto inscription();

    VisitDto visit(VisitDto visitDto);

    CitizenDto positiveCovid(CitizenDto citizenDto);
}
