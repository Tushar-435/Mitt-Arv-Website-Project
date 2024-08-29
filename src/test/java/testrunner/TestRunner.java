package testrunner;
	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = { ".//Features/login.feature" }, 
	    glue = "stepdef", // Package name where step definitions are located
	    		dryRun = false, monochrome = false,
	    		
	    		plugin = {
	    				"pretty", "html:target/Cucumber-report/New.html" },

	    				tags = "@regression"

	    		)
	public class TestRunner {
	}
	
 
	 
	
	

	
