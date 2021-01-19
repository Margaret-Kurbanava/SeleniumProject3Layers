package tests;


import app.Application;
import org.testng.annotations.*;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;



public class TestBase {

    public WebDriver driver;
    public  WebDriverWait wait;


    public Application app;
    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();

    @BeforeClass
    public  void SetUp()  {


       //Chrome Capabilities -dismiss unexpected browser alerts
       ChromeOptions caps = new ChromeOptions();
       caps.setCapability("unexpectedAlertBehaviour", "dismiss");


       //for other browsers
        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("unexpectedAlertBehaviour", "dismiss");

        //driver constructor
        //driver = new ChromeDriver(caps);

        // Edge browser run
       /* System.setProperty("webdriver.edge.driver", "C:\\SeleniumDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();*/






       if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));




/*

        //wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window
        driver.manage().window().maximize();

        //print all Capabilities
        System.out.println(((HasCapabilities) driver).getCapabilities());


        wait = new WebDriverWait(driver, 10);
*/

        //Shutdown the browser. Replacement for TestNG AfterAll.
      // Runtime.getRuntime().addShutdownHook(new Thread(() -> { driver.quit(); driver = null; }));



        //



    }








    @AfterClass
    public void stop() {
      //driver.quit();
    }
}