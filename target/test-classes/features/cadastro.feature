Feature: Cadastro de um novo usuario
  Como um consumidor
  Eu quero me cadastrar em uma plataforma de compras
  Para que eu possa acessar e comprar o que eu quero

  Scenario: Cadastro
    Given que eu acesso a plataforma
    And clico em Sign in
    When insiro meu email
    And preencho todos os campos
    Then sou logado no sistema
