package tests;



import helpers.ApplicationManager;
import helpers.data.AccountData;
import helpers.data.Settings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class AuthBase extends TestBase {

    @BeforeEach
    public void setUp(){
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().openPage();
    }

    @BeforeAll
    static void beforeAll() throws IOException {

        ApplicationManager applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().openPage();
        applicationManager.getLoginHelper().login(new AccountData(Settings.getUserSetting().getEmail(), Settings.getUserSetting().getPassword()));
    }

    @AfterAll
    static void afterAll() {
        ApplicationManager applicationManager = ApplicationManager.getInstance();
        applicationManager.getLoginHelper().logout();
    }

}