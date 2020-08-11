package StepDefinitions;

import Pages.DarkSkyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DarkskyTimelineSD {

    DarkSkyPage darkSkyPage = new DarkSkyPage();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Pageconfing_properties() {

    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyPage.getTextMaintemp();
        String actual = darkSkyPage.getTextTimelinetemp();

        System.out.println("Main temp:"+expected);

        System.out.println("Timeline temp:"+actual);

        Assert.assertEquals("The tempratures are not same",expected,actual);



    }
}
