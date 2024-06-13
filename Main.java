public class    Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto produto1 = new ProdutoSimples("001", "Notebook", CategoriaProduto.ELETRONICOS, 10, 2500.0);
        Produto produto2 = new ProdutoSimples("002", "Camisa", CategoriaProduto.ROUPAS, 50, 40.0);

        Fornecedor fornecedor = new Fornecedor("Tech Supplier", "contato@techsupplier.com");
        PedidoReabastecimento pedido = new PedidoReabastecimento(produto1, 5, fornecedor);

        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        estoque.adicionarFornecedor(fornecedor);
        estoque.registrarPedidoReabastecimento(pedido);

        System.out.println("Produtos no estoque:");
        for (Produto p : estoque.getProdutos()) {
            System.out.println(p.getNome() + " - " + p.getQuantidade() + " unidades");
        }
    }
}
