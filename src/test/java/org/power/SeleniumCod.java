package org.power;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

 
public class SeleniumCod extends DatabasCod {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipseworkspace\\Adactin\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.adactin.com/HotelApp/");

		fileBrowse("E:\\Eclipseworkspace\\Adactin\\File\\Hotel.xlsx");
		
		sheetName("orderid");
		sheetName("login");
		WebElement txtuser = driver.findElement(By.xpath("//input [@id='username']"));
		txtuser.sendKeys(getData(0, 0));

		WebElement txtpass = driver.findElement(By.xpath("//input [@id='password']"));
		txtpass.sendKeys(getData(0, 1));

		WebElement txtbtn = driver.findElement(By.xpath("//input[@id='login']"));
		txtbtn.click();
		
		WebElement location = driver.findElement(By.xpath("//select[@id='location']"));
		Select s = new Select(location);
		s.selectByIndex(5);

		WebElement hotels = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select e = new Select(hotels);
		e.selectByValue("Hotel Sunshine");

		WebElement room_type = driver.findElement(By.xpath("//select[@id='room_type']"));
		Select l = new Select(room_type);
		l.selectByVisibleText("Standard");

		WebElement room_nos = driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select f = new Select(room_nos);
		f.selectByIndex(2);

		WebElement checkin = driver.findElement(By.xpath("//input[@id='datepick_in']"));
		checkin.clear();
		checkin.sendKeys(getData(1, 3));

		WebElement checkout = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		checkout.clear();
		checkout.sendKeys(getData(1, 4));

		WebElement adult_room = driver.findElement(By.xpath("//select[@id='adult_room']"));
		Select g = new Select(adult_room);
		g.selectByValue("2");

		WebElement child_room = driver.findElement(By.xpath("//select[@id='child_room']"));
		Select h = new Select(child_room);
		h.selectByValue("2");

		WebElement Submit = driver.findElement(By.xpath("//input[@id='Submit']"));
		Submit.click();
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='radiobutton_0']"));
		radiobtn.click();

		WebElement Submit1 = driver.findElement(By.xpath("//input[@id='continue']"));
		Submit1.click();

		WebElement firstnme = driver.findElement(By.xpath("//input[@id='first_name']"));
		firstnme.sendKeys(getData(1, 5));

		WebElement lastnme = driver.findElement(By.xpath("//input[@id='last_name']"));
		lastnme.sendKeys(getData(1, 6));

		WebElement billngadrs = driver.findElement(By.xpath("//textarea[@id='address']"));
		billngadrs.sendKeys(getData(1, 7));

		WebElement cc_num = driver.findElement(By.xpath("//input[@id='cc_num']"));
		cc_num.sendKeys(getData(1, 8));
		
		WebElement cc_type = driver.findElement(By.xpath("//select[@id='cc_type']"));
		Select i = new Select(cc_type);
		i.selectByValue("MAST");
		
		WebElement cc_exp_month = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select j = new Select(cc_exp_month);
		j.selectByValue("2");
		
		WebElement cc_exp_year = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select k = new Select(cc_exp_year);
		k.selectByValue("2022");
		
		WebElement cc_cvv = driver.findElement(By.xpath("//input[@id='cc_cvv']"));
		cc_cvv.sendKeys(getData(1, 9));
		
		WebElement txtbtn1 = driver.findElement(By.xpath("//input[@id='book_now']"));
		txtbtn1.click();
		
		Thread.sleep(10000);
	 	WebElement orderid = driver.findElement(By.id("order_no"));
		String val = orderid.getAttribute("value");
		//System.out.println(val);
		
		
		getattribute(orderid, writeExcel(2, 8));
		
}
}
