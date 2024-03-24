package Tasks2;


import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task3 extends Tests{

        private SoftAssert softAssert;
        @Test
        public void testInvalidPassword() {
            bot.navigate("https://practicetestautomation.com/practice-test-login/");
            By usernameField = By.name("username");
            By passwordField = By.name("password");
            By submitButton = By.id("submit");

            JSONObject testCaseData = (JSONObject) testData.get("Assignment3Data");
            bot.type(usernameField, (String) testCaseData.get("Username"));
            bot.type(passwordField, (String) testCaseData.get("Password"));
            bot.click(submitButton);

            softAssert = new SoftAssert();
            By errorMessage = By.id("error");
            softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed(),"Error message is not displayed");
            softAssert.assertEquals(driver.findElement(errorMessage).getText(), "Your password is invalid!", "Error message is incorrect");
            softAssert.assertAll();
        }

    }


