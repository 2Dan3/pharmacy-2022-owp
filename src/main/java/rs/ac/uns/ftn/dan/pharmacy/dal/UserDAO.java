package rs.ac.uns.ftn.dan.pharmacy.dal;

import rs.ac.uns.ftn.dan.pharmacy.model.entity.User;

import java.util.List;

public interface UserDAO {
    User findOne(String jmbg);
    User findOne(Long id);
    List<User> findAll();
    int save(User newUser);
    int update(User existingUser);
    int delete(Long id);

    User findByEmail(String email);
}
