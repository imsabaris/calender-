package org.cal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CalenderDouble {
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		String exp_Month = "August 2022";
		String exp_Year = "2022";
		String exp_DatePic="32";
		WebDriverManager.chromedriver().setup();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.ca/");
		WebElement checkInBox = driver.findElement(By.id("d1-btn"));
		checkInBox.click();
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.uitk-date-picker.date-picker-menu")));
		String curMonth = driver.findElement(By.cssSelector("h2.uitk-date-picker-month-name.uitk-type-medium:nth-of-type(1)")).getText();
		System.out.println(curMonth);
		while(true) {
			curMonth = driver.findElement(By.cssSelector("h2.uitk-date-picker-month-name.uitk-type-medium:nth-of-type(1)")).getText();
			if(curMonth.equals(exp_Month)) {
				break;
			}else {
				driver.findElement(By.cssSelector("button[class*='uitk-button uitk-button-medium uitk-button-only-icon ']:nth-of-type(2)")).click();
			}
			
			
		}
		curMonth = driver.findElement(By.cssSelector("h2.uitk-date-picker-month-name.uitk-type-medium:nth-of-type(1)")).getText();
		System.out.println(curMonth);
		
		try {
			driver.findElement(By.cssSelector("button[data-day='"+exp_DatePic+"']:nth-of-type(1)")).click();
			driver.findElement(By.cssSelector("button.uitk-button.uitk-button-medium.uitk-button-has-text.uitk-button-primary.uitk-flex-item.uitk-flex-shrink-0.dialog-done")).click();
		} catch (Exception e) {
			System.out.println("Wrong Date");
		}
		
	}
	
}