package com.example.algaecal.teststeps;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * Base test steps class. Sets up Spring dependency injection
 */
@ContextConfiguration(locations = "classpath:spring-test-config.xml")
@EnableConfigurationProperties
@TestPropertySource("classpath:test.properties")
public class BaseTestSteps {}
