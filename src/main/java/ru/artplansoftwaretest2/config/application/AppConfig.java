package ru.artplansoftwaretest2.config.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.artplansoftwaretest2.dao.UsersDao;
import ru.artplansoftwaretest2.dao.impl.UsersDaoImpl;
import ru.artplansoftwaretest2.entity.Users;

@Configuration
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.mariadb.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.mariadb.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.mariadb.user"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.mariadb.password"));
        return dataSource;
    }

    @Bean
    public UsersDao usersDao(){
        return new UsersDaoImpl(Users.class);
    }
}
