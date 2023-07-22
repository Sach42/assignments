package io.reservation.reservation.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.reservation.reservation.domain")
@EnableJpaRepositories("io.reservation.reservation.repos")
@EnableTransactionManagement
public class DomainConfig {
}
