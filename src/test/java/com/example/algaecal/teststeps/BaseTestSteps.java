package com.example.algaecal.teststeps;

import org.springframework.test.context.ContextConfiguration;

/**
 * Base test steps class. Sets up Spring dependency injection
 */
@ContextConfiguration(locations = "classpath:spring-test-config.xml")
public class BaseTestSteps {}
