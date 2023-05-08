package rs.ac.uns.ftn.dan.pharmacy.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.dan.pharmacy.bean.SecondConfiguration;
import rs.ac.uns.ftn.dan.pharmacy.controller.MedicineManufacturerController;
import rs.ac.uns.ftn.dan.pharmacy.model.Manufacturer;
import rs.ac.uns.ftn.dan.pharmacy.model.Manufacturers;
import rs.ac.uns.ftn.dan.pharmacy.service.ManufacturerService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private SecondConfiguration.ApplicationMemory appMemory;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {

        appMemory = applicationContext.getBean(SecondConfiguration.ApplicationMemory.class);
        Manufacturers manufacturers = new Manufacturers();

        appMemory.put(MedicineManufacturerController.MANUFACTURERS_KEY, manufacturers);
    }

    @Override
    public List<Manufacturer> findAll() {
        Manufacturers manufacturers = (Manufacturers) appMemory.get(MedicineManufacturerController.MANUFACTURERS_KEY);
        return manufacturers.findAll();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        Manufacturers manufacturers = (Manufacturers) appMemory.get(MedicineManufacturerController.MANUFACTURERS_KEY);
        return manufacturers.save(manufacturer);
    }

    @Override
    public void edit(Manufacturer manufacturerEdited) throws IOException, URISyntaxException {
        Manufacturers manufacturers = (Manufacturers) appMemory.get(MedicineManufacturerController.MANUFACTURERS_KEY);

        Manufacturer m = manufacturers.findOne(manufacturerEdited.getCode());
        if (m != null) {
            m.setName(manufacturerEdited.getName());
            m.setCountry(manufacturerEdited.getCountry());
//            m.setCode(manufacturerEdited.getCode());
//            manufacturers.delete(m.getCode());
            manufacturers.saveToFile(m);
        }

    }

    @Override
    public void delete(Long code) throws IOException, URISyntaxException {
        Manufacturers manufacturers = (Manufacturers) appMemory.get(MedicineManufacturerController.MANUFACTURERS_KEY);

        if (manufacturers.findOne(code) != null) {
            manufacturers.delete(code);
        }
    }

    @Override
    public Manufacturer findOne(Long code) {
        Manufacturers manufacturers = (Manufacturers) appMemory.get(MedicineManufacturerController.MANUFACTURERS_KEY);

        return manufacturers.findOne(code);
    }


}
