package com.example.algaecal.rest.client;

import com.example.algaecal.data.rest.model.Product;
import com.example.algaecal.data.rest.model.ProductBundle;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Client for the product service. This abstracts all of the interactions, so the test steps do not
 * need to worry about the details.
 *
 * <p>Here I am assuming that the product service has a couple of endpoints to create or replace
 * products and product bundles, and that it uses HTTP Basic access authentication.
 */
@Service
@Slf4j
public class ProductClient {
  private static final String PRODUCT_BY_ID_ENDPOINT = "/product/{id}";
  private static final String BUNDLE_BY_ID_ENDPOINT = "/bundle/{id}";

  @Value("${services.baseUri}")
  private String baseUri;

  @Value("${services.username}")
  private String username;

  @Value("${services.password}")
  private String password;

  /**
   * Create or update a product
   *
   * @param product Product
   */
  public Product createOrUpdateProduct(Product product) {
    log.info("BaseUri: {}", baseUri);
    log.info("Creating product: {}", product);
    // Here I am assuming there is PUT endpoint with an ID in the URL that takes a payload with the
    // following structure:
    // {
    //   "price" : "33.99",
    //   "id" : "ecedfdab-9c54-4ed9-b513-a767242e9536",
    //   "name" : "AlgaeCal Plus"
    // }
    return SerenityRest.given()
        .baseUri(baseUri)
        .auth()
        .basic(username, password)
        .body(product)
        .pathParam("id", product.getId())
        .put(PRODUCT_BY_ID_ENDPOINT)
        .then()
        .statusCode(either(equalTo(HttpStatus.SC_OK)).or(equalTo(HttpStatus.SC_CREATED)))
        .extract()
        .body()
        .as(Product.class);
  }

  /**
   * Create or update a product bundle
   *
   * @param productBundle Product bundle
   */
  public ProductBundle createOrUpdateBundle(ProductBundle productBundle) {
    log.info("Creating bundle: {}", productBundle);
    // Here I am assuming there is PUT endpoint with an ID in the URL that takes a payload with the
    // following structure:
    // {
    //   "items" : [
    //      {
    //         "productId" : "bae4f411-e4ae-4c7a-b9ec-43e081e37539",
    //         "quantity" : 6
    //      },
    //      {
    //         "quantity" : 6,
    //         "productId" : "3b710613-445f-4bff-befd-96b974ffa7e5"
    //      }
    //   ],
    //   "discountPrice" : "100.28",
    //   "name" : "12 Month Supply",
    //   "id" : "12-Month-Supply"
    // }
    return SerenityRest.given()
        .baseUri(baseUri)
        .auth()
        .basic(username, password)
        .body(productBundle)
        .pathParam("id", productBundle.getId())
        .put(BUNDLE_BY_ID_ENDPOINT)
        .then()
        .statusCode(either(equalTo(HttpStatus.SC_OK)).or(equalTo(HttpStatus.SC_CREATED)))
        .extract()
        .body()
        .as(ProductBundle.class);
  }
}
