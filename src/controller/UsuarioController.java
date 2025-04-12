package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioController {
    public boolean autenticar(String email, String senha) {
        String sql = "SELECT * FROM usuarios " + "WHERE email = ? AND senha = ? ";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            comando = gerenciador.prepararConexao(sql);

            comando.setString(1, email);
            comando.setString(2, senha);
            resultado = comando.executeQuery();
            if (resultado.next()) {
                return true;

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);

        }
        return false;
    }
    
    public boolean inserirUsuario(Usuario usu) {
        String sql = "INSERT INTO usuarios(nome, email, senha, datanasc) " + "VALUES (?,?,?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, usu.getNome());
            comando.setString(2, usu.getEmail());
            comando.setString(3, usu.getSenha());
            comando.setDate(4, new java.sql.Date(usu.getDatanasc().getTime()));
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
    public List<Usuario> consultar() {
        String sql = "SELECT * FROM tbusuario";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaUsuario = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Usuario usu = new Usuario();

                usu.setPkusuario(resultado.getInt("pkusuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setDatanasc(resultado.getDate("datanasc"));
                listaUsuario.add(usu);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioController.class.getName()).log(
                    Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaUsuario;
    }
}
