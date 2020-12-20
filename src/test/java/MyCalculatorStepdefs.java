import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class MyCalculatorStepdefs {
    private int total;

    private MyCalculatorStepdefs calculator;

    @Before
    private void init() {
        total = -999;
    }

    @Given("^I have a calculator$")
    public void initializeCalculator() throws Throwable {
        calculator = new MyCalculatorStepdefs();
    }

    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void testAdd(int num1, int num2) throws Throwable {
        total = calculator.add(num1, num2);
    }

    public int add(int a, int b) {
        return a + b;
    }

    @Then("^the result should be (-?\\d+)$")
    public void validateResult(int result) throws Throwable {
        Assert.assertThat(total, Matchers.equalTo(result));
    }
}
