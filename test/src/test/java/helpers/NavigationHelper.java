package helpers;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.Dimension;


public class NavigationHelper extends HelperBase {
    private ApplicationManager applicationManager;

    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        this.applicationManager = applicationManager;
    }

    @Test
    public void openPage() {
        driver.get("https://diary.anek.ws/");
        driver.manage().window().setSize(new Dimension(1053, 807));
    }
}
