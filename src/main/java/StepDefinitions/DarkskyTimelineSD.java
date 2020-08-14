package StepDefinitions;

import Pages.DarkSkyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;

public class DarkskyTimelineSD {

    DarkSkyPage darkSkyPage = new DarkSkyPage();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Pageconfing_properties() {

        Assert.assertEquals("We are not on the correct page",
                "Dark Sky - Broadway, New York, NY",
                SharedSD.getDriver().getTitle());


    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyPage.getTextMaintemp();
        String actual = darkSkyPage.getTextTimelinetemp();

        System.out.println("Main temp:"+expected);

        System.out.println("Timeline temp:"+actual);

        Assert.assertEquals("The tempratures are not same",expected,actual);



    }



    @Then("I verify timeline is displayed with two hours incremented")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()  {
                 ArrayList<Integer> timeList = darkSkyPage.getTimeList();

                 ArrayList<Integer> expectedDiff = new ArrayList<>();

                 for(int i=0;i<10;i++)
                 {
                     expectedDiff.add(2);
                 }

        System.out.println("Expected list:"+expectedDiff);

                ArrayList<Integer> actualDiff = new ArrayList<>();

                 for (int i=0;i<timeList.size()-1;i++) {

                 int timeDiff =0;

                     int time1 = timeList.get(i);
                     int time2 = timeList.get(i+1);



                     if(time2>time1)
                         timeDiff= time2-time1;

                     if(time2<time1)
                         timeDiff= (time2+12)-time1;


                //[12, 1, 3, 5, 7, 9, 11, 1, 4, 6, 8]

                     actualDiff.add(timeDiff);

                 }
        System.out.println("actual list:"+actualDiff);

                 Assert.assertEquals("the timeline diffrence is not 2 everywhere",
                         expectedDiff,actualDiff);

    }



    @Then("I verify lowest and highest temp is displayed correctly")
    public void i_verify_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {
                   darkSkyPage.clickExpander();

        ArrayList<String> expected = darkSkyPage.getBarTempList();
        System.out.println(expected);
        ArrayList<String> actual = darkSkyPage.getTimelineTempList();
        System.out.println(actual);

        Assert.assertEquals("temepratures are not correct",expected,actual);

    }




    }

