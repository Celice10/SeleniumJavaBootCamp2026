package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    static WebDriver driver;    //the variable belongs to the class, not to any object.
                                //there is only one single driver shared by across all the objects. We can call it without creating an object of the class.

    public static WebDriver startBrowser (String browserName, String url) {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
