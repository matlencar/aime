# Sprint Digital Business Enablement 

# ProjetoAssistente GPT

API de gerenciamento e consulta de dados de um e-commerce de computadores e periféricos.


## Endpoints

- Cliente

    - [Efetuar login](#login)
    - [Realizar Cadastro](#cadastrar)
    - [Atualizar Cadastro](#atualizarcliente)
    - [Deletar Conta](#deletarcliente)

- Categoria

    - [Listar todas Categorias](#listar_categorias)
    - [Inserir Categoria](#inserir_categoria)
    - [Atualizar Categoria](#atualizar_categoria)
    - [Deletar Categoria](#deletar_categoria)

- Compra

    - [Listar todas Compras](#listar_todas_compras)
    - [Listar todas Compras por Usuario](#listar_compras_usuario)
    - [Registrar Compra](#registrar_compra)
    - [Atualizar Compra](#atualizar_compra)

- Empresa

    - [Listar todas Empresas](#listar_empresas)
    - [Cadastra Empresa](#cadastrar_empresa)
    - [pesquisa empresa](#pesquisar_empresa)
    - [Atualizar dados da Empresa](#atualizar_empresa)
    - [Deletar Empresa](#deletar_empresa)
    
- Endereço Cliente

    - [Cadastra Endereço de um cliente](#cadastrar_endereco_cliente)
    - [Mostra endereços de um cliente](#mostra_endereco_cliente)
    - [Atualizar endereço de um cliente](#atualiza_endereco_cliente)
    - [Deletar endereço de um cliente](#deleta_endereco_cliente)

- Endereço Empresa

    - [Cadastra Endereço de uma empresa](#cadastrar_endereco_empresa)
    - [Mostra endereços de uma empresa](#mostra_endereco_empresa)
    - [Atualizar endereço da empresa](#atualiza_endereco_empresa)
    - [Deletar endereço da empresa](#deleta_endereco_empresa)

- Endereço Transportadora

    - [Cadastra Endereço de uma Transportadora](#cadastrar_endereco_transportadora)
    - [Mostra endereços de uma Transportadora](#mostra_endereco_transportadora)
    - [Atualizar endereço da Transportadora](#atualiza_endereco_transportadora)
    - [Deletar endereço da Transportadora](#deleta_endereco_transportadora)

- Marca

    - [Cadastra uma marca](#cadastrar_marca)
    - [mostra todas as marcas](#mostrar_marcas)
    - [pesquisa marca](#pesquisar_marca)
    - [Atualizar dados de uma marca](#atualizar_marca)
    - [Deletar uma marca](#deletar_marca)

- Produto

    - [Cadastra um produto](#cadastrar_produto)
    - [mostra todos os produtos cadastrados](#mostrar_produtos)
    - [pesquisa produto](#pesquisar_produto)
    - [Atualizar dados de um produto](#atulizar_produto)
    - [Deletar um produto](#deletar_produto)
    
- Transportadora

    - [Cadastra Transportadoras](#cadastrar_transportadora)
    - [Mostra as transportadoras](#mostrar_transportadoras)
    - [Atualizar as informações das transportadoras](#atualizar_transportadora)
    - [Deletar transportadoras](#deletar_transportadora)


- Telefone Cliente

    - [Cadastra telefone de cliente](#cadastratelefonecliente)
    - [Mostra telefone de um cliente](#mostratelefonecliente)
    - [Atualiza telefone de um cliente](#atualiza_telefone_cliente)
    - [Deleta Telefone de um cliente](#deletar_telefone_cliente)

- Telefone Empresa

    - [Cadastrar telefone de empresa](#cadastrartelefoneempresa)
    - [Mostra telefone de um empresa](#mostratelefoneempresa)
    - [Atualiza telefone de uma empresa](#atualiza_telefone_empresa)
    - [Deleta Telefone de uma empresa](#deletar_telefone_cliente)

- Telefone Transportadora

    - [Cadastra telefone de transportadora](#cadastratelefonetransportadora)
    - [Mostra telefone de uma transportadora](#mostratelefonetransportadora)
    - [Atualiza telefone de uma transportadora](#atualizar_telefone_transportadora)
    - [Deleta Telefone de uma transportadora](#deletar_telefone_transportadora)
---
### Descrição dos Endpoints

## Cliente

### Login

`GET` /localhost/api/clientes/

```js
{
    id:"1",
    usuario: "PedroSag",
    senha: "1234abc@"
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|
---
### Cadastrar
    
`POST` /localhost/api/clientes

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     |Campo para preenchimento de nome do usuario
|     Email    |String|     Sim     |Campo obrigatorio para que o usuario tenha acesso a sua conta no APP
|     CPF      |String|     Sim     |É obrigatorio que o usuario informe seu cadastro, sem CPF ele não pode proseguir
|      RG      |String|     Sim     |Nesse campo é precios colocar o RG do usuario para que possa proseguir com o cadastro
|     Senha    |String|     Sim     |Campo obrigatorio, usuario deve colocar uma senha que contenha entre 6 a 8 caracteres para poder proseguir
|     Data     | Date |     Sim     |Campo para que o usuario coloque sua data de nascimento
|Status|Char|sim| Deve indicar se a conta do cliente está "A"(ativo) ou "I" inativo
|     nome social  |String|     não     |caso o usuário tenha um nome social ele pode registrar em nossa plataforma
|Telefone_clinte|object|sim| Objeto que se refere ao telefone do cliente contendo o ID, numero, ddd, ddi e status
|Endereco_cliente|object |sim|  Objeto que se refere ao endereço do cliente contendo ID, cep, logradouro, bairro, pais, numero, status, complemento

```js
{
    id: 1,
    nome: "Pedro Henrique Sanagiotto",
    email: "pedro@gemail.com",
    CPF: "111.222.444-10",
    RG: "33.123.987-8",
    senha: "12345@abc",
    data_de_nascimento: "20/09/2002",
    status: "A"
    nomeSocial:"Pedrinho";
    Telefone_Cliente:{
        telefone: "97978-5131",
        ddd: "11"
        ddi:"15",
        Status: "A",
    },
    endereco_Cliente:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Cliente

`PUT` /localhost/api/cadastro/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     |Campo para preenchimento de nome do usuario
|     Email    |String|     Sim     |Campo obrigatorio para que o usuario tenha acesso a sua conta no APP
|     CPF      |String|     Sim     |É obrigatorio que o usuario informe seu cadastro, sem CPF ele não pode proseguir
|      RG      |String|     Sim     |Nesse campo é precios colocar o RG do usuario para que possa proseguir com o cadastro
|     Senha    |String|     Sim     |Campo obrigatorio, usuario deve colocar uma senha que contenha entre 6 a 8 caracteres para poder proseguir
|     Data     | Date |     Sim     |Campo para que o usuario coloque sua data de nascimento
|Status|Char|sim| Deve indicar se a conta do cliente está "A"(ativo) ou "I" inativo
|     nome social  |String|     não     |caso o usuário tenha um nome social ele pode registrar em nossa plataforma
|Telefone_clinte|object|sim| Objeto que se refere ao telefone do cliente contendo o ID, numero, ddd, ddi e status
|Endereco_cliente|object |sim|  Objeto que se refere ao endereço do cliente contendo ID, cep, logradouro, bairro, pais, numero, status, complemento

```js
{
    id: 1,
    nome: "Pedro Henrique Sanagiotto",
    email: "pedro@gemail.com",
    CPF: "111.222.444-10",
    RG: "33.123.987-8",
    senha: "12345@abc",
    data_de_nascimento: "20/09/2002",
    status: "A"
    nomeSocial:"Pedrinho";
    Telefone_Cliente:{
        telefone: "97978-5131",
        ddd: "11"
        ddi:"15",
        Status: "A",
    },
    endereco_Cliente:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Deletar_Cliente
`DELETE` /localhost/api/cliente/{id}


```js
    {
        id: "1"
    }
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Categoria

### Listar_Categorias

`GET` /localhost/api/categoria

```js
{
    id:1
    nome: "Placa mãe",
    descricao: "Componentes para hardware de computadores"
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|
---
### Inserir_Categoria

`POST` /localhost/api/categoria

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|id |Integer|sim|Gerado automaticamente pela aplicação
|     Nome     |String|     Sim     |Campo para preenchimento do nome da categoria que sera inserida
|   Descricao  |String|     Sim     |Campo para preenchimento das descrição da categoria

```js
{
    id:1
    nome: "Placa mãe",
    descricao: "Componentes para hardware de computadores"
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Categoria

`PUT` /localhost/api/categoria

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|id |Integer|sim|Gerado automaticamente pela aplicação
|     Nome     |String|     Sim     |Campo para preenchimento do nome da categoria que sera inserida
|   Descricao  |String|     Sim     |Campo para preenchimento das descrição da categoria
```js
{
    id:1
    nome: "Placa mãe",
    descricao: "Componentes para hardware de computadores"
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Categoria

`DELETE` /localhost/api/categoria/{id}


```js
    {
        id: "1"
    }
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
## Compra

### Listar_Todas_Compras
`GET` /localhost/api/compras/

```js
{
    id:"1",
    data: "11/12/20",
    hora: "14:30"
    cliente: {
        id: 1,
        nome: "Pedro Henrique Sanagiotto",
        email: "pedro@gemail.com",
        CPF: "111.222.444-10",
        RG: "33.123.987-8",
        senha: "12345@abc",
        data_de_nascimento: "20/09/2002",
        status: "A"
        nomeSocial:"Pedrinho";
        Telefone_Cliente:{
            telefone: "97978-5131",
            ddd: "11"
            ddi:"15",
            Status: "A",
        },
        endereco_Cliente:{
            id:1
            cep:"00000-000"
            logradouro:"Rua Lins dVasconcelos"
            bairro:"Aclimação"
            pais:"brasil"
            numero:1011
            status:"A"
            complemento:"ap 42A"
        }
    }
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|

---
### Listar_Compras_Usuario
`GET` /localhost/api/compras/{id}
```js
{
    id:"1",
    data: "11/12/20",
    hora: "14:30"
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|
---

### Registrar_Compra
`POST` /localhost/api/compras

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Data |String|     Sim     |Necessario para cadastrar uma compra
|hora|String|     Sim     | Registro da hora da compra
|   Cliente  |object|     Sim     | Objeto que se refere o Cliente da compra com ID, nome, email, CPF, RG, senha, data de nascimento, status, nome social, telefone e endereço
|Produto |object|sim| Objeto que se refere ao produto da compra com id, nome, descricao, estrelas, numerod e avaliacoes, preco, preço frete, categoria, empresa, transportadora e marca
```js

{
    id:"1",
    data: "11/12/20",
    hora: "14:30"
    cliente: {
        id: 1,
        nome: "Pedro Henrique Sanagiotto",
        email: "pedro@gemail.com",
        CPF: "111.222.444-10",
        RG: "33.123.987-8",
        senha: "12345@abc",
        data_de_nascimento: "20/09/2002",
        status: "A"
        nomeSocial:"Pedrinho";
        Telefone_Cliente:{
            telefone: "97978-5131",
            ddd: "11"
            ddi:"15",
            Status: "A",
        },
        endereco_Cliente:{
            id:1
            cep:"00000-000"
            logradouro:"Rua Lins dVasconcelos"
            bairro:"Aclimação"
            pais:"brasil"
            numero:1011
            status:"A"
            complemento:"ap 42A"
        }
    }
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Atualizar_Compra
`PUT` /localhost/api/compras/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Data |String|     Sim     |Necessario para cadastrar uma compra
|hora|String|     Sim     | Registro da hora da compra
|   Cliente  |object|     Sim     | Objeto que se refere o Cliente da compra com ID, nome, email, CPF, RG, senha, data de nascimento, status, nome social, telefone e endereço
|Produto |object|sim| Objeto que se refere ao produto da compra com id, nome, descricao, estrelas, numerod e avaliacoes, preco, preço frete, categoria, empresa, transportadora e marca
```js
{
    id:"1",
    data: "PedroSag",
    hora: "1234abc@"
    Cliente:{
        id:1
        nome: "Pedro Henrique Sanagiotto",
        data de nascimento: "20/09/2002",
        RG: "33.123.987-8",
        CPF: "111.222.444-10",
        email: "pedro@gemail.com",
        nome de usuario: "PedroSag"
        senha: "12345@abc",
        confirmacao de senha: "12345@abc"
    }
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

## Empresa
### Listar_Empresas
`GET` /localhost/api/empresas/

```Js
{
    id:1,
    nome:"computador Co",
    nomeRazaoSocial:"Computadores Co",
    descricao: "empresa de tech",
    numeroVendas:125454,
    numeroAvaliacao:5
    enderecoEmpresa:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
    telefoneEmpresa:{
        id:1
        telefone:"99999-9999"
        ddd:"011",
        ddi:"+55"
        status:"A"
    },
    produtos:{
        {
            id:1,
            nome:"computador",
            descricao:"Computador high tech",
            estrelas:5,
            numeroAvaliacoes:2,
            preco:1000.00,
            precoFrete:9.99
            categoria:{
                id:1
                nome: "Placa mãe",
                descricao: "Componentes para hardware de computadores"
            },
            transportadora:{
                id:1,
                nome:"Sedex",
                descricao:"Entrega super rápida",
                numeroNota:5
            }
            marca:{
                id:1,
                nome:"nieke",
                descricao:"produto bom e barato",
                nota:5,
            }
        }
    }
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Cadastrar_Empresa
`POST` /localhost/api/telefoneEmpresa
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   Nome       |String|     Sim     |Necessario para cadastrar uma empresa
| Razão Social |String|     Sim     |Necessario para cadastrar uma empresa
|numeroAvaliação|Interger|     Sim     | Registra a avaliação da empresa, a nota pode ser de 0-5
|   Endereço  |object|     Sim     | Este campo recebe um objeto referende ao endereço da empresa contendo: id, CEP, logradouro, bairro, pais, numero, status e complemento.
| Telefone | object | sim | Este campo recebe um objeto referende ao telefone da empresa contendo: id, telefone, DDD , DDI e Status.

```Js
{
    id:1,
    nome:"computador Co",
    razaoSocial:"Computadores Co",
    numeroAvaliacao:5
    enderecoEmpresa:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
    telefoneEmpresa:{
        id:1
        telefone:"99999-9999"
        ddd:"011",
        ddi:"+55"
        status:"A"
    }
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Pesquisar_Empresa
`GET` /localhost/api/empresas/{id}
```Js
{
    id:1,
    nome:"computador Co",
    nomeRazaoSocial:"Computadores Co",
    numeroAvaliacao:5
    enderecoEmpresa:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
    telefoneEmpresa:{
        id:1
        telefone:"99999-9999"
        ddd:"011",
        ddi:"+55"
        status:"A"
    }
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Atualizar_Empresa
`PUT` /localhost/api/empresas/{id}
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   Nome       |String|     Sim     |Necessario para cadastrar uma empresa
| Razão Social |String|     Sim     |Necessario para cadastrar uma empresa
|numeroAvaliação|Interger|     Sim     | Registra a avaliação da empresa, a nota pode ser de 0-5
|   Endereço  |object|     Sim     | Este campo recebe um objeto referende ao endereço da empresa contendo: id, CEP, logradouro, bairro, pais, numero, status e complemento.
| Telefone | object | sim | Este campo recebe um objeto referende ao telefone da empresa contendo: id, telefone, DDD , DDI e Status.

```Js
{
    id:1,
    nome:"computador Co",
    razaoSocial:"Computadores Co",
    numeroAvaliacao:5
    enderecoEmpresa:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
    telefoneEmpresa:{
        id:1
        telefone:"99999-9999"
        ddd:"011",
        ddi:"+55"
        status:"A"
    }
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Deletar_Empresa
`DELETE` /localhost/api/categoria/{id}

```js
    {
        id: "1"
    }
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Endereço Cliente

### Cadastrar_Endereco_Cliente
`POST` /localhost/api/enderecoCliente/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um cliente
| Bairro | String | sim | nescessário para cadastrar do endereço do cliente
| Pais | String | sim | nescessário para cadastrar do endereço do cliente
| Numero | Interger | sim | Se refere ao numero da residência
| Status | Char | sim | Enum que indica se o endereço esta ativo ou inativo
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Mostra_Endereco_Cliente
`GET` /localhost/api/enderecoCliente/{id}
```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Atualiza_Endereco_Cliente
`PUT` /localhost/api/enderecoCliente/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um cliente
| Bairro | String | sim | nescessário para cadastrar do endereço do cliente
| Pais | String | sim | nescessário para cadastrar do endereço do cliente
| Numero | Interger | sim | Se refere ao numero da residência
| Status | Char | sim | Enum que indica se o endereço esta ativo ou inativo
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Deleta_Endereco_Cliente
`DELETE` /localhost/api/enderecoCliente/{id}
```js
    {
        id: "1"
    }
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|

---
## Endereço Empresa
### Cadastrar_Endereco_Empresa
`POST` /localhost/api/enderecoEmpresa/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um Empresa
| Bairro | String | sim | nescessário para cadastrar do endereço do Empresa
| Pais | String | sim | nescessário para cadastrar do endereço do Empresa
| Numero | Interger | sim | Se refere ao numero da residência
| Status | Char | sim | Enum que indica se o endereço esta ativo ou inativo
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Mostra_Endereco_Empresa
`GET` /localhost/api/enderecoEmpresa/{id}
```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Atualiza_Endereco_Empresa
`PUT` /localhost/api/enderecoEmpresa/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um Empresa
| Bairro | String | sim | nescessário para cadastrar do endereço do Empresa
| Pais | String | sim | nescessário para cadastrar do endereço do Empresa
| Numero | Interger | sim | Se refere ao numero da residência
| Status | Char | sim | Enum que indica se o endereço esta ativo ou inativo
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deleta_Endereco_Empresa
`DELETE` /localhost/api/enderecoEmpresa/{id}
```js
    {
        id: "1"
    }
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Endereço Transportadora
### Cadastrar_Endereco_Transportadora
`POST` /localhost/api/enderecoTransportadora/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um Transportadora
| Bairro | String | sim | nescessário para cadastrar do endereço do Transportadora
| Pais | String | sim | nescessário para cadastrar do endereço do Transportadora
| Numero | Interger | sim | Se refere ao numero da residência
| Status | Char | sim | Enum que indica se o endereço esta ativo ou inativo
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Mostra_Endereco_Transportadora
`GET` /localhost/api/enderecoTransportadora/{id}
```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Atualiza_Endereco_Transportadora
`PUT` /localhost/api/enderecoTransportadora/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um Transportadora
| Bairro | String | sim | nescessário para cadastrar do endereço do Transportadora
| Pais | String | sim | nescessário para cadastrar do endereço do Transportadora
| Numero | Interger | sim | Se refere ao numero da residência
| Status | Char | sim | Enum que indica se o endereço esta ativo ou inativo
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    id:1
    cep:"00000-000"
    logradouro:"Rua Lins dVasconcelos"
    bairro:"Aclimação"
    pais:"brasil"
    numero:1011
    status:"A"
    complemento:"ap 42A"
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deleta_Endereco_Transportadora
`DELETE` /localhost/api/enderecoTransportadora/{id}
```js
    {
        id: "1"
    }
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Marca

### Cadastrar_Marca
`POST` /localhost/api/marca/

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome da marca, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre a marca
| Nota | Interger | sim | a nota da empresa é dada entre 1-5

```JS
{
    id:1,
    nome:"nieke",
    descricao:"produto bom e barato",
    nota:5,
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Mostrar_Marcas
`GET` /localhost/api/marca/
```JS
{
    id:1,
    nome:"nieke",
    descricao:"produto bom e barato",
    nota:5,
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---

### Pesquisar_Marca
`POST` /localhost/api/marca/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome da marca, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre a marca
| Nota | Interger | sim | a nota da empresa é dada entre 1-5

```JS
{
    id:1,
    nome:"nieke",
    descricao:"produto bom e barato",
    nota:5,
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Atualizar_Marca

`PUT` /localhost/api/marca/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome da marca, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre a marca
| Nota | Interger | sim | a nota da empresa é dada entre 1-5

```JS
{
    id:1,
    nome:"nieke",
    descricao:"produto bom e barato",
    nota:5,
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_Marca
`DELETE` /localhost/api/marca/{id}

```JS
{
    id:1,
}
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Produto

### Cadastrar_Produto
`POST` /localhost/api/Produto/

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome do Produto, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre o produto
| estrelas | Interger | sim | a nota da empresa é dada entre 1-5
|Numero Avaliações|Interger|sim| quantidade de avaliações feitas por clientes
| Preço | Double | sim | Valor em reais do produto com apenas 2 casas decimais
| Preço Frete | Double | sim | Valor em reais do custo de envio do produto
| Categoria | Object | sim | Objeto referente a categoria do produto com ID, nome e descrição 
| Empresa | Object | sim | Objeto referente a empresa do produto com ID, nome, razão social, avaliação, endereço da empresa(object) e telefone da empresa(object)
| Transportadora | Object | sim | Objeto referente a transportadora do produto com ID, Nome, descrição e nota
| Marca | object | sim | Objeto referente a marca do produto com ID, nome, descrição e nota

```js
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Mostrar_Produtos
`GET` /localhost/api/Produto/

```js
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Pesquisar_Produto
`GET` /localhost/api/Produto/{id}

```js
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Atulizar_Produto
`PUT` /localhost/api/Produto/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome do Produto, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre o produto
| Nota | Interger | sim | a nota da empresa é dada entre 1-5
| Preço | Double | sim | Valor em reais do produto com apenas 2 casas decimais
| Preço Frete | Double | sim | Valor em reais do custo de envio do produto
| Categoria | Object | sim | Objeto referente a categoria do produto com ID, nome e descrição 
| Empresa | Object | sim | Objeto referente a empresa do produto com ID, nome, razão social, avaliação, endereço da empresa(object) e telefone da empresa(object)
| Transportadora | Object | sim | Objeto referente a transportadora do produto com ID, Nome, descrição e nota
| Marca | object | sim | Objeto referente a marca do produto com ID, nome, descrição e nota

```js
    produto:{
        id:1,
        nome:"computador",
        descricao:"Computador high tech",
        estrelas:5,
        numeroAvaliacoes:2,
        preco:1000.00,
        precoFrete:9.99
        categoria:{
            id:1
            nome: "Placa mãe",
            descricao: "Componentes para hardware de computadores"
        }
        empresa:{
            id:1,
            nome:"computador Co",
            razaoSocial:"Computadores Co",
            numeroAvaliacao:5
            enderecoEmpresa:{
                id:1
                cep:"00000-000"
                logradouro:"Rua Lins de Vasconcelos"
                bairro:"Aclimação"
                pais:"brasil"
                numero:1011
                status:"A"
                complemento:"ap 42A"
            }
            telefoneEmpresa:{
                id:1
                telefone:"99999-9999"
                ddd:"011",
                ddi:"+55"
                status:"A"
            }
        }
        transportadora:{
            id:1,
            nome:"Sedex",
            descricao:"Entrega super rápida",
            numeroNota:5
        }
        marca:{
            id:1,
            nome:"nieke",
            descricao:"produto bom e barato",
            nota:5,
        }
    }
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_Produto
`DELETE` /localhost/api/Produto/{id}
```JS
{
    id:1,
}
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Transportadora 

### Cadastrar_transportadora

`POST` /localhost/api/transportadora/

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome da transportadora, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre a Transportadora
| Numero Nota | Interger | sim | a nota da Transportadora é dada entre 1-5
|   Endereço  |object|     Sim     | Este campo recebe um objeto referende ao endereço da empresa contendo: id, CEP, logradouro, bairro, pais, numero, status e complemento.
| Telefone | object | sim | Este campo recebe um objeto referende ao telefone da empresa contendo: id, telefone, DDD , DDI e Status.

```JS
transportadora:{
    id:1,
    nome:"Sedex",
    descricao:"Entrega super rápida",
    numeroNota: 5
    endereco_transportadora:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
    telefone_transportadora:{
        telefone: "97978-5131",
        ddd: "11"
        ddi: "15",
        Status: "A",
    }
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Mostrar_transportadoras
`GET` /localhost/api/transportadora/

```JS
transportadora:{
    id:1,
    nome:"Sedex",
    descricao:"Entrega super rápida",
    numeroNota: 57
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### atualizar_transportadora
`PUT` /localhost/api/transportadora/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     ID       |Interger|     Sim     |Gerado automaticamente pela aplicação
| Nome | String | sim | Nome da transportadora, é necessario para cadastrar uma marca
| Descrição | String | sim | Descrição sobre a Transportadora
| Numero Nota | Interger | sim | a nota da Transportadora é dada entre 1-5
|   Endereço  |object|     Sim     | Este campo recebe um objeto referende ao endereço da empresa contendo: id, CEP, logradouro, bairro, pais, numero, status e complemento.
| Telefone | object | sim | Este campo recebe um objeto referende ao telefone da empresa contendo: id, telefone, DDD , DDI e Status.

```JS
transportadora:{
    id:1,
    nome:"Sedex",
    descricao:"Entrega super rápida",
    numeroNota: 5
    endereco_transportadora:{
        id:1
        cep:"00000-000"
        logradouro:"Rua Lins dVasconcelos"
        bairro:"Aclimação"
        pais:"brasil"
        numero:1011
        status:"A"
        complemento:"ap 42A"
    }
    telefone_transportadora:{
        telefone: "97978-5131",
        ddd: "11"
        ddi: "15",
        Status: "A",
    }
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_transportadora
`DELETE` /localhost/api/transportadora/{id}
```JS
{
    id:1,
}
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Telefone Cliente

### Mostra_telefone_cliente

`GET` /localhost/api/telefoneCliente/{id}
```js
{
    id: 1,
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Cadastra_telefone_cliente
`POST` /localhost/api/telefoneCliente

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|ID|Interger|sim | Gerado automaticamente pela aplicação
|   Telefone   |String|     Sim     |Necessario para inserir o telefone do cliente
|      ddd     |String|     Sim     |Codigo da cidade em qual pertence o telefone
|      ddi     |String|     Sim     |Codigo do estado em qual pertence o telefone
|     Status   |String|     Sim     |Se o telefone está ativo ou não

```js
{
    id: 1,
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Atualiza_telefone_cliente
`PUT` /localhost/api/telefoneCliente/{id}
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|ID|Interger|sim | Gerado automaticamente pela aplicação
|   Telefone   |String|     Sim     |Necessario para inserir o telefone do cliente
|      ddd     |String|     Sim     |Codigo da cidade em qual pertence o telefone
|      ddi     |String|     Sim     |Codigo do estado em qual pertence o telefone
|     Status   |String|     Sim     |Se o telefone está ativo ou não

```js
{
    id: 1,
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|

---
### Deletar_telefone_cliente
`DELETE` /localhost/api/telefoneCliente/{id}
```JS
{
    id:1,
}
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Telefone Empresa

###  Mostra_telefone_empresa

  `GET` /localhost/api/telefoneEmpresa/{id}

```js
{
    id: 1,
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
###  Cadastrar_telefone_empresa

  `POST` /localhost/api/telefoneEmpresa

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|ID|Interger|sim | Gerado automaticamente pela aplicação
|   Telefone   |String|     Sim     |Necessario para inserir o telefone do empresa
|      ddd     |String|     Sim     |Codigo da cidade em qual pertence o telefone
|      ddi     |String|     Sim     |Codigo do estado em qual pertence o telefone
|     Status   |String|     Sim     |Se o telefone está ativo ou não

```js
{
    id: 1,
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Atualiza_telefone_empresa
`PUT` /localhost/api/telefoneEmpresa/{id}
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|ID|Interger|sim | Gerado automaticamente pela aplicação
|   Telefone   |String|     Sim     |Necessario para inserir o telefone da empresa
|      ddd     |String|     Sim     |Codigo da cidade em qual pertence o telefone
|      ddi     |String|     Sim     |Codigo do estado em qual pertence o telefone
|     Status   |String|     Sim     |Se o telefone está ativo ou não

```js
{
    id: 1,
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|

---
### Deletar_telefone_empresa
`DELETE` /localhost/api/telefoneEmpresa/{id}
```JS
{
    id:1,
}
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Telefone Transportadora

   ### Mostra_telefone_transportadora

`GET` /localhost/api/telefoneTransportadora/

```js
{
    id:"1"
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|

   ### Cadastrar_telefone_transportadora

   `POST` /localhost/api/telefoneTransportadora

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   Telefone   |String|     Sim     |Necessario para inserir o telefone do cliente
|      ddd     |String|     Sim     |Codigo da cidade em qual pertence o telefone
|      ddi     |String|     Sim     |Codigo do estado em qual pertence o telefone
|     Status   |String|     Sim     |Se o telefone está ativo ou não

```js
{
    telefone: "97978-5131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

   ### Atualizar_telefone_transportadora

   `PUT` /localhost/api/telefoneTransportadora/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   Telefone   |String|     Sim     |Necessario para inserir o telefone do cliente
|      ddd     |String|     Sim     |Codigo da cidade em qual pertence o telefone
|      ddi     |String|     Sim     |Codigo do estado em qual pertence o telefone
|     Status   |String|     Sim     |Se o telefone está ativo ou não

```js
{
    id: 1
    telefone: "97978-4131",
    ddd: "11"
    ddi: "15",
    Status: "A",
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

   ### Deletar_telefone_transportadora

   `DELETE` /localhost/api/telefoneTransportadora/{id}

```js
{
    id: 1
}
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Link do video de apresentação do projeto do grupo - MDC

https://www.youtube.com/watch?v=7zBbZLdia3w

### `Integrantes`

```js
        André Massao Nakamura RM93046

        Andrea Madureira RM95489

        Erick de Luca Pereira RM94554

        Matheus Alencar Silva RM94642

        Pedro Henrique Sanagiotto RM93182

```
