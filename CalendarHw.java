package hwCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CalendarHw {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();

        driver.findElement(By.name("leaveList[calFromDate]")).click();
        WebElement month= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth=new Select(month);
        selectMonth.selectByIndex(2);
        WebElement year= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear=new Select(year);
        selectYear.selectByVisibleText("1992");
        List<WebElement> days= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement day:days)
            if (day.getText().equals("18")){
                day.click();
                break;
            }
        }





    }

