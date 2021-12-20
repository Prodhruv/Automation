package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeSignup {
    public WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    public DemoBlazeSignup(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 40);
    }

    private By signupButton = new By.ById("signin2");
    private By usernameTextBox = new By.ById("sign-username");
    private By passwordTextBox = new By.ById("sign-password");
    private By submitButton = new By.ByXPath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    private By closeButton = new By.ByXPath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");


    public void clickOnSignupButton() {
        driver.findElement(signupButton).click();
    }

    public void setUsername(String strUsername) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(usernameTextBox)));
        driver.findElement(usernameTextBox).sendKeys(strUsername);

    }

    public void setPassword(String strPassword) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordTextBox)));
        driver.findElement(passwordTextBox).sendKeys(strPassword);

    }

    public void clickOnSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitButton)));
        driver.findElement(submitButton).click();
    }

    public String get_alert_msg() throws InterruptedException {

        String alert_msg = null;
        int i = 0;
        while (i++ <= 5) {
            try {
                alert = driver.switchTo().alert();
                alert_msg = alert.getText();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(4000);
                continue;
            }

        }
        return (alert_msg);
    }


    public void after_submit() throws InterruptedException {
      String alert_msg= get_alert_msg();
      if (alert_msg.equals("This user already exist."))
      {
          System.out.println("Change username");
          alert.accept();
      }
      else if (alert_msg.equals("Sign up successful."))
      {
          alert.accept();
          System.out.println(alert_msg);
          wait.until(ExpectedConditions.visibilityOf(driver.findElement(closeButton)));
          driver.findElement(closeButton).click();
      }

    }
}