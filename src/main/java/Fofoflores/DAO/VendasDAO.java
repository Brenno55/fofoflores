package Fofoflores.DAO;

import Fofoflores.Model.Vendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendasDAO {
    
    public static String url ="jdbc:mysql://localhost:3306/fofoflores";
    public static String login = "root";
    public static String senha = "";
    
    public static ArrayList<Vendas> buscarTodas (){ //SELECT --- Todas as vendas
        ArrayList<Vendas> listaRetorno = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, senha);
            sql = conn.prepareStatement("SELECT cliente, id, dataVenda, valorTotal FROM Vendas");
            rs = sql.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    Vendas objeto = new Vendas();
                    objeto.setCliente(rs.getString("cliente"));
                    objeto.setID(rs.getInt("ID"));
                    objeto.setDataVenda(rs.getDate("dataVenda"));
                    objeto.setTotal(rs.getDouble("valorTotal"));
                    listaRetorno.add(objeto);
                }
            }
        }catch(SQLException | ClassNotFoundException ex){
            listaRetorno = null;
        }
        return listaRetorno;
    }
}
