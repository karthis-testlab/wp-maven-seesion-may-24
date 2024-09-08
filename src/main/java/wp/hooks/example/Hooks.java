package wp.hooks.example;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
		System.out.println("Running the scenario: "+scenario.getName()+" beforeScenario");
	}
	
	@After(order = 2)
	public void afterSCenario(Scenario scenario) {
		if(scenario.isFailed()) {
			System.err.println(scenario.getName()+" was falied! - afterSCenario");
		} else {
			System.out.println(scenario.getName()+" was sucess! - afterSCenario");
		}
	}
	
	@Before(order = 2)
	public void beforeScenario1(Scenario scenario) {
		System.out.println("Running the scenario: "+scenario.getName()+" beforeScenario1");
	}
	
	@After(order = 1)
	public void afterSCenario1(Scenario scenario) {
		if(scenario.isFailed()) {
			System.err.println(scenario.getName()+" was falied! - afterSCenario1");
		} else {
			System.out.println(scenario.getName()+" was sucess! - afterSCenario1");
		}
	}
	
	@BeforeStep
	public void beforeEachStep() {
		System.err.println("Should run before eachstep of the scenario");
	}
	
	@AfterStep
	public void afterEachStep() {
		System.err.println("Should run after eachstep of the scenario");
	}
	
	
}
