package App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JpaConfig {

    @Bean
    public LocalEntityManagerFactoryBean createEMF() {
        LocalEntityManagerFactoryBean emfBean = new LocalEntityManagerFactoryBean();
        emfBean.setPersistenceUnitName("jpa-spring");
        return emfBean;
    }
}
