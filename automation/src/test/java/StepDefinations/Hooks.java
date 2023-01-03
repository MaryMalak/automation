package StepDefinations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class Hooks {

        WebDriver driver=null;
        @BeforeTest
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            driver.navigate().to("https://techytypes.com/");

        }
        @Test
        public void checkform() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys("Mary Malak");

            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[2]/div/input")).sendKeys("Mary@gmail.com");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/div/div/div/textarea")).sendKeys("hello");
            //driver.findElement(By.linkText("Send")).click();
           driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/button[@type=\"submit\"]")).click();
            String actualresult=driver.findElement(By.cssSelector("div[class=\"Toastify__toast-body\"]")).getText();
           String expected="Submited Successfully!";
           Assert.assertTrue(actualresult.contains(expected));
            System.out.println(actualresult);
            Thread.sleep(3000);

        }
        @AfterTest
        public void closeBrowse(){
            driver.quit();
        }

    }



