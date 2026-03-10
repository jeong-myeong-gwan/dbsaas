package mj.dbsaas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.filter.ForwardedHeaderFilter;



@Configuration
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource(
        value = "classpath:application-${spring.profiles.active}.properties",
        ignoreResourceNotFound = true
    )
})
public class AppConfig {

      
    
}
