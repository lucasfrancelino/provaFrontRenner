package page;

import java.util.Locale;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class Object {
	
	Faker faker = new Faker();
	Faker usFaker = new Faker(new Locale("en-US"));
	public WebDriverWait wait;
	
	public void clicar(String elemento) {
		try {
			Gerenciador.getDriver().findElement(By.id(elemento)).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Gerenciador.getDriver().findElement(By.xpath(elemento)).click();
		}
	}
	
	public String geradorEmail() {
		return faker.internet().safeEmailAddress();
	}
	
	public void digitar(String elemento, String texto) {
		try {
			Gerenciador.getDriver().findElement(By.id(elemento)).sendKeys(texto);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Gerenciador.getDriver().findElement(By.xpath(elemento)).sendKeys(texto);
		}
	}
	
	public void esperar_elemento(String elemento) {
        wait = new WebDriverWait(Gerenciador.getDriver(), 10); 
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemento)));  
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento))); 
        }
    }
	
	public String recuperar_texto_elemento(String elemento) {
        wait = new WebDriverWait(Gerenciador.getDriver(), 5); 
        try {
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemento))).getText();
            return texto;
        } catch (Exception e) {
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento))).getText();
            return texto;
        }
    }
	
	public void preencherCadastro() {
		clicar("//input[@id='id_gender1']");
		digitar("//input[@id='customer_firstname']", "Lucas");
		digitar("//input[@id='customer_lastname']", "Test");
		digitar("//input[@id='passwd']", "1123456");
		clicar("//select[@id='days']");
		digitar("//select[@id='days']", "10");
		clicar("//select[@id='months']");
		digitar("//select[@id='months']", "January");
		clicar("//select[@id='years']");
		digitar("//select[@id='years']", "2000");
		digitar("//input[@id='address1']", "501 Hall Rd");
		digitar("//input[@id='city']", "Alabama(AL)");
		digitar("//select[@id='id_state']", "Alabama");
		digitar("//input[@id='postcode']", "36033");
		digitar("//input[@id='phone']", "(334) 376-9963");
		digitar("//input[@id='phone_mobile']", "(334) 376-9963");
		digitar("//input[@id='alias']", " Rua João Pessoa");
		clicar("//button[@id='submitAccount']");
	}
	
	public void pesquisar(String roupa) {
		WebElement elemento = Gerenciador.getDriver().findElement(By.xpath("//input[@id='search_query_top']"));
		elemento.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);
		digitar("//input[@id='search_query_top']", roupa);
		clicar("//button[@class='btn btn-default button-search']");
	}
	
	public void validar_mensagem(String texto_esperado, String texto) {
        Assert.assertEquals(texto_esperado, texto);    
    }
	
	public void quantidade(String quantidade) {
		WebElement elemento = Gerenciador.getDriver().findElement(By.xpath("//input[@id='quantity_wanted']"));
		elemento.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);
		digitar("//input[@id='quantity_wanted']", quantidade);
	}

}
