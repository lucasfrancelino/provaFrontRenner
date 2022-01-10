package lucas.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Gerenciador;
import page.Object;

public class StepDefinitions {
	
	private Object obj = new Object();

	@Given("que eu acesso a plataforma")
	public void que_eu_acesso_a_plataforma() {
		Gerenciador.getDriver().get("http://automationpractice.com/");
	}
	@Given("clico em Sign in")
	public void clico_em_sign_in() {
	    obj.clicar("//a[@class='login']");
	}
	@When("insiro meu email")
	public void insiro_meu_email() {
	    String email = obj.geradorEmail();
	    obj.digitar("//input[@id='email_create']", email);
	    obj.clicar("//button[@id='SubmitCreate']");
	    obj.esperar_elemento("//h1[contains(text(),'Create an account')]");
	}
	@When("preencho todos os campos")
	public void preencho_todos_os_campos() {
	    obj.preencherCadastro();
	}
	@Then("sou logado no sistema")
	public void sou_logado_no_sistema() {
		obj.esperar_elemento("//h1[contains(text(),'My account')]");
	}
	
	@Given("eu pesquise o item {string}")
	public void eu_pesquise_o_item(String roupa) {
	    obj.pesquisar(roupa);
	}

	@Given("clico no Printed Chiffon Dress")
	public void clico_no_printed_chiffon_dress() {
	    obj.clicar("//img[@title='Printed Chiffon Dress']");
	}
	
	@Given("clico na Faded Short Sleeve T shirts")
	public void clico_na_Faded_Short_Sleeve_T_shirts() {
		obj.clicar("//img[@title='Faded Short Sleeve T-shirts']");
	}
	
	@Given("clico no Blouse")
	public void clico_no_Blouse() {
		obj.clicar("//img[@title='Blouse']");
	}
	
	@Given("tamanho {string}")
	public void tamanho(String tamanho) {
	    obj.digitar("//select[@id='group_1']", tamanho);
	}
	@Given("cor Verde")
	public void cor_verde() {
	    obj.clicar("//a[@title='Green']");
	}
	@Given("cor Azul")
	public void cor_azul() {
	    obj.clicar("//a[@title='Blue']");
	}
	@Given("quantidade {string}")
	public void cor_azul(String quantidade) {
	    obj.quantidade(quantidade);
	}
	@When("clico em add to cart")
	public void clico_em_add_to_cart() {
	   obj.clicar("//button[@name='Submit']");
	}
	@When("clico em Proceed to checkout")
	public void clico_em_proceed_to_checkout() {
//	    obj.clicar("//a[@title='Proceed to checkout']");
		obj.esperar_elemento("//i[@class='icon-ok']");
		obj.clicar("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");
	}
	@When("clico em Proceed to checkout seguindo para Address")
	public void clico_em_proceed_to_checkout_seguindo_para_address() {
		obj.esperar_elemento("//h1[@id='cart_title']");
	    obj.clicar("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
	}
	@When("clico em Proceed to checkout seguindo para Shopping")
	public void clico_em_proceed_to_checkout_seguindo_para_shopping() {
		obj.esperar_elemento("//h1[@class='page-heading']");
		obj.clicar("/html/body/div/div[2]/div/div[3]/div/form/p/button");
	}
	@When("aceito os termos")
	public void aceito_os_termos() {
		obj.esperar_elemento("//h1[@class='page-heading']");
	    obj.clicar("//input[@type='checkbox']");
	}
	@When("clico em Proceed to checkout seguindo para Payment")
	public void clico_em_proceed_to_checkout_seguindo_para_payment() {
		obj.esperar_elemento("//h1[@class='page-heading']");
		obj.clicar("/html/body/div/div[2]/div/div[3]/div/div/form/p/button");
	}
	@When("escolho pagamento com check")
	public void escolho_pagamento_com_check() {
		obj.esperar_elemento("//h1[@class='page-heading']");
	    obj.clicar("//a[@title='Pay by check.']");
	}
	@When("confirmo minha ordem")
	public void confirmo_minha_ordem() {
		obj.esperar_elemento("//h1[@class='page-heading']");
	    obj.clicar("//span[contains(text(),'I confirm my order')]");
	}
	@Then("vejo a mensagem de confirmacao da compra {string}")
	public void vejo_a_mensagem_de_confirmacao_da_compra(String msg) {
		obj.esperar_elemento("//h1[@class='page-heading']");
	    obj.validar_mensagem("Your order on My Store is complete.", msg);
	}

}
