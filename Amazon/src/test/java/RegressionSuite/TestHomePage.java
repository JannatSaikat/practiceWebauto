package RegressionSuite;

import org.testng.annotations.Test;
import regression.HomePage;

public class TestHomePage extends HomePage {

    @Test
    public void user1(){
        signIn("daljeet", "password1");
    }
}
