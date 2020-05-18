package com.example.algaecal.teststeps;

import com.example.algaecal.data.cucumber.BundleItem;
import com.example.algaecal.data.rest.model.Product;
import com.example.algaecal.data.rest.model.ProductBundle;
import com.example.algaecal.data.rest.model.ProductIdAndQuantity;
import com.example.algaecal.rest.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Test steps related to the product API
 */
public class ProductApiTestSteps extends BaseTestSteps {
    @Autowired
    private ProductClient productClient;

    public void createOrUpdateBundle(String bundleName, BigDecimal discountPrice, List<BundleItem> bundleItems) {
        // I am assuming the product API is a REST API.
        // These are fake endpoints, as I do not know what the API looks like
        List<ProductIdAndQuantity> productsIdsAndQuantities = new ArrayList<>();
        bundleItems.forEach(item -> {
            Product product = new Product();
            product.setName(item.getProductName());
            product.setPrice(item.getPriceInDollars());
            Product result = productClient.createOrUpdateProduct(product);
            ProductIdAndQuantity productIdAndQuantity = new ProductIdAndQuantity();
            productIdAndQuantity.setProductId(result.getId());
            productIdAndQuantity.setQuantity(item.getQuantity());
            productsIdsAndQuantities.add(productIdAndQuantity);
        });
        ProductBundle bundle = new ProductBundle();
        bundle.setName(bundleName);
        bundle.setId(bundleName.replace(" ", "-"));
        bundle.setDiscount(discountPrice);
        bundle.setItems(productsIdsAndQuantities);
        productClient.createOrUpdateBundle(bundle);
    }
}
