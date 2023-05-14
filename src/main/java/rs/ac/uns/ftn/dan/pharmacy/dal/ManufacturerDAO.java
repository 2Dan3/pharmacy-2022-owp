package rs.ac.uns.ftn.dan.pharmacy.dal;

import rs.ac.uns.ftn.dan.pharmacy.model.entity.Manufacturer;

public interface ManufacturerDAO {
    Manufacturer findOne(Long id);
}
