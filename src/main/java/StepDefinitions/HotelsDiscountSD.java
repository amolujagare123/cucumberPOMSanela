package StepDefinitions;

import Pages.HotelsSearchPage;
import com.google.gson.stream.JsonToken;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HotelsDiscountSD  {

    HotelsSearchPage hotelsSearchPage = new HotelsSearchPage();

    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String maxDiscount) throws Throwable {

        int maxDiscountint = Integer.parseInt(maxDiscount);

        System.out.println("max discount="+maxDiscountint);

        int actualPrice = hotelsSearchPage.getDealPrice();
        System.out.println("deal Price="+actualPrice);


       boolean result = actualPrice<maxDiscountint;


       Assert.assertTrue("The discount price is greater than max discount",result);

    }

}
