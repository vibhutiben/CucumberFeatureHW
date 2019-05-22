package ab1;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class Hook extends BasePage{

    BrowserSelector browserSelector = new BrowserSelector();
    static String timeStamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());

    @Before
    public void setUpBrowser(){
        browserSelector.Browser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();
        driver.get("http://demo.nopcommerce.com/");

    }


    @After
    public void closeBrowser(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotsName = scenario.getName().replaceAll("[.,:;?!]","")+ timeStamp+".png";
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty(("user.dir")+"target/cucumber-reports/extent-reports/ScreenShots"+screenshotsName));

            try{  copyFile(sourcePath,destinationPath);
                scenario.write("!!!Scenario Failed!!!Please see attached screenshot for the error/issue");
                scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
            } catch (IOException e) {

            }
        }
        driver.quit();
    }}

