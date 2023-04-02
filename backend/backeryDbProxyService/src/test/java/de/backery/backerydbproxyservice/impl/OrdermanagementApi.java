package de.backery.backerydbproxyservice.impl;

import de.backery.backerydbproxyservice.common.CommonTestBase;
import de.backery.backerydbproxyservice.to.OrderTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OrdermanagementApi extends CommonTestBase {

    @Autowired
    protected TestRestTemplate restTemplate;
    private String validOrderId;
    private List<OrderTo> allOrders = new ArrayList<>();
    private OrderTo mockOrder;
    private OrderTo resultOrder;

    @When("a GET request will be made against the endpoint to grab all orders")
    public void aGETRequestWillBeMadeAgainstTheEndpointToGrabAllOrders() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .pathSegment("orders")
                .toUriString();
        allOrders = restTemplate.getForEntity(url, List.class).getBody();
    }

    @Then("it should obtain {int} orders from the database")
    public void itShouldObtainOrdersFromTheDatabase(int numberOfExpectedOrders) {
        assertThat(allOrders.size(), equalTo(numberOfExpectedOrders));
    }

    @Given("a valid order id {string}")
    public void aValidOrderId(String orderId) {
        validOrderId = orderId;
    }

    @When("a GET request will be made with an specific order id")
    public void aGETRequestWillBeMadeWithAnSpecificOrderId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("/orders/")
                .pathSegment(validOrderId)
                .toUriString();
        resultOrder = restTemplate.getForEntity(url, OrderTo.class).getBody();
    }

    @Then("it should return an order with the id {string}")
    public void itShouldReturnAnOrderWithTheId(String validOrderId) {
        assertThat(resultOrder.getOrderId(), equalTo(validOrderId));
    }

    @Given("an order with the description {string}")
    public void anOrderWithTheDescription(String description) {
        mockOrder = OrderTo
                .builder()
                .description(description)
                .build();
    }

    @When("a POST request will be made in order to create a new order")
    public void aPOSTRequestWillBeMadeInOrderToCreateANewOrder() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("orders")
                .toUriString();
        resultOrder = restTemplate.postForObject(url, mockOrder, OrderTo.class);
    }

    @Then("it should the new order with the description {string}")
    public void itShouldTheNewOrderWithTheDescription(String description) {
        assertThat(mockOrder.getDescription(), equalTo(description));
    }

    @When("a PUT request will be made with an specific order id and providing a new description {string}")
    public void aPUTRequestWillBeMadeWithAnSpecificOrderIdAndProvidingANewDescription(String newDescription) {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("orders")
                .pathSegment(validOrderId)
                .toUriString();
        mockOrder = OrderTo
                .builder()
                .description(newDescription)
                .build();
        restTemplate.put(url, mockOrder);
    }

    @Then("the existing order with the id {string} should appear with updated information")
    public void theExistingOrderWithTheIdShouldAppearWithUpdatedInformation(String arg0) {
    }

    @Then("the new order should have the new name {string}")
    public void theNewOrderShouldHaveTheNewName(String arg0) {
    }

    @When("a DELETE request will be made with an specific order id")
    public void aDELETERequestWillBeMadeWithAnSpecificOrderId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("orders")
                .pathSegment(validOrderId)
                .toUriString();
        restTemplate.delete(url);
    }

    @Then("requesting order with id {string} should return an HTTP {int} error")
    public void requestingOrderWithIdShouldReturnAnHTTPError(String arg0, int arg1) {
    }
}
