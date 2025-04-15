package model;

import java.util.Date;

public class Clientes {



    private int pkCliente;
    private String nome ;
    private String telefone;
    private Date dataNasc;

    public Clientes(int pkCliente, String nome, String telefone, Date dataNasc) {
        this.pkCliente = pkCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    public Clientes() {
    }

    public int getPkCliente() {
        return pkCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setPkCliente(int pkCliente) {
        this.pkCliente = pkCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    
    
}
