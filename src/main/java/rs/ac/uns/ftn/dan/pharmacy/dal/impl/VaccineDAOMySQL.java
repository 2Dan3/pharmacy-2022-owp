package rs.ac.uns.ftn.dan.pharmacy.dal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.dan.pharmacy.dal.ManufacturerDAO;
import rs.ac.uns.ftn.dan.pharmacy.dal.VaccineDAO;
import rs.ac.uns.ftn.dan.pharmacy.model.dto.VaccineFilterDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Manufacturer;
import rs.ac.uns.ftn.dan.pharmacy.model.entity.Vaccine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VaccineDAOMySQL implements VaccineDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ManufacturerDAO manufacturerDAO;

    private class VaccineRowMapper implements RowMapper<Vaccine> {

        @Override
        public Vaccine mapRow(ResultSet rs, int rowNum) throws SQLException {
            int index = 1;
            Long id = rs.getLong(index++);
            String name = rs.getString(index++);
            Integer amountAvailable = rs.getInt(index++);

            Long manufacturerId = rs.getLong(index++);
            Manufacturer maker = manufacturerDAO.findOne(manufacturerId);

            Vaccine vaccine = new Vaccine(id, name, amountAvailable, maker);
            return vaccine;
        }
    }

    //        TODO check isBlank() method behavior, for runtime errors
    @Override
    public List<Vaccine> findAll(VaccineFilterDTO vaccineFilter) {

        List<Object> args = new ArrayList<Object>();

        String query = "SELECT v.id, v.name, v.amount_available, v.manufacturer_id, m.id FROM vaccines v, manufacturers m ";

        StringBuffer whereCondition = new StringBuffer(" WHERE v.manufacturer_id = m.id ");
        boolean imaArgumenata = false;

        if(vaccineFilter.getVaccineName() != null && !vaccineFilter.getVaccineName().isBlank()) {
            String vaccineName = "%" + vaccineFilter.getVaccineName() + "%";
            if(imaArgumenata)
                whereCondition.append(" AND ");
            whereCondition.append("v.name LIKE ?");
            imaArgumenata = true;
            args.add(vaccineName);
        }

        if(vaccineFilter.getMakerName() != null && !vaccineFilter.getMakerName().isBlank()) {
            String makerName = "%" + vaccineFilter.getMakerName() + "%";
            if(imaArgumenata)
                whereCondition.append(" AND ");
            whereCondition.append("m.name LIKE ?");
            imaArgumenata = true;
            args.add(makerName);
        }

        if(vaccineFilter.getCountry() != null && !vaccineFilter.getCountry().isBlank()) {
            String country = "%" + vaccineFilter.getCountry() + "%";
            if(imaArgumenata)
                whereCondition.append(" AND ");
            whereCondition.append("m.country LIKE ?");
            imaArgumenata = true;
            args.add(country);
        }

        if(vaccineFilter.getAmountMin() != null && vaccineFilter.getAmountMin() != 0) {
            if(imaArgumenata)
                whereCondition.append(" AND ");
            whereCondition.append("v.amount_min >= ?");
            imaArgumenata = true;
            args.add(vaccineFilter.getAmountMin());
        }

        if(vaccineFilter.getAmountMax() != null) {
            if(imaArgumenata)
                whereCondition.append(" AND ");
            whereCondition.append("v.amount_max <= ?");
            imaArgumenata = true;
            args.add(vaccineFilter.getAmountMax());
        }


        if(imaArgumenata)
            query += whereCondition.toString();
        query += " ORDER BY v.name";

        System.out.println(query);

        return jdbcTemplate.query(query, args.toArray(), new VaccineRowMapper());
    }
}
