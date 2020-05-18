package com.example.algaecal.teststeps;

import com.example.algaecal.data.cucumber.BundleItem;
import com.example.algaecal.rest.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Test steps related to the product API
 */
public class ProductApiTestSteps extends BaseTestSteps {
    @Autowired
    private ProductClient productClient;

    public void createOrUpdateBundle(String bundleName, int discountPrice, List<BundleItem> bundleItems) {
        // I am assuming the product API is a REST API.
        // This is a fake endpoint, as I do not know what the API looks like
        productClient.createBundle(bundleName);
    }
}
