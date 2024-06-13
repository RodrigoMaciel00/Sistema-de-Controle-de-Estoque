import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estoque {
    // Atributos existentes
    private final List<Produto> produtos;
    private final List<Fornecedor> fornecedores;
    private final List<PedidoReabastecimento> pedidosReabastecimento;

    // Construtor existente
    public Estoque() {
        this.produtos = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.pedidosReabastecimento = new ArrayList<>();
    }

    // Métodos existentes

    public void cadastrarProduto(String codigo, String nome, CategoriaProduto categoria, int quantidade, double preco, boolean composto, List<Produto> componentes) {
        Produto produto;
        if (composto) {
            produto = new ProdutoComposto(codigo, nome, categoria, quantidade, preco, componentes);
        } else {
            produto = new ProdutoSimples(codigo, nome, categoria, quantidade, preco);
        }
        adicionarProduto(produto);
    }

    // Restante dos métodos existentes
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void registrarEntrada(Produto produto, int quantidade) {
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public void registrarSaida(Produto produto, int quantidade) {
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void registrarPedidoReabastecimento(PedidoReabastecimento pedido) {
        pedidosReabastecimento.add(pedido);
        registrarEntrada(pedido.produto(), pedido.quantidade());
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public List<PedidoReabastecimento> getPedidosReabastecimento() {
        return pedidosReabastecimento;
    }

    public List<Produto> listarProdutosBaixaQuantidade(int quantidadeMinima) {
        return produtos.stream()
                .filter(produto -> produto.getQuantidade() <= quantidadeMinima)
                .collect(Collectors.toList());
    }

    public List<PedidoReabastecimento> listarPedidosReabastecimentoPendentes() {
        return pedidosReabastecimento.stream()
                .filter(pedido -> pedido.produto().getQuantidade() < pedido.quantidade())
                .collect(Collectors.toList());
    }
}
