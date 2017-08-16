package Pages;

import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by hillel on 28.07.17.
 */
public class LoginPage extends Tools{
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private String FIRST_URL = "https://drive.google.com/drive/my-drive";
//email
    private String EMAIL_SUCCESS = "testusermail2017@gmail.com";
    private String EMAIL_FAIL = "fdsfd@fdsfazazazazazads2@gmail.com";
    private By email_field = By.cssSelector("div>input[type='email']");
    private String email_failed = "input[type='password'][name='hiddenPassword']";
//password
    private By password_field = By.cssSelector("input[type='password'][name='password']");
    private String PASS_SUCCESS = "Password11";
    private String PASS_FAIL = "asaasdfasd";
//button
    private By emailIn = By.cssSelector("div#identifierNext");
    //private By emailIn = By.id("identifierNext");
    private By passwordIn = By.cssSelector("div#passwordNext");

//check element
        boolean doesElementExists(String selector) {
            try {
                driver.findElement(By.cssSelector(selector));
                return true;
            }
            catch (NoSuchElementException e) {
                return false;
            }
        }


    private void doLogin(String mail){
        driver.navigate().to(FIRST_URL);
        driver.findElement(email_field).sendKeys(mail);
        driver.findElement(emailIn).click();
    }
    private void doContinuePassword(String pass){
        driver.findElement(password_field).sendKeys(pass);
        driver.findElement(passwordIn).click();
    }

    public void loginFail(){
        doLogin(EMAIL_FAIL);
        Assert.assertTrue(doesElementExists(email_failed));
    }

    public void loginSuccess(){
        doLogin(EMAIL_SUCCESS);
        Assert.assertTrue(doesElementExists("input[type='password'][name='password']"));
    }

    public void password_failed(){
        doContinuePassword(PASS_FAIL);
        Assert.assertTrue(doesElementExists("input[type='password'][name='password']"));
    }

    public void password_succesful(){
        doContinuePassword(PASS_SUCCESS);
        Assert.assertFalse(doesElementExists("input[type='password'][name='password']"));
    }
}
