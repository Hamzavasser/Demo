package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.AddUser;
import pages.HomePage;
import pages.Login;

public class DemoSiteTest {
	
	static WebDriver driver;

	
	
	@BeforeClass 
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(HomePage.getUrl());
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	
		
	}
	
	@Test
	public void test() throws InterruptedException {
		final String userName = "mike";
		final String passWord = "Williams";
		HomePage nav = PageFactory.initElements(driver, HomePage.class);
		nav.addAUser();
		AddUser use = PageFactory.initElements(driver, AddUser.class);
		use.uName(userName, passWord);
		Thread.sleep(3000);
		nav.navLogin();
		Login log = PageFactory.initElements(driver, Login.class);
		log.login(userName, passWord);
		assertEquals("**Successful Login**", driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")).getText());
		
		
	}

}
