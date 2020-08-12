package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyPage extends  BasePage{

    By mainTempText = By.xpath("//span[@class='summary swap']");
    By timelineTemtext = By.xpath("//span[@class='first']//span");
    By timeListRaw = By.xpath("//span[@class='hour']/span");


    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timeListTextRow = getElementTextList(timeListRaw);

        System.out.println(timeListTextRow);
//[12am, 1am, 3am, 5am, 7am, 9am, 11am, 1pm, 4pm, 6pm, 8pm]
        ArrayList<Integer> timelistInt= new ArrayList<>();

        for(int i=0;i<timeListTextRow.size();i++)
        {
            String timeRow = timeListTextRow.get(i);
            int l = timeRow.length();
            String   timeStr =  timeRow.substring(0,l-2); // "12"
            int timeInt = Integer.parseInt(timeStr);

            timelistInt.add(timeInt);

        }


 // [12, 1, 3, 5, 7, 9, 11, 1, 4, 6, 8]
        System.out.println(timelistInt);

        return  timelistInt;
    }



    public String getTextMaintemp() // 81˚ Possible Drizzle and Humid.
    {
        String text = getTextFromElement(mainTempText);

        return text.split("˚")[0];
    }

    public String getTextTimelinetemp() //82°
    {
        String text = getTextFromElement(timelineTemtext);
        return text.split("°")[0];
    }
}
