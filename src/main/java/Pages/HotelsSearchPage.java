package Pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchPage extends  BasePage{


    By starRatingList = By.xpath("//span[contains(@class,'star-rating-text')]");

    By distanceTextList = By.xpath("//ul[@class='property-landmarks']/li[2]");

    By hotelsList = By.xpath("//a[@class='property-name-link']");


    public ArrayList<String> getHotelsList()
    {
        return  getElementTextList(hotelsList);
    }


    public ArrayList<Double> getDistancelist()
    {
        ArrayList<String> distanceListRow = getElementTextList(distanceTextList);

        System.out.println(distanceListRow);
        ArrayList<Double> distanceList = new ArrayList<>();

        for (int i=0;i<distanceListRow.size();i++)
        {

//"3.5 km to Chhatrapati Shivaji International Airport (BOM)"
          double distance =  Double.parseDouble(distanceListRow.get(i).split(" ")[0]);

            distanceList.add(distance);
        }

          return distanceList;
    }

    public void selectStar(String star)
    {
        SharedSD.getDriver().navigate().refresh();
        SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+star+"']")).click();
    }

    public ArrayList<String> getstarList() // 5-star
    {
        return  getElementTextList(starRatingList);
    }



}
