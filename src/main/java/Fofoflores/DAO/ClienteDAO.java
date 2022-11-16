/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fofoflores.DAO;

import static Fofoflores.DAO.VendasDAO.login;
import static Fofoflores.DAO.VendasDAO.senha;
import static Fofoflores.DAO.VendasDAO.url;
import Fofoflores.Model.Cliente;
import Fofoflores.Model.Vendas;
import View.TelaCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caio Santos
 */
public class ClienteDAO {
    
    public static  String url="jdbc:mysql://localhost:3306/fofoflores" + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Cliente obj) {
        
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente (cpf, nome, data_nascimento, celular, telefone, email, endereço, numero_casa, cep, bairro, cidade, complemento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs .next()) {
                    int id = rs.getInt(1);
                    for (Cliente item : obj.getListaCliente()) {
                        PreparedStatement comandoSQLItem = conexao.prepareStatement("INSERT INTO cliente (cpf, nome, data_nascimento, celular, telefone, email, endereço, numero_casa, cep, bairro, cidade, complemento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                        comandoSQLItem.setString(1, obj.getCpf());
                        comandoSQLItem.setString(2, obj.getNome());
                        comandoSQLItem.setString(3, obj.getDataNascimento());
                        comandoSQLItem.setInt(4, obj.getCelular());
                        comandoSQLItem.setInt(5, obj.getTelefone());
                        comandoSQLItem.setString(6, obj.getEmail());
                        comandoSQLItem.setString(7, obj.getEndereco());
                        comandoSQLItem.setInt(8, obj.getNumero());
                        comandoSQLItem.setInt(9, obj.getCep());
                        comandoSQLItem.setString(10, obj.getBairro());
                        comandoSQLItem.setString(11, obj.getCidade());
                        comandoSQLItem.setString(12, obj.getComplemento());

                        int linhasAfetadasItem = comandoSQLItem.executeUpdate();
                        if(linhasAfetadasItem>0){
                            retorno = true;
                        }
                    }
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return retorno;
        
    }
}
