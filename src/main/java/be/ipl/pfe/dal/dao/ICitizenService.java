package be.ipl.pfe.dal.dao;

import be.ipl.pfe.bizz.dto.CitizenDto;
import be.ipl.pfe.bizz.dto.VisitDto;

import java.util.Set;

public interface ICitizenService {

    CitizenDto inscription();

    VisitDto visit(VisitDto visitDto);

    Set<String> positiveCovid(CitizenDto citizenDto);
}
