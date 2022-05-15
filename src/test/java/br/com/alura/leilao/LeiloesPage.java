package br.com.alura.leilao;


import org.openqa.selenium.WebDriver;



public class LeiloesPage extends PageObject{

	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	
	
	
	public LeiloesPage(WebDriver browser) {		
	      
	        super (browser);	
	        browser.manage().window().maximize();
	        
	    }

	public void fechar() {
		this.browser.quit();
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILOES);
		return new CadastroLeilaoPage(browser);
		
	}

	

	
  }

