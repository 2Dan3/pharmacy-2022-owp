package rs.ac.uns.ftn.dan.pharmacy.service;

import rs.ac.uns.ftn.dan.pharmacy.model.dto.VaccineFilterDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Vaccine;

import java.util.List;

public interface VaccineSvc {
    List<Vaccine> findAll(VaccineFilterDTO vaccineFilter);
}
