
package Fofoflores.DAO;

import static Fofoflores.DAO.ClienteDAO.login;
import static Fofoflores.DAO.ClienteDAO.senha;
import static Fofoflores.DAO.ClienteDAO.url;
import Fofoflores.Model.Cliente;
import Fofoflores.Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
     public static  String url="jdbc:mysql://localhost:3306/fofoflores" + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Produto obj) {
        
        boolean retorno = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produto (cor, quantidade, validade, valor, especie, produto) VALUES (?,?,?,?,?,?)");
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs .next()) {
                    int id = rs.getInt(1);
                    for (Produto item : obj.getListaProduto()) {
                        PreparedStatement comandoSQLItem = conexao.prepareStatement("INSERT INTO produto (cor, quantidade, validade, valor, especie, produto) VALUES (?,?,?,?,?,?)");
                        comandoSQLItem.setString(1, obj.getCor());
                        comandoSQLItem.setDouble(2, obj.getQuantidade());
                        comandoSQLItem.setString(3, obj.getValidade());
                        comandoSQLItem.setInt(4, (int) obj.getValor());
                        comandoSQLItem.setString(5, obj.getEspecie());
                        comandoSQLItem.setString(6, obj.getProduto());
                       

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
    
    


