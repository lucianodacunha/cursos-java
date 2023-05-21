# Maven

Notas do curso de Maven

01. [Intro](https://github.com/lucianodacunha/maven-course/tree/01-intro)
02. [Eclipse com Maven](https://github.com/lucianodacunha/maven-course/tree/02-eclipse)
03. [Repositórios: Local/Remoto](https://github.com/lucianodacunha/maven-course/tree/03-repositorios)
04. [Relatório de Qualidade](https://github.com/lucianodacunha/maven-course/tree/04-relatorio-de-qualidade)
05. [Projeto Web com Maven](https://github.com/lucianodacunha/maven-course/tree/05-projeto-web)
06. [Projeto Web: Utilizando seu Projeto como Dependência](https://github.com/lucianodacunha/maven-course/tree/06-projeto-web-2)


# 01. Maven: Intro

Ferramenta de automação de compilação.

## Instalação

- [Download](https://maven.apache.org/download.cgi)
- Instalação: 
```
$ tar -xvf apache-maven-...
# mv apache-maven-... /opt/maven3
```
- Adicione ao final do `~/.bashrc`
```
export MVN_HOME="/opt/maven3/"
export PATH="$PATH:${MVN_HOME}/bin"
```

##  Primeiro Projeto

- Forma mais simples de executar o maven:

```
mvn archetype:generate
```

Será necessário responder algumas perguntas referentes à configuração do projeto. Basicamente, será necessário definir os seguintes parâmetros:

- **artifactId**: nome do projeto.
- **groupId**: geralmente a url invertida, como é utilizada no package.
- **interactiveMode**: false/true, caso false, nada mais será perguntado.
- **archetypeArtifactId**: o archetype do projeto.
- **archetypeVersion**: a versão do archetype. Utilizando essa, evitará gerar o projeto em uma versão muito antiga do maven.

Esses parâmetros, podem ser fornecidos no momento da geração do archetype.

```
mvn archetype:generate  -DartifactId=example -DgroupId=com.company \
-DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-quickstart \
-DarchetypeVersion=1.4
```
A seguinte estrutura é gerada inicialmente:

```
example/
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── company
    │               └── App.java
    └── test
        └── java
            └── com
                └── company
                    └── AppTest.java
```

## Maven Phases

- **compile**: Compila os arquivos, gerando os .class e depositando-os em uma pasta `target`. 

Agora temos a seguinte estrutura de diretórios:

```
../example/
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── company
│   │               └── App.java
│   └── test
│       └── java
│           └── com
│               └── company
│                   └── AppTest.java
└── target
    └── classes
        └── com
            └── company
                └── App.class
```
- **test**: executa os tests existentes, gerando um relatório em `txt` no diretório `target/surefire-reports`. 

```
Test set: com.company.AppTest
-------------------------------------------------------------------------------
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.031 s - in com.company.AppTest
```

- **package**: empacota o arquivo compilado para distribuição, conforme definido previamento no `pom.xml`.

## Executando o projeto

- `.class`: Para executar um projeto que possui somente o .class, utilize o comando:

```
mvn exec:java -Dexec.mainClass="com.company.App"

```

- `.jar`: Para executar um projeto existente em um jar, utilize o comando:

```
$ java -cp app.jar com.company.App
```

Porém, caso exista alguma dependência, o jar gerado por padrão terá somente os arquivos do projeto. Para criar um .jar que inclua as dependências, também conhecido como `fat jar`, é necessário adicionar um plugin.

Exemplo de configuração do plugin.

```
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
                <archive>
                    <manifest>
                        <mainClass>com.company.App</mainClass>
                    </manifest>
                </archive>                
            </configuration>
            <executions>
                <execution>
                    <id>make-assembly</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>  
```

Com o plugin configurado, execute:

```
$ mvn clean package
$ java -cp example-1.0-SNAPSHOT-jar-with-dependencies.jar com.company.App
```

### Mais em [Maven Guide](https://maven.apache.org/guides/getting-started/index.html)

# 02. Maven: Eclipse

## Importando um projeto no Eclipse

- `File` > `Import` > `Maven` > `Existing Maven Projects` > Selecione o diretório > `Finish`

Na importação, serão criados alguns arquivos necessário para a IDE, como o `.classpath`, `.settings` e o `.project`. 

Existe a opção de criar esses arquivo utilizando o próprio Maven:

```
mvn eclipse:eclipse
```

## Adicionando uma lib
    - Acesso o [mvn repository](http://mvnrepository.com/)
    - Copie o xml de sua lib
    - Adicione no arquivo pom.xml

Exemplo: 

```xml
<dependency>
    <groupId>commons-logging</groupId>
    <artifactId>commons-logging</artifactId>
    <version>1.2</version>
</dependency>
```

### Alternativa para gerenciamento de dependências: [ivy](https://ant.apache.org/ivy/)

# 03. Repositórios: Remoto/Local

Todos os plugins baixados são mantidos em cópia e versão em um diretório local (cache).

Caso seja especificado uma nova versão no `pom.xml`, um novo download será realizado e acrescentado no cache.

```
$ tree -L 1 ~/.m2/repository/
~/.m2/repository/
├── commons-lang
├── commons-logging
├── junit
└── log4j
```
Por padrão, o maven sempre fará uma consulta remota por novas versões. Por exemplo, ao adicionar uma nova dependência:

```
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>
```

 e compilar novamente

 ```
 $ mvn compile
 ```

Novos downloads serão realizados

```
Downloading from central: https://repo.maven.apache.org/maven2/com/google/code/gson/gson/2.8.8/gson-2.8.8.pom
Downloaded from central: https://repo.maven.apache.org/maven2/com/google/code/gson/gson/2.8.8/gson-2.8.8.pom (6.0 kB at 4.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/com/google/code/gson/gson-parent/2.8.8/gson-parent-2.8.8.pom
Downloaded from central: https://repo.maven.apache.org/maven2/com/google/code/gson/gson-parent/2.8.8/gson-parent-2.8.8.pom (4.6 kB at 17 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/com/google/code/gson/gson/2.8.8/gson-2.8.8.jar
Downloaded from central: https://repo.maven.apache.org/maven2/com/google/code/gson/gson/2.8.8/gson-2.8.8.jar (242 kB at 412 kB/s)

```
## Utilizar somente o cache

Para utilizar somente fontes do cache, utilize o parâmentro `-o` (Work offline) ao executar o maven.

```
mvn -o compile
```

Caso tenha informado alguma dependência que ainda não exista no cache, o build irá falhar:

```
[INFO] BUILD FAILURE
...
[ERROR] ... Cannot access central (https://repo.maven.apache.org/maven2) in offline mode ...
```

# 04. Relatórios de qualidade

## Fases 

Existem várias fases que podem ser executadas em um build de um projeto. [São elas](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html#running-maven-tools): 

```
validate
compile
test
package
integration-test
verify
install
deploy
```

Por padrão, quando executada um fase, se existir anterior, será obrigatoriamente executada. Por exemplo, caso execute o compile, o validate será sempre executado antes.

## Plugins

Plugins podem ser adicionados ao maven, incrementando suas funcionalidades e adicionando novos recursos. Por exemplo o plugin [PMD](https://maven.apache.org/plugins/maven-pmd-plugin/).

### Goals 

- **pmd:pmd**: realiza uma análise no código e gera um relatório/site com os resultados.

```
mvn pmd:pmd
```

```
...
Rule                Violação                                        Linha
UnusedPrivateField  Avoid unused private fields such as 'idade'.    11
...
```

- **pmd:check**: falha o build se alguma violação for encontrada no código.

#### Definindo execução automática

Um goal pode ser executado automaticamente em uma determinada fase do build. Para isso, adicione sua config no `pom.xml`.

```
  <build>
    <plugins>
      <plugin> <!-- Define o plugin -->
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-pmd-plugin</artifactId>
        <version>3.10.0</version>
        <executions>
            <execution><!-- Define a fase de execução do plugin -->
                <phase>verify</phase>
                    <goals>
                        <goal>check</goal> <!-- Define o goal executado -->
                    </goals>
            </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
```

### Utilizando o plugin JaCoCo

[Esse plugin](https://www.eclemma.org/jacoco/trunk/doc/maven.html) gera um relatório da cobertura dos testes no projeto.

#### Configurando o `pom.xml`

- **Plugin**: adicione o xml do plugin

```
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.7</version>
</plugin> 
```

- **Build**: configurando goals no build ou em alguma fase do processo.

Esse plugin define os seguintes goals:

```
help
prepare-agent
prepare-agent-integration
merge
report
report-integration
report-aggregate
check
dump
instrument
restore-instrumented-classes
```

Defina um goal, utilizando o xml:

```
          <executions>
            <execution>
              <goals>
                <goal>prepare-agent</goal>
                <goal>report</goal>
              </goals>
            </execution>
          </executions>
```

Para o plugin gerar a cobertura, são necessárias duas fases: prepare-agent e report.

Desta forma, escrevemos um método e rodamos o comando `mvn verify`.

No primeiro momento, configuramos o teste para falhar, entrar a mensagem exibida no console é algo como:

```
[ERROR] There are test failures.
```

Após correção, rodamos novamente o `verify`:

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
...
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.257 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

Verificamos que os testes passaram e além disso, no diretório `target/site/jacoco/` foi criado um relatório exibindo as estatísticas dos testes realizados.

![](imgs/001-estatisticas-de-testes.png)

#### Utilizando o Eclipse

Já temos o projeto importado no Eclipse, mas com algumas alterações no cli, pode ser necessário executar um update para que aplique todas as alterações também no ambiente da IDE.

Após corrigidos eventuais falhas, é só criar os perfis de configuração do Maven no Run do Eclipse. Abaixo um exemplo de como configurar para executar um `verify` no Eclipse.

![](imgs/002-configuracao-eclipse.png)

### Atualizando dependências

- Verificar:

```
mvn versions:display-dependency-updates
```

Como todas as dependências estão _pinadas_, no caso do projeto de exemplo, foi exibido: 

```
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   com.google.code.gson:gson ............................. 2.8.0 -> 2.8.8
[INFO]   joda-time:joda-time ................................. 2.9.9 -> 2.10.12
[INFO]   junit:junit ........................................... 4.11 -> 4.13.2
```

- Verificar e Aplicar

```
mvn versions:use-latest-versions
```

```
[INFO] Major version changes allowed
[INFO] Updated junit:junit:jar:4.11 to version 4.13.2
[INFO] Updated com.google.code.gson:gson:jar:2.8.0 to version 2.8.8
[INFO] Updated joda-time:joda-time:jar:2.9.9 to version 2.10.12
```

Para verificar se tudo continua funcionando, rodamos `mvn test`:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

# 05. Criando um projeto web

Para criar um projeto web com maven, o processo é muito similar ao anterior.

```
$ mvn archetype:generate -DartifactId=webstore -DgroupId=io.dev.app.webstore \
-DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-webapp
```

A seguinte estrutura de arquivos será criada:

```
webstore/
├── pom.xml
├── src
│   └── main
│       ├── resources
│       └── webapp
│           ├── index.jsp
│           └── WEB-INF
│               └── web.xml
└── target
    └── classes
```

As mesmas opções podem ser utilizadas para criar o projeto utilizando o Eclipse.

```
Create project >> Maven >> Maven projet ...
```

## Adicionando o servidor

Agora para fazermos o deploy da aplicação em desenvolvimento, adicionamos o plugin do servidor, nesse caso, o Jetty.

```
    <plugin>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-maven-plugin</artifactId>
      <version>9.3.7.v20160115</version>
    </plugin>
```

Inicialmente, utilizaremos a configuração do Jetty na sua forma mais simples.

Para subir o servidor, execute o goal:

```
$ mvn jetty:run
```

Se tudo correr bem, seu bash ficará bloqueado com a seguinte mensagem:

```
[INFO] Started ServerConnector@95416d{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
[INFO] Started @31950ms
[INFO] Started Jetty Server
```

Para finalizar o serviço, execute `CTRL+C`.

```
[INFO] Stopped ServerConnector@95416d{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
...
[INFO] Jetty server exiting.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
...
```

## Realizando algumas correções no projeto

- **Adicionando o plugin da API Servlets**: apesar do Jetty resolver essa dependência internamente, é importante adicionarmos explicitamente o Servlet no xml para evitarmos erros no ambiente/IDE.

```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
```

- **Atualizando o web.xml**: Dentro da pasta WEB-INF, o xml existente está se referindo a uma versão antigo de Servet, atualizaremos para a versão 3.1. Substituimos todos os antigo xml:

```
<!DOCTYPE web-app PUBLIC
"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
"http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
    <display-name>Archetype Created Web Application</display-name>
</web-app>
```

pelo novos modelo:

```
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
    http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
    version="3.1">
</web-app>
```

> TODO: Reagrupar os sources folders no Eclipse.

## Criando um Servlet

Por padrão, o projeto já é criado com pelo menos um arquivo jsp na raiz do diretório webapp. Esse arquivo, apesar de ter extensão jsp, quando carregador no servidor, é convertido para um servet.

Mas vamos criar outro servlet, esse com um arquivo .java.

```
package io.dev.servlets;

// ...imports 

@WebServlet(urlPatterns={"/mensagem"}) // definindo o contexto
public class MensagemServlet extends HttpServlet { // extendendo HttpServlet
    @Override // sobrescrevendo o métod doGet
    protected void doGet(
        HttpServletRequest req,
        HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter(); // recuperando o writer da resposta
        out.println("<h1 style='color: red;'>Hello Servlets</h1>");
        out.close();
    }    
}
```

Reiniciando o servidor e acessando o endereço `localhost:8080/mensagem` podemos ver a saída html.

## Alterando o contexto

Adicionando mais uma configuração no `pom.xml`, podemos alterar o contexto do nosso Servlet.

```
  <configuration>
    <scanIntervalSeconds>10</scanIntervalSeconds>
        <webApp>
            <contextPath>/store</contextPath>
        </webApp>
    </configuration>
```

Com isso, a url mudou para `http://localhost:8080/store/mensagem`.

# 06. Projeto Web (Continuação)

## Importando o projeto no Eclipse

- **Definindo a versão do Java**:

Ao importar o projeto maven no Eclipse, alguns erros de JDK podem ser exibidos.

Para evitá-los e ser mais explícito sobre qual versão utilizar, adicione essa property no `pom.xml`.

```
    <properties>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
    </properties>
```

Outro forma de definir qual versão do Java desejada, é utilizar o plugin [compiler](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html).

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>11</source>
        <target>11</target>
    </configuration>
</plugin>
```

- **Configurando os sources**:

Dependendo do projeto importado, os sources podem não estar configurados.

![](imgs/006-001-project-explorer.png)

Nesse caso, é possível e recomendado configurá-los seguindo o padrão utilizado em projetos Maven.

![](imgs/006-002-project-explorer.png)

Para isso, acesse no package explorer, as propriedades do projeto:

```
Build Path > Configure Build Path 
```

![](imgs/006-001-config-build-path-sources.png)

## Exportando para `.war`

Para compartilharmos esse projeto web ou fazemos o deploy em alguns servidor, o mais utilizado é exportar o projeto para um arquivo format `.war`.

Esse formato, basicamente é a compactação de todos os arquivos do projeto em um `.zip`, porém com a extensão `war`.

No Eclipse, acesse no package explorer as propriedades do projeto:

```
Export > War File
```

O arquivo será gerado na pasta `target/`. Por padrão o nome do arquivo será o mesmo que definido em `artifactId`. Caso deseje gerar o arquivo final com outro nome, poderá ser utilizada a tag:

```
<finalName>webstore</finalName> 
```

na seção `build` do pom.xml.

### Verificando o conteúdo do `.war`

```
$ unzip -l webstore.war 
Archive:  webstore.war
  Length      Date    Time    Name
---------  ---------- -----   ----
        0  2021-10-03 14:36   META-INF/
      130  2021-10-03 14:36   META-INF/MANIFEST.MF
        0  2021-10-03 14:36   WEB-INF/
        0  2021-10-03 14:36   WEB-INF/classes/
        0  2021-10-03 14:36   WEB-INF/classes/io/
        0  2021-10-03 14:36   WEB-INF/classes/io/dev/
        0  2021-10-03 14:36   WEB-INF/classes/io/dev/servlets/
        0  2021-10-03 14:36   WEB-INF/lib/
      642  2021-10-02 18:22   index.jsp
     1081  2021-10-03 14:36   WEB-INF/classes/io/dev/servlets/MensagemServlet.class
      255  2021-10-02 18:56   WEB-INF/web.xml
   176285  2021-10-01 17:00   WEB-INF/lib/automaton-1.11-8.jar
  1295981  2021-10-01 17:00   WEB-INF/lib/javafaker-1.0.2.jar
   296616  2021-10-01 17:00   WEB-INF/lib/snakeyaml-1.23-android.jar
    14395  2021-10-01 17:00   WEB-INF/lib/generex-1.0.2.jar
   479881  2021-10-01 17:00   WEB-INF/lib/commons-lang3-3.5.jar
   138416  2021-10-03 14:22   WEB-INF/lib/caelum-stella-core-2.1.5.jar
        0  2021-10-03 14:36   META-INF/maven/
        0  2021-10-03 14:36   META-INF/maven/io.dev.app.webstore/
        0  2021-10-03 14:36   META-INF/maven/io.dev.app.webstore/webstore/
     1610  2021-10-03 14:36   META-INF/maven/io.dev.app.webstore/webstore/pom.xml
      119  2021-10-03 14:36   META-INF/maven/io.dev.app.webstore/webstore/pom.properties
---------                     -------
  2405411                     22 files
```

Veja que o pacote contém todos os arquivos do projeto, inclusive as dependências. Isso porque no `pom.xml` quando adicionada uma dependência, por padrão seu escopo será definido _compile_.

> Esse escopo faz com que a dependência esteja disponível para compilação para quem depender dela. Por exemplo, se iremos realizar um deploy no servidor de aplicação, precisaremos das dependências do projeto, e graças ao compile elas estarão disponíveis para compilação em tempo de execução.

Lembrando que o _junit_ não foi adicionado ao pacote, pois seu escopo estava definido como _test_.

```
...
<groupId>junit</groupId>
<artifactId>junit</artifactId>
...
<scope>test</scope>
...
```

### Outros escopos

- Provided
- Runtime
- Test
- System
- Import

## Adicionando projetos como dependências

Podemos adicionar nossos próprios projetos como dependência no xml. Para isso, basta utilizar as configurações definidas no xml do projeto.

No exemplo abaixo, vamos adicionar o projeto `example`, já existente.

```
<dependency>
    <groupId>io.dev.app</groupId>
    <artifactId>example</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

A partir daí, o projeto já é exibido no project explorer, como dependência, para o WebStore.

![](imgs/006-003-dependency-example.png)

Desta forma, já podemos utilizar o projeto `example` no código do projeto `webstore`. Porém, nesse ponto, ainda não podemos criar o pacote da aplicação web.

Por enquanto, o projeto web ainda está utilizando como dependência o projeto da aplicação `example`. Para utilizarmos `example` como dependência e exportar o arquivo .war, precisar instalar o .jar do projeto example no repositório local do Maven.

Desta forma, no projeto exemplo, geramos o jar com o comando:

```
$ mvn package install
```

O jar será instalado no repositório local:

```
[INFO] Installing .../example/target/example-1.0-SNAPSHOT.jar to ~/.m2/repository/io/dev/app/example/1.0-SNAPSHOT/example-1.0-SNAPSHOT.jar
[INFO] Installing .../example/pom.xml to ~/.m2/repository/io/dev/app/example/1.0-SNAPSHOT/example-1.0-SNAPSHOT.pom
[INFO] Installing .../example/target/example-1.0-SNAPSHOT-jar-with-dependencies.jar to ~/.m2/repository/io/dev/app/example/1.0-SNAPSHOT/example-1.0-SNAPSHOT-jar-with-dependencies.jar

```
Agora podemos adicionar o .jar como dependência no projeto web. Para isso, remova o projeto example do Eclipse (ou apenas feche-o) e atualize o pom.xml.

Olhando nas dependência do Maven, verá que o `example-1.0-SNAPSHOT.jar` foi adicionado.

![](imgs/006-004-dependency-example.png)

### Verificando o repositório local

Verificando o log de instalação da dependência example, vemos que o jar foi instalado em `~/.m2/repository`. Vamos listar o jar existente lá:

```
unzip -l example-1.0-SNAPSHOT.jar 
Archive:  example-1.0-SNAPSHOT.jar
  Length      Date    Time    Name
---------  ---------- -----   ----
        0  2021-10-03 15:59   META-INF/
      133  2021-10-03 15:59   META-INF/MANIFEST.MF
        0  2021-10-03 15:59   io/
        0  2021-10-03 15:59   io/dev/
        0  2021-10-03 15:59   io/dev/app/
        0  2021-10-03 15:59   io/dev/model/
      601  2021-10-03 15:59   io/dev/app/App.class
     2141  2021-10-03 15:59   io/dev/model/Pessoa.class
        0  2021-10-03 15:59   META-INF/maven/
        0  2021-10-03 15:59   META-INF/maven/io.dev.app/
        0  2021-10-03 15:59   META-INF/maven/io.dev.app/example/
     3546  2021-10-03 15:55   META-INF/maven/io.dev.app/example/pom.xml
      109  2021-10-03 15:59   META-INF/maven/io.dev.app/example/pom.properties
---------                     -------
     6530                     13 files
```

Perceba que a dependência `com.github.javafaker`, utilizada no projeto example não aparece na lista de arquivos. 

Porém quando subimos o servidor Jetty, a aplicação web funciona normalmente. Isso se deve ao fato de que a dependência do `javafaker` existe no pom.xml de example e desta forma, ela é adicionada na árvore no projeto final, como dependência de example.

![](imgs/006-005-dependency-tree.png)

É possível também visualizar a árvore de dependências utilizando o cli do Maven com o comando { }

```
[INFO] io.dev.app.webstore:webstore:war:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:3.8.1:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] +- br.com.caelum.stella:caelum-stella-core:jar:2.1.5:compile
[INFO] \- io.dev.app:example:jar:1.0-SNAPSHOT:compile
[INFO]    +- com.github.javafaker:javafaker:jar:1.0.2:compile
[INFO]    |  +- org.apache.commons:commons-lang3:jar:3.5:compile
[INFO]    |  +- org.yaml:snakeyaml:jar:android:1.23:compile
[INFO]    |  \- com.github.mifmif:generex:jar:1.0.2:compile
[INFO]    |     \- dk.brics.automaton:automaton:jar:1.11-8:compile
[INFO]    +- commons-logging:commons-logging:jar:1.2:compile
[INFO]    \- joda-time:joda-time:jar:2.10.12:compile
```
