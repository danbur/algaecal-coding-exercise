# AlgaeCal QA Exercise

This is my implementation of the functional test for the Add cart button for bundles.  I chose to implement my solution
in Java with the Serenity framework, which is a nice wrapper around the WebDriver UI automation framework, and the
Rest Assured REST services testing framework.  I did not know what the UI or back-end services would look like, so I
made some basic assumptions and created a fake REST client and page objects.  I also chose to write my test in the
Cucumber BDD language, which is supported by Serenity.  I am using Lombok, which eliminates a lot of boilerplate code
for data classes, such as getters, setters, and comparison methods.  I am also using Spring for dependency injection
and configuration management. 

The functional test can be found in the file `AddBundleToCart.feature`.

The way Serenity tests are structured is with two layers.  The Step Definitions layer transforms the text of Cucumber
steps into Java code and does any data transformation needed.  This is in turn calls the Test Steps layer, which
actually implements individual test actions.  There are also page objects, and I created a client for the product
service, which is another separate piece.  (Here I assumed the test itself would need to create back-end data with the
product service, but this might not be the case in real life.  I might have separate script create static data before
any of the UI tests run.)

## Running Tests

To run the test, use the following command:

`gradlew test --tests TestAddBundleToCart`

These tests run on Firefox by default. You will need to set the path to GeckoDriver in `serenity.properties`.

## Log Output

Log output will go into the file `target/site/serenity/test.log`