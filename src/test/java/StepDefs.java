import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
class IsItOver {
    static String isItOver(String number) {
        return "1200".equals(number) ? "Quarantine is going on!" : "Quarantine is over!";
    }
}
class CanIGoToCinema {
    static String canIGoToCinema() {
        return "Yes, you can!";
    }
}
public class StepDefs {
    private String number;
    private String actualAnswer;
    private String actualAnswer2;
    private String answer;
    private String number2;
    @Given("number of ill people is (.+)")
    public void ill_people() {
        number = "10";
    }
    @Given("quarantine is over")
    @When("I ask whether it's quarantine is over")
    public void I_ask_whether_it_is_quarantine_is_over() {
        actualAnswer = IsItOver.isItOver(number);
    }
    @When("I ask whether i can go to cinema")
    public void I_ask_whether_i_can_go_to_cinema() {
        actualAnswer2 = CanIGoToCinema.canIGoToCinema();
    }
    @Then("I should tell you (.+)")
    public void i_should_be_told_1() {
        String    expectedAnswer = "Quarantine is over!";
        assertEquals(expectedAnswer, actualAnswer);
    }
    @Then("I should be told {string}")
    public void i_should_be_told_2(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer2);
    }
}