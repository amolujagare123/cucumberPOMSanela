package StepDefinitions;

import Pages.HotelsSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;

public class HotelDistanceSD {

    HotelsSearchPage hotelsSearchPage = new HotelsSearchPage();
    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of airport$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_airport(String distance)  {

        double expectedDistance = Double.parseDouble(distance);

        System.out.println("Expected distance:"+expectedDistance);

        ArrayList<Double> distList = hotelsSearchPage.getDistancelist();

        System.out.println(distList);

        boolean result = true;

        ArrayList<Double> greaterDistList = new ArrayList<>();

        for(int i=0;i<distList.size();i++)
        {

            if(distList.get(i)>expectedDistance)
            {
                result=false;
                greaterDistList.add(distList.get(i));
            }


        }

        System.out.println(greaterDistList);

        Assert.assertTrue("some distances are greater than:"+expectedDistance
                +"as follows\n"+greaterDistList
                ,result);

    }

    @And("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String hotelName)  {

        ArrayList<String> hotelslist = hotelsSearchPage.getHotelsList();

        System.out.println(hotelslist);

        boolean result = false;

        for(int i=0;i<hotelslist.size();i++)
        {
            if(hotelslist.get(i).contains(hotelName))
            {
                result = true;
                System.out.println(hotelslist.get(i));
            }


        }


    }


}
