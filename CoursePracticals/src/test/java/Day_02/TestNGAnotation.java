package Day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnotation {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        //Setup web browser driver
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void beforMethod(){
        //Open a web browser (Chrome Broser)
        driver = new ChromeDriver();

        //Navigate to the web page
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod(){
        if(driver!=null){
            driver.quit();
        }
        //driver.close();
    }

    @Test
    public void LoginPage(){

        //Type username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //press loging Button
        driver.findElement(By.id("login-button")).click();

        String PageTitle = driver.getTitle();
        System.out.print("Landing Page Title:" +PageTitle);

        //Verify landing page
        Assert.assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Products");

    }

    /*@Test
    public void testmethod2(){
        System.out.println("Test method 2");
    }*/
}
