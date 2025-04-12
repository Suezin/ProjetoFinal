package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Produtos;



public class ProdutosController {
     public List<Produtos> consultarProdutos() {
        String sql = "SELECT * FROM produtos";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Produtos> listaProdutos = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Produtos prod = new Produtos();

                prod.setPkProduto(resultado.getInt("pkservico"));
                prod.setDescricao(resultado.getString("nomeservico"));
                prod.setPreco(resultado.getString("preco"));
                
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioController.class.getName()).log(
                    Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaProdutos;
    }
    
    public boolean inserirProduto(Produtos prod){
    
        String sql = "INSERT INTO produtos(descricao, preco) " + "VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, prod.getDescricao());
            comando.setString(2, prod.getPreco());
 
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
    public boolean alterarProduto(Produtos prod) {
        String sql = "UPDATE produtos " + "SET descricao = ?, preco = ? ";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, prod.getDescricao());
            comando.setString(2, prod.getPreco());
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
     public boolean deletar(int pkProdutos) {
        Produtos prod = new Produtos();
        String sql = "DELETE FROM produtos WHERE pkproduto = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkProdutos);
            comando.executeUpdate();
            return true;
        } catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            gerenciador.fecharConexao();
        }
        return false;
    }
}
