
package Fofoflores.DAO;


import Fofoflores.Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ProdutoDAO {
     public static  String url="jdbc:mysql://localhost:3306/fofoflores" + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Produto obj) {
       boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produto (produto, especie, valor, validade, quantidade_estoque, cor) VALUES (?,?,?,?,?,?)");
            comandoSQL.setString(1, obj.getProduto());
            comandoSQL.setString(2, obj.getEspecie());
            comandoSQL.setDouble(3, obj.getValor());
            comandoSQL.setString(4, obj.getValidade());
            comandoSQL.setInt(5, obj.getQuantidade());
            comandoSQL.setString(6, obj.getCor());
            
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
    
    
