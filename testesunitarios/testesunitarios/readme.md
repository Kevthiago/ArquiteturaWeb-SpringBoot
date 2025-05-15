# 📘 Projeto: Testes Unitários e Mocking em Spring Boot

Este projeto foi criado como parte da prática de testes unitários com **Spring Boot**, **JUnit 5** e **Mockito**, utilizando um cenário simples com a entidade `Usuario`.

---

## 🎯 Objetivo

Implementar e validar **testes unitários** para o controlador e serviço de usuários em uma aplicação Spring Boot, usando técnicas de **mocking** e simulação de dependências com o Mockito.

---

## ⚙️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
  - Spring Web
  - Spring Data JPA
- MariaDB
- Spring Boot DevTools
- JUnit 5
- Mockito

---

## 🧱 Estrutura da Aplicação

- `Usuario` (entidade)
- `UsuarioRepository` (interface JPA)
- `UsuarioService` (camada de negócio)
- `UsuarioController` (API REST)

---

## 🧪 Testes Implementados

Foram desenvolvidos testes **unitários** para as camadas de `Controller` e `Service`.

### ✅ `UsuarioControllerTest`

- `testListarUsuarios`  
  Verifica se o controller retorna corretamente uma lista de usuários.

- `testBuscarUsuarioExistente`  
  Testa o retorno de um usuário válido por ID.

- `testBuscarUsuarioNaoEncontrado`  
  Testa a resposta HTTP 404 quando o usuário não existe.

- `testCriarUsuario`  
  Verifica o comportamento da criação de usuário via POST.

### ✅ `UsuarioServiceTest`

- `testListarTodos`  
  Testa se o serviço retorna todos os usuários simulados.

- `testBuscarPorId_Existente`  
  Verifica o retorno correto quando o usuário existe no mock.

- `testBuscarPorId_NaoEncontrado`  
  Garante que `Optional.empty()` seja retornado para ID inexistente.

- `testSalvarUsuario`  
  Testa o salvamento de um novo usuário via mock do repositório.

---

## 📊 Relatório de Execução dos Testes

Os testes foram executados diretamente pela IDEA do VSCode e os logs de execução estão no padrão de saída bruta de testes do JUnit. Abaixo, a interpretação dos resultados:

### ✅ Logs de `UsuarioControllerTest`

- %TSTTREE3,testCriarUsuario(...),false,1,false,2  
- %TSTTREE4,testBuscarUsuarioNaoEncontrado(...),false,1,false,2  
- %TSTTREE5,testBuscarUsuarioExistente(...),false,1,false,2  
- %TSTTREE6,testListarUsuarios(...),false,1,false,2  
- %RUNTIME3406

**Significado:**
- Cada linha `%TSTTREE` representa um teste unitário executado.
- O trecho `false,1,false,2` indica que:
  - O teste **não falhou**
  - Foi executado uma vez
  - Nenhuma exceção
  - Nenhum erro
- `%RUNTIME3406`: tempo total de execução dos testes (3,4 segundos)

Todos os 4 testes do controller passaram corretamente ✅

---

### ✅ Logs de `UsuarioServiceTest`

- %TSTTREE3,testBuscarPorId_Existente(...),false,1,false,2
- %TSTTREE4,testSalvarUsuario(...),false,1,false,2
- %TSTTREE5,testBuscarPorId_NaoEncontrado(...),false,1,false,2
- %TSTTREE6,testListarTodos(...),false,1,false,2
- %RUNTIME4327


**Significado:**
- 4 testes foram executados com sucesso.
- Nenhum teste falhou, não houve exceções.
- `%RUNTIME4327`: tempo total de execução dos testes foi de 4,3 segundos.

Todos os testes da camada de serviço também passaram ✅

---

## 🗃️ Banco de Dados

Configuração do banco de dados feita com **MariaDB**, especificada no `application.properties`. Os testes unitários **não dependem do banco** por usarem `Mockito` para simular as operações da camada de persistência (`UsuarioRepository`).

---

## 🚀 Como Executar os Testes

Certifique-se de que o projeto está corretamente configurado e execute:

```bash
./mvnw test
```

Ou, pela IDE (a utilizada foi o VSCode), você pode:

Clicar com o botão direito no projeto e selecionar "Run Tests" para rodar todos os testes.

Ou clicar com o botão direito diretamente na classe de teste, por exemplo UsuarioControllerTest ou UsuarioServiceTest, e selecionar "Run" para executar apenas aquele conjunto específico de testes.

---

> ### 📝 Feito por **Kevin Thiago dos Santos**  
> **Como tarefa para a disciplina de Arquitetura de Aplicações Web**

---
