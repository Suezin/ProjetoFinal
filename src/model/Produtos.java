package model;
public class Produtos {
    private int pkProduto;
    private String descricao;
    private String preco ;

    public int getPkProduto() {
        return pkProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPkProduto(int pkProduto) {
        this.pkProduto = pkProduto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Produtos(int pkProduto, String descricao, String preco) {
        this.pkProduto = pkProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produtos() {
    }
   
    
}
