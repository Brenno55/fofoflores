package Fofoflores.DAO;


import Fofoflores.Model.Cliente;
import Fofoflores.Model.Vendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public static boolean salvar(Vendas objVendas){
   boolean retorno = false;
        Connection conexao = null;
        
        try{
            //1) Carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Abrir a conexao
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3) Criar objeto de conexão
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO Vendas (cpfCliente, TotaldaCompra) VALUES(?,?);"
                                            , Statement.RETURN_GENERATED_KEYS );
            comandoSQL.setString(1, objVendas.getCpfCliente());
            comandoSQL.setDouble(2, objVendas.getTotaldaCompra());
            
            
            //4) Executar o comando SQL
            int numeroLinhas = comandoSQL.executeUpdate();
            if(numeroLinhas>0){
                retorno = true;
                
                 }
                    
        }catch(ClassNotFoundException ex){
            retorno = false;
        }catch (SQLException ex) {
            retorno = false;
        }
        
        return retorno;
    }
          public static boolean salvarDetalhes(Vendas objVendas){
   boolean retorno = false;
        Connection conexao = null;
        
        try{
            //1) Carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Abrir a conexao
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3) Criar objeto de conexão
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO Detalhes_das_Vendas (Vendedor, Produto, Quantidade, Valor) VALUES(?,?,?,?);"
                                            , Statement.RETURN_GENERATED_KEYS );
            comandoSQL.setString(1, objVendas.getVendedor());
            comandoSQL.setInt(2, objVendas.getCodigoProduto());
            comandoSQL.setInt(3, objVendas.getQuantidade());
            comandoSQL.setDouble(4, objVendas.getValor());
            
            
            //4) Executar o comando SQL
            int numeroLinhas = comandoSQL.executeUpdate();
            if(numeroLinhas>0){
                retorno = true;
                
                 }
                    
        }catch(ClassNotFoundException ex){
            retorno = false;
        }catch (SQLException ex) {
            retorno = false;
        }
        
        return retorno;
    }
          
           public static ArrayList<Vendas> listar(){
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        
        Connection conexao = null;
        
        try{
            //1) Carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Abrir a conexao
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3) Criar objeto de conexão
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT nome FROM cliente WHERE cpf=?;");
            
            //4) Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                //Enquanto existirem linhas
                while(rs.next()){
                    //Resgato o valor de cada linha e passo para o objeto
                    Vendas novoObjeto = new Vendas();
                    novoObjeto.setCliente(rs.getString("nome"));
                    
                    //Em seguida, adiciono o objeto à lista
                    listaRetorno.add(novoObjeto);
                
                }

            }

            
                    
        }catch(ClassNotFoundException ex){
            listaRetorno = null;
        }catch (SQLException ex) {
            listaRetorno = null;
        }
        
        return listaRetorno;
    }
}
