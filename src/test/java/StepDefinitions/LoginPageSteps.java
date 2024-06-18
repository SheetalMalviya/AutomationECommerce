package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Factory.DriverFactories;
import org.WebPages.LoginWebPage;
import org.testng.Assert;


public class LoginPageSteps {


    private LoginWebPage loginWebPage = new LoginWebPage(DriverFactories.get_driver());

    @Given("User is on Login Page")
    public void user_is_on_login_page() {

        DriverFactories.get_driver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        System.out.println("The title of login page is " + loginWebPage.getTitleLoginPage());
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String loginTitle) {
        Assert.assertEquals(loginWebPage.getTitleLoginPage(), loginTitle);
    }

    @Then("Forgot password link should be visible")
    public void forgot_password_link_should_be_visible() {
        Assert.assertTrue(loginWebPage.isForgotPasswordLinkVisible());
    }

    @When("User enter the username {string}")
    public void user_enter_the_username(String email) {
        loginWebPage.enter_emailID(email);
        System.out.println("The emailID is " + email);
    }

    @When("User enter the password {string}")
    public void user_enter_the_password(String pwd) {
        loginWebPage.enter_password(pwd);
        System.out.println("The password is " + pwd);

    }

    @When("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginWebPage.click_signIn();

    }

    @Then("User should be able to land on accounts page and title should be {string}")
    public void user_should_be_able_to_land_on_accounts_page(String accountTitle) {
        System.out.println("The title of accounts page is " + accountTitle);
        Assert.assertEquals(loginWebPage.getTitleAccountPage(), accountTitle);
    }


}
