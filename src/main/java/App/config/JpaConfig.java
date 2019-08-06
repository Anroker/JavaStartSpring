package App.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter, DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();

        emfBean.setPersistenceUnitName("jpa-spring");
        emfBean.setDataSource(dataSource);
        emfBean.setJpaVendorAdapter(adapter);
        emfBean.setPackagesToScan("App/model");
        return emfBean;
    }

    @Bean
    public JpaVendorAdapter createVendorAdapter() {

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource source = new BasicDataSource();
        source.setUrl("jdbc:mysql://localhost:3306/jpaapp?useSSL=false&serverTimezone=UTC");
        source.setUsername("root");
        source.setPassword("root");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setInitialSize(2);
        return source;
    }
}
