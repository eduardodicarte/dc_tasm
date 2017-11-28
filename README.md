SeleniumMantisAPI
=================

#TableView-

TableView dsjfioskdfjidsrj Demo!

<br>
  <img height="700" src="https://raw.githubusercontent.com/djstava/PostsCollection/master/images/mac/swift_from_scratch_1/UITableView_01.png" />
</br>

API para desenvolvimento de testes automatizados, servindo de ferramenta para o serviço de integração contínua

Instruções para montagem de ambiente

Os projetos foram feitos para serem utilizados juntamente com o Maven

1 - baixe os seguintes projetos:

  1.1 - seleniumMantisEJB
  1.2 - seleniumMantisVIEW
  1.3 - seleniumMantisPARENT
  
2 - crie um novo projeto maven com o nome de seleniumMantisEAR e copie o arquivo pom_ear.xml existente no projeto 
seleniumMantisPARENT. 

3 - Adicione como módulos os projetos seleniumMantisEJB e seleniumMantisVIEW.

4 - Compile o projeto seleniumMantisPARENT, ele se encarregará de compilar o restante dos projetos na sua devida ordem.

5 - Inclua um server application, o projeto foi desenvolvido para ser executado com o JBOSS.


Para dúvidas, informações ou sugestões entre em contato pelo email git.dicarte@yahoo.com.br
