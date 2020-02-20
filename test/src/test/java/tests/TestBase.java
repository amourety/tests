package tests;

import helpers.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

  protected ApplicationManager applicationManager;

  @BeforeEach
  public void setUp(){
      applicationManager = ApplicationManager.getInstance();
  }

  @AfterAll
  public static void destroy() {
    ApplicationManager.getInstance().stop();
  }
}
