/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fofoflores.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public static boolean salvar(String nome, String CPF, String Email, String Telefone) {
        
        boolean retorno = false;
        Connection conexao = null;
       
        try {
            Class.forName("com.mysql.jdbc.Drive");
            
            conexao = DriverManager.getConnection(url,login,senha);
            
            Statement instrucaoSQL = conexao.createStatement();
            
            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO cliente (nome,CPF,Email,Telefone) values('" 
                                        + nome
                                        + "','" 
                                        + CPF + "','" 
                                        + Email + "','" 
                                        + Telefone + "')");
            if(linhasAfetadas>0) {
                retorno = true;
            } else{
                 retorno = false;
                throw new Exception("Não foi possivel inserir o cliente");
                
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        } catch(Exception ex) {
            System.out.println("Erro:" + ex.getMessage()); 
            retorno = false;
        }
        return retorno;
    }
}
