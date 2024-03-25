package CoursePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursePractical {

    @Test
    public void LoginPage(){

        //Setup web browser driver
        WebDriverManager.chromedriver().setup();

        //Open a web browser (Chrome Broser)
        WebDriver driver = new ChromeDriver();

        //Navigate to the web page
        driver.get("https://www.saucedemo.com/");

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
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class=\"title\"]")).getText(),"Products");

        driver.quit();

    }
}
