public abstract class ProdutoBase implements Produto {
    private final String codigo;
    private final String nome;
    private final CategoriaProduto categoria;
    private int quantidade;
    private final double preco;

    public ProdutoBase(String codigo, String nome, CategoriaProduto categoria, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public CategoriaProduto getCategoria() {
        return categoria;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
