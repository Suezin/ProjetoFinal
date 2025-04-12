package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Servicos;
import model.Usuario;

public class ServicosController {
    public List<Servicos> consultarServios() {
        String sql = "SELECT * FROM servicos";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Servicos> listaServico = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Servicos serv = new Servicos();

                serv.setPkServico(resultado.getInt("pkservico"));
                serv.setDescricao(resultado.getString("nomeservico"));
                serv.setPreco(resultado.getString("preco"));
                serv.setTempo(resultado.getString("tempo"));
                listaServico.add(serv);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioController.class.getName()).log(
                    Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaServico;
    }
    
    public boolean inserirServico(Servicos serv){
    
        String sql = "INSERT INTO servicos(nomeservico, preco, tempo) " + "VALUES (?,?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, serv.getDescricao());
            comando.setString(2, serv.getPreco());
            comando.setString(3, serv.getTempo());
 
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
     public boolean deletar(int pkServico) {
        Servicos serv = new Servicos();
        String sql = "DELETE FROM servicos WHERE pkservico = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkServico);
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
