<h1>SecurityDemo</h1>
<p>
<img src="https://camo.githubusercontent.com/57cec1c01287dfdc2a3fe64954936293c761b7fa9a7fc1b9de3916a295f15170/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465" alt="Java" data-canonical-src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&amp;logo=openjdk&amp;logoColor=white" style="max-width: 100%;">
<img src="https://camo.githubusercontent.com/49f645b5e439b0d748424412207eae5748b81d77563f866d8528f60c66b669e1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465" alt="Spring" data-canonical-src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&amp;logo=spring&amp;logoColor=white" style="max-width: 100%;">
<img src="https://camo.githubusercontent.com/29e7fc6c62f61f432d3852fbfa4190ff07f397ca3bde27a8196bcd5beae3ff77/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706f7374677265732d2532333331363139322e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d706f737467726573716c266c6f676f436f6c6f723d7768697465" alt="Postgres" data-canonical-src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&amp;logo=postgresql&amp;logoColor=white" style="max-width: 100%;">
<img src="https://camo.githubusercontent.com/4590c0af4aeb1b75233885f86e80c1da8cb2afd401173a40e41370f5cad5db20/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73" alt="JWT" data-canonical-src="https://img.shields.io/badge/JWT-black?style=for-the-badge&amp;logo=JSON%20web%20tokens" style="max-width: 100%;">
</p>

### Este projeto é uma API construída utilizando Java com Spring, tendo como banco de dados o PostgreSQL e método de autenticação Spring Security com JWT.
</br>This project is an APi built using Java whit Spring, using PostgreSQL as the database and the authentication method is Spring Security with JWT.

### O objetivo deste projeto é exemplificar uma implementação de Spring Security, como fonte de estudos.
</br>This project's goes is exemplifier an implemetation of Spring Security, just for study.

<h2>Instalação</h2>
Installation

1. Clone o repositório
   </br>Clone the repository
   
   <pre>git clone https://github.com/PaivaYago/SecurityDemo.git</pre>
   
2. Instale as dependencias do Maven
   </br>Install Maven's dependencies
   
3. Instale o <a href="https://www.postgresql.org/">PostegreSQL</a>
   </br>Install <a href="https://www.postgresql.org/">PostegreSQL</a>

<h2>Usando</h2>
Usage

1. Start a aplicação pela classe SecurityDemoApplication
   </br>Star the API by SecurityDemoApplication class
   
2. A API será acessada pelo http://localhost:8080
   </br>The access will be by http://localhost:8080

<h2>Endpoints</h2>

<pre>GET /product - retorna uma lista de produtos para todos os usuários autenticados
               return a product's list to any authenticated usuary
               
POST /product - regitra produtos, mas apenas por acesso ADMIN
                register products, but only to ADMIN access
                
POST /auth/login - loga e retorna um token para autenticação
                   logs and return a token to use for authentication
                   
POST /auth/register - registra usuários, mas apenas por acesso ADMIN
                      register a new usuary, but only to ADMIN access</pre>

<h2>Banco de dados</h2>
Database

A API utiliza o <a href="https://www.postgresql.org/">PostegreSQL</a> como banco de dados.
</br>The API uses <a href="https://www.postgresql.org/">PostegreSQL</a> as the database.

<pre>
  CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    price INTEGER NOT NULL
);
  CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);
</pre>

<h2>Autenticação</h2>

<pre>USER -> tipo de acesso padrão
        standard access
  
ADMIN -> tipo de acesso com todas as permissões
         access with all permissions</pre>
