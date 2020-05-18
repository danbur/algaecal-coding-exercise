package com.example.algaecal.teststeps;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * Base test steps class. Sets up Spring dependency injection
 */
@ContextConfiguration(locations = "classpath:spring-test-config.xml")
@TestPropertySource("classpath:test.properties")
public class BaseTestSteps {}
