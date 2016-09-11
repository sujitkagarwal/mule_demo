package steps;

import cucumber.api.java.en.Given;

/**
 * Created by Anie on 7/3/2016.
 */
public class CucumberSteps {
    private String loginId;
    public CucumberSteps()
    {
        System.out.println("in cucumber steps");

    }

@Given("^I am login as valid user (.+)$")
 public void loginUser(String userName)
{
    loginId=userName;

}
    @Given("^a fresh environment$")
    public void freshEnv()
    {
        System.out.println("in a fresh env");
    }
}
