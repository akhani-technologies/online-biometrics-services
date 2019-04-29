package za.co.sbs.akhani.biometrics.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"za.co.sbs.akhani.biometrics.domain"})
@EnableJpaRepositories(basePackages = {"za.co.sbs.akhani.biometrics.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
