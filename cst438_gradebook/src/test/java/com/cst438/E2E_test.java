package com.cst438;
 //Gradebook
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class E2E_test {
   public static final String CHROME_DRIVER_FILE_LOCATION 
                          = "C:/chromedriver.exe";
   public static final String URL = "http://localhost:3000";
   public static final String ASSIGNMENT_NAME = "ASSIGNMENT";
   public static final String ASSIGNMENT_DUE_DATE = "2021-09-03";
   public static final String ASSIGNMENT_COURSE = "cst100";
   public static final int SLEEP_DURATION = 1000; // 1 second.

   @Test
   public void add_Assignment() throws Exception
   {
      //TODO update the property name for your browser 
      System.setProperty("webdriver.chrome.driver",
                     CHROME_DRIVER_FILE_LOCATION);
      //TODO update the class ChromeDriver()  for your browser
      WebDriver driver = new ChromeDriver();
      
      WebElement we;
      try {
         driver.get(URL);
         
         Thread.sleep(SLEEP_DURATION);
         //Enter assignment name
         we = driver.findElement(By.id("assignmentName"));
         we.sendKeys(ASSIGNMENT_NAME);
         //Enter Due Date
         we = driver.findElement(By.id("dueDate"));
         we.sendKeys(ASSIGNMENT_DUE_DATE);
         //Enter Course Name
         we = driver.findElement(By.id("courseTitle"));
         we.sendKeys(ASSIGNMENT_COURSE);
         
         Thread.sleep(SLEEP_DURATION);
         
         we = driver.findElement(By.id("newAssignment"));
         we.click();
         Thread.sleep(SLEEP_DURATION);
         
         //Refreshes page
         driver.get(URL);
      }
      catch(Exception Ex){
         throw Ex;
      }
      finally
      {
         //Required, but unsure what to do with it
         Thread.sleep(SLEEP_DURATION);
      }

   }

}
