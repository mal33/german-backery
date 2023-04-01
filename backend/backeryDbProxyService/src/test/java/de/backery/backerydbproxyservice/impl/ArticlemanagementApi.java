package de.backery.backerydbproxyservice.impl;

import de.backery.backerydbproxyservice.common.CommonTestBase;
import de.backery.backerydbproxyservice.to.ArticleTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import java.util.ArrayList;
import java.util.List;

public class ArticlemanagementApi extends CommonTestBase {

    @Autowired
    protected TestRestTemplate restTemplate;
    private String validArticleId;
    private List<ArticleTo> allArticles = new ArrayList<>();
    private ArticleTo mockArticle;
    private ArticleTo resultArticle;

    @When("a GET request will be made against the endpoint to grab all articles")
    public void aGETRequestWillBeMadeAgainstTheEndpointToGrabAllArticles() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .pathSegment("articles")
                .toUriString();
        allArticles = restTemplate.getForEntity(url, List.class).getBody();
    }

    @Then("it should obtain {int} articles from the database")
    public void itShouldObtainArticlesFromTheDatabase(int numberOfExpectedArticles) {
        assertThat(allArticles.size(), equalTo(numberOfExpectedArticles));
    }

    @Given("a valid article id {string}")
    public void aValidArticleId(String someArticleId) {
        validArticleId = someArticleId;

    }

    @When("a GET request will be made with an specific article id")
    public void aGETRequestWillBeMadeWithAnSpecificArticleId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("/articles/")
                .pathSegment(validArticleId)
                .toUriString();
        resultArticle = restTemplate.getForEntity(url, ArticleTo.class).getBody();
    }

    @Then("it should return an article with the id {string}")
    public void itShouldReturnAnArticleWithTheId(String articleId) {
        assertThat(resultArticle.getArticleId(), equalTo(articleId));
    }


    @Given("a bread name {string} with the description {string}")
    public void aBreadNameWithTheDescription(String name, String description) {
        mockArticle = ArticleTo
                .builder()
                .name(name)
                .description(description)
                .build();
    }

    @When("a POST request will be made in order to create a new article")
    public void aPOSTRequestWillBeMadeInOrderToCreateANewArticle() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("articles")
                .toUriString();
        resultArticle = restTemplate.postForObject(url, mockArticle, ArticleTo.class);
    }

    @Then("it should the new article with the name {string} with the description {string}")
    public void itShouldTheNewArticleWithTheNameWithTheDescription(String name, String description) {
        assertThat(mockArticle.getName(), equalTo(name));
        assertThat(mockArticle.getDescription(), equalTo(description));
    }

    @When("a PUT request will be made with an specific article id and providing a new name {string}")
    public void aPUTRequestWillBeMadeWithAnSpecificArticleIdAndProvidingANewName(String newNameForArticle) {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("articles")
                .pathSegment(validArticleId)
                .toUriString();
        mockArticle = ArticleTo
                .builder()
                .name(newNameForArticle)
                .build();
        restTemplate.put(url, mockArticle);
    }

    @Then("the existing article with the id {string} should appear with updated information")
    public void theExistingArticleWithTheIdShouldAppearWithUpdatedInformation(String arg0) {
    }

    @Then("the new article should have the new name {string}")
    public void theNewArticleShouldHaveTheNewName(String arg0) {
    }

    @When("a DELETE request will be made with an specific article id")
    public void aDELETERequestWillBeMadeWithAnSpecificArticleId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .path("articles")
                .pathSegment(validArticleId)
                .toUriString();
        restTemplate.delete(url);
    }

    @Then("requesting article with id {string} should return an HTTP {int} error")
    public void requestingArticleWithIdShouldReturnAnHTTPError(String arg0, int arg1) {
    }
}
