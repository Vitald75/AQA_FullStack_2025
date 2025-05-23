package eu.senla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PimAddEmployeeTest extends BaseTest {

//  @DisplayName("Успешное добавление PIM employee")
//  @Test
//  @Tag("smoke")
//  @Order(1)
//  public void testPimAddEmployee() {
//
//    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    successfulLogin();
//
//    // open PIM page
//    driver.findElement(By.cssSelector("a[href$='viewPimModule']")).click();
//    driver.manage().window().maximize();
//    wait.until(
//        d ->
//            driver
//                .findElement(
//                    By.cssSelector(
//                        "button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']"))
//                .isDisplayed());
//
//    // click button Add
//    driver
//        .findElement(
//            By.cssSelector(
//                "button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']"))
//        .click();
//    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Add Employee']")).isDisplayed());
//
//    // fill form and click Save button
//    driver.findElement(By.name("firstName")).sendKeys("Alexandr");
//    driver.findElement(By.name("middleName")).sendKeys("Sergeevich");
//    driver.findElement(By.name("lastName")).sendKeys("PushyKin");
//    driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//    wait.until(d -> driver.findElement(By.xpath("//h6[text()='Alexandr PushyKin']"))).isDisplayed();
//  }
}
