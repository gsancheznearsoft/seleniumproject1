import automation.components.LoginPage;
import automation.components.ManagerHomePage;
import automation.components.PagesFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestCase extends DataProviders{

    public WebDriver webDriver;
    public PagesFactory pagesFactory;
    LoginPage loginPage;
    ManagerHomePage managerHomePage;

    @BeforeTest
    public void before(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        PagesFactory pagesFactory = new PagesFactory(webDriver);
    }

    public LoginPage goToWebsite(String website) {
        webDriver.get(website);
        return new LoginPage(webDriver, pagesFactory);
    }


    @AfterTest
    public void after() {
        webDriver.quit();
    }

}
