package Falabella.test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.JavascriptExecutor;
import utility.metodos;

public class TestAutomation {
	
	
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sodimac.cl");
	}

	// Ingreso y flujo exitoso
	@Test 
	public void TestExitoso() {
		metodos.waitSeconds(1);
	    WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-med-search-bar-SearchBar-79247401-c89a-4b16-9d3c-f91206c21c2c-desktop\"]/input"));
		searchBox.clear();
		searchBox.sendKeys("pintura blanca"+ Keys.ENTER);
		metodos.waitSeconds(5);
	
		driver.findElement(By.xpath("//img[@id='1214012']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		String actualString = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/div/div")).getText();
		assertTrue(actualString.contains("$17.890"));
		metodos.waitSeconds(2);}

	// Ingreso y flujo NO exitoso
	@Test
	public void TestNoExitoso() {
		
		metodos.waitSeconds(1);
	    WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-med-search-bar-SearchBar-79247401-c89a-4b16-9d3c-f91206c21c2c-desktop\"]/input"));
		searchBox.clear();
		searchBox.sendKeys("pintura blanca"+ Keys.ENTER);
		metodos.waitSeconds(2);
	
		driver.findElement(By.xpath("//img[@id='1214012']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		String actualString = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/div/div")).getText();
		assertTrue(actualString.contains("$20.890"));	
		metodos.waitSeconds(2);}

	
	@After
	public void tearDown() {
		driver.quit();
	}

}