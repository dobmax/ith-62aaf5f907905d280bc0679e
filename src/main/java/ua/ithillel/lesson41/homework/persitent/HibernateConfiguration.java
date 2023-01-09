package ua.ithillel.lesson41.homework.persitent;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

public class HibernateConfiguration {
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("ua.ithillel.lesson41.homework.persistent.entity");
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        var props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.highlight_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return props;
    }

    @Bean
    public DataSource dataSource() {
        var ds = new SimpleDriverDataSource();
        ds.setDriverClass(Driver.class);
        ds.setUrl("jdbc:postgresql://localhost:5432/academy");
        ds.setUsername("sa");
        ds.setPassword("");

        return ds;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(LocalSessionFactoryBean sessionFactory) {
        var txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory.getObject());
        return txManager;
    }
}
