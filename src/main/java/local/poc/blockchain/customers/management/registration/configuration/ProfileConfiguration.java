package local.poc.blockchain.customers.management.registration.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile({"local", "dev"})
@PropertySource({
    // classpath resources
    "classpath:config/registration.properties", "classpath:config/registration-${spring.profiles.active}.properties"
    // file resources
    // "file:${registration.conf.path}/registration.properties",
    // "file:${registration.conf.path}/registration-${spring.profiles.active}.properties"
})
public class ProfileConfiguration {
	
}
