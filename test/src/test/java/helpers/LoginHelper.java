package helpers;

import generator.User;
import helpers.data.AccountData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class LoginHelper extends HelperBase  {

    private ApplicationManager applicationManager;

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        this.applicationManager = applicationManager;
    }

    @Test
    public void logout(){
        driver.findElement(By.linkText("Выйти")).click();
    }
    @Test
    public void login(AccountData accountData) {
        driver.findElement(By.id("Nik")).click();
        driver.findElement(By.id("Nik")).sendKeys(accountData.getLogin());
        driver.findElement(By.id("Password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("login_subm")).click();
        assertEquals("amourety", applicationManager.getDriver().findElement(By.id("author")).getText());
    }
    public void loginInvalid(User accountData) throws IOException {
        driver.findElement(By.id("Nik")).click();
        driver.findElement(By.id("Nik")).sendKeys(accountData.getEmail());
        driver.findElement(By.id("Password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("login_subm")).click();
        assertEquals(true, applicationManager.getDriver().findElement(By.className("err")).isEnabled());
    }
    public boolean isLogged() throws IOException {
        try {
            if (applicationManager.getDriver().findElement(By.id("author")).getText() != null) {
                return false;
            } else return true;
        }
        catch (Exception e){
            return true;
        }
    }
}
