import java.util.List;

public class ProdutoComposto extends ProdutoBase {
    private final List<Produto> componentes;

    public ProdutoComposto(String codigo, String nome, CategoriaProduto categoria, int quantidade, double preco, List<Produto> componentes) {
        super(codigo, nome, categoria, quantidade, preco);
        this.componentes = componentes;
    }

    public List<Produto> getComponentes() {
        return componentes;
    }
}
