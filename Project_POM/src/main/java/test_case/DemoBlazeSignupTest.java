package test_case;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.zeromq.ZThread;
import pages.DemoBlazeSignup;
import test_case.SingletonDriver;
public class DemoBlazeSignupTest
 {

  @Test
  public static void main(String[] args) throws InterruptedException {
   SingletonDriver sd = SingletonDriver.getInstanceOfSingletonDriver();
   WebDriver driver= sd.getDriver();

   DemoBlazeSignup signup_page = new DemoBlazeSignup(driver);
   Thread.sleep(5000);
   signup_page.clickOnSignupButton();
   signup_page.setUsername("Dhruv31");
   signup_page.setPassword("Yadav@123");
   signup_page.clickOnSubmitButton();
   signup_page.after_submit();

  }
 }
