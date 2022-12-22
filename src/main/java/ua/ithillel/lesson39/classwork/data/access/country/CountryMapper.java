package ua.ithillel.lesson39.classwork.data.access.country;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import ua.ithillel.lesson39.classwork.entity.Country;
import ua.ithillel.lesson39.classwork.entity.Mainland;

import java.sql.ResultSet;

public class CountryMapper implements RowMapper<Country> {
    @SneakyThrows
    @Override
    public Country mapRow(ResultSet rs, int rowNum) {
        var mainland = new Mainland();
        mainland.setId(rs.getLong("mainland_id"));
        mainland.setName(rs.getString("mainland_name"));

        var country = new Country();
        country.setName(rs.getString("name"));
        country.setId(rs.getLong("id"));
        country.setMainland(mainland);

        return country;
    }
}
