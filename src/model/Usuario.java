package model;

import java.util.Date;

public class Usuario {

    private int pkusuario;
    private String nome ;
    private String email;
    private String senha;
    private Date datanasc;

    public Usuario(int pkusuario, String nome, String email, String senha, Date datanasc) {
        this.pkusuario = pkusuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.datanasc = datanasc;
    }

    public Usuario() {
    }

    
    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
    
    public int getPkusuario() {
        return pkusuario;
    }

    public void setPkusuario(int pkusuario) {
        this.pkusuario = pkusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
