/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author dhana.arvina
 */
public class TestCase2 {
    WebDriver driver = null;
    
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    
    @Test
    public void secondCase(){
        driver.get("http://localhost:8080/AUTng-main/index.php");
        driver.findElement(By.name("username")).sendKeys("xxx");
        driver.findElement(By.name("password")).sendKeys("xxx");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedResult = "Wrong username or password!";
        String actualResult = driver.findElement(By.className("notif")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
    public TestCase2() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
