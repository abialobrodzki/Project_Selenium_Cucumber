package main02;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/features/Main02.feature", plugin = {"pretty", "html:UserNewOrderTest.html"}, tags = "@Main02")

public class NewOrderTest {

}
