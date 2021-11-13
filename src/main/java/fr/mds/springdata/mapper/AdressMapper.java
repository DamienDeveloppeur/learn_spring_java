package fr.mds.springdata.mapper;

import fr.mds.springdata.domain.Adress;
import fr.mds.springdata.domain.Specie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressMapper {
    String id;

    public AdressMapper() {
        this("id");
    }

    public AdressMapper(String id) {
        this.id = id;
    }

    public Adress mapRow(ResultSet rs, int rowNum) throws SQLException {
        Adress ad = new Adress(rs.getLong(id), rs.getString("code"), rs.getString("ville"), rs.getString("address"));
        return ad;
    }
}
