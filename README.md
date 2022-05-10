# Frete Pessoal

> O projeto consiste em uma plataforma / aplicativo onde os usuários possam tanto inserir produtos que desejam enviar a um determinado destino, quanto visualizar os produtos disponíveis na cidade onde estão e para onde precisam ser levados.

## Justificativa Técnica

O transporte de produtos entre diferentes localidades do território brasileiro é um serviço que possui um valor elevado para a maior parte da população. O Correios é órgão responsável pelo sistema de logística de encomendas de qualquer natureza dentro da extensão territorial brasileira, e é alvo de constantes críticas de seus usuários, além do preço elevado já citado, outros fatores são responsáveis pela insatisfação destes serviços oferecidos, podendo citar a demora na entrega das encomendas, constantes casos de perdas e extravios das mercadorias transportadas, descaso com a qualidade do serviço por parte dos funcionários, entre outros. Existem também serviços de empresas particulares, onde fazem entregas com maior velocidade e a um menor preço, porém, são suscetíveis a diversas fraudes, prejudicando não só as pessoas que fazem seu uso, como também sua própria imagem e qualidade do que prometem cumprir.

## Objetivo Geral

Fornecer uma alternativa de transporte de mercadorias de pequeno porte de forma mais rápida e econômica.

## Objetivo Específico

Analisar as formas de transporte de cargas no Brasil
Verificar a viabilidade de pessoas transportarem objetos de outras e serem remuneradas
Criar uma plataforma para o usuário poder enviar, receber, e transportar objetos
Criar um sistema de gerenciamento do transporte desses objetos

## Ferramenta de Desenvolvimento

# Spring Boot

    O Spring Boot traz a ideia de convenção em vez de configuração, e, para fazer jus a essa frase, a própria plataforma Spring disponibilizou a ferramenta Spring Initializr, que possibilita à pessoa desenvolvedora ter toda a configuração inicial de um projeto Spring com alguns cliques.
A função do Spring Boot no projeto será criar uma aplicação REST gerenciar os dados de usuários, de viagens, encomendas e preços. Ele se comunicará com um Banco de Dados Mysql para obter os dados. E disponibilizará urls para os aplicativos web e mobile, contendo os serviços disponibilizados, tais como, registro de encomenda, obtenção de encomenda, entrega de encomenda, detalhes de usuários, etc.

## Histórico de lançamentos

* 0.0.1
  * Primeira interação do projeto

## Contributing

1. Faça o _fork_ do projeto (<https://github.com/yagomarialva/FretePessoalBackend>)
2. Crie uma _branch_ para sua modificação (`git checkout -b feature/fooBar`)
3. Faça o _commit_ (`git commit -am 'Add some fooBar'`)
4. _Push_ (`git push origin feature/fooBar`)
5. Crie um novo _Pull Request_

