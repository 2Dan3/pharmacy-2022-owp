package rs.ac.uns.ftn.dan.pharmacy.dal;

import rs.ac.uns.ftn.dan.pharmacy.model.dto.VaccineFilterDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Vaccine;

import java.util.List;

public interface VaccineDAO {
    List<Vaccine> findAll(VaccineFilterDTO vaccineFilter);
}
