# HTML I

## ARPA

Redes de computadores, de origem militar. Inicialmente conectavam poucos pontos
mas com a implementação em universidades, a rede se expandiu, passando a 
conectar diversas cidades.

## Modems

Moduladores de sinais digitais, transformando-os em analógicos. Foram 
determinantes na expansão das redes de computadores. 

Com esses avanços, outras formas de envio de dados foram criadas, surgindo o 
email, ftp, etc. 

## WWW

Essa rede de computadores cresceu ainda mais, atingindo patamares mundiais com a 
criação da Word Wide Web, pelo lab do CERN, na Suíça.

## HTML

Para padronizar a comunicação e troca de informações na rede, a sugestão foi 
utilizar o que chamaram de hypertexto. Uma espécie de texto que possíbilitava a 
interação com o leitor. Nesse sentido, para manipular esse hypertexto, foi 
criada uma linguagem de marcação, chamada HTML (Hypertext Markup Language).

## O primeiro site da internet

> http://info.cern.ch

Para enviar os documentos HTML, o CERN desenvolveu um protocolo, o HTTP, e assim
possibilitou o início da criação e compartilhamento de sites na internet.

## WEB

A web é um ecossistema composto por diversas tecnologias como o HTTP, o TCP/IP,
TLS, DNS, UDP (etc).

## HTTP

Hypertext Transfer Protocol, utilizado para a comunicação na web, na 
transferência de documentos HTML. Nesse protocolo, o cliente precisa estabelecer 
um contato inicial com o servidor, chamado de handshake e após isso, o servidor 
fica disponível para as requisições do cliente.

Com e evolução da web, novas versões de HTTP foram lançadas, estando atualmente
na versão 2.0. Entre outras coisas, essa versão possui camadas de segurança, 
TLS/SSL para utilizarmos em tranferência que devem ser criptografadas.

Com essa camada o protocolo passa a ser definido como HTTPS.

## HTTPS

Assim como no HTTP, existe uma fase de conexão, chamada handshake, e após esse
primeiro momento, o servidor troca chaves de criptografia com o client afim de 
certificar-se que o destino e o remotente são seguros.

Por fim, iniciam-se a troca de mensagens. Apesar do aumento das mensagens, o 
HTTPS, utiliza o HTTP2.0, deixando a comunicação mais rápida.

## Request

- Request:

GET / HTTP/1.1
Host: developer.mozilla.org
Accept-Language: br

Essa é a parte do request que é aberta aos nós da web pelos quais passam a 
comunicação.

Os headers e o body, somente quem tiver a chave do client conseguirá ler.

Alguns tipos de request não possuirão body.

## Response 

- Response 
HTTP/1.1 200 OK
Date: Sat, 20 Oct 2010 12:22:34 GMT
Server: Apache
Last-Modified: Tue, 01 Dec 2020 21:00:21 GMT
...

Assim como no request, o headers e body serão criptografados no SSL.

## Verbos HTTP

- get: retorna a representação de um dado
- post: inclusão de novas informações
- put: aplicar modificações integrais
- patch: aplicar modificações parciais
- delete: remove uma informação
- options: retorna as operações possíveis de um recurso

## Códigos HTTP

- 1xx - informação
- 2xx - sucesso
- 3xx - redirecionamento
- 4xx - erro do cliente
- 5xx - erro no servidor

## Camadas da Internet

- aplicação: comunicação entre servidor e cliente. O mais alto nível.
- transport: TCP, o protocolo de transporte.
- network: IP, o endereçamento.
- datalink: o meio de transporte, o ethernet.
- physical: a infraestrutura de  transporte, a rodovia.

## DNS

> Domain Name Server

Para resolver endereços IP, existem os DNS's que guardam a informação de onde 
procurar determinado recurso na internet. 

Existem diversos servidores que dividem a tarefa de armazenar informações sobre
a localização de recursos na internet e cada um guarda parte dessa informação, 
exemplo:

- root name server: identifica onde é o server que guarda os .com
- top level domain name server: identifica o server que guarda informações como
*.com, ou seja, todos os recursos que pertencem ao .com
- authorative name server: indica o local onde os recursos estão, 
www.example.com.

Esses server, trabalham com cache, assim, depois de uma consulta, é possível 
armazenarem locais de informações e recursos por um determinado tempo, evitando
assim consultar repetitivas por um tempo.

## TCP

No TCP, a informação é quebrada em pacotes. Após essa etapa, os pacotes são 
enviados pela rede, priorizando rotas mais rápidas. 

Ao final, todos os pactes, ou fragmentos são agrupados novamente.

## Deep Web
 
Conteúdos da internet que não estão indexados fazem parte desse grupo. 

Na vdd, a Dark Web, é um ambiente na internet também conhecido como rede Tor.
Nesse ambiente, geralmente os nós não sabe a origem dos pacotes recebidos, 
tornando essas informações impossíveis de serem rastreadas.

## Navegadores

Responsavel por interpretar os documentos HTML utilizados para troca de 
informações na internet.

- Nexus: primeiro navegador, com alguns recursos gráficos.
- Mosaic: 
- Netscape:
- Internet Explorer
- Mozilla
- Phoenix
- Firefox 
- Chrome
- Edge
- Opera
- Safari
