package Pages;

import org.openqa.selenium.By;

public class DarkSkyAPIPage extends  DarkSkyPage{

    By loginLink = By.xpath("//a[@class='button']");

    public void clickLoginLink()
    {
        clickOn(loginLink);
    }
}
