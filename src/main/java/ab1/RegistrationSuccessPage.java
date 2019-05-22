package ab1;

import org.openqa.selenium.By;

public class RegistrationSuccessPage extends Utils {

    //Locators for rugistrationsuccesspage
    private By _registrationcompleted = By.xpath("//div[@class='result']");

    public void verifyUserSeeRegistrationSuccessMessage(){

        assertTextMessage(_registrationcompleted,"Your registration completed");
    }

}
