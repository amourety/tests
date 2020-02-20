package tests;

import helpers.EntityHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.data.AccountData;
import helpers.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyTest extends AuthBase {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test3(){
        applicationManager.getEntityHelper().createEntity(new Data("Message"));
        assertEquals("Message", applicationManager.getDriver().findElement(By.className("dt")).getText());
    }

    @Test
    public void test7(){
        applicationManager.getEntityHelper().editEntity("Message2");
        assertEquals("Message2", applicationManager.getDriver().findElement(By.className("dt")).getText());

    }


}
