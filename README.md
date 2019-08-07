# Projeto PDCase

Para executar comandos SQL no banco, rode o seguinte comando:
$ java -jar /pasta_do_wildfly/modules/system/layers/base/com/h2database/h2/main/h2-1.4.193.jar


Isto vai abrir uma aba no browser. Lá, aponte a seguinte url JDBC:

jdbc:h2:/pasta_sistema-backend/src/main/resources/db/h2-db;AUTO_SERVER=TRUE



Servidor utilizado: WildFly 13
Banco de dados: H2 SQL

## Instruções para execuação do projeto:


### Backend

 Configurar conexão para o wildfly:
 Iniciar o wildfly (sem fazer ainda o deploy do projeto) e abrir o console em localhost:9990
Caso ainda não tenha configurado um usuário para acessar o console, execute o comando /pasta_do_wildfly/bin/add-user.sh - no linux - ou /pasta_do_wildfly/bin/add-user.bat - no windows.
Acesse configuration->subsystems->datasources and drivers->datasources e clique no botão "add datasource".
Na próxima tela, escolha "h2" e clique em "next". Então mude o "jndi name" para "
java:/h2".
Use a url jdbc "jdbc:h2:/pasta_sistema-backend/src/main/resources/db/h2-db;AUTO_SERVER=TRUE

Não se esqueça de substituir "pasta_sistema-backend" para o diretório completo onde tenha baixado o projeto. As outras propriedades podem ser as padrões (usuário "sa" e sem utilizar senha).

O console pedirá para reiniciar. Após isto, já pode ser realizado o deploy do projeto.


### Frontend
	Abrir um terminal (dos, shell, etc.) na raiz do projeto sistema-frontend e executar o comando: npm start. O browser deverá acessar o link: localhost:4200.

### Diagramas do projeto (ER, UC, UML): 
	Disponíveis nos arquivos: diagrama-casos-de-uso.png, diagrama-er.png, diagrama-classe.png
