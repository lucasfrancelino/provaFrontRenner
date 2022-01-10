@tag
Feature: Comprar produtos do site automationpractice.com 
  Como um cliente cadastrado no automationpractice.com
	Eu quero fazer a compra de ao menos três produtos
	Para que eu possa estar bem vestida
  
  @tag1
  Scenario: Comprar vestido
    Given eu pesquise o item "Printed Chiffon Dress"
    And clico no Printed Chiffon Dress
    And tamanho "M"
    And cor Verde
    When clico em add to cart
    And clico em Proceed to checkout
    And clico em Proceed to checkout seguindo para Address
    And clico em Proceed to checkout seguindo para Shopping
    And aceito os termos
    And clico em Proceed to checkout seguindo para Payment
    And escolho pagamento com check
    And confirmo minha ordem
    Then vejo a mensagem de confirmacao da compra "Your order on My Store is complete."
    
  #@tag2
  Scenario: Comprar blusa
    Given eu pesquise o item "Faded Short Sleeve T-shirts"
    And clico na Faded Short Sleeve T shirts
    And tamanho "M"
    And cor Azul
    When clico em add to cart
    And clico em Proceed to checkout
    And clico em Proceed to checkout seguindo para Address
    And clico em Proceed to checkout seguindo para Shopping
    And aceito os termos
    And clico em Proceed to checkout seguindo para Payment
    And escolho pagamento com check
    And confirmo minha ordem
    Then vejo a mensagem de confirmacao da compra "Your order on My Store is complete."
    
	Scenario: Comprar vestido noturno
    Given eu pesquise o item "Blouse"
    And clico no Blouse
    And quantidade "2"
    And tamanho "M"
    When clico em add to cart
    And clico em Proceed to checkout
    And clico em Proceed to checkout seguindo para Address
    And clico em Proceed to checkout seguindo para Shopping
    And aceito os termos
    And clico em Proceed to checkout seguindo para Payment
    And escolho pagamento com check
    And confirmo minha ordem
    Then vejo a mensagem de confirmacao da compra "Your order on My Store is complete."
