
package model;

public class Servicos {
     private int pkServico ;
    private String descricao;
    private String tempo;
    private String preco;

    public void setPkServico(int pkServico) {
        this.pkServico = pkServico;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getPkServico() {
        return pkServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTempo() {
        return tempo;
    }

    public String getPreco() {
        return preco;
    }

    public Servicos(int pkServico, String descricao, String tempo, String preco) {
        this.pkServico = pkServico;
        this.descricao = descricao;
        this.tempo = tempo;
        this.preco = preco;
    }

    public Servicos() {
    }
}
