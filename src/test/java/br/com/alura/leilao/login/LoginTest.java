package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
    public void BeforeEach(){
        this.paginaDeLogin = new LoginPage();
    }
    
    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }
	
    //Teste com login valido
	@Test
	public void efetuarLoginDadosValidos() {
		
		paginaDeLogin.preencherFormularioLogin("fulano", "pass");
		paginaDeLogin.submitFormulario();
		
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getUsuarioLogado());
		
	}
	
	//Teste com login invalido
	@Test
	public void LogarComDadosInvalidos(){
		paginaDeLogin.preencherFormularioLoginInvalido("invalido", "123456");
		paginaDeLogin.submitFormulario();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginError());
		Assert.assertNull(paginaDeLogin.getUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
		
	}
	
	@Test
	public void naoAcessarPaginaRestritaSemLogar() {
		paginaDeLogin.validarPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
	    Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
		
	}
	

}
