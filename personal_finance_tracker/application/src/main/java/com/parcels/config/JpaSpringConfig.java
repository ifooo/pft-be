package com.parcels.config;

import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.parcels.domain")
public class JpaSpringConfig {
}
