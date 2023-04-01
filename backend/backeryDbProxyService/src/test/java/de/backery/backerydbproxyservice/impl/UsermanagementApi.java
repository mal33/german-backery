package de.backery.backerydbproxyservice.impl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsermanagementApi {
    @When("a GET request will be made against the endpoint to grab all users")
    public void aGETRequestWillBeMadeAgainstTheEndpointToGrabAllUsers() {
    }

    @Then("it should obtain {int} users from the database")
    public void itShouldObtainUsersFromTheDatabase(int arg0) {
    }

    @Given("a valid user id {string}")
    public void aValidUserId(String arg0) {
    }

    @When("a GET request will be made with an specific user id")
    public void aGETRequestWillBeMadeWithAnSpecificUserId() {
    }

    @Then("it should return an user with the id {string}")
    public void itShouldReturnAnUserWithTheId(String arg0) {
    }

    @Given("a username {string} with the password {string}")
    public void aUsernameWithThePassword(String arg0, String arg1) {
    }

    @When("a POST request will be made in user to create a new user")
    public void aPOSTRequestWillBeMadeInUserToCreateANewUser() {
    }

    @Then("it should the new user with the username {string}")
    public void itShouldTheNewUserWithTheUsername(String arg0) {
    }

    @Then("the hashed password should be equivalent to {string}")
    public void theHashedPasswordShouldBeEquivalentTo(String arg0) {
    }

    @When("a PUT request will be made with an specific user id and providing a new username {string}")
    public void aPUTRequestWillBeMadeWithAnSpecificUserIdAndProvidingANewUsername(String arg0) {
    }

    @Then("the existing user with the id {string} should appear with updated information")
    public void theExistingUserWithTheIdShouldAppearWithUpdatedInformation(String arg0) {
    }

    @Then("the new user should have the new name {string}")
    public void theNewUserShouldHaveTheNewName(String arg0) {
    }

    @When("a DELETE request will be made with an specific user id")
    public void aDELETERequestWillBeMadeWithAnSpecificUserId() {
    }

    @Then("requesting user with id {string} should return an HTTP {int} error")
    public void requestingUserWithIdShouldReturnAnHTTPError(String arg0, int arg1) {
    }
}
