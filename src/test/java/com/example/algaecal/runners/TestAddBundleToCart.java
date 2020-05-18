package com.example.algaecal.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/** Test runner for the add bundle to cart test */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.algaecal",
    tags = "@AddBundleToCart")
public class TestAddBundleToCart {}
