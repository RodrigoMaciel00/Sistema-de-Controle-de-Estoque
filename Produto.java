public interface Produto {
    String getCodigo();
    String getNome();
    CategoriaProduto getCategoria();
    int getQuantidade();
    double getPreco();
    void setQuantidade(int quantidade);
}
