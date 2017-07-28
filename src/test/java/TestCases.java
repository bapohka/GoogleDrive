import Pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Created by hillel on 28.07.17.
 */
public class TestCases extends ChromeConfig {

    @Test
    void failedLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFail();
    }

    @Test
    void failedPass() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess();
        loginPage.password_failed();
    }

    @Test
    void succesfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess();
        loginPage.password_succesful();
    }

    @Test
    void uploadFile(){

    }

    @Test
    void deleteFile(){

    }
}
