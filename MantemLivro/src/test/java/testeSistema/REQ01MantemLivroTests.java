package testeSistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ01MantemLivroTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@BeforeEach
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://ts-scel-web.herokuapp.com/login");
	driver.manage().window().maximize();
	js = (JavascriptExecutor) driver;
	vars = new HashMap<String, Object>();
	}
	@AfterEach
	public void tearDown() {
	driver.quit();
	}
	   @Test
	    public void cadastrarlivro() {
	      driver.get("https://ts-scel-web.herokuapp.com/login");
	      //driver.manage().window().setSize(new Dimension(1344, 665));
	      driver.findElement(By.name("username")).click();
	      driver.findElement(By.name("username")).sendKeys("jose");
	      driver.findElement(By.name("password")).sendKeys("123");
	      driver.findElement(By.cssSelector("button")).click();
	      driver.findElement(By.linkText("Livros")).click();
	      espera();
	      driver.findElement(By.id("isbn")).click();
	      driver.findElement(By.id("isbn")).sendKeys("1234");
	      driver.findElement(By.id("autor")).click();
	      driver.findElement(By.id("autor")).sendKeys("Ana Cunha");
	      driver.findElement(By.id("titulo")).click();
	      driver.findElement(By.id("titulo")).sendKeys("Especialista em Marketing");
	      driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	      espera();
  
	    // consultar livro
  driver.findElement(By.linkText("Voltar")).click();
  driver.findElement(By.linkText("Livros")).click();
  driver.findElement(By.linkText("Lista de Livros")).click();
  espera();
    
   //alterarlivro
    	
    driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
    driver.findElement(By.id("titulo")).click();
    driver.findElement(By.id("titulo")).sendKeys(" Digital");
    driver.findElement(By.cssSelector(".btn")).click();
    espera();
       
 
 //excluirlivro
 driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
 espera();
 driver.findElement(By.linkText("Voltar")).click();
 driver.findElement(By.linkText("Livros")).click();
 driver.findElement(By.linkText("Lista de Livros")).click();
 espera();
 }
    
  public void espera() {
	  try {
	  Thread.sleep(8000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
}