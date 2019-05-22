package ab1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {

    LoadProp loadProp = new LoadProp();


    public void Browser(){
        String browser = loadProp.getProperty("browser");
        String setUpBrowser = System.getProperty("setupBrowser");
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver = new FirefoxDriver();
            driver.manage().window().fullscreen();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            ChromeOptions options =new ChromeOptions();
            options.addArguments("diable-infobars");
            options.addArguments("--disable-extenstions");
            options.addArguments("disable-setUpBrowser-side-navigation");
            options.addArguments("--incognito");
            options.addArguments("disable-bink-feature=BlockCredentialedSubresources");
            driver = new ChromeDriver(options);
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
            InternetExplorerOptions options=new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,"true");
            driver = new InternetExplorerDriver(options);
            driver.manage().window().maximize();
        }
        else{System.out.println("Browser name is Empty or typed wrong:"+browser);
        }

    }}




