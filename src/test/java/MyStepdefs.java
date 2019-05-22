import ab1.HomePage;
import ab1.RegistrationPage;
import ab1.RegistrationSuccessPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    @Given("^user is on register page$")
    public void user_is_on_register_page() {
        homePage.clickOnRegister();
    }

    @When("^user enters all registration details$")
    public void user_enters_all_registration_details() {
        registrationPage.verifyUserIsOnRegisterPage();
        registrationPage.userEnterRegistrationDetails();
    }

    @Then("^user should able to register successfully$")
    public void user_should_able_to_register_successfully() {
    }



    @When("^user select euro currency$")
    public void userSelectEuroCurrency() {
        homePage.selectcurrency();

    }

    @Then("^user able to see all products with euro price sucessfully$")
    public void userAbleToSeeAllProductsWithEuroPriceSucessfully() {
        homePage.verifyCurrency();

    }
}
