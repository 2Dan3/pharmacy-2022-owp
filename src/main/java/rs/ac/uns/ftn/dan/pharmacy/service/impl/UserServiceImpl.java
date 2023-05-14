package rs.ac.uns.ftn.dan.pharmacy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.dan.pharmacy.dal.UserDAO;
import rs.ac.uns.ftn.dan.pharmacy.model.CreateUserDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.User;
import rs.ac.uns.ftn.dan.pharmacy.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findOne(String jmbg) {
        return userDAO.findOne(jmbg);
    }

    @Override
    public User findOne(Long id) {
        return userDAO.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public int save(CreateUserDTO userDTO) {
        User newUser = new User(userDTO);
        return userDAO.save(newUser);
    }

    @Override
    public int update(User existingUser) {
        return userDAO.update(existingUser);
    }

    @Override
    public int delete(Long id) {
        return userDAO.delete(id);
    }
}
