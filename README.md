## Projeto para gestão de senhas de atendimento bancário.
---

Projeto desenvolvido com SpringBoot + Angular. 

O backend armazena as senhas geradas __em memória__.

### Como executar:

Na pasta backend execute:

`./mvnw spring-boot:run`

Na pasta frontend execute:

`npm start` ou `yarn start` ou `ng serve`

Acesse a url: `localhost:4200` em seu navegador.

### Melhorias

* Atualizar o backend para utilizar uma base de dados.
* Tornar responsabilidade do backend o controle das ultimas senhas chamadas, de forma que todas as instâncias saibam quais as ultimas senhas.
* Adicionar segurança :)