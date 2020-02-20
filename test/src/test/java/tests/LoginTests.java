package tests;

import generator.User;
import helpers.ApplicationManager;
import helpers.data.AccountData;
import helpers.data.Settings;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends TestBase {

    @Test
    @Order(1)
    public void testLoginValidData() throws InterruptedException, IOException {
        ApplicationManager applicationManager = ApplicationManager.getInstance();
        if (!applicationManager.getLoginHelper().isLogged())
            return;
        applicationManager.getNavigationHelper().openPage();
        System.out.println(1);
        applicationManager.getLoginHelper().login(new AccountData(Settings.getUserSetting().getEmail(), Settings.getUserSetting().getPassword()));
        applicationManager.getLoginHelper().logout();
    }

    @Test
    @Order(2)
    public void testLoginInvalidData() throws InterruptedException, IOException {
        ApplicationManager applicationManager = ApplicationManager.getInstance();
        if (!applicationManager.getLoginHelper().isLogged())
            return;
        applicationManager.getNavigationHelper().openPage();
        System.out.println(2);
        User user = new User("AAAAAAAAAA", "AAAAAAAAA");
        applicationManager.getLoginHelper().loginInvalid(user);
    }

}