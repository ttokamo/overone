package by.overone.it.config;

import by.overone.it.pojo.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:ds.properties")
@ComponentScan(basePackages = {"by.overone.it"})
public class DaoConfiguration {

    @Autowired
    Environment env;

    @Bean
    public Properties dataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty("useSSL", env.getProperty("useSSL"));
        properties.setProperty("serverTimezone", env.getProperty("serverTimezone"));
        properties.setProperty("createDatabaseIfNotExist", env.getProperty("createDatabaseIfNotExist"));
        return properties;
    }

    @Bean
    public DataSource webappDataSource(Properties dataSourceProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("User.url"));
        config.setUsername(env.getProperty("User.user"));
        config.setPassword(env.getProperty("User.password"));
        config.setDriverClassName(env.getProperty("jdbc.driver"));
        config.setMaximumPoolSize(env.getProperty("User.pool_size", Integer.class));
        config.setDataSourceProperties(dataSourceProperties);
        return new HikariDataSource(config);
    }

    @Bean
    public LocalSessionFactoryBean webappSessionFactory(@Qualifier("webappDataSource") DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(properties);

        sessionFactory.setAnnotatedPackages("by.overone.it.pojo");
        sessionFactory.setAnnotatedClasses(
                User.class
        );

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager webappTransactionManager(@Qualifier("webappSessionFactory") SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }

}
