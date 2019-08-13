package spitter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spitter.domain.Spitter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:/application.properties")
@ComponentScan(basePackages = "spitter.dao")
@EnableTransactionManagement
public class DataConfig {

    private final Environment env;

    @Autowired
    public DataConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType("mysql");
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    // - > hibernate 配置
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("spitter.domain");
        Properties pro = new Properties();
        pro.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
        pro.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        pro.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        factoryBean.setHibernateProperties(pro);
        return factoryBean;
    }

    // -> Could not obtain transaction-synchronized Session for current thread
    @Bean
    public PlatformTransactionManager platformTransactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }
}
