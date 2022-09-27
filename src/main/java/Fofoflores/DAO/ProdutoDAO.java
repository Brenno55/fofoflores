/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fofoflores.DAO;

import Fofoflores.Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class ProdutoDAO {
  // CONEXAO COM O BANCO , A DEFINIR 
  public static String url="jdbc:mysql://localhost:3306/exemplojdbc" + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
  public static String login="root";
  public static String senha="";
    
    public static boolean salvar(Produto obj){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            //Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2 passo - abrir conexao
            conexao = DriverManager.getConnection(url, login, senha);
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Produto VALUES (?, ?)");
            instrucaoSQL.setString(1, obj.getProdutoNome());
            instrucaoSQL.setString(2, obj.getProdutoEspecie());
            instrucaoSQL.setDouble(3, obj.getProdutoValor());
            instrucaoSQL.setString(4, obj.getProdutoCor());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = true;
            }else{
                retorno = false;
            }
            
        } catch (Exception e) {
            retorno = false;
        } finally{
            if(conexao != null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return retorno; 
    }
}
