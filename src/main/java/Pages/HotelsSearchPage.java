package Pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchPage extends  BasePage{


    By starRatingList = By.xpath("//span[contains(@class,'star-rating-text')]");

    By distanceTextList = By.xpath("//ul[@class='property-landmarks']/li[2]");

    By hotelsList = By.xpath("//a[@class='property-name-link']");

    By dealPrice = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");


    public int getDealPrice()
    {
        String amountRaw = getTextFromElement(dealPrice);

        String amountRawWithoutRs = amountRaw.substring(2); // 5,948

        String amoutnWithoutCommaStr ="";

        for(int i=0;i<amountRawWithoutRs.length();i++)
        {

            if(amountRawWithoutRs.charAt(i)!=',')
                amoutnWithoutCommaStr = amoutnWithoutCommaStr +  amountRawWithoutRs.charAt(i);

        }

        int amountWithoutComma = Integer.parseInt(amoutnWithoutCommaStr);

        return amountWithoutComma;
    }


    // for discount in doller

    public int getDealPriceInDoller()
    {
        String amountRaw = getTextFromElement(dealPrice);

        String amountRawWithoutDoller = amountRaw.substring(1); // $548

        int amountWithoutComma = Integer.parseInt(amountRawWithoutDoller);

        return amountWithoutComma;
    }

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
