
package Fofoflores.DAO;


import Fofoflores.Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ProdutoDAO {
     public static  String url="jdbc:mysql://localhost:3306/fofoflores";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Produto obj) {
       boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produto (produto, especie, valor, validade, quantidade_estoque, cor,codigo_produto) VALUES (?,?,?,?,?,?,?)");
            comandoSQL.setString(1, obj.getProduto());
            comandoSQL.setString(2, obj.getEspecie());
            comandoSQL.setDouble(3, obj.getValor());
            comandoSQL.setString(4, obj.getValidade());
            comandoSQL.setInt(5, obj.getQuantidade());
            comandoSQL.setString(6, obj.getCor());
            comandoSQL.setInt(7, obj.getCodigo());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                  retorno = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;
        }
        return retorno;
    }
    
       public static ArrayList<Produto> buscar(){
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto;");
            
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    Produto novoObjeto = new Produto();
                    novoObjeto.setCodigo(rs.getInt("codigo_produto"));
                    novoObjeto.setEspecie(rs.getString("especie"));
                    novoObjeto.setValor(rs.getDouble("valor"));
                    novoObjeto.setProduto(rs.getString("Produto"));
                    novoObjeto.setQuantidade(rs.getInt("quantidade_estoque"));
                    novoObjeto.setValidade(rs.getString("validade"));
                    novoObjeto.setCor(rs.getString("cor"));
                    
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
       
       public static ArrayList<Produto> buscaFiltro(int codigo){
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE codigo_produto=?;");
            comandoSQL.setInt(1, codigo);
            
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    Produto novoObjeto = new Produto();
                    novoObjeto.setCodigo(rs.getInt("codigo_produto"));
                    novoObjeto.setEspecie(rs.getString("especie"));
                    novoObjeto.setValor(rs.getDouble("valor"));
                    novoObjeto.setProduto(rs.getString("Produto"));
                    novoObjeto.setQuantidade(rs.getInt("quantidade_estoque"));
                    novoObjeto.setValidade(rs.getString("validade"));
                    novoObjeto.setCor(rs.getString("cor"));
                    
                    listaRetorno.add(novoObjeto);
                
                }

            }

            
                    
        }catch(ClassNotFoundException ex){
            listaRetorno = null;
            JOptionPane.showMessageDialog(null, ".Erro na conexão.");
        }catch (SQLException ex) {
            listaRetorno = null;
                 JOptionPane.showMessageDialog(null, "Erro na banco");
        }
        
        return listaRetorno;
    }
       
        public static boolean excluir(int codigo){
    
        boolean retorno = false;
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produto WHERE codigo_produto=?");
            comandoSQL.setInt(1, codigo);
            
            int numeroLinhas = comandoSQL.executeUpdate();
            if(numeroLinhas>0){
                retorno = true;
            }
                    
        }catch(ClassNotFoundException ex){
            retorno = false;
              JOptionPane.showMessageDialog(null, ".Erro na conexão.");
        }catch (SQLException ex) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro na banco");
        }
        
        return retorno;
    }
        
        public static boolean alterar(Produto objSelecionado){
    
        boolean retorno = false;
        Connection conexao = null;
        
        try{
            //1) Carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Abrir a conexao
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3) Criar objeto de conexão
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produto SET produto =? , especie=?, valor=?, validade=?,"
                    + " quantidade_estoque=?, cor=? WHERE codigo_produto=?");
            comandoSQL.setString(1, objSelecionado.getProduto());
            comandoSQL.setString(2, objSelecionado.getEspecie());
            comandoSQL.setDouble(3, objSelecionado.getValor());
            comandoSQL.setString(4, objSelecionado.getValidade());
            comandoSQL.setInt(5, objSelecionado.getQuantidade());
            comandoSQL.setString(6, objSelecionado.getCor());
            comandoSQL.setInt(7, objSelecionado.getCodigo());
            
            //4) Executar o comando SQL
            int numeroLinhas = comandoSQL.executeUpdate();
            if(numeroLinhas>0){
                retorno = true;
            }
                    
        }catch(ClassNotFoundException ex){
            retorno = false;
              JOptionPane.showMessageDialog(null, ".Erro na conexão.");
        }catch (SQLException ex) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro na banco");
        }
        
        return retorno;
    }
}
        
    
