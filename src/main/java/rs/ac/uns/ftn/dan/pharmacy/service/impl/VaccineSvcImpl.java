package rs.ac.uns.ftn.dan.pharmacy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.dan.pharmacy.dal.VaccineDAO;
import rs.ac.uns.ftn.dan.pharmacy.model.dto.VaccineFilterDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Vaccine;
import rs.ac.uns.ftn.dan.pharmacy.service.VaccineSvc;

import java.util.List;

public class VaccineSvcImpl implements VaccineSvc {

    @Autowired
    VaccineDAO vaccineDAO;

    @Override
    public List<Vaccine> findAll(VaccineFilterDTO vaccineFilter) {
        return vaccineDAO.findAll(vaccineFilter);
    }
}
