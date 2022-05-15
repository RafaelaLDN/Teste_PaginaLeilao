package br.com.alura.leilao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.leilao.login.LoginPage;


public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
    	paginaDeLogin.preencherFormularioLogin("fulano", "pass");
    	this.paginaDeLeiloes = paginaDeLogin.submitFormulario();
    	this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }
	
	
    
    @AfterEach
    public void afterEach(){
        this.paginaDeLeiloes.fechar();
    }
    
    @Test
    public void CadastrarLeilao() {    	
    	
    	String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje;
        String valor = "500.00";

        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
        
    	
    }
    
    @Test
    public void validarCadastroDeLeilaoInvalido() {
    	this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
    	
    	Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
    	Assert.assertTrue(this.paginaDeCadastro.isMsgDeValidacao());
    }
	
}