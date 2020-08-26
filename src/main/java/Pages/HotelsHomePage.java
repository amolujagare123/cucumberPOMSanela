package Pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class HotelsHomePage extends  BasePage{

    By cityText = By.xpath("//input[@id='qf-0q-destination']");
    By searchBox = By.xpath("//button[@type='submit']");

    public void  clicksearchBox() {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        try {
            WebElement btnSearch = driver.findElement(searchBox);
            js.executeScript("arguments[0].click()", btnSearch);
        }
        catch (StaleElementReferenceException e)
         {
             clickOn(cityText);
         }
    }




    public void setCityText(String city)
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();

        WebElement txtCity = SharedSD.getDriver().findElement(cityText);
        js.executeScript("arguments[0].setAttribute('value','"+city+"')",txtCity);
    }

}
