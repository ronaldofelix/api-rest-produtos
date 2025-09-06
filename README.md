# Gerenciador de Produtos (CRUD)

Este é um projeto de exemplo de uma **API REST** construída com **Spring Boot** para praticar o deploy no serviço **Railway**. A aplicação expõe endpoints para gerenciar informações de produtos e pode ser facilmente implantada.

---

### Tecnologias

* **Backend:**
    * **Spring Boot:** Framework para desenvolvimento de aplicações Java.
    * **Java:** Linguagem de programação.
    * **Maven:** Ferramenta de gerenciamento de dependências.
    * **Spring Data JPA:** Para persistência de dados.
    * **PostgreSQL:** Banco de dados relacional em produção.
    * **H2 Database:** Banco de dados em memória para desenvolvimento local.
* **Frontend (Exemplo):**
    * **HTML, CSS, JavaScript:** Interface básica para interagir com a API.
* **Hospedagem:**
    * **Railway:** Plataforma de hospedagem para a aplicação e o banco de dados.

---

### Funcionalidades da API

A aplicação oferece os seguintes endpoints para a gestão de produtos:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/produtos` | Cria um novo produto. |
| `GET` | `/produtos` | Lista todos os produtos. |
| `GET` | `/produtos/{id}` | Busca um produto pelo ID. |
| `PUT` | `/produtos/{id}` | Atualiza um produto existente pelo ID. |
| `DELETE` | `/produtos/{id}` | Deleta um produto pelo ID. |

---

### Pré-requisitos

Para rodar o projeto localmente, você precisa ter instalado:

* **Java 17** ou superior
* **Maven**
* Uma IDE como **IntelliJ IDEA**, **VS Code** ou **Eclipse**

---

### Como Rodar a Aplicação Localmente

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/ronaldofelix/api-rest-produtos.git](https://github.com/ronaldofelix/api-rest-produtos.git)
    cd seu-repositorio
    ```

2.  **Configure o banco de dados local:**
    O projeto está configurado para usar o **H2 Database** em memória por padrão. Não é necessária nenhuma configuração adicional de banco de dados para o desenvolvimento.

3.  **Execute a aplicação:**
    Abra o projeto na sua IDE e execute a classe principal `MinhaAplicacaoCrudApplication.java`.

4.  **Acesse a interface:**
    Após a aplicação iniciar, acesse a interface básica no seu navegador: `http://localhost:8080/index.html`

5.  **Teste os endpoints:**
    Você pode usar ferramentas como o **Postman** ou o **Insomnia** para testar a API em `http://localhost:8080/produtos`.

---

### Deploy no Railway

O projeto está otimizado para um deploy rápido no Railway. Siga os passos abaixo:

1.  **Crie um repositório Git:** Faça o push do seu código para um repositório no GitHub, GitLab ou Bitbucket.
2.  **Conecte o Railway:** Crie uma conta no [Railway](https://railway.app/) e conecte seu repositório. O Railway detectará automaticamente que se trata de um projeto Spring Boot.
3.  **Adicione um banco de dados:** No painel do seu projeto Railway, adicione um novo serviço de banco de dados **PostgreSQL**.
4.  **Variáveis de Ambiente:** O Spring Boot é inteligente o suficiente para se conectar ao banco de dados do Railway automaticamente, pois a plataforma injeta a variável de ambiente `DATABASE_URL`. Não é necessário alterar o código.

---

### Interface Frontend e Atualização da URL da API(Exemplo)

O projeto inclui um arquivo `index.html` em `src/main/resources/static` com uma interface básica para interagir com a API. Para que ela funcione após o deploy, você precisa atualizar a URL da API no código JavaScript.

1.  Localize o arquivo **`src/main/resources/static/index.html`**.
2.  Encontre a linha que define a URL da API:
    ```javascript
    const API_URL = 'http://localhost:8080/produtos';
    ```
3.  Substitua `'http://localhost:8080/produtos'` pela URL completa da sua aplicação no Railway.

    **Exemplo:**
    ```javascript
    const API_URL = '[https://sua-app-no-railway.up.railway.app/produtos](https://sua-app-no-railway.up.railway.app/produtos)';
    ```

Após a configuração, o Railway fará o deploy da sua aplicação e do banco de dados, deixando-a pronta para uso online. A URL pública da sua aplicação estará disponível no painel do Railway.