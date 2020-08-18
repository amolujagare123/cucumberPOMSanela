package Pages;

import org.openqa.selenium.By;

public class LoginPage extends  DarkSkyAPIPage{

    By loginButton = By.xpath("//button[contains(text(),'Log in')]");

public void clickLoginButton()
{
 clickOn(loginButton);
}


}
