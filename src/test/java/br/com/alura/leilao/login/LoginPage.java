package br.com.alura.leilao.login;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


import br.com.alura.leilao.LeiloesPage;
import br.com.alura.leilao.PageObject;

public class LoginPage extends PageObject {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	
		
	public LoginPage() {	
				
	        super(null);
	        this.browser.navigate().to(URL_LOGIN);
	        browser.manage().window().maximize();
	        
	    }

	public void preencherFormularioLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
	}

	public LeiloesPage submitFormulario() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
		
	}
	public void preencherFormularioLoginInvalido(String username, String password) {
		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("123456");
	}	
	
	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	public String getUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-fulano")).getText();
		} catch (NoSuchElementException e) {
			return null;
			 
		}
	}

	public void validarPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
		
	}

	public boolean contemTexto(String Texto) {
		return browser.getPageSource().contains(Texto);
	}

	public boolean isPaginaDeLoginError() {
		return browser.getCurrentUrl().equals("http://localhost:8080/login?error");
	}

  }

