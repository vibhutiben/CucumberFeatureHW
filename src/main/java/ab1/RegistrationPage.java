package ab1;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils {


    LoadProp loadProp = new LoadProp();

    //Locators for Registerpage
    private By _firstName = By.xpath("//input[@name='FirstName']");
    private By _lastName = By.xpath("//*[@id='LastName']");
    private By _email = By.xpath("//*[@id=\'Email\']");
    private By _password = By.xpath("//input[@id='Password']");
    private By _confirmPassword = By.xpath("//input[@name='ConfirmPassword']");
    private By _registerButton = By.xpath("//input[@id='register-button']");

    // private static String Timestamp = createTimeStamp();

    //Assert for user on Registerpage
    public void verifyUserIsOnRegisterPage(){
        assertURL("register");}

    //Registration Details
    public void userEnterRegistrationDetails(){

        enterText(_firstName,loadProp.getProperty("firstname"));
        enterText(_lastName,loadProp.getProperty("lastname"));
        enterText(_email,"shivangi1"+getCurrentDateTime()+"@test.com");
        enterText(_password,loadProp.getProperty("password"));
        enterText(_confirmPassword,loadProp.getProperty("confirmpassword"));
        clickElementBy(_registerButton);
    }
}
