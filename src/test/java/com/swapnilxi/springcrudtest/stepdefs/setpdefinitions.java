package com.swapnilxi.springcrudtest.stepdefs;


import com.swapnilxi.springcrudtest.SpringcrudtestApplication;
import com.swapnilxi.springcrudtest.entity.Product;
import com.swapnilxi.springcrudtest.repository.ProductRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Caption: Step Definitions for Product feature

@CucumberContextConfiguration
@SpringBootTest(classes = SpringcrudtestApplication.class)
public class setpdefinitions {

    @Autowired
    private ProductRepository productRepository;

    private Product product;
    private int initialProductCount;

    @Given("the user has opened the product creation page")
    public void openProductCreationPage() {
        // Additional setup for opening the product creation page goes here
        initialProductCount= productRepository.findAll().size();
    }

    @When("the user enters product details")
    public void enterProductDetails() {
        product= new Product();
        product.setName("dummy");
        product.setQuantity(10);
        product.setPrice(9.99);
    }

    @When("clicks on the save button")
    public void clickSaveButton() {
        productRepository.save(product);
    }

    @Then("the product should be created successfully")
    public void verifyProductCreation() {
        assertNotNull(product.getId());
        //assertequals(expectedValue, actual)
        assertEquals(initialProductCount+1,productRepository.findAll().size());
    }
}
