package helpers;

import helpers.data.Data;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class EntityHelper extends HelperBase {

    private ApplicationManager applicationManager;

    public EntityHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        this.applicationManager = applicationManager;
    }

    @Test
    public void editEntity(String string){
        driver.findElement(By.linkText("Все записи")).click();
        driver.findElement(By.linkText("Править")).click();
        driver.findElement(By.id("DiText")).click();
        driver.findElement(By.id("DiText")).clear();
        driver.findElement(By.id("DiText")).sendKeys(string);
        driver.findElement(By.id("btn_save")).click();
    }

    @Test
    public void createEntity(Data data){
        driver.findElement(By.id("DiText")).click();
        driver.findElement(By.id("DiText")).sendKeys(data.getData());
        driver.findElement(By.id("btn_save")).click();
    }

}
