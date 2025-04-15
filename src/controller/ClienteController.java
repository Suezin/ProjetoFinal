package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Clientes;
import model.Usuario;

public class ClienteController {
    
    public boolean inserir(Clientes cliente) {
        String sql = "INSERT INTO clientes(nome, telefone, datanasc) " + "VALUES (?,?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getTelefone());
            comando.setDate(3, new java.sql.Date(cliente.getDataNasc().getTime()));
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    
}
    
    public boolean alterarUsuario(Clientes cliente) {
        String sql = "UPDATE clientes " + "SET nome = ?, telefone = ?, datanasc = ? WHERE pkcliente = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(4, cliente.getPkCliente());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getTelefone());
            comando.setDate(3, new java.sql.Date(cliente.getDataNasc().getTime()));
     

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
    public Clientes buscarPorPk(int pkCliente) {
        String sql = "SELECT * FROM clientes " + "WHERE pkcliente= ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Clientes cliente = new Clientes();

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkCliente);
            resultado = comando.executeQuery();
            if (resultado.next()) {
                cliente.setPkCliente(resultado.getInt("pkcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setDataNasc(resultado.getDate("datanasc"));
                }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioController.class.getName()).log(
                    Level.SEVERE, null, e);
        } finally {
            gerenciador.fecharConexao();
        }
        return cliente;
    }

    public List<Clientes> consultar() {
        String sql = "SELECT * FROM clientes";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Clientes> listaClientes = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Clientes cliente = new Clientes();

                cliente.setPkCliente(resultado.getInt("pkcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setDataNasc(resultado.getDate("datanasc"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteController.class.getName()).log(
                    Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaClientes;
    }

    public boolean deletar(int pkUsuario) {
        Usuario usu = new Usuario();
        String sql = "DELETE FROM clientes WHERE pkusuario = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkUsuario);
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