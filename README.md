# Sistema de Controle de Estoque

Este projeto implementa um sistema de controle de estoque que gerencia produtos, fornecedores e pedidos de reabastecimento. O sistema incorpora recursos avançados como enumerações, herança, polimorfismo, interfaces e listas. Ele permite cadastrar produtos, registrar entradas e saídas de estoque, e gerar relatórios de estoque.

## Estrutura do Projeto

### Enum `CategoriaProduto`

Define as categorias dos produtos. As categorias possíveis são:
- ELETRONICOS
- ALIMENTOS
- ROUPAS
- LIVROS
- FERRAMENTAS

### Interface `Produto`

Define a assinatura dos métodos comuns a todos os produtos:
- `String getCodigo()`
- `String getNome()`
- `CategoriaProduto getCategoria()`
- `int getQuantidade()`
- `double getPreco()`
- `void setQuantidade(int quantidade)`

### Classe Abstrata `ProdutoBase`

Implementa a interface `Produto` e serve como base para diferentes tipos de produtos.

### Subclasses `ProdutoSimples` e `ProdutoComposto`

- **ProdutoSimples**: Representa produtos individuais.
- **ProdutoComposto**: Representa produtos compostos por outros produtos.

### Classe `Fornecedor`

Representa um fornecedor de produtos com os atributos:
- `String nome`
- `String contato`

### Classe `PedidoReabastecimento`

Representa um pedido de reabastecimento de produtos com os atributos:
- `Produto produto`
- `int quantidade`
- `Fornecedor fornecedor`

### Classe `Estoque`

Gerencia o estoque de produtos, registrando entradas, saídas e reabastecimentos. Inclui métodos para:
- `void adicionarProduto(Produto produto)`
- `void removerProduto(Produto produto)`
- `void registrarEntrada(Produto produto, int quantidade)`
- `void registrarSaida(Produto produto, int quantidade)`
- `void adicionarFornecedor(Fornecedor fornecedor)`
- `void registrarPedidoReabastecimento(PedidoReabastecimento pedido)`

## Instalação

Para compilar e executar o projeto, siga os seguintes passos:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
