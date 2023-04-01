package de.backery.backerydbproxyservice.impl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrdermanagementApi {
    @When("a GET request will be made against the endpoint to grab all orders")
    public void aGETRequestWillBeMadeAgainstTheEndpointToGrabAllOrders() {
    }

    @Then("it should obtain {int} orders from the database")
    public void itShouldObtainOrdersFromTheDatabase(int arg0) {
    }

    @Given("a valid order id {string}")
    public void aValidOrderId(String arg0) {
    }

    @When("a GET request will be made with an specific order id")
    public void aGETRequestWillBeMadeWithAnSpecificOrderId() {
    }

    @Then("it should return an order with the id {string}")
    public void itShouldReturnAnOrderWithTheId(String arg0) {
    }

    @Given("an order with the description {string}")
    public void anOrderWithTheDescription(String arg0) {
    }

    @When("a POST request will be made in order to create a new order")
    public void aPOSTRequestWillBeMadeInOrderToCreateANewOrder() {
    }

    @Then("it should the new order with the description {string}")
    public void itShouldTheNewOrderWithTheDescription(String arg0) {
    }

    @When("a PUT request will be made with an specific order id and providing a new description {string}")
    public void aPUTRequestWillBeMadeWithAnSpecificOrderIdAndProvidingANewDescription(String arg0) {
    }

    @Then("the existing order with the id {string} should appear with updated information")
    public void theExistingOrderWithTheIdShouldAppearWithUpdatedInformation(String arg0) {
    }

    @Then("the new order should have the new name {string}")
    public void theNewOrderShouldHaveTheNewName(String arg0) {
    }

    @When("a DELETE request will be made with an specific order id")
    public void aDELETERequestWillBeMadeWithAnSpecificOrderId() {
    }

    @Then("requesting order with id {string} should return an HTTP {int} error")
    public void requestingOrderWithIdShouldReturnAnHTTPError(String arg0, int arg1) {
    }
}
