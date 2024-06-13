import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class EstoqueCadastroTest {
    private Estoque estoque;

    @Before
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testCadastrarProdutoSimples() {
        estoque.cadastrarProduto("001", "Teclado", CategoriaProduto.ELETRONICOS, 10, 50.0, false, null);
        Produto produto = estoque.getProdutos().getFirst();
        assertEquals("Teclado", produto.getNome());
        assertEquals(CategoriaProduto.ELETRONICOS, produto.getCategoria());
        assertEquals(10, produto.getQuantidade());
        assertEquals(50.0, produto.getPreco(), 0.01);
    }

    @Test
    public void testCadastrarProdutoComposto() {
        ProdutoSimples teclado = new ProdutoSimples("002", "Teclado", CategoriaProduto.ELETRONICOS, 5, 50.0);
        estoque.cadastrarProduto("003", "Computador", CategoriaProduto.ELETRONICOS, 2, 1500.0, true, Arrays.asList(teclado));
        Produto produto = estoque.getProdutos().getFirst();
        assertTrue(produto instanceof ProdutoComposto);
        ProdutoComposto computador = (ProdutoComposto) produto;
        assertEquals("Computador", computador.getNome());
        assertEquals(1, computador.getComponentes().size());
        assertEquals("Teclado", computador.getComponentes().getFirst().getNome());
    }
}
