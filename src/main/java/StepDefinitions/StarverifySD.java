package StepDefinitions;

import Pages.HotelsHomePage;
import Pages.HotelsSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class StarverifySD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();
    HotelsSearchPage hotelsSearchPage = new HotelsSearchPage();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen()  {

        hotelsHomePage.setCityText("Pune, Maharashtra, India");
        hotelsHomePage.clicksearchBox();
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) // 5 stars
    {

       hotelsSearchPage.selectStar(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars)  {

        ArrayList<String> starList = hotelsSearchPage.getstarList();

        System.out.println(stars);
        System.out.println(starList);

        String expectedStar = stars.split(" ")[0]+"-star"; // 5-star

        int frequency = Collections.frequency(starList,expectedStar);
        int size = starList.size();

        System.out.println("frequecy="+frequency);
        System.out.println("size"+size);
        boolean result = frequency==size;

        Assert.assertTrue("all stars are not:"+stars,result);

    }

}
