package regression;

import base.CommonApi;
import org.openqa.selenium.By;

public class HomePage extends CommonApi {

    public void clickAccount(String URL){
        driver.get(URL);
    }

    public void clickSignIn(){
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).click();
    }

    public void sendUsername(String username) {
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).sendKeys(username);
    }

    public void writePass(String pass) {
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(pass);
        //pass
        //parameterize
    }
    public void submit(){
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }

    public void signIn(String userName, String password){

        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }

}
