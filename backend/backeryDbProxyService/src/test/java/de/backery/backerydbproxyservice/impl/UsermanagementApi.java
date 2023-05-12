package de.backery.backerydbproxyservice.impl;

import de.backery.backerydbproxyservice.common.CommonTestBase;
import de.backery.backerydbproxyservice.to.UserTo;
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

public class UsermanagementApi extends CommonTestBase {

    @Autowired
    protected TestRestTemplate restTemplate;
    private String validUserId;
    private List<UserTo> allUsers = new ArrayList<>();
    private UserTo mockUser;
    private UserTo resultUser;

    @When("a GET request will be made against the endpoint to grab all users")
    public void aGETRequestWillBeMadeAgainstTheEndpointToGrabAllUsers() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .pathSegment("users")
                .toUriString();
        allUsers = restTemplate.getForEntity(url, List.class).getBody();
    }

    @Then("it should obtain {int} users from the database")
    public void itShouldObtainUsersFromTheDatabase(int numberOfExpectedUsers) {
        assertThat(allUsers.size(), equalTo(numberOfExpectedUsers));
    }

    @Given("a valid user id {string}")
    public void aValidUserId(String someUserId) {
        validUserId = someUserId;
    }

    @When("a GET request will be made with an specific user id")
    public void aGETRequestWillBeMadeWithAnSpecificUserId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("/users/")
                .pathSegment(validUserId)
                .toUriString();
        resultUser = restTemplate.getForEntity(url, UserTo.class).getBody();
    }

    @Then("it should return an user with the id {string}")
    public void itShouldReturnAnUserWithTheId(String userId) {
        assertThat(resultUser.getUserId(), equalTo(userId));
    }

    @Given("a username {string} with the password {string}")
    public void aUsernameWithThePassword(String username, String password) {
        mockUser = UserTo
                .builder()
                .username(username)
                .password(password)
                .build();
    }

    @When("a POST request will be made in user to create a new user")
    public void aPOSTRequestWillBeMadeInUserToCreateANewUser() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("users")
                .toUriString();
        resultUser = restTemplate.postForObject(url, mockUser, UserTo.class);
    }

    @Then("it should the new user with the username {string}")
    public void itShouldTheNewUserWithTheUsername(String username) {
        assertThat(mockUser.getUsername(), equalTo(username));
    }

    @Then("the hashed password should be equivalent to {string}")
    public void theHashedPasswordShouldBeEquivalentTo(String arg0) {
        // TODO: Implement some logic to check provided password with Bcrypt hash
    }

    @When("a PUT request will be made with an specific user id and providing a new username {string}")
    public void aPUTRequestWillBeMadeWithAnSpecificUserIdAndProvidingANewUsername(String username) {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("users")
                .pathSegment(validUserId)
                .toUriString();
        mockUser = UserTo
                .builder()
                .username(username)
                .build();
        restTemplate.put(url, mockUser);
    }

    @Then("the existing user with the id {string} should appear with updated information")
    public void theExistingUserWithTheIdShouldAppearWithUpdatedInformation(String arg0) {
    }

    @Then("the new user should have the new name {string}")
    public void theNewUserShouldHaveTheNewName(String arg0) {
    }

    @When("a DELETE request will be made with an specific user id")
    public void aDELETERequestWillBeMadeWithAnSpecificUserId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("users")
                .pathSegment(validUserId)
                .toUriString();
        restTemplate.delete(url);
    }

    @Then("requesting user with id {string} should return an HTTP {int} error")
    public void requestingUserWithIdShouldReturnAnHTTPError(String arg0, int arg1) {
    }
}
