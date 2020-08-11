package Pages;

import org.openqa.selenium.By;

public class DarkSkyPage extends  BasePage{

    By mainTempText = By.xpath("//span[@class='summary swap']");
    By timelineTemtext = By.xpath("//span[@class='first']//span");


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
