package Basics;

import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

    import java.time.Duration;

    public class LoginPage {

        WebDriver driver;

        @Test
        public void loginWithValidDetails() throws InterruptedException {

            //driver = new ChromeDriver();
            driver = new EdgeDriver();
            driver.get("https://ndosisimplifiedautomation.vercel.app");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
            driver.findElement(By.id("login-email")).sendKeys("test12345@gmail.com");
            driver.findElement(By.id("login-password")).sendKeys("test@123");
            driver.findElement(By.id("login-submit")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("#dashboard"));


            String expectedUrl = "https://ndosisimplifiedautomation.vercel.app/#dashboard";

            if(driver.getCurrentUrl().equals(expectedUrl)) {
                System.out.println("Login is successful");
            } else{
                        System.out.println("Login failed!");
                  }
            System.out.println("Current URL: " + driver.getCurrentUrl());


            wait.until(ExpectedConditions.elementToBeClickable(By.className("user-pill"))).click();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/div/button[5]"))).click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(5000);
            alert.accept();

            driver.quit();
        }
    }
