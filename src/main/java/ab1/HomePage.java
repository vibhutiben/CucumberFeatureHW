package ab1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utils {

    //Locators for homepage
    private By _registerLink = By.linkText("Register");
    private By _currency = By.id("customerCurrency");


    //Homepage Elements
    public void clickOnRegister() {
        clickElementBy(_registerLink);
    }

    public void selectcurrency() {
        selectDropdownValue(_currency, "Euro");
    }

    public void verifyCurrency(){
        boolean present = true;
        List<WebElement> activeList = driver.findElements(By.className("actual-price"));
        for(WebElement element:activeList){
            String str = element.getText();

            for(int i =0; i<str.length();i++){
                char ch = str.charAt(i);
                if(ch == '€') {
                    present = true;
                }}
            if(present == true){
                System.out.println("€"+"is present in the array list");
                }
            else{System.out.println("The € is not present at the array list");
            }
        }



    }
}