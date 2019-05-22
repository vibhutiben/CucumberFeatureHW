package ab1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {


    //Clicking Element
    public static void clickElementBy(By by) {
        driver.findElement(by).click();
    }

    // If URL contain specific Word
    public static void assertURL(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    //Enter Text in Input field
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    //Get current date and time
    static String getCurrentDateTime() {
        // create object of simple date format class and decide format
        DateFormat dateformat = new SimpleDateFormat("MMddyyyyHHmmss");

        // get current date time with date()
        Date date = new Date();

        // format for date
        String date1 = dateformat.format(date);
        // print the date

        System.out.println("Current date and time is" + date1);
        return date1;
    }

    //Actual result - Getting Text From Web

    public static void assertTextMessage(By by,String expected){
        String actual =driver.findElement(by).getText();
        Assert.assertEquals(expected,actual);}

    //Explicity Wait
    public static void waitForVisibility(By by,int seconds){

        WebDriverWait wait = new WebDriverWait(driver,seconds);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }
    //Dropdown select text value
    public static void selectDropdownValue(By by, String text) {

        WebElement month_dropdown = driver.findElement(by);

        Select month_dd = new Select(month_dropdown);

        month_dd.selectByVisibleText(text);
    }
    //Take a ScreenShot

    public static void captureScreenShot(String screenShotName) {


        TakesScreenshot ts = (TakesScreenshot) driver;//Create object
        File source = ts.getScreenshotAs(OutputType.FILE);//call get method and take a screenshot and keep in a memory(file)

        try {
            FileHandler.copy(source, new File("./Screenshots/" + screenShotName + ".png"));
            System.out.println("Screenshot Taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());

        }}}


