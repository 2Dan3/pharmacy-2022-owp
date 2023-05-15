package rs.ac.uns.ftn.dan.pharmacy.dal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.dan.pharmacy.dal.UserDAO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.User;

import org.springframework.jdbc.core.RowMapper;
import rs.ac.uns.ftn.dan.pharmacy.model.enums.Role;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class UserDAOMySQL implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            int index = 1;
            Long id = rs.getLong(index++);
            String jmbg = rs.getString(index++);
            String password = rs.getString(index++);
            String email = rs.getString(index++);
            String name = rs.getString(index++);
            String surname = rs.getString(index++);
            Date dateOfBirth = rs.getDate(index++);
            String address = rs.getString(index++);
            String phoneNum = rs.getString(index++);
            Timestamp registrationTimestamp = rs.getTimestamp(index++);
            Role role = Role.valueOf(rs.getString(index++));

            User user = new User(id, jmbg, password, email, name, surname, dateOfBirth, address, phoneNum, registrationTimestamp, role);
            return user;
        }
    }

    @Override
    public User findOne(String jmbg) {
        try {
            String query = "SELECT id, jmbg, password, email, name, surname, birth_date, address, phone, reg_timestamp, role FROM users WHERE jmbg = ?";
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), jmbg);
        } catch (EmptyResultDataAccessException ex) {
            // in case user not found
            return null;
        }
    }

    @Override
    public User findOne(Long id) {
        try {
            String query = "SELECT id, jmbg, password, email, name, surname, birth_date, address, phone, reg_timestamp, role FROM users WHERE id = ?";
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            // in case user not found
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            String query = "SELECT id, jmbg, password, email, name, surname, birth_date, address, phone, reg_timestamp, role FROM users WHERE email = ?";
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), email);
        } catch (EmptyResultDataAccessException ex) {
            // in case user not found
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT id, jmbg, password, email, name, surname, birth_date, address, phone, reg_timestamp, role FROM users";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    @Override
    public int save(User u) {
        String query = "INSERT INTO users (jmbg, password, email, name, surname, address, birth_date, phone, reg_timestamp, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, u.getJmbg(), u.getPassword(), u.getEmail(), u.getName(), u.getSurname(), u.getAddress(), u.getDateOfBirth(), u.getPhoneNum(), u.getRegistrationTimestamp(), u.getRole());
    }

    @Override
    public int update(User u) {
        String sql = "UPDATE users SET password, email, name, surname, address, birth_date, phone WHERE id = ?";
        return jdbcTemplate.update(sql, u.getPassword(), u.getEmail(), u.getName(), u.getSurname(), u.getAddress(), u.getDateOfBirth(), u.getPhoneNum(), u.getId());
    }

    @Override
    public int delete(Long id) {
        String query = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

}
