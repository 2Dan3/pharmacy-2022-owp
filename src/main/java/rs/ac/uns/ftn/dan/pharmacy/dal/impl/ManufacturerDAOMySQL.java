package rs.ac.uns.ftn.dan.pharmacy.dal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.dan.pharmacy.dal.ManufacturerDAO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ManufacturerDAOMySQL implements ManufacturerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private class ManufacturerRowMapper implements RowMapper<Manufacturer> {

        @Override
        public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
            int index = 1;
            Long id = rs.getLong(index++);
            String name = rs.getString(index++);
            String country = rs.getString(index++);

            Manufacturer manufacturer = new Manufacturer(id, name, country);
            return manufacturer;
        }

    }

    @Override
    public Manufacturer findOne(Long id) {
        try {
            String query = "SELECT id, name, country FROM manufacturers WHERE id = ?";
            return jdbcTemplate.queryForObject(query, new ManufacturerRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            // in case manufacturer not found
            return null;
        }
    }
}
