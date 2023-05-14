package rs.ac.uns.ftn.dan.pharmacy.service;

import org.springframework.context.ApplicationContextAware;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Manufacturer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface ManufacturerService extends ApplicationContextAware {

    List<Manufacturer> findAll();

    Manufacturer save(Manufacturer manufacturer);

    void edit(Manufacturer manufacturerEdited) throws IOException, URISyntaxException;

    void delete(Long code) throws IOException, URISyntaxException;

    Manufacturer findOne(Long code);
}
