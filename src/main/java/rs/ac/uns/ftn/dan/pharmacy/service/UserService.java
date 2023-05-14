package rs.ac.uns.ftn.dan.pharmacy.service;

import rs.ac.uns.ftn.dan.pharmacy.model.dto.CreateUserDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.User;

import java.util.List;

public interface UserService{
    User findOne(String jmbg);
    User findOne(Long id);
    List<User> findAll();
    int save(CreateUserDTO userDTO);
    int update(User existingUser);
    int delete(Long id);

    User findByEmail(String email);
}
