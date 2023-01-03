package StepDefinations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class Hooks {

        WebDriver driver=null;
        @BeforeMethod
        //@BeforeTest
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            driver.navigate().to("https://techytypes.com/");

        }
        @Test
        public void checkformWithValidData() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys("Mary Malak");

            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[2]/div/input")).sendKeys("Mary@gmail.com");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/div/div/div/textarea")).sendKeys("hello");
            //driver.findElement(By.partialLinkText("Send")).click();
            driver.findElement(By.cssSelector("div>div>button[type=\"submit\"]")).submit();
            Thread.sleep(2000);
            // driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/button[@type=\"submit\"]")).click();
            String actualresult=driver.findElement(By.cssSelector("div[class=\"Toastify__toast-body\"]")).getText();
           String expected="Submited Successfully!";
            System.out.println("actuaaaaal"+actualresult);
           Assert.assertTrue(actualresult.contains(expected));



        }
    @Test
    public void checkformWithINValidName() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys("M");

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[2]/div/input")).sendKeys("Mary@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/div/div/div/textarea")).sendKeys("hello");
        driver.findElement(By.cssSelector("div>div>button[type=\"submit\"]")).submit();
        Thread.sleep(2000);
        String actualresult=driver.findElement(By.cssSelector("div[class=\"Toastify__toast-body\"]")).getText();
        String expected="Name must be at least 3 characters";

        Assert.assertTrue(actualresult.contains(expected));


    }
    @Test
    public void checkformWithINValidMail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys("Mary");

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[2]/div/input")).sendKeys("Mary.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/div/div/div/textarea")).sendKeys("hello");
        driver.findElement(By.cssSelector("div>div>button[type=\"submit\"]")).submit();
        Thread.sleep(2000);
        String actualresult=driver.findElement(By.cssSelector("div[class=\"Toastify__toast-body\"]")).getText();
        String expected="Please add a Valid Email Address";

        Assert.assertTrue(actualresult.contains(expected));


    }
    @Test
    public void checkformWithSmallMessage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[1]/div/input")).sendKeys("Mary");

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[1]/div[2]/div/input")).sendKeys("Mary@gmaill.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[8]/div/div[2]/form/div[2]/div/div/div/div/textarea")).sendKeys("h");
        driver.findElement(By.cssSelector("div>div>button[type=\"submit\"]")).submit();
        Thread.sleep(2000);
        String actualresult=driver.findElement(By.cssSelector("div[class=\"Toastify__toast-body\"]")).getText();
        String expected="Message must be at least 5 characters";

        Assert.assertTrue(actualresult.contains(expected));


    }

        @AfterMethod
        public void closeBrowse(){
            driver.quit();
        }

    }



