
package Fofoflores.DAO;

import java.util.*;
import static Fofoflores.DAO.VendasDAO.login;
import static Fofoflores.DAO.VendasDAO.senha;
import static Fofoflores.DAO.VendasDAO.url;
import Fofoflores.Model.Cliente;
import Fofoflores.Model.Vendas;
import View.TelaCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteDAO {
    
    public static  String url="jdbc:mysql://localhost:3306/fofoflores";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Cliente obj) {
        
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente (cpf, nome, data_nascimento, celular, telefone, email, endereco, numero_casa, cep, bairro, cidade, complemento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            comandoSQL.setString(1, obj.getCpf());
            comandoSQL.setString(2, obj.getNome());
            comandoSQL.setString(3, obj.getDataNascimento());
            comandoSQL.setString(4, obj.getCelular());
            comandoSQL.setString(5, obj.getTelefone());
            comandoSQL.setString(6, obj.getEmail());
            comandoSQL.setString(7, obj.getEndereco());
            comandoSQL.setString(8, obj.getNumero());
            comandoSQL.setString(9, obj.getCep());
            comandoSQL.setString(10, obj.getBairro());
            comandoSQL.setString(11, obj.getCidade());
            comandoSQL.setString(12, obj.getComplemento());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                  retorno = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;
        }
        return retorno;
    }
}
