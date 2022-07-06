import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/Main01.feature", plugin = {"pretty", "html:UserNewAddressTest.html"}, tags = "@Main01")

public class UserNewAddressTest {

}
