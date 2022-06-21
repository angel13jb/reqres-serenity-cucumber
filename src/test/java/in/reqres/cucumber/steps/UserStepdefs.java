package in.reqres.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.reqres.userinfo.UserSteps;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class UserStepdefs {
    @Steps
    UserSteps userSteps;
    ValidatableResponse response;
    static String name="sweety"+ TestUtils.getRandomValue();
    static  String job="tester";
    static String userId ="";
    @When("^I insert name and job$")
    public void iInsertNameAndJob() {
        userSteps.createUser(name ,job);

    }

    @And("^I send post request to creat user$")
    public void iSendPostRequestToCreatUser() {
        response= userSteps.createUser(name ,job);

    }

    @Then("^I should be able to create new user succefully$")
    public void iShouldBeAbleToCreateNewUserSuccefully() {
        response.statusCode(201);
    }

    @And("^I should be able to get new user created Id$")
    public void iShouldBeAbleToGetNewUserCreatedId() {
        userId= response.extract().path("id");
        System.out.println(userId);
    }

    @When("^I send a get request for fatching single user record by id$")
    public void iSendAGetRequestForFatchingSingleUserRecordById() {
        response=userSteps.getSingleUser(userId);

    }

    @Then("^I should be able to get single record$")
    public void iShouldBeAbleToGetSingleRecord() {
        response.statusCode(200);
    }

    @And("^Verify name of the User created id$")
    public void verifyNameOfTheUserCreatedId() {
        response.body("name",equalTo(name));
    }

    @When("^I insert name and job for updating  user$")
    public void iInsertNameAndJobForUpdatingUser() {

    }

    @And("^I send patch request for updating user$")
    public void iSendPatchRequestForUpdatingUser() {
        response=userSteps.updateUser(Integer.parseInt(name),job,userId);
    }

    @Then("^i should be able to update data in user$")
    public void iShouldBeAbleToUpdateDataInUser() {
        response.statusCode(200);
    }

    @When("^I send request for deleting user$")
    public void iSendRequestForDeletingUser() {
        response= userSteps.deleteUser(Integer.parseInt(userId));
    }

    @And("^I should be able to delete user successfully$")
    public void iShouldBeAbleToDeleteUserSuccessfully() {
        response.statusCode(204);
    }

    @And("^I should not able to get deleted record by deleted id$")
    public void iShouldNotAbleToGetDeletedRecordByDeletedId() {
        response=userSteps.getSingleUser(userId);
        response.statusCode(404);
    }
}
