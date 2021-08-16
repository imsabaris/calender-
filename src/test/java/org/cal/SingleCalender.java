package org.cal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleCalender {
	static WebDriver driver ;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']")));


		calenderSingle("29", "February", "2022");


	}	



	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");


	}
	public static void calenderSingle(String exDate,String exMonth,String exYear) {
		System.out.println("load");
		if(exMonth.equals("February")&& (Integer.parseInt(exDate)>29)) {
			System.out.println("Wrong Date: "+exMonth+" : "+exDate);
			return; 
		}
			if(Integer.parseInt(exDate)>31) {
				System.out.println("Wrong Date: "+exMonth+" : "+exDate);
				return;
			}
			String monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(monthYearVal);
			while(!(getMonthYear(monthYearVal)[0].equals(exMonth)
					&&
					getMonthYear(monthYearVal)[1].equals(exYear))) {


				driver.findElement(By.xpath("//a[@title='Next']")).click();
				monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			}
			//driver.findElement(By.xpath("//a[text()='"+exDate+"']")).click();
			try {
			driver.findElement(By.xpath("//a[text()='"+exDate+"']")).click();
		} catch (Exception e) {
			System.out.println("Wrong Date: "+exMonth+" : "+exDate);
		}
			 		
		}

	
}
