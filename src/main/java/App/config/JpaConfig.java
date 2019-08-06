package App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {

        LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();

        Map<String,String > prop = new HashMap<>();
        prop.put("javax.persistence.jdbc.url","jdbc:mysql://localhost:3306/jpaapp?useSSL=false&serverTimezone=UTC");
        prop.put("javax.persistence.jdbc.user", "root");
        prop.put("javax.persistence.jdbc.password", "root");
        prop.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        prop.put("javax.persistence.schema-generation.database.action", "drop-and-create");

        emfBean.setPersistenceUnitName("jpa-spring");
        emfBean.setJpaPropertyMap(prop);
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
}
