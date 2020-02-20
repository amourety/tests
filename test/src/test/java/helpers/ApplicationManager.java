package helpers;

import helpers.data.AccountData;
import helpers.data.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class ApplicationManager {

    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private EntityHelper entityHelper;

    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;
    private AccountData accountData;
    private Data data;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();


    private ApplicationManager(){
        System.setProperty("webdriver.chrome.driver", "/Users/amourety/Downloads/chromedriver");
        this.driver = new ChromeDriver();
        this.js = (JavascriptExecutor) driver;
        this.vars = new HashMap<String, Object>();
        this.navigationHelper = new NavigationHelper(this);
        this.loginHelper = new LoginHelper(this);
        this.entityHelper = new EntityHelper(this);
    }

    public void stop(){
        driver.quit();
    }

    public static ApplicationManager getInstance(){
        if (Objects.isNull(app.get())) {
            app.set(new ApplicationManager());
        }
        return app.get();
    }


    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public void setLoginHelper(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public EntityHelper getEntityHelper() {
        return entityHelper;
    }

    public void setEntityHelper(EntityHelper entityHelper) {
        this.entityHelper = entityHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
