package ua.ithillel.lesson39.classwork.data.access;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class DataSourceConfiguration {
    @Bean
    public DataSource postgresDataSource() {
        var ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/world");
        ds.setUsername("sa");
        ds.setPassword("");

        return ds;
    }
}
