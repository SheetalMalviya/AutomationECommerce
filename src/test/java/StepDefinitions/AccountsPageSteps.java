package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Factory.DriverFactories;
import org.WebPages.AccountsWebpage;
import org.WebPages.LoginWebPage;

import java.util.Map;
import java.util.List;

import org.testng.Assert;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;

public class AccountsPageSteps {
    private AccountsWebpage accountsWebpage;
    LoginWebPage loginWebPage = new LoginWebPage(DriverFactories.get_driver());

    @When("User enters credentials on login page")
    public void user_enters_credentials_on_login_page(DataTable dataTableOfCreds) {
        DriverFactories.get_driver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        List<Map<String, String>> credList = dataTableOfCreds.asMaps();
        String email_ID = credList.get(0).get("EmailId");
        String pwd = credList.get(0).get("Password");
        accountsWebpage= loginWebPage.doLogin(email_ID, pwd);
    }

    @Given("User is on Accounts Page")
    public void user_is_on_accounts_page() {

    }

    @Then("The title of the accounts page is {string}")
    public void the_title_of_the_accounts_page_is(String string) {
        loginWebPage.getTitleAccountPage();
        Assert.assertEquals(loginWebPage.getTitleAccountPage(), "My account - My Shop");

    }

    @Then("The account section list has items in below Order")
    public void the_account_section_list_has_items_in_below_order(DataTable accountSectionTable) {
        List<String> expectedAcountSectionList = accountSectionTable.asList();
        System.out.println("The expected account section list is "+expectedAcountSectionList);
       List<String> actualAccountSectionList= accountsWebpage.getAccountSectionList();
        System.out.println("The actual account section list is "+actualAccountSectionList);
        Assert.assertTrue(actualAccountSectionList.containsAll(expectedAcountSectionList));

    }

    @Then("Then The Account section has {int} items")
    public void then_the_account_section_has_items(Integer int1) {
        Assert.assertEquals(accountsWebpage.getAccountSectionListCount(), int1);
    }


}
