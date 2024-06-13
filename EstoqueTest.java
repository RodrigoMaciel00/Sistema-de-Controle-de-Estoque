import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class EstoqueTest {
    private Estoque estoque;
    private ProdutoSimples produtoSimples;
    private Fornecedor fornecedor;

    @Before
    public void setUp() {
        estoque = new Estoque();
        produtoSimples = new ProdutoSimples("001", "Teclado", CategoriaProduto.ELETRONICOS, 10, 50.0);
        ProdutoComposto produtoComposto = new ProdutoComposto("002", "Computador", CategoriaProduto.ELETRONICOS, 5, 1500.0, Arrays.asList(produtoSimples));
        fornecedor = new Fornecedor("Fornecedor1", "contato@fornecedor1.com");

        estoque.adicionarProduto(produtoSimples);
        estoque.adicionarProduto(produtoComposto);
        estoque.adicionarFornecedor(fornecedor);
    }

    @Test
    public void testAdicionarProduto() {
        assertEquals(2, estoque.getProdutos().size());
    }

    @Test
    public void testRegistrarEntrada() {
        estoque.registrarEntrada(produtoSimples, 5);
        assertEquals(15, produtoSimples.getQuantidade());
    }

    @Test
    public void testRegistrarSaida() {
        estoque.registrarSaida(produtoSimples, 3);
        assertEquals(7, produtoSimples.getQuantidade());
    }

    @Test
    public void testRegistrarPedidoReabastecimento() {
        PedidoReabastecimento pedido = new PedidoReabastecimento(produtoSimples, 20, fornecedor);
        estoque.registrarPedidoReabastecimento(pedido);
        assertEquals(30, produtoSimples.getQuantidade());
        assertEquals(1, estoque.getPedidosReabastecimento().size());
    }

    @Test
    public void testAdicionarFornecedor() {
        assertEquals(1, estoque.getFornecedores().size());
    }
}
