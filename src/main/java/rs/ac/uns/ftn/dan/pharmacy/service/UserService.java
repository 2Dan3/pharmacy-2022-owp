package rs.ac.uns.ftn.dan.pharmacy.service;

import org.springframework.context.ApplicationContextAware;
import rs.ac.uns.ftn.dan.pharmacy.model.CreateUserDTO;

import java.text.ParseException;

public interface UserService extends ApplicationContextAware {
    void save(CreateUserDTO userDTO) throws ParseException;
}
