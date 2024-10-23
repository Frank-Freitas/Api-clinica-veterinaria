# Projeto VetMaster - Backend (trabalho-api)

## Descrição

O projeto é uma API para o gerenciamento de uma clínica veterinária. Ele permite o cadastro de clientes (proprietários dos animais) e dos animais, além de gerenciar consultas veterinárias.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- H2 Database
- Lombok
- MapStruct
- Springdoc OpenAPI
- Therapi Runtime Javadoc
- Jacoco


## Pré-requisitos

- JDK 11+
- Maven 3.8+

## Instalação

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/Frank-Freitas/Api-clinica-veterinaria
   ```

2. **Navegue até o diretório do projeto:**

   ```bash
   cd desktop/Api-clinica-veterinaria

   ```

   
### Observação

- Certifique que o repositório foi clonado na pasta desktop(area de trabalho). Caso tenha escolhido um diretório diferente, ajuste o caminho no comando cd de acordo com a localização correta.


3. **Configure o banco de dados:**

   Edite o arquivo [application.yaml](src/main/resources/application.yaml) com as configurações do seu banco de dados.

4. **Compile e execute o projeto:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   A API estará disponível em `http://localhost:8080`.

## Documentação da API (Swagger)

A documentação da API pode ser acessada por meio do Swagger. Após iniciar o backend, você pode acessar a documentação por meio da seguinte URL:

[/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Endpoints

Abaixo está a descrição dos principais endpoints da API:

### **1. GET /api/Animal**

- **Descrição:** Retorna uma lista de usuários.

- **Resposta:**
  - **200 OK**
    ```json
    [
      {
        "id": 1,
        "nome": "Lilica",
        "especie": "cachorro"
        "age:" 4,
        "ownerName:" thiago"
        "email": "thiago@email.com"
      },      

      {
        "id": 33,
	      "name": "dog",
	      "espécie: "cachorro",
	      "age": 4
	      "ownerName": "joao",
	      "ownerEmail": "joao@email.com"
      },

      {
        "id": 34,
	      "name": "doguinho",
	      "espécie: "cachorro",
	      "age": 5
	      "ownerName": "joao",
	      "ownerEmail": "joao@gmail.com
      }           
      
    ]
    

### **2. POST /api/Animal**

- **Descrição:** Cria um novo usuário.

- **Corpo da Requisição:**
  ```json
  {
        "name": "dog",
	      "espécie: "cachorro",
	      "age": 4
	      "ownerName": "joao",
	      "ownerEmail": "joao@email.com"
  }


### **3. GET /api/Animal/{id}**

- **Descrição:** Retorna um usuário específico pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 4,
      "nome": "dog",
      "especie": "cachorro",
      "email": "joao@email.com"
    }
    
  - **404 Not Found** (se o animal não for encontrado)

### **4. PUT /api/Animal/{id}**

- **Descrição:** Atualiza um usuário existente.
- **Corpo da Requisição:**
  ```json
  {
        "id": 0,
	      "name": "doguinho",
	      "espécie: "cachorro",
	      "age": 5
	      "ownerName": "joao",
	      "ownerEmail": "joao@gmail.com
  }    
    
  - **404 Not Found** (se o usuário não for encontrado)

### **5. DELETE /api/Animal/{id}**

- **Descrição:** Remove um usuário pelo ID.
- **Parâmetros de Caminho:**
  - "id": 35
- **Resposta:**
  - **204 No Content**
  - **404 Not Found** (se o usuário não for encontrado)
